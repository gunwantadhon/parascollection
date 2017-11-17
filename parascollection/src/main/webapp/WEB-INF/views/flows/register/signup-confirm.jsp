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


<div class="container">
<div class="row">
 <!-- column to display the personal details -->
 <div class="col-sm-6">
 <div class="panel panel-primary">
 <div class="panel-heading">
 <h4>Personal Details</h4>
 </div>
 <div class="panel-body">
 <!-- code to display the personal details -->


 <div class="text-center">
 <h4>${registerModel.user.firstname} ${registerModel.user.lastname}
</h4>
 <h5>Email : ${registerModel.user.email}</h5>
 <h5>Contact Number : ${registerModel.user.contactNumber}</h5>
 <h5>Role : ${registerModel.user.role}</h5>

 </div>
 </div>
 <div class="panel-footer">
<!-- anchor to move to the edit of personal details -->
<a href="${flowExecutionUrl}&_eventId_personal" class="btn btnprimary">edit</a>
 </div>
 </div>

 </div>

 <!-- column to display the address -->
 <div class="col-sm-6">

 <div class="panel panel-primary">
 <div class="panel-heading">
 <h4>Billing Address</h4>
 </div>
 <div class="panel-body">
<!-- code to display the communication address -->
<div class="text-center">
 <h4>${registerModel.billing.addressLineOne}</h4>
 <h4>${registerModel.billing.addressLineTwo} </h4>
 <h4>${registerModel.billing.city} ${registerModel.billing.postalCode}
</h4>
 <h4>${registerModel.billing.state} ${registerModel.billing.country}
</h4>

 </div>
 </div>
 <div class="panel-footer">
<!-- anchor to move to the edit of address -->
<a href="${flowExecutionUrl}&_eventId_billing" class="btn btnprimary">edit</a>
 </div>
 </div>

 </div>
</div>
<!-- to provide the confirm button after displaying the details -->
<div class="row">
 <div class="col-sm-4 col-sm-offset-4">

 <div class="text-center">

 <!-- anchor to move to the success page -->
<a href="${flowExecutionUrl}&_eventId_submit" class="btn btnprimary">confirm</a>

 </div>

 </div>
</div>
</div>
<%@include file="../shared/flow-footer.jsp"%>




</body>
</html>