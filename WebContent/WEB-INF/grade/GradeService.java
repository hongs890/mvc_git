package grade;

import java.sql.SQLException;
import java.util.List;

import global.CommonService;

public interface GradeService extends CommonService{
	// 총 7개의 기본 패턴이 존재
	// exeU
	
	public String insert(GradeBean grade);
	public GradeBean findBySeq(int seq);
	public String update(GradeBean grade);
	public String delete(String delete); 
	public String GradeCal(GradeBean grade);
	public int count(String findByCount);
}
