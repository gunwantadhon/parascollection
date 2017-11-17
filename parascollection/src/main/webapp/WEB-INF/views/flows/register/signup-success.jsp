<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<title>Online Shopping ${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap CSS theme -->
<link href="${css}/paper-bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap CSS theme -->
<link href="${css}/datatables.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<script type="text/javascript">
window.menu = '${title}';
window.contextRoot='${contextRoot}'
</script>

</head>
<body>


<%@include file="../shared/flow-header.jsp"%>
<div class="container">
<div class="row">
 <div class="col-sm-offset-4 col-sm-4">

 <div class="text-center">
 <h1>Welcome!</h1>
 <h3>onlineshopping.com</h3>
 <h6>You can use your email address as username to login!</h6>
 <div>
 <a href="${contextRoot}/login" class="btn btn-lg btn-success">Login
Here</a>
 </div>
 </div>

 </div>
</div>
</div>
<%@include file="../shared/flow-footer.jsp"%>
</body>
</html>