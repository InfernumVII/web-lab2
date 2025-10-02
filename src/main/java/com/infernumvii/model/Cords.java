package com.infernumvii.model;

import java.io.Serializable;
import java.math.BigDecimal;
import com.infernumvii.exception.CordsInvalidFormat;

import jakarta.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

@RequestScoped
@Getter
@Setter
public class Cords implements Serializable {
    private BigDecimal x;
    private static final BigDecimal maxX = new BigDecimal(3);
    private static final BigDecimal minX = new BigDecimal(-3);
    private double y;
    private static final double minY = -3.;
    private static final double maxY = 5.;
    private double R;
    private static final double minR = 1.;
    private static final double maxR = 5.;
    private final int chartStep = 176;

    public Cords() {
    }

    public String getChartX(){
        BigDecimal globalStep = new BigDecimal(chartStep / R);
        return (x.multiply(globalStep).add(new BigDecimal(220))).toPlainString();
    }

    public String getChartY() {
        double globalStep = chartStep / R;
        return String.valueOf(220 - globalStep * y);
    }

    public boolean checkY(){
        return (y >= minY && y <= maxY);
    }

    public boolean checkX(){
        return (x.compareTo(minX) >= 0 && x.compareTo(maxX) <= 0);
    }

    public boolean checkR(){
        return (R >= minR && R <= maxR);
    }

    public boolean validateCords() {
        return (checkX() && checkY() && checkR());
    }
    
    @Override
    public String toString() {
        return "Cords [x=" + x + ", y=" + y + ", R=" + R + "]";
    }

    public boolean isPointInTheArea(){
        boolean circleCond = (
            x.compareTo(BigDecimal.ZERO) >= 0 &&
            y <= 0 &&
            x.pow(2).add(new BigDecimal(y).pow(2))
                .compareTo(new BigDecimal(R * R / 4.0f)) <= 0
        );
        boolean triangleCond = (
                x.compareTo(BigDecimal.ZERO) <= 0 &&
                y >= 0 &&
                y <= R/2.0f &&
                new BigDecimal(y).compareTo(x.add(new BigDecimal(R/2.0f))) <= 0
        );
        boolean squareCond = (
            x.compareTo(BigDecimal.ZERO) >= 0 &&
            y >= 0 &&
            x.compareTo(new BigDecimal(R)) <= 0 &&
            y <= R/2.0f
        );
        return circleCond || triangleCond || squareCond;
    }

 




}