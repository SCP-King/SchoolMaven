package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {
    private int stationid;
    private String stationname;
    private List<String> lines;
    private List<Integer> next;
    private int provideid;
}
