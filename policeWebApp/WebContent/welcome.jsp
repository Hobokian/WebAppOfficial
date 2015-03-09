<%@page import="utils.UtilsDB"%>
<%@page import="utils.Languages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
    <!--  -->  
<html>
  <head>
  <%
  if(request.getParameter("language")!=null) {
		session.setAttribute("language",request.getParameter("language"));
	}
  if(session.getAttribute("language")==null){
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
    <title><%=UtilsDB.getWord(language, "welcomeTitle") %></title>
    <%@ page import= "com.policeApp.db.DataBaseStandardUtilities" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/styles.css" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet">
  </head>   
  <body>
	<div class="wrapper container">
		<header>
			<jsp:include page="header.jsp" />
		</header>
		<div class="heading">
			<h1><%=UtilsDB.getWord(language, "welcomeTitle") %></h1>
		</div>
		<div class="row">
			<aside class="col-md-5">
				<jsp:include page="menu.jsp" />
				<br><br><br><br><br><br><br>	
			</aside>
			<section class="col-md-19">
				
				<%=DataBaseStandardUtilities.getSelectedIncidents(language,(String)session.getAttribute("filter"),(String)session.getAttribute("id"))%>
			</section>
		</div>
	</div>
	<footer>
		<jsp:include page="footer.jsp" />
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

  </body>
</html>
