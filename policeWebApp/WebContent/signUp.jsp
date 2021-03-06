<%@page import="utils.UtilsDB"%>
<%@page import="utils.Languages"%>
<%@ page import= "com.policeApp.db.DataBaseStandardUtilities" %>
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
    String province;
    String city;
    if(session.getAttribute("province")==null){ province = "0";}
    else {province = (String)session.getAttribute("province");}
    if(session.getAttribute("city")==null){ city = "0";}
    else { city = (String)session.getAttribute("city");}
    %>
    <title><%=UtilsDB.getWord(language, "signUpTitle") %></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0; text/html; charset=UTF-8">
    <link href="css/styles.css" rel="stylesheet">
	<link href="http://fonts.googleapis.com/css?family=Oswald:400,300" rel="stylesheet">
  </head>
  <body>
	<div class="wrapper container">
		<header>
		</header>
		<div class="heading">
			<h1><%=UtilsDB.getWord(language, "signUpTitle") %></h1>
		</div>   
	  <form action="signUpPage" method="post"> 
		<div class="row">
			<section class="col-md-3"></section>
			<section class="col-md-4">
				<div class="form-group">
					<h5 style="height:28px;"><%=UtilsDB.getWord(language, "signUpBadgeNumber") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;"><%=UtilsDB.getWord(language, "signUpAccessCode") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;"><%=UtilsDB.getWord(language, "signUpName") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;"><%=UtilsDB.getWord(language, "signUpFirstName") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;"><%=UtilsDB.getWord(language, "signUpLastName") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;"><%=UtilsDB.getWord(language, "signUpEmail") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;"><%=UtilsDB.getWord(language, "signUpPhone") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;"><%=UtilsDB.getWord(language, "signUpPassword") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;"><%=UtilsDB.getWord(language, "signUpConfirmPassword") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:28px;"><%=UtilsDB.getWord(language, "province") %></h5>
				</div>
			    <div class="form-group">
					<h5 style="height:28px;"><%=UtilsDB.getWord(language, "city") %></h5>
			    </div>
			</section>
			<section class="col-md-6">
				<div class="form-group">
					<input type="text" name="budge" id="budge" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "signUpBadgeNumber") %>" value="<%=session.getAttribute("budge") %>" >
			    </div>
			    <div class="form-group">
					<input type="text" name="accessCode" id="accessCode" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "signUpAccessCode") %>" value="<%=session.getAttribute("accessCode") %>">
			    </div>
			    <div class="form-group">
					<input type="text" name="userName" id="userName" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "signUpName") %>" value="<%=session.getAttribute("userName") %>">
			    </div>
			    <div class="form-group">
					<input type="text" name="userFirstName" id="userFirstName" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "signFirstName") %>" value="<%=session.getAttribute("userFirstName") %>">
			    </div>
			    <div class="form-group">
					<input type="text" name="userLastName" id="userLastName" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "signLastName") %>" value="<%=session.getAttribute("userLastName") %>">
			    </div>
			    <div class="form-group">
					<input type="text" name="email" id="email" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "signUpEmail") %>" value="<%=session.getAttribute("email") %>">
			    </div>
			    <div class="form-group">
					<input type="text" name="phoneNumber" id="phoneNumber" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "signUpPhone") %>" value="<%=session.getAttribute("phone") %>">
			    </div>
			    <div class="form-group">
					<input type="password" name="password" id="password" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "signUpPassword") %>">
			    </div>
			    <div class="form-group">
					<input type="password" name="confirmPassword" id="confirmPassword" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "signUpConfirmPassword") %>">
			    </div>
			    
			    <div class="form-group">
			    	<select id="province" name="province" class="form-control"  <%=DataBaseStandardUtilities.makeDynamicProvinceCity() %> >
						<%=DataBaseStandardUtilities.getProvince(province)%>
					</select>
				</div>
			    <div class="form-group">
					<select id="city" name="city" class="form-control"  onchange="addCityFunction()">
					<%=UtilsDB.createSelectListCity(DataBaseStandardUtilities.getCityArray(), province, city) %>
					</select>
			    </div>
			</section>
			<section class="col-md-10">
				<div class="form-group" style="height: 50%;">
				</div>
				<div class="form-group">
					<section class="col-md-8">
						<input type="text" id="addCity" name="addCity" class="form-control input-sm" style="visibility: hidden"/>
					</section>
					<section class="col-md-2">
						<input type="submit" id="addCityButton" name="action" value="<%=UtilsDB.getWord(language, "addCity") %>" class="btn btn-primary" style="visibility: hidden;"/>
					</section>
				</div>
			</section>		
		</div>
		<section class="col-md-3"></section>
		<section class="col-md-9">
			<div class="form-group">
				<input type="checkbox" id="accept" name="accept" onClick="EnableSubmit(this)"> <a href="signUpAgreement.jsp" onclick="window.open('signUpAgreement.jsp', 'newwindow', 'width=800, height=800'); return false;"><%=UtilsDB.getWord(language, "lisenceAgreement") %></a> <br><br><br><br>
				<input type="submit" id="signUp" name="action" class="btn btn-primary" value="<%=UtilsDB.getWord(language, "signUpButton") %>" disabled/>
				<input type="submit" name="action" class="btn btn-primary" value="<%=UtilsDB.getWord(language, "backButton") %>" />
			</div>
			<br><br><br><br><br><br><br>
		</section>
	  </form>
	</div>
	<footer>
		<jsp:include page="footer.jsp" />
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <script>
    function EnableSubmit(val)
    {
        var sbmt = document.getElementById("signUp");

        if (val.checked == true)
        {
            sbmt.disabled = false;
        }
        else
        {
            sbmt.disabled = true;
        }
    } 
    </script>
    
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
	    document.getElementById("addCity").style.visibility = "hidden";
		document.getElementById("addCityButton").style.visibility = "hidden";
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
