package account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountController
 */

@WebServlet({"/bank/main.do","/bank/regist.do","/bank/deposit.do","/bank/withdraw.do","/bank/update.do"
	,"/bank/delete.do","/bank/list.do","/bank/search.do","/bank/count.do"})
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = request.getServletPath().split("/")[2].split(".do")[0];
		String pkg = request.getServletPath().split("/")[1].split(".do")[0];
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/"+pkg+"/"+view+".jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
