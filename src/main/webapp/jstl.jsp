<%-- 
    Document   : jstl
    Created on : Mar 31, 2020, 8:59:21 PM
    Author     : leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL</title>
    </head>
    <body>
        <!-- Antes de usar JSTL, lembrar de baixar a lib para o projeto e depois importar na página -->
        
        <h2>If</h2>
        <c:if test="${2 > 1}">
            <p>2 é maior que 1</p>
        </c:if>
        
        <h2>Switch</h2>
        <c:choose>
            <c:when test="${1 > 1}">
                <p>2 é maior que 1</p>
            </c:when>
            <c:otherwise>
                <p>Não é maior que 1</p>
            </c:otherwise>
        </c:choose>
                
        <h2>For</h2>
        <c:forEach begin="0" end="10" var="i">
            <span>${i}</span>
        </c:forEach>
        
        <h2>Var</h2>
        <c:set var="count" value="1"/>
        ${count}        
                
    </body>
</html>
