package cn.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {

	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;
	private String client_checkcode;
	private String server_checkcode;
	private Map<String, String> errors = new HashMap<String, String>();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getClient_checkcode() {
		return client_checkcode;
	}
	public void setClient_checkcode(String client_checkcode) {
		this.client_checkcode = client_checkcode;
	}
	public String getServer_checkcode() {
		return server_checkcode;
	}
	public void setServer_checkcode(String server_checkcode) {
		this.server_checkcode = server_checkcode;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public boolean validate() {
		boolean isOK = true;
		
		//用户名判断
		if(this.username == null || this.username.trim().equals("")) {
			isOK = false;
			errors.put("username", "用户名不能为空!");
		} else if(!this.username.matches("[A-Za-z]{3,8}")) {
			isOK = false;
			errors.put("username", "用户名必须是3-8位的数字或字母！");
		}
		
		if(this.password == null || this.password.trim().equals("")) {
			isOK = false;
			errors.put("password", "密码不能为空!");
		} else if(!this.password.matches("[A-Za-z]{3,8}")) {
			isOK = false;
			errors.put("password", "密码必须是3-8位的数字或字母！");
		}
		
		if(this.password2 == null || this.password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "密码不能为空!");
		} else if(!this.password.equals(this.password2)) {
			isOK = false;
			errors.put("password2", "前后密码不一致！");
		}
		
		if(this.email == null || this.email.trim().equals("")) {
			isOK = false;
			errors.put("email", "email不能为空!");
		} else if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
			isOK = false;
			errors.put("email", "不是有效的email！");
		}
		
		if(this.birthday!=null && !this.birthday.trim().equals("")) {
			try{
				DateLocaleConverter dlc = new DateLocaleConverter();
				dlc.convert(this.birthday, "yyyy-MM-dd");
			}catch (Exception e) {
				isOK = false;
				errors.put("birthday", "日期格式有误！");
			}
		}
		
		if(this.nickname == null || this.nickname.trim().equals("")) {
			isOK = false;
			errors.put("nickname", "昵称不能为空！");
		} else if(!this.nickname.matches("^([\u4e00-\u9fa5]+)$")) {
			isOK = false;
			errors.put("nickname", "昵称必须为中文！");
		}
		
		if(this.client_checkcode == null || this.client_checkcode.trim().equals("")) {
			isOK = false;
			errors.put("client_checkcode", "验证码不能为空！");
		} else if(!this.client_checkcode.equals(this.server_checkcode)) {
			isOK = false;
			errors.put("client_checkcode", "验证码有误！");
		}
		return isOK;
	}
}
