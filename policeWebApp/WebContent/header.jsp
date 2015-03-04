<%@page import="utils.UtilsDB"%>
<%@page import="utils.Languages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</head>
<body>
			<div class="col-md-17 sitemap">
			<form id="callEditProfileServlet" name="callEditProfileServlet" action="editProfile" method="get">
			</form>
      		</div>
			<div class="col-md-3 sitemap">
				<input type="image" src="images/Russia_flag.PNG" 									width="20" height="20" name="languageRus" id="languageRus" onClick="funLanguage('RUS')"/>
				<input type="image" src="images/Great_Britain_flag_clothing_icon_ID_503.png" 		width="20" height="20" name="languageEng" id="languageEng" onClick="funLanguage('EN')"/>
				<input type="image" src="images/53e3a35e6ba7c4173e977b89_france_french_flag.png" 	width="20" height="20" name="languageFra" id="languageFra" onClick="funLanguage('FR')"/>
			</div>
			<div class="dropdown col-md-4 sitemap">
			<%if(session.getAttribute("id")!=null){%>
		        <button class="btn dropdown-toggle logOut" type="button" id="menu1" data-toggle="dropdown"><%=UtilsDB.getWord(language, "headerHi") %>, <%=session.getAttribute("name")%>
		        <span class="caret"></span></button>
		        <ul class="dropdown-menu" role="menu" aria-labelledby="menu1" style="position: absolute; right: 0px; top: 35px;">
			        <li role="presentation"><a role="menuitem" tabindex="1" onclick="editUser()"><%=UtilsDB.getWord(language, "headerEditUser") %></a></li>
<!--			    <li role="presentation"><a role="menuitem" tabindex="2" onclick="fun()">menu2</a></li> 												-->     
			        <li role="presentation" class="divider"></li>
			        <li role="presentation"><a role="menuitem" tabindex="3" onclick="logOutMenu()"><%=UtilsDB.getWord(language, "headerLogout") %></a></li>
		        </ul>
		    <%} %>
      		</div>
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
            
            <script>
            function logOutMenu()
            {
            	//Session.abondon();
            	
            	window.location.href = 'logout.jsp';
            	//TODO clean session
            }
            </script>
            
            <script>
            function editUser()
            {
            	document.getElementById("callEditProfileServlet").submit();
            	
            }
            </script>
</body>
</html>