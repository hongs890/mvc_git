package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DatabaseFactory;
import global.Vendor;

/**
 *  * @date  : 2016. 7. 1.  * @author: 배근홍  * @file  : MemberDAO.java  * @story 
 * :  
 */

public class MemberDAO {
	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	private MemberDAO() {
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(
					Constants.ORACLE_URL,
					Constants.USER_ID,
					Constants.USER_PW);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insert(MemberBean mem) {
		int result = 0;	
		String sql = "insert into member(id,pw,name,reg_date,ssn,email) "
				+ "values(?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPw());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getRegDate());
			pstmt.setString(5, mem.getSsn());
			pstmt.setString(6, mem.getEmail());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return result;
	}

	public void update(MemberBean mem) {
		String sql = "update member set pw = ?, email = ? where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getPw());
			pstmt.setString(2, mem.getEmail());
			pstmt.setString(3, mem.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(MemberBean mem) {
		String sql = "delete from member where id = ? and pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPw());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	
	public List<?> list() {
		String sql = "select * from member";
		List<MemberBean> list = new ArrayList<MemberBean>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberBean t = new MemberBean(rs.getString("ID"), rs.getString("NAME"), rs.getString("PW"),
						rs.getString("SSN"), rs.getString("EMAIL"), rs.getString("PROFILE_IMG"));
				t.setRegDate(rs.getString("REG_DATE"));
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public MemberBean findById(String pk) {
		String sql = "select * from member where id = ?";
		MemberBean temp = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pk);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				temp = new MemberBean(rs.getString("ID"), rs.getString("PW"), rs.getString("NAME"),
						rs.getString("SSN"), rs.getString("EMAIL"), rs.getString("PROFILE_IMG"));
				temp.setRegDate(rs.getString("REG_DATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	
	public List<?> findByName(String name) {
		String sql = "select * from member where name = ?";
		List<MemberBean> list2 = new ArrayList<MemberBean>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberBean mem = new MemberBean(rs.getString("ID"), rs.getString("NAME"), rs.getString("PW"),
						rs.getString("SSN"), rs.getString("EMAIL"), rs.getString("PROFILE_IMG"));
				mem.setRegDate(rs.getString("REG_DATE"));
				list2.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
	}

	public int count() {
		int count = 0;
		String sql = "select count(*) as count from member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public boolean login(MemberBean param) {
		boolean loginOk= false;
		if(param.getId()!=null 
				&& param.getPw()!=null 
				&& this.existId(param.getId())){
			MemberBean member = this.findById(param.getId());
			if(member.getPw().equals(param.getPw())){
				loginOk = true;
			}
		
		}
		return loginOk;
	}
	
	public boolean existId(String id){
		boolean existOK = false;
		String sql = "select count(*) as count from member where id = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result == 1){
			existOK = true;
		}
		return existOK;
	}
}