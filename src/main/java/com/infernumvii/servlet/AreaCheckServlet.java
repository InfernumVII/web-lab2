package com.infernumvii.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.infernumvii.controller.TableController;
import com.infernumvii.model.Cords;
import com.infernumvii.model.StartTime;
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
    @Inject
    StartTime startTime;

    private void updateRow(){
        Cords cords = new Cords();
        cords.setX(this.cords.getX());
        cords.setY(this.cords.getY());
        cords.setR(this.cords.getR());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        TableRow tableRow = new TableRow(
                            cords, 
                            formatter.format(date), 
                            TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - startTime.getStartTime()), 
                            cords.isPointInTheArea());
        tableController.storeRow(tableRow);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        updateRow();
        response.sendRedirect(request.getContextPath() + "/table.jsp");
    }
}
