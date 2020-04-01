<%-- 
    Document   : el.jsp
    Created on : Mar 31, 2020, 7:26:49 PM
    Author     : leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL</title>
    </head>
    <body>
        <!-- Só irá funcionar se tiver no escopo o atributo customerList  -->
        
        ${customerList}
        ${customerList.size() > 1}  
        ${customerList.size() gt 1}  
        
        ${customerList.size() < 1}  
        ${customerList.size() lt 1}  
        
        ${customerList.size() >= 1}  
        ${customerList.size() ge 1}  
        
        ${customerList.size() <= 1}  
        ${customerList.size() le 1}  
        
        ${customerList.size() == 1}  
        ${customerList.size() eq 1}  
        
        ${customerList.size() != 1}  
        ${customerList.size() ne 1}
        
        ${customerList.size() != 1 &&  2 > 2}  
        ${customerList.size() != 1 and  2 > 2}  
  
        ${customerList.size() != 1 ||  2 > 2}  
        ${customerList.size() != 1 or  2 > 2}   
        
        <!--Exemplo de utilização do operador [] -->
        ${customerList[0].name}
        ${customerList[1].name}
        ${customerList[2].name}
        
    </body>
</html>
