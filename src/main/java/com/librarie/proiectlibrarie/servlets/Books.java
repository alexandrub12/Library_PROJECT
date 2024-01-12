package com.librarie.proiectlibrarie.servlets;

import com.librarie.proiectlibrarie.common.BookDto;
import com.librarie.proiectlibrarie.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Books", value = "/Books")
public class Books extends HttpServlet {

    @Inject
    BookBean bookBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        List<BookDto> books=bookBean.findAllBooks();
        request.setAttribute("books",books);
        request.getRequestDispatcher("WEB-INF/pages/Books.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }
}