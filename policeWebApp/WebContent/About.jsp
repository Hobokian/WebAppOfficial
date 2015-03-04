<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<html>
  <head>
    <title>Register Form</title>
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
			<h1>Submission Complete</h1>
		</div>
	  <form action="createReport" method="GET"> 
		<div class="row">
			<section class="col-md-3"></section>
			<section class="col-md-10">
				<div>
				<p>
				<h2>What it's all about:</h2><br>
				This is a web application program that that police can access to report/review traffic incidents, 
				including links to video (stored off site, i.e. youtube, etc..)
				reported anonymously or not by witnesses.<br>
				</div>
			</section>		
		</div>
		<section class="col-md-3"></section>
	  </form>
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
							<a href="About.jsp">About</a>
							<a href="">Services</a>
						</div>
						<div class="col-md-12">
							<a href="">Support</a>
							<a href="Contact.jsp">Contact</a>
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
  </body>
</html>