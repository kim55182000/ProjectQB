package onet.com.vo;

import java.util.ArrayList;
import java.util.HashMap;

public class Score_chartDto {

	// 18.10.22 현이 score_chartDto 만듦

	private String member_id;
	
	private int exam_info_num;
	private int score_chart_score;
	private int score_chart_rank;
	private String class_name;
	// 양회준10.24추가 
	private String exam_info_name;
	
	private float avg_score;
	private int start;
	private int end;
	
	// 영준 10.25 추가
	private String member_name;
	
	//양회준11.5추가
	private HashMap<String, Integer> score_list;
	private String score_chart_comment;
	private double class_chart_avg;
	
	
	
	public double getClass_chart_avg() {
		return class_chart_avg;
	}

	public void setClass_chart_avg(double class_chart_avg) {
		this.class_chart_avg = class_chart_avg;
	}

	public String getScore_chart_comment() {
		return score_chart_comment;
	}

	public void setScore_chart_comment(String score_chart_comment) {
		this.score_chart_comment = score_chart_comment;
	}

	private String exam_info_desc;
	
	

	public HashMap<String, Integer> getScore_list() {
		return score_list;
	}

	public void setScore_list(HashMap<String, Integer> score_list) {
		this.score_list = score_list;
	}

	public String getExam_info_desc() {
		return exam_info_desc;
	}

	public void setExam_info_desc(String exam_info_desc) {
		this.exam_info_desc = exam_info_desc;
	}


	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	

	
	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	
	public String getExam_info_name() {
		return exam_info_name;
	}

	public void setExam_info_name(String exam_info_name) {
		this.exam_info_name = exam_info_name;
	}
	public float getAvg_score() {
		return avg_score;
	}
	public void setAvg_score(float avg_score) {
		this.avg_score = avg_score;
	}
	// 추가
	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public int getExam_info_num() {
		return exam_info_num;
	}

	public void setExam_info_num(int exam_info_num) {
		this.exam_info_num = exam_info_num;
	}

	public int getScore_chart_score() {
		return score_chart_score;
	}

	public void setScore_chart_score(int score_chart_score) {
		this.score_chart_score = score_chart_score;
	}

	public int getScore_chart_rank() {
		return score_chart_rank;
	}

	public void setScore_chart_rank(int score_chart_rank) {
		this.score_chart_rank = score_chart_rank;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

}
