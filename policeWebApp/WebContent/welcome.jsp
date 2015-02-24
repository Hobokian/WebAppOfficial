<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>
    <!--  -->  
<html>
  <head>
    <title>Police web app</title>
    <%@ page import= "com.policeApp.db.DataBaseStandardUtilities" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/styles.css" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet">
  </head>   
  <body>
  <%  %>
	<div class="wrapper container">
		<header>
			<div class="col-md-20 sitemap"></div>
			<div class="dropdown col-md-4 sitemap">
		        <button class="btn dropdown-toggle logOut" type="button" id="menu1" data-toggle="dropdown">Hi, <%=session.getAttribute("name")%>
		        <span class="caret"></span></button>
		        <ul class="dropdown-menu" role="menu" aria-labelledby="menu1" style="position: absolute; right: 0px; top: 35px;">
			        <li role="presentation"><a role="menuitem" tabindex="1" onclick="editUser()">edit profile</a></li>
			        <li role="presentation"><a role="menuitem" tabindex="2" onclick="fun()">menu2</a></li>
			        <li role="presentation" class="divider"></li>
			        <li role="presentation"><a role="menuitem" tabindex="3" onclick="logOutMenu()">Log Out</a></li>
		        </ul>
      		</div>
		</header>
		<div class="heading">
			<h1>Police Application</h1>
		</div>
		<div class="row">
			<aside class="col-md-5">
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
			</aside>
			<section class="col-md-19">
				<%=session.getAttribute("table")%>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script>
    function logOutMenu()
    {
    	window.location.href = 'index.jsp';
    	//TODO clean session
    	
    }
    </script>
    
    <script>
    function editUser()
    {
    	window.location.href = 'editProfile.jsp';
    }
    </script>

  </body>
</html>
