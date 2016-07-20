/**
 * 
 */
package member;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @date  : 2016. 6. 16.
 * @author: 배근홍
 * @file  : Student.java
 * @story :
 */
public class MemberBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id, pw, name, regDate, gender, ssn, profileImg, email;
	private int birth;
	
	public MemberBean() {}
	
	public MemberBean(String id,String pw, String name, String ssn, String email, String profileImg) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.ssn = ssn;
		this.profileImg = profileImg;
		this.email = email;
		String now = regDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		String[] ssnArr = ssn.split("-");
		String[] nowArr = now.split("-");
		int ageResult1 = Integer.parseInt(ssnArr[0]);
		int genderResult = Integer.parseInt(ssnArr[1]);
		int ageResult2 = Integer.parseInt(nowArr[0]);
		int ageResult0 = 0;
		
		switch (genderResult%2) {
			case 1: case 5:
				ageResult0 = ageResult2-(1899+(ageResult1/10000));
				this.birth=ageResult0;
				this.gender = "남";
				break;
			case 3: case 7:
				ageResult0 = ageResult2-(1999+(ageResult1/10000));
				this.birth=ageResult0;
				this.gender = "남";
			break;
			case 2: case 6:
				ageResult0 = ageResult2-(1899+(ageResult1/10000));
				this.birth=ageResult0;
				this.gender = "여";
			break;
			case 4: case 8:
				ageResult0 = ageResult2-(1999+(ageResult1/10000));
				this.birth=ageResult0;
				this.gender = "여";
			break;
			default:
				System.out.println("잘못된 값을 입력하셨습니다");
				break;
		}
	
	}
	
	
	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public void setPw(String pw){
		this.pw = pw;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setSsn(String ssn){
		this.ssn = ssn;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	//-----------------------------
	public String getId(){
		return this.id;
	}
	public String getPw(){
		return this.pw;
	}
	public String getName(){
		return this.name;
	}
	public String getRegDate(){
		return this.regDate;
	}
	
	public void setRegDate() {
		this.regDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public String getGender(){
		return this.gender;
	}
	public String getSsn(){
		return this.ssn;
	}
	public int getBirth(){
		return this.birth;
	}
	
	public String getEmail() {
		return this.email;
	}

	




	@Override
	public String toString() {
		return "학생 [아이디=" + id + ", 비밀번호="+pw+", 이메일="+email+" 이름=" + name + ", 등록일=" + regDate + ", 성별=" + gender
				+ ", 주민번호=******-******* , 나이=" + birth + "]\n";
	}
	
	
	}

