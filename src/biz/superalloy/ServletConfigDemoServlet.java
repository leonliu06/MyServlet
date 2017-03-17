package biz.superalloy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ServletConfigDemoServlet", 
	urlPatterns = { "/servletConfigDemo" }, 
	initParams = { 
			@WebInitParam(name = "admin", value = "Harry Taciak"), 
			@WebInitParam(name = "email", value = "admin@example.com") 
		}
	)
public class ServletConfigDemoServlet implements Servlet {
	
	private transient ServletConfig servletConfig;
	
	@Override
	public void init(ServletConfig servletConfig){
		this.servletConfig = servletConfig;
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException ,IOException {
		ServletConfig servletConfig = getServletConfig();
		String admin = servletConfig.getInitParameter("admin");
		String email = servletConfig.getInitParameter("email");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head></head><body>" + "Admin:" + admin + "<br/>Email:" + email + "</body></html>");
		
		ServletContext servletContext = servletConfig.getServletContext();
		//servletContext.getInitParameterNames()
		Enumeration<String> enumeration = servletContext.getAttributeNames();
		while(enumeration.hasMoreElements()){
			System.out.println(enumeration.nextElement());
		}
		
		
		Enumeration<String> e = servletContext.getInitParameterNames();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
		
	}

	@Override
	public ServletConfig getServletConfig(){
		return servletConfig;
	}
	
	@Override
	public String getServletInfo(){
		return "ServletConfig demo";
	}
	
	@Override
	public void destroy(){
		
	}	

}
