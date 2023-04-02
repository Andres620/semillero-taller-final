package com.semillero.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.semillero.application.contracts.DTO.core.UserDTO;
import com.semillero.application.contracts.Iservices.IUserService;
import com.semillero.application.implementation.services.UserService;


public class UserController extends HttpServlet{
    private IUserService userService;
    private ObjectMapper mapper;
    //private UserControllerMapper mapper;

    public UserController() {
        userService = new UserService();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();
        if (path == null) {
            List<UserDTO> users = (List<UserDTO>) userService.listUsers();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
            response.setContentType("application/json");
            response.getWriter().println(json);
        } else {
            switch (path) {
                case "/search":
                    String identificationCard = request.getParameter("cedula");
                    try {
                        UserDTO user = userService.findUser(identificationCard);
                        String json = mapper.writeValueAsString(user);
                        response.setContentType("application/json");
                        response.getWriter().println(json);
                    } catch (Exception e) {
                        response.setStatus(404);
                        Map<String, String> error = new HashMap<>();
                        error.put("error", e.getMessage());
                        String json = mapper.writeValueAsString(error);
                        response.setContentType("application/json");
                        response.getWriter().println(json);
                    }
                    break;
                default:
                    response.setStatus(404);
                    Map<String, String> error = new HashMap<>();
                    error.put("error", "Resource not found");
                    String json = mapper.writeValueAsString(error);
                    response.setContentType("application/json");
                    response.getWriter().println(json);
                    break;
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String content = request.getContentType();

        if (content != null && content.equals("application/json")) {
            UserDTO user = mapper.readValue(request.getInputStream(), UserDTO.class);
            System.out.println(user);
            try {
                userService.saveUser(user);
                response.setStatus(HttpServletResponse.SC_CREATED);
                Map<String, String> responseMap  = new HashMap<>();
                responseMap .put("message", "User saved successfully");
                String json = mapper.writeValueAsString(responseMap );
                response.setContentType("application/json");
                response.getWriter().println(json);

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                Map<String, String> error = new HashMap<>();
                error.put("error", e.getMessage());
                String json = mapper.writeValueAsString(error);
                response.setContentType("application/json");
                response.getWriter().println(json);
            }

        } else {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            Map<String, String> error = new HashMap<>();
            error.put("error", "The content must be JSON");
            String json = mapper.writeValueAsString(error);
            response.setContentType("application/json");
            response.getWriter().println(json);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String identificationCard = request.getParameter("cedula");
        try {
            userService.deleteUser(identificationCard);
            response.setStatus(HttpServletResponse.SC_OK);
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("message", "Person deleted successfully");
            String json = mapper.writeValueAsString(responseMap);
            response.setContentType("application/json");
            response.getWriter().println(json);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            String json = mapper.writeValueAsString(error);
            response.setContentType("application/json");
            response.getWriter().println(json);
        }
    }

}
