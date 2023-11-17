<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="model.Usuario"%>
<%@page import="model.UsuarioJpaController"%>

<!DOCTYPE html>
<html>       
    
    <%
        EntityManagerFactory emf; 
        emf = Persistence.createEntityManagerFactory("ex9-jpaPU");
        UsuarioJpaController ujc = new UsuarioJpaController(null, emf);
        List <Usuario> lu = ujc.findUsuarioEntities();
        %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Lista de usuários no Banco de Dados</h1>
        <% for(Usuario u: lu){ %>
        <hp>-- <%=u.getNome()%></p>
        <% } %>
    </body>
</html>
