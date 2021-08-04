package co.k.prj.member.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private int age;
	private String hobby;
	private String author;
	private char state;
	
	private String check; // 로그인 or 상태 체크 용도
		
}
