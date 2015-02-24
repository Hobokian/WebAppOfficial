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
			<h1>Registration Form</h1>
		</div>
	  <form action="createReport" method="post"> 
		<div class="row">
			<section class="col-md-3"></section>
			<section class="col-md-4">
				<div class="form-group">
					<h5 style="height:28px;">Badge Number</h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;">Access Code</h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;">First and Last Name</h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;">Email Address</h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;">Phone Number</h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;">Password</h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;">Confirm Password</h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;">Province</h5>
				</div>
			    <div class="form-group">
					<h5 style="height:28px;">City</h5>
			    </div>
			</section>
			<section class="col-md-6">
				<div class="form-group">
					<input type="text" name="budge" id="budge" class="form-control input-sm" placeholder="plate number" value="<%=session.getAttribute("budge") %>" >
			    </div>
			    <div class="form-group">
					<input type="text" name="accessCode" id="accessCode" class="form-control input-sm" placeholder="url link" value="<%=session.getAttribute("accessCode") %>">
			    </div>
			    <div class="form-group">
					<input type="text" name="userName" id="userName" class="form-control input-sm" placeholder="Street" value="<%=session.getAttribute("userName") %>">
			    </div>
			    <div class="form-group">
					<input type="text" name="email" id="email" class="form-control input-sm" placeholder="email" value="<%=session.getAttribute("email") %>">
			    </div>
			    <div class="form-group">
					<input type="text" name="phoneNumber" id="phoneNumber" class="form-control input-sm" placeholder="phone" value="<%=session.getAttribute("phone") %>">
			    </div>
			    <div class="form-group">
					<input type="password" name="password" id="password" class="form-control input-sm">
			    </div>
			    <div class="form-group">
					<input type="password" name="confirmPassword" id="confirmPassword" class="form-control input-sm">
			    </div>
			    
			    <div class="form-group">
			    	<select id="province" name="province" class="form-control"  <%=DataBaseStandardUtilities.makeDynamicProvinceCity() %> >
						<%=DataBaseStandardUtilities.getProvince()%>
					</select>
				</div>
			    <div class="form-group">
					<select id="city" name="city" class="form-control"  onchange="addCityFunction()"></select>
			    </div>
			</section>
			<section class="col-md-10">
				<div class="form-group" style="height: 63.5%;">
				</div>
				<div class="form-group">
					<section class="col-md-8">
						<input type="text" id="addCity" name="addCity" class="form-control input-sm" style="visibility: hidden"/>
					</section>
					<section class="col-md-2">
						<input type="submit" id="addCityButton" name="action" value="Add City" class="btn btn-primary" style="visibility: hidden;"/>
					</section>
				</div>
			</section>		
		</div>
		<section class="col-md-3"></section>
		<section class="col-md-9">
			<div class="form-group">
				<input type="submit" name="action" class="btn btn-primary" value="signUp" />
				<input type="submit" name="action" class="btn btn-primary" value="Back" />
			</div>
		</section>
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
    function addCityList(array) {
	    var selectedProvinceIndex = document.getElementById("province").selectedIndex;
	    var cityElement = document.getElementById("city");
	    cityElement.length = 0;
	    cityElement.options[0] = new Option('Select city', '');
	    cityElement.selectedIndex = 0;
	    for (var i = 0; i < array[selectedProvinceIndex-1].length; i++) {
	    	cityElement.options[cityElement.length] = new Option(array[selectedProvinceIndex-1][i],(i+1) );
	    }
	    cityElement.options[cityElement.length]=new Option('add city',i+1 );
    }
    </script>
    
    <script>
    function addCityFunction() {
		var selectedCityIndex = document.getElementById("city").selectedIndex;
		var cityElement = document.getElementById("city");
		if(selectedCityIndex==(cityElement.length-1))
		{
			document.getElementById("addCity").style.visibility = "visible";
			document.getElementById("addCityButton").style.visibility = "visible";
		}
		else
		{
			document.getElementById("addCity").style.visibility = "hidden";
			document.getElementById("addCityButton").style.visibility = "hidden";
		}
    }
    </script>

  </body>
</html>
