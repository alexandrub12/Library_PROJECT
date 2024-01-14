package com.librarie.proiectlibrarie.servlets;

import com.librarie.proiectlibrarie.common.BookDto;
import com.librarie.proiectlibrarie.common.UserDto;
import com.librarie.proiectlibrarie.ejb.BookBean;
import com.librarie.proiectlibrarie.ejb.ImprumutareBean;
import com.librarie.proiectlibrarie.ejb.UserBean;
import com.librarie.proiectlibrarie.entities.User;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_IMPRUMUTARI"}))
@WebServlet(name = "AddImprumutare", value = "/AddImprumutare")
public class AddImprumutare extends HttpServlet {

    @Inject
    BookBean bookBean;
    @Inject
    UserBean userBean;
    @Inject
    ImprumutareBean imprumutareBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        List<BookDto> books=bookBean.findAllBooks();
        request.setAttribute("books",books);

        Principal principal = request.getUserPrincipal();

        if (principal != null) {
            // Get the username
            String username = principal.getName();
            UserDto user=userBean.findUserByUsername(username);
            request.setAttribute("user",user);

            request.setAttribute("test",username);
        }


        request.getRequestDispatcher("WEB-INF/pages/addImprumutare.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String data_imprumutareString = request.getParameter("data_imprumutare");
        String data_returnareString = request.getParameter("data_returnare");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");


        try {
            Date data_imprumutare = dateFormat.parse(data_imprumutareString);
            Date data_returnare = dateFormat.parse(data_returnareString);
            Long bookId = Long.parseLong(request.getParameter("book_id"));
            Long userId = Long.parseLong(request.getParameter("user_id"));

            imprumutareBean.createImprumutare(userId,bookId,data_imprumutare,data_returnare);
            response.sendRedirect(request.getContextPath()+"/Imprumutari");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}