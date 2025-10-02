package com.infernumvii.model;

import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cords {
    private BigDecimal x;
    private double y;
    private double R;
    
    private static final BigDecimal MIN_X = new BigDecimal(-3);
    private static final BigDecimal MAX_X = new BigDecimal(3);
    private static final double MIN_Y = -3.0;
    private static final double MAX_Y = 5.0;
    private static final double MIN_R = 1.0;
    private static final double MAX_R = 5.0;

    public boolean checkY(){
        return (y >= MIN_Y && y <= MAX_Y);
    }

    public boolean checkX(){
        return (x.compareTo(MIN_X) >= 0 && x.compareTo(MAX_X) <= 0);
    }

    public boolean checkR(){
        return (R >= MIN_R && R <= MAX_R);
    }

    public boolean isValid() {
        return (checkX() && checkY() && checkR());
    }
    
    @Override
    public String toString() {
        return "Cords [x=" + x + ", y=" + y + ", R=" + R + "]";
    }
}