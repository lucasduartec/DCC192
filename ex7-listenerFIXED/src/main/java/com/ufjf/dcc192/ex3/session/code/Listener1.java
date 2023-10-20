package com.ufjf.dcc192.ex3.session.code;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class Listener1 implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(">>> Context Initialized");

        context = sce.getServletContext();
        context.setAttribute("userCounter", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(">>> Session Created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(">>> Session Destroyed");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println(">>> Attribute Added: " + event.getName());

        HttpSession session = event.getSession();

        if (event.getName().equals("loggedIn") && session.getAttribute("loggedIn").equals("FALSE")) {
            Integer count = (Integer) context.getAttribute("userCounter");
            context.setAttribute("userCounter", count - 1);
        } else if (event.getName().equals("loggedIn") && session.getAttribute("loggedIn").equals("TRUE")) {
            Integer count = (Integer) context.getAttribute("userCounter");
            context.setAttribute("userCounter", count + 1);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(">>> Attribute Removed: " + event.getName());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println(">>> AttributeReplaced: " + event.getName());

        HttpSession session = event.getSession();

        if (event.getName().equals("loggedIn") && session.getAttribute("loggedIn").equals("FALSE")) {
            Integer count = (Integer) context.getAttribute("userCounter");
            context.setAttribute("userCounter", count - 1);
        } else if (event.getName().equals("loggedIn") && session.getAttribute("loggedIn").equals("TRUE")) {
            Integer count = (Integer) context.getAttribute("userCounter");
            context.setAttribute("userCounter", count + 1);
        }

    }
}
