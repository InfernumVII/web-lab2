package com.infernumvii.model;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RequestScoped
public class StartTime implements Serializable{
    private long startTime;

    public StartTime(){
    }
}