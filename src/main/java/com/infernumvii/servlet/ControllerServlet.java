package com.infernumvii.servlet;


import java.io.IOException;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/api")
public class ControllerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long startTime = System.nanoTime();
        request.setAttribute("startTime", startTime);

        if (!hasValidParameters(request)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, 
                "Missing or invalid parameters. Required: x, y, R");
            return;
        }

        request.getRequestDispatcher("/api/area-check").forward(request, response);
    }
    
    private boolean hasValidParameters(HttpServletRequest request) {
        Enumeration<String> paramsEnumeration = request.getParameterNames();
        List<String> params = Collections.list(paramsEnumeration);
        return (params.stream()
            .allMatch(param -> Set.of("x", "y", "R").contains(param)) 
            && params.size() == 3);
    }

    
    

}
