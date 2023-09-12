package com.ufjf.dcc192.ex3.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "menu", urlPatterns = {"/menu"})
public class menu extends HttpServlet {
    
    public String senha;
    
    @Override
    public void init(){
        senha = getServletConfig().getInitParameter("senha");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String resp = (String) session.getAttribute("logged");
        
        if(resp == null){
            response.sendRedirect("index.jsp");
        }
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet menu</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Menu</h1>");
                out.println("<h2>Usuário: " +resp+ "</h2>");
                out.println("<a href=\"WelcomeServlet\">Welcome</a>");                
                out.println("<a href=\"sair\">Sair</a>");
                out.println("</body>");
                out.println("</html>");
            
        }        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String user = request.getParameter("user");
       String password = request.getParameter("password");
       
       if(user == null || password == null || !(user.equals("teste") && password.equals(senha)))
       {
           response.sendRedirect("index.jsp");
       }
       else {
           request.getSession(true).setAttribute("logged", user);
           processRequest(request, response);
       }        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
