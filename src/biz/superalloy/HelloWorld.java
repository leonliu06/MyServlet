package biz.superalloy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.Cookies;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet(urlPatterns = "/Helloworld" )
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Hello World I am Servlet");
		
		System.out.println(request.getContentLength());
		System.out.println(request.getContentType());
		System.out.println(request.getContextPath());
		Cookie[] cookies = request.getCookies();
		System.out.println(cookies[0].getName());
		System.out.println(request.getQueryString());
		System.out.println(request.getMethod());
		HttpSession httpSession = request.getSession();
		System.out.println(httpSession.getId());		
	
		//org.apache.catalina.core.StandardContext
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
