<%-- 
    Document   : home
    Created on : Mar 3, 2020, 7:32:48 PM
    Author     : leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial</title>
    </head>
    <body>
        <main>
            <nav>
                <p>Menu aqui</p>
            </nav>
            <section>
                <p style="text-align: right;">
                <%  
                    out.print("Usuário logado: " + application.getAttribute("userName"));
                %>
                </p>
                <p>Card's aqui</p>
                <p>Card's aqui</p>
                <p>Card's aqui</p>
            </section>
        </main>
    </body>
</html>
