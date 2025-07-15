<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>URDOGZONE</title>
<style>
	#header{            
	    width:100%;
	    height:50px;
	    text-align: center;
	    background-color: aqua;
	}
	#main{
	    float:left;
	    width:100%;
	}
	#footer{
	    width: 100%;
	    height: 50px;            
	    text-align: center;
	    background-color: orange;
	    clear:both;
	}
	#main{ 
	       min-height: 600px;
	 } 
</style>
</head>
<body>
    <div id="header"><tiles:insertAttribute name="header" /></div>
    <div id="main"><tiles:insertAttribute name="body" /></div>    
    <div id="footer"><tiles:insertAttribute name="footer" /></div>
</body>
</html>