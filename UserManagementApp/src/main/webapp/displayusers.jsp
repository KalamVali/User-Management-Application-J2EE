<%@page import="com.servlet.saveuser.UserDao"%>
<%@ page language="java" contentType="text/html;" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
     <title>Insert title here</title>
</head>
<body bgcolor="pink">
       <table border="1">
            <thead>
                 <tr>
                     <th>UserID</th>
                     <th>UserName</th>
                     <th>UserEmail</th>
                     <th>UserMobile</th>
                     <th>UserLocation</th>
                  </tr>
            </thead>
            
            <tbody>
                 <c:forEach items="<%= new UserDao().findAll()  %>" var="user">
                      <tr>
                          <td>${user.userId}</td>
                          <td>${user.userName}</td>
                          <td>${user.userEmail}</td>
                          <td>${user.userMobile}</td>
                          <td>${user.userLocation}</td> 
                      </tr>
                 </c:forEach>
                 
            </tbody>
       </table>
</body>
</html>