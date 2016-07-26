package subject;

/**
 * @date  : 2016. 7. 26.
 * @author: 배근홍
 * @file  : SubjectServiceImpl.java
 * @story  :
 */
public class SubjectServiceImpl implements SubjectService{

	SubjectDAO dao = SubjectDAO.getInstance();
	
	private static SubjectServiceImpl instance = new SubjectServiceImpl();
	public static SubjectServiceImpl getInstance() {
		return instance;
	}
	private SubjectServiceImpl() {}
	
	public void insert(SubjectBean bean) {
		dao.insert(bean);
	}

}
