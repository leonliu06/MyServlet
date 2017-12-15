package biz.superalloy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map.Entry;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet(name = "MyServlet", urlPatterns = { "/my" })
public class MyServlet implements Servlet{
	
	private transient ServletConfig servletConfig;
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletConfig = servletConfig;
		
		//org.apache.catalina.core.StandardContext
		
		
		
	}
	
	@Override
	public ServletConfig getServletConfig(){
		return servletConfig;
	}
	
	@Override
	public String getServletInfo(){
		return "My Servlet";
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println(this.servletConfig.getInitParameter("name"));
		
		Enumeration<String> sEnumeration = servletConfig.getInitParameterNames();
		
		while(sEnumeration.hasMoreElements()){
			System.out.println(sEnumeration.nextElement());
		}
		
		System.out.println("servletConfig.getServletContext() = " + servletConfig.getServletContext());
		
		System.out.println(request.getContentLength());
		System.out.println(request.getContentType());
		System.out.println(request.getParameterMap());
		System.out.println(request.getProtocol());
		System.out.println(request.getCharacterEncoding());
		System.out.println(request.getLocalAddr());
		System.out.println(request.getLocalName());
		System.out.println(request.getLocalPort());
		System.out.println(request.getServletContext());
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("value"));
		//System.out.println(request.getParameter("value").equals(""));
		for(Entry<String, String[]> entry : request.getParameterMap().entrySet()){
			System.out.println(entry.getKey());
			for(String v : entry.getValue()){
				System.out.print(v + " ");
			}
			System.out.println();
		}
		
		Locale locale = request.getLocale();
		System.out.println("locale: " + locale.getCountry() + "-" + locale.getDisplayLanguage() + "-" + locale.getLanguage() + "-" + locale.getDefault());
		
		
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		System.out.println(httpServletRequest.getMethod());
		
		String servletName = servletConfig.getServletName();
		
		//String initParameter = servletConfig.getInitParameter(name)
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head></head>" + "<body>Hello from " + servletName + "<script>alert('xxxx')</script>" + "</body></html>");
	}
	
	@Override
	public void destroy(){
		
	}

}
