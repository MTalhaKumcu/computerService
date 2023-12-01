package com.solvd.laba.block1.task2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTechnician {
    private List<String> technicians;

    public void setTechnicianName(String fileReader) {
        this.technicians = fileTechnicianReader(fileReader);

    }

    private List<String> fileTechnicianReader(String fileReader) {
        List<String> technicians = new ArrayList<>();
        try (BufferedReader TechnicianBR = new BufferedReader(new FileReader(fileReader))) {
            String cloumn;
            while ((cloumn = TechnicianBR.readLine()) != null) {
                technicians.add(cloumn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return technicians;
    }

    public List<String> getTechniciansName() {
        return technicians;
    }
    //ServiceTechnician setTechnicianName = new technicianNamer ("TechnicianList.txt");

}
