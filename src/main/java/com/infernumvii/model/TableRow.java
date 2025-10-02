package com.infernumvii.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TableRow {
    private Cords cords;
    private String currentTimeSeconds;
    private long timeExecution;
    private boolean success;
    
    @Override
    public String toString() {
        return "TableRow [cords=" + cords + ", currentTimeSeconds=" + currentTimeSeconds + ", timeFromStartSeconds="
                + timeExecution + ", success=" + success + "]";
    }  
}
