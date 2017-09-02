<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.sz.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更新图书信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h4 align="center">修改图书信息</h4>
  <% Book book =(Book) request.getAttribute("book"); %>
     <form action="BookAction?type=update" method="post">
    	<table align="center"border='1' cellspacing=0>
    		<tr>
    			<td>书名：</td>
    			<td><input type="text" name="bookName" value="<%=book.getBookName() %>"/></td>
    		</tr>
    		<tr>
    			<td>作者：</td>
    			<td><input type="text" name="author" value="<%=book.getAuthor() %>"/></td>
    		</tr>
    		<tr align="center">	
    			<input type="hidden" name="id" value="<%=book.getId() %>" />
    			<td colspan="2"><input type="submit" value="修改"/></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
