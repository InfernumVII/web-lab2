package com.infernumvii.dto;

import jakarta.enterprise.context.RequestScoped;
import lombok.*;

@Getter
@AllArgsConstructor
@RequestScoped
public class ChartPointDTO {
    private String chartX;
    private String chartY;
}
