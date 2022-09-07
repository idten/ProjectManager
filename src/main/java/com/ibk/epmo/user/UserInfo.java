package com.ibk.epmo.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Document(indexName = "user_info")
public class UserInfo {
	
	@Id
	private String userId; //직원번호 
	private String userName;//이름 
	
	private String depName; //부서명
	private String depCode;
	private String authCode;//사용자/관리자     USER//ADMIN
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date regDate = new Date();	//등록일자 
	private Date updateDate = new Date();	//등록일자 
	
	public UserInfo() {
		
	}
	public UserInfo(String USER_ID, String USER_NAME, String DEP_NAME, String AUTH_CODE, Date REG_DATE, Date UPDATE_DATE) {
		this.userId = USER_ID; 
		this.userName = USER_NAME;
		this.depName = DEP_NAME;
		this.authCode = AUTH_CODE;
		this.regDate = REG_DATE;
		this.updateDate = new Date();
	}
	public String toString() {
		
		return "USER_ID="+userId 
				+ ",USER_NAME="+ userName  
				+ ",DEP_NAME=" + depName
				+ "AUTH_CODE=" + authCode;
	}
}
