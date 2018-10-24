package onet.com.teacher.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onet.com.teacher.dao.TeacherDao;
import onet.com.vo.ClassDto;
import onet.com.vo.ExamInfoDto;
import onet.com.vo.ExamMemberDto;
import onet.com.vo.ExamPaperDto;
import onet.com.vo.MemberDto;
import onet.com.vo.QuestionDto;
import onet.com.vo.Question_choiceDto;
import onet.com.vo.Question_levelDto;

@Service
public class TeacherService {
	
	@Autowired
	private SqlSession sqlsession;
	
	/*한결 - 10.17 새 시험지 만들기 문제 뿌리기 각 문제,문제보기,문제 난이도 시작*/
	public List<QuestionDto> question(){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<QuestionDto> result = dao.question();
		return result;
	}
	public List<Question_choiceDto> question_choice(){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<Question_choiceDto> result = dao.question_choice();
		return result;
	}
	public List<Question_levelDto> question_level(){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<Question_levelDto> result = dao.question_level();
		return result;
	}
	/*한결 - 10.17 새 시험지 만들기 문제 뿌리기 각 문제,문제보기,문제 난이도 끝*/
	
	/*재훈 - 10.19 강사 문제관리 - 내가 만든 문제 시작 */
	public List<QuestionDto> teacherMyQuestion(String member_id){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<QuestionDto> result = dao.teacherMyQuestion(member_id);
		return result;
	}
	
	public List<QuestionDto> teacherMyQuestionSearch(String lgsearchtype, String mdsearchtype, String smsearchtype, String leveltype, String questiontype, String keyword, String member_id){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<QuestionDto> result = dao.teacherMyQuestionSearch(lgsearchtype, mdsearchtype, smsearchtype, leveltype, questiontype, keyword, member_id);
		return result;
	}
	
	/*재훈 - 10.19 강사 문제관리 - 내가 만든 문제 끝 */
	
	
	/* 영준 - 10.16 선생님 시험관리 페이지 시작 */
	public List<ExamPaperDto> examPaperList(int class_num){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<ExamPaperDto> result = dao.examPaperList(class_num);
		return result;	
	}
	/* 영준 - 10.16 강사 시험관리 페이지 끝 */
	
	/*한결 - 10.17 시험지 체크 및 insert 시작*/
	public String examPaperCheck(String exam_paper_name) {
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		String result = dao.examPaperCheck(exam_paper_name);
		return result;
	}
	

	public int examPaperInsert(String exam_paper_name,String member_id,String exam_paper_desc,String exam_paper_status) {
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		int result = dao.examPaperInsert(exam_paper_name,member_id,exam_paper_desc,exam_paper_status);
		return result;
	}
	public int examPaperUpdate(String exam_paper_name,String member_id,String exam_paper_desc,String exam_paper_num,String exam_paper_status) {
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		int result = dao.examPaperUpdate(exam_paper_name,member_id,exam_paper_desc,exam_paper_num,exam_paper_status);
		return result;
	}
	public int examQuestionSelect(String exam_paper_num, String question_num) {
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		int result = dao.examQuestionSelect(exam_paper_num, question_num);
		return result;
	}
	public int examQuestionInsert(String exam_paper_num, String question_num, String exam_question_seq, String exam_question_score) {
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		int result = dao.examQuestionInsert(exam_paper_num,question_num, exam_question_seq, exam_question_score);
		return result;
	}
	public int examQuestionDelete(String exam_paper_num) {
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		int result = dao.examQuestionDelete(exam_paper_num);
		return result;
	}

	/*한결 - 10.17 시험지 체크  및 insert 끝*/

	/* 영준 - 10.16 선생님 시험관리 페이지 끝 */
	
	/* 영준 - 10.17 내 시험지 삭제 시작 */
	public int examPaperDelete(int exam_paper_num) {
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		int result = dao.examPaperDelete(exam_paper_num);
		System.out.println("시험지 삭제 result값 : " + result);
		return result;
	}
	/* 영준 - 10.17 내 시험지 삭제 끝 */
	
	/*민지 - 10.18 시험등록*/
	public int examInfoInsert(ExamInfoDto dto){
		
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		int result = dao.examInfoInsert(dto);
		return result;
	}
	
	public int examMemberInsert(ExamMemberDto dto) {
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		
		int result = dao.examMemberInsert(dto);
		return result;
		
	}
	/*민지- 10.18 시험등록 끝*/

	/*--성태용 시작--*/
	public List<QuestionDto> questionSearch(String lgsearchtype, String mdsearchtype, String smsearchtype, String leveltype, String questiontype, String keyword){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<QuestionDto> result = dao.questionSearch(lgsearchtype, mdsearchtype, smsearchtype, leveltype, questiontype, keyword);
		return result;
	}
	public List<ExamPaperDto> myExamPaperList(String member_id){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<ExamPaperDto> result = dao.myExamPaperList(member_id);
		return result;	
	}
	public List<ExamPaperDto> myTempExamList(String member_id){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<ExamPaperDto> result = dao.myTempExamList(member_id);
		return result;	
	}
	public List<ExamInfoDto> examScheduleList(String member_id){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<ExamInfoDto> result = dao.examScheduleList(member_id);
		return result;
	}
	public List<ExamInfoDto> examScheduleList2(int exam_paper_num){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<ExamInfoDto> result = dao.examScheduleList2(exam_paper_num);
		return result;
	}
	public int deleteExam(int exam_paper_num) {
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		int result = dao.deleteExam(exam_paper_num);
		return result;
	}
	
	public List<QuestionDto> updateExamView(int exam_paper_num){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<QuestionDto> result = dao.updateExamView(exam_paper_num);
		return result;
	}
	
	
	/*--성태용 끝--*/
	/*민지 10.12 클래스멤버 리스트, 클래스 리스트  관리*/
	public List<MemberDto> classMemberList(int exam_paper_num){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		
		List<MemberDto> result = dao.classMemberList(exam_paper_num);
		return result;
	}
	public List<MemberDto> classMemberListUpdate(int exam_info_num){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		
		List<MemberDto> result = dao.classMemberListUpdate(exam_info_num);
		return result;
	}
	
	
	
	public ClassDto classInfo(int exam_paper_num){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		ClassDto result = dao.classInfo(exam_paper_num);
		return result;
		
	}
	
	/* 영준 - 10.18 선생님 시험일정 삭제 시작 */
	public int teacherExamSchedultDelete(int exam_info_num) {
		ExamInfoDto dto = new ExamInfoDto();
		dto.setExam_info_num(exam_info_num);
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		int result = dao.teacherExamSchedultDelete(dto);
		System.out.println("시험일정삭제 result값 : " + result);
		return result;
	}
	/* 영준 - 10.18 선생님 시험일정 삭제 끝 */

	/*민지 - 10.22 시험일정 수정*/
	
	public List<ExamInfoDto> classExamList(int exam_info_num){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		ExamInfoDto dto = new ExamInfoDto();
		dto.setExam_info_num(exam_info_num);
		List<ExamInfoDto> result = dao.classExamList(dto);
		return result;
	}
	
	
	public int examInfoIUpdate(ExamInfoDto dto) {
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		
		int result = dao.examInfoIUpdate(dto);
		
		return result;
	}
	
	
	/*민지 - 10.22 시험일정 수정 끝*/
	
	
}
