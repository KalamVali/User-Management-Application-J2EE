<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
     <c:if test="${result == 1 }">
         Deleted Successfully...
         <jsp:include page="userdelete.html"/>
     </c:if>
     
     <c:if test="${result == 0 }">
         Deletion failed....
         <jsp:include page="userdelete.html"/>
     </c:if>
</body>
</html>