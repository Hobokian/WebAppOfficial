<%@page import="utils.UtilsDB"%>
<%@page import="utils.Languages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*"%>
<html>
  <head>
  <%
	Cookie langCookie = UtilsDB.getLangCookie(request, response);
	if(request.getParameter("language")!=null) {
		langCookie.setValue(request.getParameter("language"));
		UtilsDB.setLangCookie(request, response, langCookie);
	}
  	String language = langCookie.getValue();
  %>
    <title><%=UtilsDB.getWord(language, "thanksTitle") %></title>
    <%@ page import= "com.policeApp.db.DataBaseStandardUtilities" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/styles.css" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet">
	
  </head>
  <body>
	<div class="wrapper container">
		<header>
		</header>
		<div class="heading">
			<h1><%=UtilsDB.getWord(language, "thanksTitle") %></h1>
		</div>
		<div class="row">
			<section class="col-md-3"></section>
			<section class="col-md-10">
				<div>
				<p>
				<h2><%=UtilsDB.getWord(language, "thanksHeader") %>.</h2><br>
				<%=UtilsDB.getWord(language, "thanksMessage") %>"<%=session.getAttribute("newCaseID") %>".<br>
				<%=UtilsDB.getWord(language, "thanksPostMessage") %><br>
				</div>
			</section>		
		</div>
		<section class="col-md-3"></section>
		<section class="col-md-6">
			<div class="form-group">
				<input type="submit" name="action" class="btn btn-primary" onclick="window.location.href = 'index.jsp';" />
			</div>
		</section>
	</div>
	
	<footer>
		<jsp:include page="footer.jsp" />
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    

  </body>
</html>