package com.infernumvii.view;

import java.util.LinkedList;
import java.util.List;

import com.infernumvii.controller.TableController;
import com.infernumvii.dto.ChartPointDTO;
import com.infernumvii.model.TableRow;
import com.infernumvii.util.ChartMapper;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.*;

@Named("viewHelper")
@RequestScoped
public class ViewHelper {
    @Inject
    private TableController tableController;

    // public ChartPointDTO getLastChartPoint() {
    //     if (tableController.getHistory().isEmpty()) {
    //         return null;
    //     }
        
    //     TableRow lastRow = tableController.getHistory().getLast();
    //     return ChartMapper.toChartPoint(lastRow.getCords());
    // }

    public ChartPointDTO getChartPoint(int index) {
        if (tableController.getHistory().isEmpty() || index > tableController.getHISTORY_SIZE() - 1) {
            return null;
        }

        TableRow exactRow = tableController.getHistory().get(index);
        return ChartMapper.toChartPoint(exactRow.getCords());
        
    }
}
