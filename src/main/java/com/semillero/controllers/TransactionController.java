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
import com.semillero.application.contracts.DTO.core.TransactionDTO;
import com.semillero.application.contracts.Iservices.ITransactionService;
import com.semillero.application.implementation.services.TransactionService;

public class TransactionController extends HttpServlet{
    private ITransactionService transactionService;
    private ObjectMapper mapper;

    public TransactionController() {
        transactionService = new TransactionService();
        mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();
        if (path == null) {
            response.setStatus(404);
            Map<String, String> error = new HashMap<>();
            error.put("error", "Resource not found");
            String json = mapper.writeValueAsString(error);
            response.setContentType("application/json");
            response.getWriter().println(json);
        } else {
            switch (path) {
                case "/search":
                    int accountId = Integer.parseInt(request.getParameter("id_cuenta"));
                    try {
                        List<TransactionDTO> transactions = (List<TransactionDTO>) transactionService.listTransactionsAccount(accountId);
                        String json = mapper.writeValueAsString(transactions);
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
            TransactionDTO transaction = mapper.readValue(request.getInputStream(), TransactionDTO.class);
            System.out.println(transaction);
            try {
                transactionService.saveTransaction(transaction);
                response.setStatus(HttpServletResponse.SC_CREATED);
                Map<String, String> responseMap  = new HashMap<>();
                responseMap .put("message", "Transaction saved successfully");
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
}
