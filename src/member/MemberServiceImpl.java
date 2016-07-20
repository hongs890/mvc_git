package member;

import java.util.List;
import java.util.Map;

import bank.AccountService;
import bank.AccountServiceImpl;


/**
 * @date  : 2016. 6. 20.
 * @author: 배근홍
 * @file  : StudentServiceImpl.java
 * @story :
 */
public class MemberServiceImpl implements MemberService {
	
	MemberDAO dao = MemberDAO.getInstance();
	AccountService accService = AccountServiceImpl.getInstence();
	
	MemberBean session;
	private static MemberServiceImpl instanceImpl = new MemberServiceImpl();
	
	private MemberServiceImpl() {
		session = new MemberBean();
	}

	public MemberBean getSession() {
		return session;
	}
	
	public void logoutSession(MemberBean member) {
		if (member.getId().equals(session.getId()) && member.getPw().equals(session.getPw())) {
			session = null;
		}
	}
	
	public static MemberServiceImpl getInstanceImpl() {
		return instanceImpl;
	}
	
	@Override
	public String regist(MemberBean mem) {
		String msg = "";
		if (dao.insert(mem)==1) {
			msg = dao.findById(mem.getId()).getName();
		}
		return msg;
	}

	

	@Override
	public void update(MemberBean mem) {
		dao.update(mem);
		session = dao.findById(mem.getId());
	}

	@Override
	public void delete(MemberBean mem) {
		dao.delete(mem);
		session = dao.findById(mem.getId());
	}
	
	
	public int count() {
		return dao.count();
	}
	@Override
	public MemberBean findById(String id) {
	
		return dao.findById(id);
	}
	public List<?> list() {
		return dao.list();
	}
	public List<?> findByName(String findName) {
		return dao.findByName(findName);
	}
	@Override
	public List<?> findBy(String keyword) {
		return null;
	}
	@Override
	public Map<?, ?> map() {
		return null;
	}
	
	public String login(MemberBean member) {
		String result = "";
			if (dao.login(member)) {
				session = dao.findById(member.getId());
				result = session.getName();
				accService.map();
			}else{
				result = "";
			}
		
		return result;
	}
	public String myAccount() {
		return session.toString();
	}
}