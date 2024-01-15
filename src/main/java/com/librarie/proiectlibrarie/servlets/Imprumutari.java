package com.librarie.proiectlibrarie.servlets;

import com.librarie.proiectlibrarie.common.ImprumutareDto;
import com.librarie.proiectlibrarie.common.UserDto;
import com.librarie.proiectlibrarie.ejb.ImprumutareBean;
import com.librarie.proiectlibrarie.ejb.UserBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@DeclareRoles({"READ_IMPRUMUTARI", "WRITE_IMPRUMUTARI","EDIT_IMPRUMUTARE"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"READ_IMPRUMUTARI"}),
        httpMethodConstraints = {@HttpMethodConstraint(value = "POST", rolesAllowed = {"DELETE_IMPRUMUTARI"})})
@WebServlet(name = "Imprumutari", value = "/Imprumutari")
public class Imprumutari extends HttpServlet {


    @Inject
    ImprumutareBean imprumutareBean;

    @Inject
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {

        Principal principal = request.getUserPrincipal();

        long userId=0;
        if (principal != null) {
            // Get the username
            String username = principal.getName();
            UserDto user=userBean.findUserByUsername(username);
            userId=user.getId();
        }

        List<ImprumutareDto> imprumutari=imprumutareBean.findAllImprumutariByUserId(userId);
        request.setAttribute("imprumutari",imprumutari);
        request.getRequestDispatcher("WEB-INF/pages/imprumutari.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String[] imprumutareIdsAsString =request.getParameterValues("imprumutare_ids");
        if(imprumutareIdsAsString !=null){
            List<Long> imprumutareIds =new ArrayList<>();
            for(String imprumutareIdAsString : imprumutareIdsAsString){
                imprumutareIds.add(Long.parseLong(imprumutareIdAsString));
            }
            imprumutareBean.deleteImprumutariByIds(imprumutareIds);
        }
        response.sendRedirect(request.getContextPath() + "/Imprumutari");

    }
}