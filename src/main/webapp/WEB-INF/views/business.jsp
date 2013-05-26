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
<a class="btn btn-link" href="<c:url value="/logout" />"> <spring:message
        code="label.logout"/>
</a>

<form:form class="form-horizontal" method="post" action="add/${businessDate}${description}"
           commandName="business">
    <legend>
        <spring:message code="label.title"/>
    </legend>

    <div class="control-group">
        <form:label for="businessDate" class='control-label'
                    path="businessDate">
            <spring:message code="label.date"/>
        </form:label>
        <div class="controls">
            <form:input class='input-medium' placeholder="__.__.____" id="businessDate" path="businessDate"/>
        </div>
    </div>

    <div class="control-group">
        <form:label for="description" class='control-label'
                    path="description">
            <spring:message code="label.description"/>
        </form:label>
        <div class="controls">
            <form:textarea rows="2" id="description" path="description"/>
        </div>
    </div>
    <div class="control-group">

        <div class="controls">
            <input type="submit" class='btn btn-primary'
                   value="<spring:message code="label.addbusiness"/>"/>
        </div>
    </div>
</form:form>

<form:form method="get" action="find/${businessDate}"
           class="form-horizontal" commandName="business">
    <legend>
        <spring:message code="label.findbydate"/>
    </legend>
    <div class="control-group">
        <form:label class='control-label' for="searchDate"
                    path="businessDate">
            <spring:message code="label.date"/>
        </form:label>
        <div class=controls>
            <form:input placeholder="__.__.____" class="input-medium search-query" id="searchDate" path="businessDate"/>
            <input type="submit" class="btn"
                   value="<spring:message code="label.find"/>"/>
        </div>
    </div>
</form:form>

<form:form class="form-horizontal">
    <legend>
        <spring:message code="label.businesses"></spring:message>
    </legend>

    <c:if test="${!empty businessList}">

        <table class="data table table-striped table-condensed">
            <tr>
                <th><spring:message code="label.date"/></th>

                <th><spring:message code="label.description"/></th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${businessList}" var="business">
                <tr>
                    <td>${business.businessDate}</td>
                    <td>${business.description}</td>
                    <td><a href="delete/${business.id}"><spring:message
                            code="label.delete"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</form:form>
</body>
</html>