package global;

import java.util.List;
import java.util.Map;

/**
 * @date  : 2016. 7. 8.
 * @author: 배근홍
 * @file  : CommandService.java
 * @story  :
 */
public interface CommonService {
	public List<?> list(); 
	public List<?> findBy(String keyword);
	public int count();
	public Map<?,?> map();
	
	
}
