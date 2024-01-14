package com.librarie.proiectlibrarie.servlets;

import com.librarie.proiectlibrarie.common.BookDto;
import com.librarie.proiectlibrarie.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@MultipartConfig
@WebServlet(name = "AddBookPhoto", value = "/AddBookPhoto")
public class AddBookPhoto extends HttpServlet {

    @Inject
    BookBean bookBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        Long bookId = Long.parseLong(request.getParameter("id"));

        BookDto book = bookBean.findById(bookId);
        request.setAttribute("book", book);
        request.getRequestDispatcher("WEB-INF/pages/addBookPhoto.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        Long bookId = Long.parseLong(request.getParameter("book_id"));

        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();
        long fileSize = filePart.getSize();
        byte[] fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);

        bookBean.addPhotoToBook(bookId, fileName, fileType, fileContent);
        response.sendRedirect(request.getContextPath() + "/Books");
    }
}