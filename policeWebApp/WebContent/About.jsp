<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<%@page import="utils.UtilsDB"%>
<%@page import="utils.Languages"%>
<html>
  <head>
    <title>Register Form</title>
    <%@ page import= "com.policeApp.db.DataBaseStandardUtilities" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/styles.css" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet">
	<%
	if(request.getParameter("language")!=null) {
		session.setAttribute("language",request.getParameter("language"));
	}
    if(session.getAttribute("language")==null){
    	if(request.getParameter("language")==null) {
    		session.setAttribute("language",Languages.ENGLISH_LANGUAGE);
    	}
    	else//small change
    	{
    		session.setAttribute("language",request.getParameter("language"));
    	}
    }
    String language = (String)session.getAttribute("language");
    %>
  </head>
  <body>
	<div class="wrapper container">
		<header>
			<jsp:include page="header.jsp" />
		</header>
		<div class="heading">
			<h1><%=UtilsDB.getWord(language, "aboutTitle") %></h1>
		</div>
	  <form action="createReport" method="GET"> 
		<div class="row">
			<section class="col-md-3"></section>
			<section class="col-md-10">
				<div>
				<p>
				<h2><%=UtilsDB.getWord(language, "aboutTitle") %></h2><br>
				<%=UtilsDB.getWord(language, "about") %><br>
				</div>
			</section>		
		</div>
		<section class="col-md-3"></section>
	  </form>
	</div>
	
	<footer>
		<jsp:include page="footer.jsp" />
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
  </body>
</html>