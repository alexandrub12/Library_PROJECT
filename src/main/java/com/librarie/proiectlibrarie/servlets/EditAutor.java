package com.librarie.proiectlibrarie.servlets;
import com.librarie.proiectlibrarie.common.AutorDto;
import com.librarie.proiectlibrarie.ejb.AutorBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"WRITE_AUTORS"}))
@WebServlet(name = "EditAutor", value = "/EditAutor")
public class EditAutor extends HttpServlet {

    @Inject
    AutorBean autorBean;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        Long autorId=Long.parseLong(request.getParameter("id"));
        AutorDto autor=autorBean.findById(autorId);
        request.setAttribute("autor", autor);

        request.getRequestDispatcher("WEB-INF/pages/editAutor.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String numeAutor = request.getParameter("nume_autor");
        String prenumeAutor = request.getParameter("prenume_autor");
        Long autorId = Long.parseLong(request.getParameter("autor_id"));

        autorBean.updatedAutor(autorId,numeAutor,prenumeAutor);
        response.sendRedirect(request.getContextPath()+"/Autori");

    }
}