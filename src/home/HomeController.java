package home;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

@WebServlet({"/home.do"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
/*		String view = request.getServletPath().split("/")[1].split(".do")[0];*/
		String servletPath = request.getServletPath();
		String path = servletPath.split("/")[1];
		String view = path.substring(0, path.indexOf("."));
		System.out.println(view);
	
		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/global/"+view+".jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
