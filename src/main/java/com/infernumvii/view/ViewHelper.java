package com.infernumvii.view;

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

    public ChartPointDTO getLastChartPoint() {
        if (tableController.getHistory().isEmpty()) {
            return null;
        }
        
        TableRow lastRow = tableController.getHistory().getLast();
        return ChartMapper.toChartPoint(lastRow.getCords());
    }
}
