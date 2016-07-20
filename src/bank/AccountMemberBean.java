package bank;

/**
 * @date  : 2016. 7. 7.
 * @author: 배근홍
 * @file  : AccountMemberBean.java
 * @story  :
 */
public class AccountMemberBean {
	private String id, pw, name, regDate, gender, ssn;
	private int birth, accountNo, money;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "통장정보 [ID : " + id + ", 이름 : " + name + ", 생년월일 : " + ssn + ", 계좌번호 : " + accountNo + ", 잔고 : " + money + "]\n";
	}
	
	
}
