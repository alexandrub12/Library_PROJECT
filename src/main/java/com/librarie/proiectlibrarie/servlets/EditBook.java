package com.librarie.proiectlibrarie.servlets;

import com.librarie.proiectlibrarie.common.AutorDto;
import com.librarie.proiectlibrarie.common.BookDto;
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
@WebServlet(name = "EditBook", value = "/EditBook")
public class EditBook extends HttpServlet {

    @Inject
    AutorBean autorBean;

    @Inject
    BookBean bookBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        List<AutorDto> autori=autorBean.findAllAutors();
        request.setAttribute("autori",autori);

        Long bookId=Long.parseLong(request.getParameter("id"));
        BookDto book=bookBean.findById(bookId);
        request.setAttribute("book", book);

        request.getRequestDispatcher("WEB-INF/pages/editBook.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String bookName = request.getParameter("book_name");
        String pagesNumber = request.getParameter("pages_number");
        int cantitate = Integer.parseInt(request.getParameter("cantitate"));
        Long autorId = Long.parseLong(request.getParameter("autor_id"));
        Long bookId = Long.parseLong(request.getParameter("book_id"));


        bookBean.updatedBook(bookId,bookName,pagesNumber,autorId,cantitate);
        response.sendRedirect(request.getContextPath()+"/Books");

    }
}