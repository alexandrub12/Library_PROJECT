package com.librarie.proiectlibrarie.servlets;

import com.librarie.proiectlibrarie.common.AutorDto;
import com.librarie.proiectlibrarie.common.BookDto;
import com.librarie.proiectlibrarie.common.ImprumutareDto;
import com.librarie.proiectlibrarie.ejb.AutorBean;
import com.librarie.proiectlibrarie.ejb.BookBean;
import com.librarie.proiectlibrarie.ejb.ImprumutareBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_IMPRUMUTARI"}))
@WebServlet(name = "EditImprumutare", value = "/EditImprumutare")
public class EditImprumutare extends HttpServlet {

    @Inject
    BookBean bookBean;
    @Inject
    ImprumutareBean imprumutareBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        List<BookDto> books=bookBean.findAllBooks();
        request.setAttribute("books",books);

        Long imprumutareId=Long.parseLong(request.getParameter("id"));
        ImprumutareDto imprumutare=imprumutareBean.findById(imprumutareId);
        request.setAttribute("imprumutare", imprumutare);

        request.getRequestDispatcher("WEB-INF/pages/editImprumutare.jsp").forward(request,response);

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
            Long imprumutareId = Long.parseLong(request.getParameter("imprumutare_id"));

            imprumutareBean.updateImprumutare(imprumutareId,data_imprumutare,data_returnare);

            response.sendRedirect(request.getContextPath()+"/Imprumutari");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
}