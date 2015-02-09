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
			<h1>Complain Form</h1>
		</div>
	  <form action="createReport" method="GET"> 
		<div class="row">
			<section class="col-md-3"></section>
			<section class="col-md-2">
				<div class="form-group">
					<h5 style="height:34px;">Plate Number</h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:34px;">URL Link</h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:34px;">Street</h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:34px;">Province</h5>
				</div>
			    <div class="form-group">
					<h5 style="height:34px;">City</h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:34px;">Postal Code</h5>
			    </div>
			</section>
			<section class="col-md-6">
				<div class="form-group">
					<input type="text" name="plateNumber" id="plateNumber" class="form-control input-sm" placeholder="plate number" value="<%=session.getAttribute("plateNumber") %>"  style="height:34px;">
			    </div>
			    <div class="form-group">
					<input type="text" name="URLlink" id="URLlink" class="form-control input-sm" placeholder="url link" value="<%=session.getAttribute("URLlink") %>" style="height:34px;">
			    </div>
			    <div class="form-group">
					<input type="text" name="street" id="street" class="form-control input-sm" placeholder="Street" value="<%=session.getAttribute("street") %>" style="height:34px;">
			    </div>
			    <div class="form-group">
			    	<select id="province" name="province" class="form-control"  <%=DataBaseStandardUtilities.makeDynamicProvinceCity() %> style="height:34px;">
						<%=DataBaseStandardUtilities.getProvince()%>
					</select>
				</div>
			    <div class="form-group">
					<select id="city" name="city" class="form-control"  onchange="addCityFunction()" style="height:34px;"></select>
			    </div>
			    <div class="form-group">
					<input type="text" name="postalCode" id="postalCode" class="form-control input-sm" placeholder="postal code" value="<%=session.getAttribute("postalCode") %>" style="height:34px;">
			    </div>
			</section>
			<section class="col-md-10">
				<div class="form-group">
					<h5>Description</h5>
					<textarea class="form-control" name="description" rows="8" cols="30"><%=session.getAttribute("description") %></textarea>
				</div>
				<div class="form-group">
				</div>
				<div class="form-group">
					<section class="col-md-8">
						<input type="text" id="addCity" name="addCity" class="form-control input-sm" style="visibility: hidden"/>
					</section>
					<section class="col-md-4">
						<input type="submit" id="addCityButton" name="action" value="Add City" class="btn btn-primary" style="visibility: hidden;"/>
					</section>
				</div>
			</section>		
		</div>
		<section class="col-md-3"></section>
		<section class="col-md-6">
			<div class="form-group">
				<input type="submit" name="action" class="btn btn-primary" value="Report" />
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