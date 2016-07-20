package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import global.Constants;
import global.DatabaseFactory;
import global.Vendor;

/**
 * @date  : 2016. 7. 6.
 * @author: 배근홍
 * @file  : AccountDAO.java
 * @story  :
 */
public class AccountDAO {
	private Connection con;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	private static AccountDAO dao = new AccountDAO();
	public static AccountDAO getDao() {
		return dao;
	}
	private AccountDAO() {
		con = DatabaseFactory.createDatabase(Vendor.ORACLE, 
			Constants.USER_ID, 
			Constants.USER_PW).getConnection();
	}
	// 1번
	public int openAccount(AccountBean bean){
		int result = 0;
		String sql = "insert into bank(id, account_no, money) values(?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setInt(2, bean.getAccountNo());
			pstmt.setInt(3, bean.getMoney());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	// 2번
	public int deposit(String accountNo, String money){
		int result = 0;
		String sql = "update bank set money = money + ? where account_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(money));
			pstmt.setInt(2, Integer.parseInt(accountNo));
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	//3번
	public int withDraw (String account, String withdrawMoney){
		int result = 0;
		String sql = "update bank set money = money - ? where account_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(withdrawMoney));
			pstmt.setInt(2, Integer.parseInt(account));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	//4번 
	public int updateAccount(AccountMemberBean acc){
		int result = 0;
		String sql = "update member set pw = ? where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, acc.getPw());
			pstmt.setString(2, acc.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	//5번
	public int deleteAccount(String delete){
		int result = 0;
		String sql = "delete from bank where account_no = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, delete);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//6번
	public List<?> findAccount (){
		List<AccountMemberBean> list = new ArrayList<AccountMemberBean>();
		String sql = "select account, money, id, name, ssn from bank_member order by name";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				AccountMemberBean bean = new AccountMemberBean();
				bean.setAccountNo(rs.getInt("ACCOUNT"));
				bean.setMoney(rs.getInt("MONEY"));
				bean.setId(rs.getString("ID"));
				bean.setName(rs.getString("NAME"));
				bean.setSsn(rs.getString("SSN").substring(0, 6));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//7번
	public AccountMemberBean findByAcc (int account){
		AccountMemberBean result = null;
		String sql = "select * from bank_member where account = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, account);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				AccountMemberBean bean = new AccountMemberBean();
				bean.setAccountNo(rs.getInt("ACCOUNT"));
				bean.setMoney(rs.getInt("MONEY"));
				bean.setId(rs.getString("ID"));
				bean.setPw(rs.getString("PW"));
				bean.setName(rs.getString("NAME"));
				bean.setRegDate(rs.getString("REG_DATE"));
				bean.setSsn(rs.getString("SSN"));
				result = bean;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result ;
	}
	//8번
	public List<?> findByName(String name){
		List<AccountMemberBean> list = new ArrayList<AccountMemberBean>();
		String sql = "select * from bank_member where name = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				AccountMemberBean bean = new AccountMemberBean();
				bean.setAccountNo(rs.getInt("ACCOUNT"));
				bean.setMoney(rs.getInt("MONEY"));
				bean.setId(rs.getString("ID"));
				bean.setPw(rs.getString("PW"));
				bean.setName(rs.getString("NAME"));
				bean.setRegDate(rs.getString("REG_DATE"));
				bean.setSsn(rs.getString("SSN"));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//9번
	public int count(){
		int result = 0;
		String sql = "select count(*) as count from bank_member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public Map<?, ?> selectMap() {
		Map<String, AccountMemberBean> map = new HashMap<String, AccountMemberBean>();
		String sql = "select * from bank_member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				AccountMemberBean am = new AccountMemberBean();
					am.setAccountNo(rs.getInt("ACCOUNT"));
					am.setId(rs.getString("ID"));
					am.setPw(rs.getString("PW"));
					am.setMoney(rs.getInt("MONEY"));
					am.setName(rs.getString("NAME"));
					am.setRegDate(rs.getString("REG_DATE"));
					am.setSsn(rs.getString("SSN"));
				map.put(String.valueOf(am.getAccountNo()), am);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	};
	

}
