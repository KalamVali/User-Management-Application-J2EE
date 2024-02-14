<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body bgcolor="skyblue">

       <c:if test="${status == true}">
       
       <c:redirect url="https://sathyatech.com"/>

       </c:if>
       
       <c:if test="${status == false }">
        
       <jsp:include page="user-register.html"/>
       
        Login failed... Enter Valid data...
       
       </c:if>

</body>
</html>