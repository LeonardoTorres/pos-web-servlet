<%-- 
    Document   : customers.jsp
    Created on : Mar 10, 2020, 9:26:58 PM
    Author     : leonardo
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.List"%>
<%@page import="br.fjn.edu.pos.web.domain.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <% List<Customer> customerList = (List<Customer>) application
                    .getAttribute("customerList");%>      
        
                           
        <a href="create.jsp">Novo cliente</a>            
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Idade</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Customer customer: customerList) { %>
                         <tr>
                             <td><%=customer.getName()%></td>
                             <td><%=customer.getCpf()%></td>
                             <td><%=customer.getAge()%></td>
                             <td>Editar</td>
                         </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </body>
</html>
