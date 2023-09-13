<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <%
            String user = (String)session.getAttribute("logged");
            if(user!=null){
        %>   
        
        <h3>Usuário logado: <%=user%></h3>
        
        <%}%>       
        
        <h1>Welcome</h1>
        <h2>Itens Implementados</h2>
        <p>Servlets</p>
        <p>Redirecionamento</p>
        <p>Maven</p>
        <p>Objeto <i>Session</i></p>
        <p>Servlets</p>
        <p>Servlets</p>
        
        <a href="menu">Voltar</a>
    </body>
</html>
