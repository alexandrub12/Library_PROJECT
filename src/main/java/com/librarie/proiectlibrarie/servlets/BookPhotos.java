package com.librarie.proiectlibrarie.servlets;

import com.librarie.proiectlibrarie.common.BookDto;
import com.librarie.proiectlibrarie.common.BookPhotoDto;
import com.librarie.proiectlibrarie.ejb.BookBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "BookPhotos", value = "/BookPhotos")
public class BookPhotos extends HttpServlet {

    @Inject
    BookBean bookBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        Integer bookId = Integer.parseInt(request.getParameter("id"));
        BookPhotoDto photo = bookBean.findPhotoByBookId(bookId);
        if (photo != null) {
            response.setContentType(photo.getFileType());
            response.setContentLength(photo.getFileContent().length);
            response.getOutputStream().write(photo.getFileContent());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }
}