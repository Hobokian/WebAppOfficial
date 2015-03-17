<%@page import="utils.UtilsDB"%>
<%@page import="utils.Languages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%  	Cookie langCookie = UtilsDB.getLangCookie(request, response);
if(request.getParameter("language")!=null) {
	langCookie.setValue(request.getParameter("language"));
	UtilsDB.setLangCookie(request, response, langCookie);
}
String language = langCookie.getValue();
%>

		<div class="container">
			<div class="row">
				<div class="col-md-8 twitter">
					<h3><%=UtilsDB.getWord(language, "footerTwitter") %></h3>
						<%=UtilsDB.getTwit(39728435,1) %>
				</div>
				<div class="col-md-4 sitemap">
					<h3><%=UtilsDB.getWord(language, "footerSitemap") %></h3>
					<div class="row">
						<div class="col-md-12">
							<a href=""><%=UtilsDB.getWord(language, "footerAbout") %></a>
							<a href=""><%=UtilsDB.getWord(language, "footerServices") %></a>
						</div>
						<div class="col-md-12">
							<a href=""><%=UtilsDB.getWord(language, "footerSupport") %></a>
							<a href=""><%=UtilsDB.getWord(language, "footerContact") %></a>
						</div>
					</div>
				</div>
				<div class="col-md-4 social">
					<h3><%=UtilsDB.getWord(language, "footerSocialNetworks") %></h3>
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
					<a href="#"><img src="images/142506889453630.gif"></a>
				</div>
			</div>
		</div>
</body>
</html>