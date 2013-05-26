<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet" type="text/css"/>
    <link
            href="<c:url value="/resources/css/bootstrap-responsive.min.css" />"
            rel="stylesheet" type="text/css"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title"/></title>
</head>
<body>

<form:form class="form-horizontal">
<legend>
    <spring:message code="label.businesses"></spring:message>
</legend>
<c:if test="${!empty businessByDateList}">
<table class="data table table-striped table-condensed">
    <tr>
        <th><spring:message code="label.date"/></th>

        <th><spring:message code="label.description"/></th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach items="${businessByDateList}" var="business">
        <tr>
            <td>${business.businessDate}</td>
            <td>${business.description}</td>
        </tr>
    </c:forEach>

</table>
</c:if>
</form:form>
<a href="../index"><spring:message code="label.home"/></a>