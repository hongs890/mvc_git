/**
 * 
 */
package bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date  : 2016. 6. 20.
 * @author: 배근홍
 * @file  : AccountServiceImpl.java
 * @story : 계좌 인터페이스
 */
public class AccountServiceImpl implements AccountService {
	AccountDAO dao = AccountDAO.getDao();
	private Map<?,?> map;
	private static AccountServiceImpl instence = new AccountServiceImpl();
	public static AccountServiceImpl getInstence() {
		return instence;
	}
	private AccountServiceImpl() {
		new HashMap<String,AccountMemberBean>();
	}

	@Override
	public String openAccount(AccountBean acc) {
		String result = "";
		acc.setAccountNo((int) (Math.random()*999999)+100000);
		acc.setMoney(0);
		result = (dao.openAccount(acc) == 1)?"계좌 개설에 성공하였습니다":"계좌 개설에 실패하였습니다";
		return result;
	}
	@Override
	public String deposit(String accountNo, String money) {
		String result ="";
		if (dao.deposit(accountNo, money) == 1) {
			result = "입금하였습니다";
		}
		return result;
	}
	@Override
	public String withdraw(String account, String withdrawMoney) {
		String result = "";
		if (Integer.parseInt(withdrawMoney) > dao.findByAcc(Integer.parseInt(account)).getMoney()) {
			result = "잔고가 부족합니다";
		}else {
			result = "출금하였습니다";
			String.valueOf(dao.withDraw(account, withdrawMoney));
		}
		return result;
	}
	@Override
	public String updateAccount(AccountMemberBean acc) {
		return String.valueOf(dao.updateAccount(acc));
	}
	@Override
	public String deleteAccount(String delete) {
		String result = "";
		if (dao.deleteAccount(delete) == 1) {
			result ="삭제 성공";
		}else{
			result ="삭제 실패";
		}
		return result;
	}
	@Override
	public List<?> list() {
		List<?> list = dao.findAccount();
		
		return list;
	}
	@Override
	public AccountMemberBean findByAccountNo(int account) {
		return dao.findByAcc(account);
	}
	@Override
	public List<?> findBy(String name) {
		return dao.findByName(name);
	}
	@Override
	public int count() {
		return dao.count();
	}
	@Override
	public Map<?, ?> map() {
		map = new HashMap<String,AccountMemberBean>();
		map = dao.selectMap();	
		return map;
	}
}
