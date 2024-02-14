<%@ page language="java" contentType="text/html" import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
     <head>
          <title> Save user jsp</title>
     </head>
     <body bgcolor="skyblue">
          <c:if test="${saveResult == 1}">
               Data Inserted Successfully...${saveResult}
          </c:if>
          <c:if test="${saveResult == 0}">
             Data  Insertion Fail...${saveResult}
             <%@include file="add-user.html" %>
          </c:if>   
     </body>
</html>