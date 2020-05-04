<%-- 
    Document   : customers.jsp
    Created on : Mar 10, 2020, 9:26:58 PM
    Author     : leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de clientes</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <a href="${pageContext.request.contextPath}/customers/new">Novo cliente</a>  
        <div>
            <h4>Último cadastrado: ${customer.id} </h4>
            <h4>Último endereço cadastrado: ${customer.address.street}</h4>
        </div>
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Idade</th>
                        <th>Rua</th>
                        <th>Número</th>
                        <th>Criado em</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${customerList}" var="customer">
                        <tr>
                            <td>${customer.name}</td>
                            <td>${customer.cpf}</td>
                            <td>${customer.age}</td>
                            <td>${customer.address.street}</td>
                            <td>${customer.address.number}</td>
                            <td>
                                <fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss" value="${customer.createdAt}"/>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/customers/id/${customer.id}">Editar</a> 
                                <form method="POST" action="${pageContext.request.contextPath}/customers/remove">
                                    <input type="hidden" name="id" value="${customer.id}"/>
                                    <button>
                                        Excluir
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
