package com.infernumvii.service;

import java.math.BigDecimal;

import com.infernumvii.model.Cords;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AreaCheckService {

    public boolean isPointInTheArea(Cords cords){
        BigDecimal x = cords.getX();
        double y = cords.getY();
        double R = cords.getR();
        //TODO p = x.pow(2).add(new BigDecimal(y).pow(2))
        //    .compareTo(new BigDecimal(R * R / 4.0f)) <= 0 
        
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

    public boolean validateCords(Cords cords) {
        return cords != null && cords.isValid();
    }
}
