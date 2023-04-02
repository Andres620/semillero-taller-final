package com.semillero.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semillero.application.contracts.Iservices.IUserService;
import com.semillero.application.implementation.services.UserService;
import com.semillero.controllers.mappers.core.UserControllerMapper;

public class UserController extends HttpServlet{
    private IUserService userService;
    private UserControllerMapper mapper;

    public UserController() {
        userService = new UserService();
        mapper = new UserControllerMapper();
    }

    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse response)
    //         throws ServletException, IOException {
    //     String content = request.getContentType();

    //     if (content != null && content.equals("application/json")) {
    //         Map<String, Object> personaMap = mapper.readValue(request.getInputStream(), HashMap.class);
    //         System.out.println(personaMap);
    //         try {
    //             personaService.guardarPersona(personaMap);
    //             response.setStatus(HttpServletResponse.SC_CREATED);
    //             Map<String, String> respuesta = new HashMap<>();
    //             respuesta.put("mensaje", "Persona guardada con exito");
    //             String json = mapper.writeValueAsString(respuesta);
    //             response.setContentType("application/json");
    //             response.getWriter().println(json);

    //         } catch (Exception e) {
    //             response.setStatus(HttpServletResponse.SC_CONFLICT);
    //             Map<String, String> error = new HashMap<>();
    //             error.put("error", e.getMessage());
    //             String json = mapper.writeValueAsString(error);
    //             response.setContentType("application/json");
    //             response.getWriter().println(json);
    //         }

    //     } else {
    //         response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
    //         Map<String, String> error = new HashMap<>();
    //         error.put("error", "El contenido debe ser JSON");
    //         String json = mapper.writeValueAsString(error);
    //         response.setContentType("application/json");
    //         response.getWriter().println(json);
    //     }
    // }

}
