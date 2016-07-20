package grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.Database;
import global.DatabaseFactory;
import global.Vendor;

/**
 * @date  : 2016. 7. 1.
 * @author: 배근홍
 * @file  : GradeDAO.java
 * @story  :
 */

/*
 * 	public GradeBean(String name, int kor, int eng, int math) {
	this.name = name;
	this.kor = kor;
	this.eng = eng;
	this.math = math;
 * */
public class GradeDAO {
		Connection con;
		Statement stmt;
		ResultSet rs;
		PreparedStatement pstmt;
		private static GradeDAO instance = new GradeDAO();
		private GradeDAO() {
			con = DatabaseFactory.createDatabase(Vendor.ORACLE, 
					Constants.USER_ID, 
					Constants.USER_PW).getConnection();
		}
		
		public static GradeDAO getInstance() {
			return instance;
		}
	public int insert(GradeBean grade) {
		int result = 0;
		String sql = "insert into grade(seq, grade, java, sql, html, javascript, id, exam_date)"
	+ "values(seq.nextval,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, grade.getGrade());
			pstmt.setInt(2, grade.getJava());
			pstmt.setInt(3, grade.getSql());
			pstmt.setInt(4, grade.getHtml());
			pstmt.setInt(5, grade.getJavascript());
			pstmt.setString(6, grade.getId());
			pstmt.setString(7, grade.getExamDate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int update(GradeBean grade){
		int revise = 0;
		String sql = "update grade set "+grade.getType()+" = ? where seq = ?";
		GradeService impl = GradeServiceImpl.getGradeImpl();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, grade.getScore());
			pstmt.setString(2, grade.getSeq());
			pstmt.executeUpdate();
			grade = findBySeq(Integer.parseInt(grade.getSeq()));
		String sql2 = "update grade set grade = ? where seq = ?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, impl.GradeCal(grade));
			pstmt.setString(2, grade.getSeq());
			revise = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return revise;
	}
	
	public int delete(String delete) {
		int remove = 0;
		String sql = "delete from grade where seq = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, delete);
			remove = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return remove;
	}
	public int exeUpdate(String sql){
		int result = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL, 
										Constants.USER_ID, 
										Constants.USER_PW);
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		return result;
	}
	public List<?> list() {
		List<GradeBean> list = new ArrayList<GradeBean>();
		String sql = "select * from grade";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				GradeBean bean = new GradeBean();
				bean.setSeq(String.valueOf(rs.getInt("SEQ")));
				bean.setId(rs.getString("ID"));
				bean.setExamDate(rs.getString("EXAM_DATE"));
				bean.setGrade(rs.getString("GRADE"));
				bean.setJava(rs.getInt("JAVA"));
				bean.setHtml(rs.getInt("HTML"));
				bean.setJavascript(rs.getInt("JAVASCRIPT"));
				bean.setSql(rs.getInt("SQL"));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public GradeBean findBySeq(int seq) {
		GradeBean temp = null;
		String sql = "select * from grade where seq = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
				if (rs.next()) {
					GradeBean bean = new GradeBean();
					bean.setSeq(String.valueOf(rs.getInt("SEQ")));
					bean.setId(rs.getString("ID"));
					bean.setExamDate(rs.getString("EXAM_DATE"));
					bean.setGrade(rs.getString("GRADE"));
					bean.setJava(rs.getInt("JAVA"));
					bean.setHtml(rs.getInt("HTML"));
					bean.setJavascript(rs.getInt("JAVASCRIPT"));
					bean.setSql(rs.getInt("SQL"));
					temp = bean;
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public List<?> findByID(String id) {
		List<GradeBean> list = new ArrayList<GradeBean>();
		String sql = "select * from grade where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				GradeBean bean = new GradeBean();
				bean.setSeq(String.valueOf(rs.getInt("SEQ")));
				bean.setId(rs.getString("ID"));
				bean.setExamDate(rs.getString("EXAM_DATE"));
				bean.setGrade(rs.getString("GRADE"));
				bean.setJava(rs.getInt("JAVA"));
				bean.setHtml(rs.getInt("HTML"));
				bean.setJavascript(rs.getInt("JAVASCRIPT"));
				bean.setSql(rs.getInt("SQL"));
				list.add(bean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int count(String findByDate){
	int count = 0;
	String sql = "select count(*) as count from grade where EXAM_DATE= ? ";
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, findByDate);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt("COUNT");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return count;
	
	}

	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
}
