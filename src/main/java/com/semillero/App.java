package com.semillero;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

import com.semillero.controllers.UserController;

public class App 
{
    public static void main( String[] args )
    {
        Server server = new Server(8081);
        server.setHandler(new DefaultHandler());

        ServletContextHandler context = new ServletContextHandler();

        context.setContextPath("/");
        context.addServlet(UserController.class, "/user/*");


        server.setHandler(context);

        try{
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
