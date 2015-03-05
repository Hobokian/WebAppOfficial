<%@page import="utils.UtilsDB"%>
<%@page import="utils.Languages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<%if(session.getAttribute("language")==null){
    	if(request.getParameter("language")==null) {
    		session.setAttribute("language",Languages.ENGLISH_LANGUAGE);
    	}
    	else
    	{
    		session.setAttribute("language",request.getParameter("language"));
    	}
    }
    String language = (String)session.getAttribute("language");
    long twitter_id;
    if(session.getAttribute("twitterProv")==null)
    {
    	twitter_id = 39728435;
    } else {
    	twitter_id = Long.parseLong((String)session.getAttribute("twitterProv"));
    }
    %>
<body>
				<ul class="list-group menu" >
					<li class="btn list-group-item" onclick="homeMenu()" 			><%=UtilsDB.getWord(language, "menuHome") 				%></li>
					<li class="btn list-group-item" onclick="myCaseMenu()"			><%=UtilsDB.getWord(language, "menuMyCases") 			%></li>
					<li class="btn list-group-item" onclick="myCityCaseMenu()"		><%=UtilsDB.getWord(language, "menuMyCityCases") 		%></li>
					<li class="btn list-group-item" onclick="myProvinceCaseMenu()"	><%=UtilsDB.getWord(language, "menuMyProvinceCases") 	%></li>
					<li class="btn list-group-item" onclick="advancedSearchMenu()"	><%=UtilsDB.getWord(language, "menuAdvancedSearch") 	%></li>
					<li class="btn list-group-item" onclick="historyMenu()"			><%=UtilsDB.getWord(language, "menuHistory") 			%></li>
				</ul>
				<div class="panel panel-primary">
					<div class="panel-heading"><%=UtilsDB.getWord(language, "menuPoliceNews") %></div>
					<div class="panel-body">
						<%=UtilsDB.getTwit(twitter_id,1) %>		
						<%=UtilsDB.getTwit(twitter_id,2) %>		
					</div>
				</div>
<script>
	function homeMenu()
	{
		window.location.href = 'welcome.jsp?cmd=0';
	}
	function myCaseMenu()
	{
		window.location.href = 'welcome.jsp?cmd=1';
	}
	function myCityCaseMenu()
	{
		window.location.href = 'welcome.jsp?cmd=2';
	}
	function myProvinceCaseMenu()
	{
		window.location.href = 'welcome.jsp?cmd=3';
	}
	function advancedSearchMenu()
	{
		window.location.href = 'search.jsp';
	}
	function historyMenu()
	{
		window.location.href = 'welcome.jsp?cmd=4';
	}
</script>
</body>
</html>