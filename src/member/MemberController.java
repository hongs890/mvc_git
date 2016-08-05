package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.DispatcherServlet;
import global.ParamMap;
import global.Separator;
import subject.SubjectBean;
import subject.SubjectMember;
import subject.SubjectService;
import subject.SubjectServiceImpl;

@WebServlet("/member.do")	
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=== member controller ===");
		HttpSession session = request.getSession();
		Separator.init(request,response);
		MemberService service = MemberServiceImpl.getInstanceImpl();
		SubjectService subjService = SubjectServiceImpl.getInstance();
		SubjectMember sm = new SubjectMember();
		MemberBean member = new MemberBean();
		SubjectBean subject = new SubjectBean();
		switch (Separator.command.getAction()) {
		case "login" : 
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			sm = service.login(member);
			if (sm.getId().equals("fail")) {
				Separator.command.setPage("login");
				Separator.command.setView();
			} else {
				request.setAttribute("user", sm);
				session.setAttribute("user", sm);
				Separator.command.setDirectory(request.getParameter("directory"));
			}
			break;
		case "regist" : 
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			member.setName(request.getParameter("name"));
			member.setSsn(request.getParameter("ssn"));
			member.setEmail(request.getParameter("email"));
			member.setPhone(request.getParameter("phone"));
			member.setRegDate();
			System.out.println("전공 : "+request.getParameter("major"));
			System.out.println("수강과목 : " + ParamMap.getValues(request, "subject").toString());
			String name2 = service.regist(member);
			if (name2 == "") {
				Separator.command.setPage("regist");
				Separator.command.setView();
			} else {
				Separator.command.setPage("login");
				subject.setId(request.getParameter("id"));
				subject.setMajor(request.getParameter("major"));
				subject.setSubjects(ParamMap.getValues(request, "subject"));
				subjService.insert(subject);
				member.setName(name2);
				request.setAttribute("abc", member);
			}
			break;
		case "detail":
			break;
		case "update":
			member = (MemberBean) session.getAttribute("user");
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
		case "find_by_id":
			request.setAttribute("member", service.detail(request.getParameter("keyword")));
			break;
		case "find_by_name":
			request.setAttribute("list", service.findByName(request.getParameter("keyword")));
			break;
		case "list":
			request.setAttribute("list", service.list());
			break;
		case "count":
			request.setAttribute("member", service.count());
			break;
		}
		DispatcherServlet.send(request, response, Separator.command);
	}
}
