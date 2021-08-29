package com.engeto.example;


import com.sun.source.tree.TryTree;

import java.time.LocalDate;
import java.util.zip.DataFormatException;

public class Flower {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequency;

    public Flower(String name, String notes, LocalDate planted, LocalDate watering, int frequency) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequency = frequency;
    }

    public Flower(String name, LocalDate planted, int frequency) {
        this.name = name;
        this.notes = "";
        this.planted = planted;
        this.watering = LocalDate.now();
        this.frequency = frequency;
    }

    public Flower(String name) {
        this.name = name;
        this.notes = "";
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequency = 7;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) throws PlantException {
        if (watering.isBefore(getPlanted()))
            throw new PlantException("Wrong date of watering: " + watering);
        this.watering = watering;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) throws PlantException {
        if (frequency <= 0)
            throw new PlantException("Wrong value of frequency: " + frequency);
        this.frequency = frequency;
    }
}
