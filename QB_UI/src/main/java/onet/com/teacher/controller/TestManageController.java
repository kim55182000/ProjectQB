package onet.com.teacher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import onet.com.admin.service.AdminService;
import onet.com.common.service.CommonService;
import onet.com.teacher.service.TeacherService;
import onet.com.vo.QuestionDto;
import onet.com.vo.Question_choiceDto;

@Controller
@RequestMapping("/teacher/")
public class TestManageController {

	@Autowired
	private TeacherService teacherService;

	/*성태용 시작*/
	@RequestMapping(value="classListView.do")
	public @ResponseBody ModelAndView classListView(Model model) {
		List<QuestionDto> question = teacherService.question();
		model.addAttribute("question", question);
		List<Question_choiceDto> question_choice = teacherService.question_choice();
		model.addAttribute("question_choice", question_choice);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajax.common.examPaperMake_ajax");
		mv.addObject("question", question);
		mv.addObject("question_choice",question_choice);
		
		return mv;
	}
	
	@RequestMapping(value="questionSearch.do")
	public @ResponseBody ModelAndView questionSearch(@RequestParam("lgsearchtype") String lgsearchtype, 
			@RequestParam("mdsearchtype") String mdsearchtype, @RequestParam("smsearchtype") String smsearchtype,
			@RequestParam("leveltype") String leveltype, @RequestParam("questiontype") String questiontype) {
		
		List<QuestionDto> question = teacherService.questionSearch(lgsearchtype,mdsearchtype,smsearchtype,leveltype,questiontype);
		List<Question_choiceDto> question_choice = teacherService.question_choice();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ajax.common.examPaperMake_ajax");
		mv.addObject("question", question);
		mv.addObject("question_choice",question_choice);
		
		return mv;
	}
	/*성태용 끝*/
	
	/*한결 시작*/
	@RequestMapping("checkExam_paper.do")
	public @ResponseBody String checkExam_paper(@RequestParam("exam_paper_name") String exam_paper_name) {	
		String result = teacherService.examPaperCheck(exam_paper_name);
		return result;
	}	
	
	@RequestMapping("examPaperInsert.do")
	public @ResponseBody int examPaperInsert(@RequestParam("exam_paper_name") String exam_paper_name,
			@RequestParam("member_id") String member_id,@RequestParam("exam_paper_desc") String exam_paper_desc) {
		System.out.println(exam_paper_name +"//"+ member_id +"\\"+ exam_paper_desc);
		int result = teacherService.examPaperInsert(exam_paper_name,member_id,exam_paper_desc);
		return result;
	}
	
	/*한결 끝*/
}