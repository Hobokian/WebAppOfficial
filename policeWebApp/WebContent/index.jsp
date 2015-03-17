<%@page import="utils.UtilsDB"%>
<%@page import="utils.Languages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
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
    <title><%=UtilsDB.getWord(language, "splashScreenTitle") %></title>
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
    <%}%>
  </head>
  <body onunload="cleanSession()">
    <div id="myModal" class="modal fade">
        <div class="modal-dialog" style="width:75%; top:15%;">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title"><%=UtilsDB.getWord(language, "splashScreenTitle") %></h4>
                </div>
                <div class="modal-body" align="center">
                	<br><br><br>
                    <h1><%=UtilsDB.getWord(language, "splashScreenInfo") %></h1>
                    <br><br>
                    <div align="center">
                    	<input type="image" src="images/Russia_flag.PNG" 									width="100" height="100" name="languageRus" id="languageRus" onClick="funLanguage('RUS')"/>
						<input type="image" src="images/Great_Britain_flag_clothing_icon_ID_503.png" 		width="100" height="100" name="languageEng" id="languageEng" onClick="funLanguage('EN')"/>
						<input type="image" src="images/53e3a35e6ba7c4173e977b89_france_french_flag.png" 	width="100" height="100" name="languageFra" id="languageFra" onClick="funLanguage('FR')"/>
					</div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"><%=UtilsDB.getWord(language, "splashScreenClose") %></button>
                </div>
            </div>
        </div>
    </div>
	<div class="wrapper container">
		<header>
			<jsp:include page="header.jsp" />
		</header>
		<div class="heading">
			<h1><%=UtilsDB.getWord(language, "indexWelcome") %></h1>
		</div>
		<br><br><br>
		<div class="row">
			<section class="col-md-4"></section>
			<section class="col-md-6">
			  <form action="createReport" method="get"> 
			    <h4 style=" text-align: center;"><%=UtilsDB.getWord(language, "indexComplaint") %></h4>
				<div class="row">
					<section class="col-md-6">
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
					<section class="col-md-18">
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
			  <form action="createReport" method="get"> 
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
	<script>
    function funLanguage(language)
    {
    	var url = window.location.href;    
    	if (url.indexOf("?")>-1)
    	{
    		url = url.substr(0,url.indexOf("?"));
    	}
    	url += '?language=' + language;
    	window.location.href = url;
    }
    </script>
  </body>
</html>
