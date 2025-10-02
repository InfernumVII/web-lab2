package com.infernumvii.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import com.infernumvii.controller.TableController;
import com.infernumvii.model.Cords;
import com.infernumvii.model.TableRow;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/api/area-check")
public class AreaCheckServlet extends HttpServlet {
    @Inject 
    Cords cords;
    @Inject
    TableController tableController;

    private void updateRow(){
        Cords cords = new Cords();
        cords.setX(this.cords.getX());
        cords.setY(this.cords.getY());
        cords.setR(this.cords.getR());
        TableRow tableRow = new TableRow(cords, "", 0, cords.isPointInTheArea());
        tableController.storeRow(tableRow);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        updateRow();
        PrintWriter printWriter = response.getWriter();
        // printWriter.println(tableController.getHistory().size());
        response.sendRedirect(request.getContextPath() + "/table.jsp");
    }
}
