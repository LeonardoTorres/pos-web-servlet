<%-- 
    Document   : create.jsp
    Created on : Mar 10, 2020, 8:54:18 PM
    Author     : leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/css/customers/customers.css" rel="stylesheet"/>
        <title>Novo Cliente</title>
    </head>
    <body>
        <main class="create-content">
            <section>
                <h2>Novo Cliente</h2>
                <hr/>
                <form action="/pos-web/customers" method="post">
                    <div>
                        <label for="name">Nome:</label>
                        <input id="name" type="text" name="name"/>
                    </div>
                    <div>
                        <label for="cpf">CPF:</label>
                        <input id="cpf" type="text" name="cpf"/>
                    </div>
                    <div>
                        <label for="age">Idade:</label>
                        <input id="age" type="text" name="age"/>
                    </div>
                    <div>
                        <label for="street">Rua:</label>
                        <input id="street" type="text" name="street"/>
                    </div>
                    <div>
                        <label for="number">Número:</label>
                        <input id="number" type="text" name="number"/>
                    </div>
                    <div>
                        <button class="btn-save" type="submit">Salvar</button>
                    </div>
                </form>
            </section>
        </main>
    </body>
</html>
