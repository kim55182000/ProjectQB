package onet.com.student.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onet.com.student.dao.StudentDao;
import onet.com.vo.ExamInfoDto;
import onet.com.vo.ExamPaperDoQuestionDto;
import onet.com.vo.MessageDto;
import onet.com.vo.Question_choiceDto;
import onet.com.vo.Score_chartDto;
import onet.com.vo.Student_answerDto;
import onet.com.vo.Student_answerDtoList;
import onet.com.vo.Student_answerQuesDto;

@Service
public class StudentService {
	
	@Autowired
	private SqlSession sqlsession;
	
	/* 10.19 현이 학생 답안지 제출 시작 */ 
	public int examAnswerInsert(Student_answerDtoList answerList) {
		
		StudentDao dao = sqlsession.getMapper(StudentDao.class);
		int result = 0;
		
		List<Student_answerDto> items = answerList.getStudent_answer();
		for(Student_answerDto item : items) {
			int question_num = item.getQuestion_num();
			String answer = dao.searchAnswer(question_num);		//	정답 찾아와서 answer_status 비교 후 입력 
			
			if((item.getStudent_answer_choice() == null) || (!(item.getStudent_answer_choice().equals(answer)))) {   //   오답
	            item.setStudent_answer_status(0);
	            if(item.getStudent_answer_choice() == "") {
	            	item.setStudent_answer_choice(null);
	            }
	         } else {
	            item.setStudent_answer_status(1);
	         }
			result += dao.examAnswerInsert(item);	//	student_answer 테이블 insert 
		}
		
		
		String member_id = answerList.getStudent_answer().get(0).getMember_id();
		int exam_info_num= answerList.getStudent_answer().get(0).getExam_info_num();
		
		
		// 문제 정답률 insert
		List<Integer> selectQuestion = dao.selectQuestion(exam_info_num);
		int correctRatioResult = 0;
		for(Integer aQuestion : selectQuestion) {
			int question_num = aQuestion.intValue();
			correctRatioResult += dao.updateCorrectRatio(question_num);
		} 
		// System.out.println("correctRatioResult 의 결과값(정답률) : "+correctRatioResult);
		
		
		// 학생 - 성적 차트 테이블 insert
		int scoreResult = dao.score_chartInsert(member_id, exam_info_num);	//	랭크  학생 성제외한적 입력 
		
		List<Score_chartDto> chartList = dao.selectRank(exam_info_num);		//	rank 함수로 rank를 구해서 dto 리스트에 넣어줌
		int updateScoreResult = dao.updateRank(chartList, exam_info_num);	//  위의 함수로 구한 rank 리스트를 다중행 업데이트함
		//System.out.println("updateScoreResult : " + updateScoreResult);
		
		// 클래스 성적 차트 테이블 insert 
		if(dao.countClassChart(exam_info_num) > 0 ) {	// 클래스 차트가 있다면 update, 없다면 insert 
			int classScoreResult = dao.class_chartUpdate(member_id, exam_info_num);
		} else {
			int classScoreResult = dao.class_chartInsert(member_id, exam_info_num);
		}
		
		return result;
	}
	/* 10.19 현이 학생 답안지 제출 끝 */ 
	
	/*10.23 현이 지난 시험 보기 시작 */
	public List<ExamInfoDto> searchPastExam(String member_id){
		
		StudentDao dao = sqlsession.getMapper(StudentDao.class);
		List<ExamInfoDto> examInfoList = dao.searchPastExam(member_id);
		
		return examInfoList;
	}
	
	public String searchStudentName(String member_id) {
		
		StudentDao dao = sqlsession.getMapper(StudentDao.class);
		String member_name = dao.searchStudentName(member_id);
		
		return member_name;
	}
	
	public List<ExamInfoDto> searchPastExamKeyword(String member_id, String keyword){
		
		StudentDao dao = sqlsession.getMapper(StudentDao.class);
		List<ExamInfoDto> examInfoList = dao.searchPastExamKeyword(member_id, keyword);
		
		return examInfoList;
	}
	
	/*10.23 현이 지난 시험 보기 끝 */
	
	/*10.24 현이 지난 시험지 보기 시작*/
	public List<Student_answerQuesDto> selectStudentAnswer(String member_id, int exam_info_num, String student_answer_status){
		
		StudentDao dao = sqlsession.getMapper(StudentDao.class);
		List<Student_answerQuesDto> studentAnswerList = null;
		
		if(student_answer_status.equals("all")) {
			studentAnswerList = dao.selectStudentAnswer(member_id, exam_info_num);
		} else if (student_answer_status.equals("wrong")) {
			studentAnswerList = dao.selectStudentWrongAnswer(member_id, exam_info_num);
			/*for(Student_answerQuesDto dto :studentAnswerList) {
				System.out.println("문제 배치 번호 : " + dto.getExam_question_seq());
				System.out.println("answer status : " + dto.getStudent_answer_status());
			}*/
		}
		
		return studentAnswerList;
	}
	
	public List<ExamPaperDoQuestionDto> examPaperDoWrongQuestion(String member_id, int exam_info_num) throws ClassNotFoundException, SQLException, IOException {
		StudentDao dao = sqlsession.getMapper(StudentDao.class);
		List<ExamPaperDoQuestionDto> questionList = dao.examPaperDoWrongQuestion(member_id, exam_info_num);
		return questionList;
	}
	
	public List<Question_choiceDto> examPaperDoWrongQuestion_choice(int exam_info_num) throws ClassNotFoundException, SQLException, IOException {
		StudentDao dao = sqlsession.getMapper(StudentDao.class);
		List<Question_choiceDto> questionChoiceList = dao.examPaperDoWrongQuestion_choice(exam_info_num);
		return questionChoiceList;
	}
	/*10.24 현이 지난 시험지 보기 끝*/
	
	
	/*10.29민지 학생이 쪽지보내기*/
	
	public int sendTeacherMessage(String teacher_id,String message_content,String send_member_id) {
		StudentDao dao = sqlsession.getMapper(StudentDao.class);
		MessageDto dto = new MessageDto();
		dto.setReceive_member_id(teacher_id);
		dto.setMessage_content(message_content);
		dto.setSend_member_id(send_member_id);
		int result = dao.sendTeacherMessage(dto);
		
		return result;
		
		
	}
	
	
}
