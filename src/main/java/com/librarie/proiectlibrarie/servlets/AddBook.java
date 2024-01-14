package com.librarie.proiectlibrarie.servlets;

import com.librarie.proiectlibrarie.common.AutorDto;
import com.librarie.proiectlibrarie.ejb.AutorBean;
import com.librarie.proiectlibrarie.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_BOOKS"}))
@WebServlet(name = "AddBook", value = "/AddBook")
public class AddBook extends HttpServlet {

    @Inject
    BookBean bookBean;
    @Inject
    AutorBean autorBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        List<AutorDto> autori=autorBean.findAllAutors();
        request.setAttribute("autori",autori);
        request.getRequestDispatcher("WEB-INF/pages/addBook.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String bookName = request.getParameter("book_name");
        String pagesNumber = request.getParameter("pages_number");
        int cantitate = Integer.parseInt(request.getParameter("cantitate"));
        Long autorId = Long.parseLong(request.getParameter("autor_id"));

        bookBean.createBook(bookName,pagesNumber,autorId,cantitate);
        response.sendRedirect(request.getContextPath()+"/Books");
    }
}