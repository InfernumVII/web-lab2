package com.infernumvii.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.infernumvii.model.Cords;
import com.infernumvii.model.TableRow;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TableService {

    @Inject
    private AreaCheckService areaCheckService;

    public TableRow createTableRow(Cords cords, long startTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        
        long executionTime = System.nanoTime() - startTime;
        long executionTimeMicros = TimeUnit.NANOSECONDS.toMicros(executionTime);
        
        boolean success = areaCheckService.isPointInTheArea(cords);
        
        return new TableRow(
            cords,
            formatter.format(date),
            executionTimeMicros,
            success
        );
    }
}
