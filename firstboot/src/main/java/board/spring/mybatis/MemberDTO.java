package board.spring.mybatis;

import org.springframework.stereotype.Component;

@Component
public class MemberDTO {
	String member_id, name;
	int pw;
	String phone, email, regtime;

	MemberDTO(String member_id, int pw) {
		System.out.println("매개변수 있는 생성자 호출");
		this.member_id = member_id;
		this.pw = pw;
	}

	MemberDTO() {
		System.out.println("MemberDTO 기본 생성자 호출");
	}

	public MemberDTO(String member_id, String name, int pw, String phone, String email, String regtime) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
		this.regtime = regtime;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public String toString() {
		return member_id + ":" + pw + ":" + name + ":" + phone + ":" + email;
	}

}
