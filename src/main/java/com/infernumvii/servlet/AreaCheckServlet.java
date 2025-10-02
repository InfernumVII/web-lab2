package com.infernumvii.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import com.infernumvii.controller.TableController;
import com.infernumvii.model.*;
import com.infernumvii.service.*;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;



@WebServlet("/api/area-check")
public class AreaCheckServlet extends HttpServlet {
    
    @Inject 
    AreaCheckService areaCheckService;
    
    @Inject
    TableService tableService;
    
    @Inject
    TableController tableController;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cords cords;
        try {
            cords = parseParameters(request);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, 
                "Invalid parameter format: " + e.getMessage());
            return;
        }

        if (!areaCheckService.validateCords(cords)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, 
                String.format("Invalid coordinates: x=%s, y=%s, R=%s", 
                    cords.getX(), cords.getY(), cords.getR()));
            return;
        }
        
        TableRow tableRow = tableService.createTableRow(cords, (long) request.getAttribute("startTime"));
        tableController.storeRow(tableRow);
        response.sendRedirect(request.getContextPath() + "/table.jsp");
    }

    private Cords parseParameters(HttpServletRequest request) throws NumberFormatException {
        BigDecimal x = new BigDecimal(request.getParameter("x"));
        double y = Double.parseDouble(request.getParameter("y"));
        double R = Double.parseDouble(request.getParameter("R"));
        
        return new Cords(x, y, R);
    }
}
