package onet.com.teacher.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onet.com.teacher.dao.TeacherDao;
import onet.com.vo.ExamInfoDto;
import onet.com.vo.ExamPaperDto;
import onet.com.vo.QuestionDto;
import onet.com.vo.Question_choiceDto;

@Service
public class TeacherService {
	
	@Autowired
	private SqlSession sqlsession;
	
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
	
	/* 영준 - 10.16 선생님 시험관리 페이지 시작 */
	public List<ExamPaperDto> examPaperList(int class_num){
		ExamPaperDto dto = new ExamPaperDto();
		dto.setClass_num(class_num);
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<ExamPaperDto> result = dao.examPaperList(dto);
		return result;	
	}
	/* 영준 - 10.16 선생님 시험관리 페이지 끝 */
	
	/* 영준 - 10.17 내 시험지 삭제 시작 */
	public int examPaperDelete(String exam_paper_name) {
		ExamPaperDto dto = new ExamPaperDto();
		dto.setExam_paper_name(exam_paper_name);
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		int result = dao.examPaperDelete(dto);
		return result;
	}
	/* 영준 - 10.17 내 시험지 삭제 끝 */
	
	/* 영준 - 10.16 선생님 시험일정 리스트 불러오기 시작 */
	public List<ExamInfoDto> examScheduleList(){
		TeacherDao dao = sqlsession.getMapper(TeacherDao.class);
		List<ExamInfoDto> result = dao.examScheduleList();
		return result;
	}
	/* 영준 - 10.16 선생님 시험일정 리스트 불러오기 끝 */
}
