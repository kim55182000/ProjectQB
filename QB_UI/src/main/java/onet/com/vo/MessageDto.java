package onet.com.vo;

public class MessageDto {


	private int message_num;
	private String send_member_id;
	private String receive_member_id;
	private String message_content;
	private String message_date;
	private int message_check;
	private int send_check;
	private int receive_check;
	private String member_name;
	
	
	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public int getSend_check() {
		return send_check;
	}

	public void setSend_check(int send_check) {
		this.send_check = send_check;
	}

	public int getReceive_check() {
		return receive_check;
	}

	public void setReceive_check(int receive_check) {
		this.receive_check = receive_check;
	}

	public int getMessage_check() {
		return message_check;
	}

	public void setMessage_check(int message_check) {
		this.message_check = message_check;
	}

	public int getMessage_num() {
		return message_num;
	}

	public void setMessage_num(int message_num) {
		this.message_num = message_num;
	}

	public String getSend_member_id() {
		return send_member_id;
	}

	public void setSend_member_id(String send_member_id) {
		this.send_member_id = send_member_id;
	}

	public String getReceive_member_id() {
		return receive_member_id;
	}

	public void setReceive_member_id(String receive_member_id) {
		this.receive_member_id = receive_member_id;
	}

	public String getMessage_content() {
		return message_content;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

	public String getMessage_date() {
		return message_date;
	}

	public void setMessage_date(String message_date) {
		this.message_date = message_date;
	}

}

