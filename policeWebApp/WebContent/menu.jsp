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
    %>
<body>
				<ul class="list-group menu">
					<li class="btn list-group-item">Menu1</li>
					<li class="btn list-group-item">Menu2</li>
					<li class="btn list-group-item">Menu3</li>
					<li class="btn list-group-item">Menu4</li>
					<li class="btn list-group-item">Menu5</li>
					<li class="btn list-group-item">Menu6</li>
				</ul>
				<div class="panel panel-primary">
					<div class="panel-heading">police news</div>
					<div class="panel-body">
						News Here						
					</div>
				</div>
</body>
</html>