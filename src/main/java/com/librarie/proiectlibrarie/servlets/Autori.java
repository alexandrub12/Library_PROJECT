package com.librarie.proiectlibrarie.servlets;

import com.librarie.proiectlibrarie.common.AutorDto;
import com.librarie.proiectlibrarie.common.BookDto;
import com.librarie.proiectlibrarie.ejb.AutorBean;
import com.librarie.proiectlibrarie.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
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
    }
}