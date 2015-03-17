<%@page import="utils.UtilsDB"%>
<%@page import="utils.Languages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
  <%
	Cookie langCookie = UtilsDB.getLangCookie(request, response);
	if(request.getParameter("language")!=null) {
		langCookie.setValue(request.getParameter("language"));
		UtilsDB.setLangCookie(request, response, langCookie);
	}
  String language = langCookie.getValue();
  %>

<%
session.invalidate();
%>
<jsp:forward page="index.jsp" />

</body>
</html>