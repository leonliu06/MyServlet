<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		String s = dateFormat.format(new Date());
		out.println("Today is " + s);
		out.println(request.getContextPath());
		out.println(request.getParameter("userName"));
		//pageContext.setAttribute(arg0, arg1)
	%>
</body>
</html>