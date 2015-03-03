<%@page import="utils.UtilsDB"%>
<%@page import="utils.Languages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*"%>
<html>
  <head>
  <%
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
    <title><%=UtilsDB.getWord(language, "reportTitle") %></title>
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
			<h1><%=UtilsDB.getWord(language, "reportTitle") %></h1>
		</div>
	  <form action="createReport" method="post"> 
		<div class="row">
			<section class="col-md-3"></section>
			<section class="col-md-2">
				<div class="form-group">
					<h5 style="height:34px;"><%=UtilsDB.getWord(language, "reportPlateNumber") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:34px;"><%=UtilsDB.getWord(language, "reportURLlink") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:34px;"><%=UtilsDB.getWord(language, "reportStreet") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:34px;"><%=UtilsDB.getWord(language, "province") %></h5>
				</div>
			    <div class="form-group">
					<h5 style="height:34px;"><%=UtilsDB.getWord(language, "city") %></h5>
			    </div>
			    <div class="form-group">
					<h5 style="height:34px;"><%=UtilsDB.getWord(language, "reportPostalCode") %></h5>
			    </div>
			</section>
			<section class="col-md-6">
				<div class="form-group">
					<input type="text" name="plateNumber" id="plateNumber" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "reportPlateNumber") %>" value="<%=session.getAttribute("plateNumber") %>"  style="height:34px;">
			    </div>
			    <div class="form-group">
					<input type="text" name="URLlink" id="URLlink" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "reportURLlink") %>" value="<%=session.getAttribute("URLlink") %>" style="height:34px;">
			    </div>
			    <div class="form-group">
					<input type="text" name="street" id="street" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "reportStreet") %>" value="<%=session.getAttribute("street") %>" style="height:34px;">
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
					<input type="text" name="postalCode" id="postalCode" class="form-control input-sm" placeholder="<%=UtilsDB.getWord(language, "reportPostalCode") %>" value="<%=session.getAttribute("postalCode") %>" style="height:34px;">
			    </div>
			</section>
			<section class="col-md-10">
				<div class="form-group">
					<h5><%=UtilsDB.getWord(language, "reportDescription") %></h5>
					<textarea class="form-control" name="description" rows="8" cols="30"><%=session.getAttribute("description") %></textarea>
				</div>
				<div class="form-group">
				</div>
				<div class="form-group">
					<section class="col-md-8">
						<input type="text" id="addCity" name="addCity" class="form-control input-sm" style="visibility: hidden"/>
					</section>
					<section class="col-md-4">
						<input type="submit" id="addCityButton" name="action" value="<%=UtilsDB.getWord(language, "addCity") %>" class="btn btn-primary" style="visibility: hidden;"/>
					</section>
				</div>
			</section>		
		</div>
		<section class="col-md-3"></section>
		<section class="col-md-9">
			<div class="form-group">
				<input type="checkbox" id="accept" name="accept" onClick="EnableSubmit(this)"> <a href="reportAgreement.jsp" onclick="window.open('reportAgreement.jsp', 'newwindow', 'width=800, height=800'); return false;"><%=UtilsDB.getWord(language, "lisenceAgreement") %></a> <br><br><br><br>
				<input type="submit" id="report" name="action" class="btn btn-primary" value="<%=UtilsDB.getWord(language, "reportButton") %>" disabled/>
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
        var sbmt = document.getElementById("report");

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
	    var language = '<%= (String)session.getAttribute("language") %>';
	    cityElement.options[0] = new Option('Select city', '');
	    if(language == "RUS") {
	    	cityElement.options[0] = new Option('Выберите город', '');
	    }
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