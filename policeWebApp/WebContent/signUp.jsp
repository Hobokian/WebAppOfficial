<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ page import= "com.policeApp.db.DataBaseStandardUtilities" %>
</head>
<body>
	<form action="signUpPage" method="GET"> 
        <table>  
            <tr>  
                <td>budge ID</td>  
                <td><input type="text" name="budge" value="<%=session.getAttribute("budge") %>"/></td>  
            </tr>
            <tr>  
                <td>Access Code</td>  
                <td><input type="text" name="accessCode"  value="<%=session.getAttribute("accessCode") %>"/></td>  
            </tr>
            <tr>  
                <td>First and Last Name</td>  
                <td><input type="text" name="userName" value="<%=session.getAttribute("userName") %>" /></td>  
            </tr>
            <tr>  
                <td>Email Address</td>  
                <td><input type="text" name="email" value="<%=session.getAttribute("email") %>" /></td>  
            </tr>
            <tr>  
                <td>Phone Number</td>  
                <td><input type="text" name="phoneNumber" value="<%=session.getAttribute("phone") %>" /></td>  
            </tr>
            <tr>  
                <td>Password</td>  
                <td><input type="text" name="password" /></td>  
            </tr>
            <tr>  
                <td>Confirm Password</td>  
                <td><input type="text" name="confirmPassword" /></td>  
            </tr>
 			<%=DataBaseStandardUtilities.makeDynamicProvinceCity() %>
            <tr>  
                <td><input type="submit" value="signUp" /></td>  
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

