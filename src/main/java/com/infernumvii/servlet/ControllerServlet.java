package com.infernumvii.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.infernumvii.controller.TableController;
import com.infernumvii.model.Cords;
import com.infernumvii.model.TableRow;
import com.infernumvii.service.AreaCheckService;
import com.infernumvii.service.TableService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
