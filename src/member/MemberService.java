/**
 * 
 */
package member;

import java.util.List;

import global.CommonService;

/**
 * @date  : 2016. 6. 17.
 * @author: 배근홍
 * @file  : StudentService.java
 * @story :
 */
public interface MemberService extends CommonService{
	public String regist(MemberBean mem);
	public void update(MemberBean mem);
	public void delete(MemberBean mem);
	public MemberBean detail(String mem);
	public MemberBean login(MemberBean member);
	public MemberBean getSession();
	public void logoutSession(MemberBean member);
	public List<?> findByName(String findName);
}
