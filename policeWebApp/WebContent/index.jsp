<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
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
    <%} %>
  </head>
  <body onunload="cleanSession()">
    <div id="myModal" class="modal fade">
        <div class="modal-dialog" style="width:75%; top:15%;">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Hello</h4>
                </div>
                <div class="modal-body">
                	<br><br><br><br><br>
                    <h1>This is non-profit project to make our road safer</h1>
                    <br><br><br><br><br>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
	<div class="wrapper container">
		<header>
		</header>
		<div class="heading">
			<h1>Welcome</h1>
		</div>
		<br><br><br>
		<div class="row">
			<section class="col-md-4"></section>
			<section class="col-md-6">
			  <form action="createReport" method="post"> 
			    <h4 style=" text-align: center;">Compliant</h4>
				<div class="row">
					<section class="col-md-4">
						<div class="form-group">
							<h5>Email</h5>
			    		</div>
			    		<div class="form-group">
							<h5>or</h5>
			    		</div>
			    		<div class="form-group">
							<h5>Phone</h5>
			    		</div>
					</section>
					<section class="col-md-20">
						<div class="form-group">
							<input type="text" name="email" id="email" class="form-control input-sm" placeholder="email" >
			    		</div>
			    		<br>
			    		<div class="form-group">
							<input type="text" name="phone" id="phone" class="form-control input-sm" placeholder="phone" >
			    		</div>
					</section>
				</div>
				<div class="form-group">
					<input type="submit" name="action" class="btn btn-primary" value="Create complaint" style="width:100%" />
				</div>
			  </form>
			  <form action="createReport" method="post"> 
				<hr size=4><br>
				<h4 style=" text-align: center;">Anonymous</h4>
				<div class="form-group">
					<input type="submit" name="action" class="btn btn-primary" value="Create anonumus complaint" style="width:100%" />
				</div>
			  </form>
			</section>
			<section class="col-md-1"></section>
			<section class="col-md-1"></section>
			<section class="col-md-6">
			  <form action="loginServlet" method="post"> 
			    <h4 style=" text-align: center;">Enter</h4>
				<div class="row">
					<section class="col-md-6">
						<div class="form-group">
							<h5>Badge#</h5>
			    		</div>
			    		<br>
			    		<div class="form-group">
							<h5>Password</h5>
			    		</div>
					</section>
					<section class="col-md-18">
						<div class="form-group">
							<input type="text" name="username" id="username" class="form-control input-sm" placeholder="badge" >
			    		</div>
			    		<br>
			    		<div class="form-group">
							<input type="password" name="userpass" id="userpass" class="form-control input-sm" placeholder="password" >
			    		</div>
					</section>
				</div>
			    <div class="form-group">
					<input type="submit" name="action" class="btn btn-primary" value="Sign In" style="width:100%" />
				</div>
			  </form>
			  <form action="signUpPage" method="get"> 
				<div class="form-group">
					<input type="submit" name="action" class="btn btn-primary" value="Sign Up" style="width:100%" />
				</div>
			  </form>
			</section>
		</div>		
	</div>  
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-8 twitter">
					<h3>Twitter feed</h3>
					<time datetime="2015-02-10"><a href="#">10 feb</a></time>
					<p>
						I made website
					</p>
				</div>
				<div class="col-md-4 sitemap">
					<h3>Sitemap</h3>
					<div class="row">
						<div class="col-md-12">
							<a href="">About</a>
							<a href="">Services</a>
						</div>
						<div class="col-md-12">
							<a href="">Support</a>
							<a href="">Contact</a>
						</div>
					</div>
				</div>
				<div class="col-md-4 social">
					<h3>Social networks</h3>
					<a href="http://twitter.com/" class="social-icon twitter"></a>
					<a href="http://facebook.com/" class="social-icon facebook"></a>
					<a href="http://plus.google.com/" class="social-icon google-plus"></a>
					<a href="http://vimeo.com/" class="social-icon-small vimeo"></a>
					<a href="http://youtube.com/" class="social-icon-small youtube"></a>
					<a href="http://flickr.com/" class="social-icon-small flickr"></a>
					<a href="http://instagram.com/" class="social-icon-small instagram"></a>
					<a href="/rss/" class="social-icon-small rss"></a>
				</div>
				<div class="col-md-8 footer-logo">
					some picture here
				</div>
			</div>
		</div>
	</footer>
  </body>
</html>
