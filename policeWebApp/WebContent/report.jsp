<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="java.sql.*"%>
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>welcome on create report page</title>  
<%@ page import= "com.policeApp.db.DataBaseStandardUtilities" %>
</head>  
<body>  
    <h4>your info <%=session.getAttribute("email")%>  <%=session.getAttribute("phone")%></h4>  
    <form action="createReport" method="GET"> 
        <table>  
            <tr>  
                <td>Plate Number</td>  
                <td><input type="text" name="plateNumber" value="<%=session.getAttribute("plateNumber") %>" /></td>  
            </tr>
            <tr>  
                <td>URL Link</td>  
                <td><input type="text" name="URLlink" value="<%=session.getAttribute("URLlink") %>" /></td>  
            </tr>
            <tr>  
                <td>Street</td>  
                <td><input type="text" name="street" value="<%=session.getAttribute("street") %>" /></td>  
            </tr>
 			<%=DataBaseStandardUtilities.makeDynamicProvinceCity() %>
            <tr>  
                <td>Postal Code</td>  
                <td><input type="text" name="postalCode" value="<%=session.getAttribute("postalCode") %>" /></td>  
            </tr>
            <tr>  
                <td>Description</td>  
                <td><textarea name="description" rows="4" cols="50"><%=session.getAttribute("description") %></textarea></td>  
            </tr>
            <tr>  
                <td><input type="submit" value="Report" /></td>  
            </tr>  
        </table>  
    </form> 
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
    }
    </script>
</body>  
</html>