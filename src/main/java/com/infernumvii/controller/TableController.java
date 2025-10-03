package com.infernumvii.controller;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.infernumvii.model.TableRow;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Named("tableController")
@SessionScoped
@Getter
@Setter
@NoArgsConstructor
public class TableController implements Serializable {
    private final int HISTORY_SIZE = 18;
    private final List<TableRow> history = new LinkedList<TableRow>();

    public void storeRow(TableRow row){
        if (history.size() >= HISTORY_SIZE) {
            history.remove(0); 
        }
        history.add(row);
    }
}
