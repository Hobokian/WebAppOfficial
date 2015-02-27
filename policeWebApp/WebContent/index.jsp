<%@page import="utils.UtilsDB"%>
<%@page import="utils.Languages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<html>
  <head>
    <title>Welcome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/styles.css" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<%if(session.getAttribute("bFirst")==null){
		session.setAttribute("bFirst", 1);
	%>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#myModal").modal('show');
		});
    </script>
    <%} 
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
  </head>
  <body onunload="cleanSession()">
    <div id="myModal" class="modal fade">
        <div class="modal-dialog" style="width:75%; top:15%;">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title"><%=UtilsDB.getWord(language, "splashScreenTitle") %></h4>
                </div>
                <div class="modal-body">
                	<br><br><br><br><br>
                    <h1><%=UtilsDB.getWord(language, "splashScreenInfo") %></h1>
                    <br><br><br><br><br>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><%=UtilsDB.getWord(language, "splashScreenClose") %></button>
                </div>
            </div>
        </div>
    </div>
	<div class="wrapper container">
		<header>
		</header>
		<div class="heading">
			<h1><%=UtilsDB.getWord(language, "indexWelcome") %></h1>
		</div>
		<br><br><br>
		<div class="row">
			<section class="col-md-4"></section>
			<section class="col-md-6">
			  <form action="createReport" method="post"> 
			    <h4 style=" text-align: center;"><%=UtilsDB.getWord(language, "indexComplaint") %></h4>
				<div class="row">
					<section class="col-md-4">
						<div class="form-group">
							<h5><%=UtilsDB.getWord(language, "indexEmail") %></h5>
			    		</div>
			    		<div class="form-group">
							<h5><%=UtilsDB.getWord(language, "indexOr") %></h5>
			    		</div>
			    		<div class="form-group">
							<h5><%=UtilsDB.getWord(language, "indexPhone") %></h5>
			    		</div>
					</section>
					<section class="col-md-20">
						<div class="form-group">
							<input type="text" name="email" id="email" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "indexEmail") %>" >
			    		</div>
			    		<br>
			    		<div class="form-group">
							<input type="text" name="phone" id="phone" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "indexPhone") %>" >
			    		</div>
					</section>
				</div>
				<div class="form-group">
					<input type="submit" name="action" class="btn btn-primary" value="<%=UtilsDB.getWord(language, "indexCreateComplaint") %>" style="width:100%" />
				</div>
			  </form>
			  <form action="createReport" method="post"> 
				<hr size=4><br>
				<h4 style=" text-align: center;"><%=UtilsDB.getWord(language, "indexAnonymous") %></h4>
				<div class="form-group">
					<input type="submit" name="action" class="btn btn-primary" value="<%=UtilsDB.getWord(language, "indexCreateAnonymousComplaint") %>" style="width:100%" />
				</div>
			  </form>
			</section>
			<section class="col-md-1"></section>
			<section class="col-md-1"></section>
			<section class="col-md-6">
			  <form action="loginServlet" method="post"> 
			    <h4 style=" text-align: center;"><%=UtilsDB.getWord(language, "indexEnter") %></h4>
				<div class="row">
					<section class="col-md-6">
						<div class="form-group">
							<h5><%=UtilsDB.getWord(language, "indexBadge") %>#</h5>
			    		</div>
			    		<br>
			    		<div class="form-group">
							<h5><%=UtilsDB.getWord(language, "indexPassword") %></h5>
			    		</div>
					</section>
					<section class="col-md-18">
						<div class="form-group">
							<input type="text" name="username" id="username" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "indexBadge") %>" >
			    		</div>
			    		<br>
			    		<div class="form-group">
							<input type="password" name="userpass" id="userpass" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "indexPassword") %>" >
			    		</div>
					</section>
				</div>
			    <div class="form-group">
					<input type="submit" name="action" class="btn btn-primary" value="<%=UtilsDB.getWord(language, "indexSignIn") %>" style="width:100%" />
				</div>
			  </form>
			  <form action="signUpPage" method="get"> 
				<div class="form-group">
					<input type="submit" name="action" class="btn btn-primary" value="<%=UtilsDB.getWord(language, "indexSignUp") %>" style="width:100%" />
				</div>
			  </form>
			</section>
		</div>		
	</div>  
	<footer>
		<jsp:include page="footer.jsp" />
	</footer>
  </body>
</html>
