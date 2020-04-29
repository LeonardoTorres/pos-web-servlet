<%-- 
    Document   : update
    Created on : Apr 6, 2020, 7:16:05 PM
    Author     : leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edição de cliente - ${customerToUpdate.name}</title>
    </head>
    <body>
        <h1>Hello World!</h1>
         <main>
            <section>
                <form action="/pos-web/customers/update" method="post">
                    <input type="hidden" name="customer.id" value="${customerToUpdate.id}"/>
                    <div>
                        <label for="name">Nome:</label>
                        <input id="name" type="text" name="customer.name" value="${customerToUpdate.name}"/>
                    </div>
                    <div>
                        <label for="cpf">CPF:</label>
                        <input id="cpf" type="text" name="customer.cpf" value="${customerToUpdate.cpf}"/>
                    </div>
                    <div>
                        <label for="age">Idade:</label>
                        <input id="age" type="text" name="customer.age" value="${customerToUpdate.age}"/>
                    </div>
                    <div>
                        <label for="street">Rua:</label>
                        <input id="street" type="text" name="customer.address.street" value="${customerToUpdate.address.street}"/>
                    </div>
                    <div>
                        <label for="number">Número:</label>
                        <input id="number" type="text" name="customer.address.number" value="${customerToUpdate.address.number}"/>
                    </div>
                    <div>
                        <button type="submit">Salvar</button>
                    </div>
                </form>
            </section>
        </main>
    </body>
</html>
