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
import com.semillero.application.contracts.DTO.core.BankAccountDTO;
import com.semillero.application.contracts.DTO.core.CheckingAccountDTO;
import com.semillero.application.contracts.DTO.core.SavingsAccountDTO;
import com.semillero.application.contracts.DTO.parameters.AccountType;
import com.semillero.application.contracts.Iservices.IAccountService;
import com.semillero.application.implementation.services.AccountService;

public class AccountController extends HttpServlet{
    private IAccountService accountService;
    private ObjectMapper mapper;

    public AccountController() {
        accountService = new AccountService();
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
                    int userId = Integer.parseInt(request.getParameter("id_usuario"));
                    try {
                        List<BankAccountDTO> account = (List<BankAccountDTO>) accountService.listAccountsByUserId(userId);
                        String json = mapper.writeValueAsString(account);
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
            Map <String, Object> accountMap = mapper.readValue(request.getInputStream(), HashMap.class);
            System.out.println(accountMap);
            BankAccountDTO account = null ;
            String accountNuumber = accountMap.get("numberAccount").toString();
            Float balance = Float.parseFloat(accountMap.get("amount").toString());
            int owner = Integer.parseInt(accountMap.get("userId").toString());
            
            if(accountMap.get("accountType").equals(AccountType.CHECKING.toString())){
                AccountType type = AccountType.CHECKING;
                account = new CheckingAccountDTO(accountNuumber, balance,type , owner);
            }else{
                AccountType type = AccountType.SAVINGS;
                account = new SavingsAccountDTO(accountNuumber, balance,type , owner);
            }
            try {
                accountService.saveAccount(account);
                response.setStatus(HttpServletResponse.SC_CREATED);
                Map<String, String> responseMap  = new HashMap<>();
                responseMap .put("message", "Account saved successfully");
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
