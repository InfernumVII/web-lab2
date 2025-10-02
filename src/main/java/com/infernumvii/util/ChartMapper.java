package com.infernumvii.util;

import java.math.BigDecimal;

import com.infernumvii.dto.ChartPointDTO;
import com.infernumvii.model.Cords;

public class ChartMapper {
    private static final int CHART_STEP = 176;
    private static final int CHART_CENTER = 220;

    public static ChartPointDTO toChartPoint(Cords cords) {
        String chartX = calculateChartX(cords.getX(), cords.getR());
        String chartY = calculateChartY(cords.getY(), cords.getR());
        
        return new ChartPointDTO(
            chartX,
            chartY
        );
    }

    private static String calculateChartX(BigDecimal x, double R) {
        BigDecimal globalStep = new BigDecimal(CHART_STEP / R);
        return (x.multiply(globalStep).add(new BigDecimal(CHART_CENTER))).toPlainString();
    }
        

    private static String calculateChartY(double y, double R) {
        double globalStep = CHART_STEP / R;
        return String.valueOf(CHART_CENTER - globalStep * y);
    }
}
