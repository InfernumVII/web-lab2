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

import com.infernumvii.model.Cords;
import com.infernumvii.model.StartTime;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api")
public class ControllerServlet extends HttpServlet {
    @Inject
    Cords cords;
    @Inject
    StartTime startTime;

    private boolean formatCords(Function<String, String> t){
        cords.setX(new BigDecimal(t.apply("x")));
        cords.setY(Double.parseDouble(t.apply("y")));
        cords.setR(Double.parseDouble(t.apply("R")));
        return cords.validateCords();
    }

    private boolean checkCords(Enumeration<String> paramsEnumeration) {
        List<String> params = Collections.list(paramsEnumeration);
        return (params.stream()
            .allMatch(param -> Set.of("x", "y", "R").contains(param)) 
            && params.size() == 3);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        startTime.setStartTime(System.nanoTime());
        if (!checkCords(request.getParameterNames()) || !formatCords(request::getParameter)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, String.format("%s, %s, %s, %s, %s, %s, %s", Collections.list(request.getParameterNames()).stream().collect(Collectors.joining("\n")), cords, checkCords(request.getParameterNames()), formatCords(request::getParameter), cords.checkX(), cords.checkY(), cords.checkR()));
            return;
        }
        request.getRequestDispatcher("/api/area-check").forward(request, response);
    }
    
    // public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //     BufferedReader requestReader = request.getReader();
    //     String n = requestReader.lines().collect(Collectors.joining(("\n")));
    //     PrintWriter printWriter = response.getWriter();
    //     printWriter.println(n);
    // }

}
