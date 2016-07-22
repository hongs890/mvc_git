package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import global.DispatcherServlet;
import global.Separator;

@WebServlet("/member.do")	
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== member controller ===");
		Separator.init(request,response);
		MemberService service = MemberServiceImpl.getInstanceImpl();
		MemberBean member = new MemberBean();
		request.setAttribute("member", service.getSession());
		switch (Separator.command.getAction()) {
		case "login" : 
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			String name = service.login(member);
			if (name.equals("")) {
				Separator.command.setPage("login");
				Separator.command.setView();
			} else {
				Separator.command.setDirectory(request.getParameter("directory"));
				member.setName(name);
				request.setAttribute("abc", member);
			}
			break;
		case "regist" : 
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			member.setName(request.getParameter("name"));
			member.setSsn(request.getParameter("ssn"));
			member.setEmail(request.getParameter("email"));
			member.setRegDate();
			String name2 = service.regist(member);
			if (name2 == "") {
				Separator.command.setPage("regist");
				Separator.command.setView();
			} else {
				Separator.command.setPage("login");
				member.setName(name2);
				request.setAttribute("abc", member);
			}
			break;
		case "find_by_id":
			Separator.command.setView();
			break;
		case "update":
			member.setPw(request.getParameter("pw"));
			member.setEmail(request.getParameter("email"));
			service.update(member);
			break;
		case "delete":
			if (request.getParameter("pw").equals(service.getSession().getPw())) {
				member.setId(service.getSession().getId());
				member.setPw(request.getParameter("pw"));
				service.delete(member);
				Separator.command.setDirectory(request.getParameter("directory"));
				Separator.command.setView();
			} else {
				Separator.command.setPage("delete");
				Separator.command.setView();
			}
			break;
		case "logout":
			member.setId(service.getSession().getId());
			member.setPw(service.getSession().getPw());
			service.logoutSession(member);
			Separator.command.setDirectory(request.getParameter("directory"));
			Separator.command.setView();
			break;
		case "count":
			request.setAttribute("member", service.count());
			break;
		}
		DispatcherServlet.send(request, response, Separator.command);
	}
}
