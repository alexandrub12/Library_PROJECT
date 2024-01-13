package com.librarie.proiectlibrarie.servlets;

import com.librarie.proiectlibrarie.common.AutorDto;
import com.librarie.proiectlibrarie.ejb.AutorBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Autori", value = "/Autori")
public class Autori extends HttpServlet {

    @Inject
    AutorBean autorBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        List<AutorDto> autori=autorBean.findAllAutors();
        request.setAttribute("autori",autori);
        request.getRequestDispatcher("WEB-INF/pages/autori.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String[] autorIdsAsString =request.getParameterValues("autor_ids");
        if(autorIdsAsString !=null){
            List<Long> autorIds =new ArrayList<>();
            for(String autorIdAsString : autorIdsAsString){
                autorIds.add(Long.parseLong(autorIdAsString));
            }
            autorBean.deleteAutorsByIds(autorIds);
        }
        response.sendRedirect(request.getContextPath() + "/Autori");
    }
}