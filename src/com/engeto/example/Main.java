package com.engeto.example;

import java.io.FileNotFoundException;

public class Main {

    public static final String INPUTFILENAME = "kvetiny.txt";
    public static final String OUTPUTFILENAME = "vystup.txt";

    private static void getWateringInfo(FlowersList listOfflower) {
        for (int i = 0; i < listOfflower.getSizeOfList(); i++) {
            System.out.println(listOfflower.getFlower(i).getName()
                + ", Watered: " + listOfflower.getFlower(i).getWatering()
                + ", Next watering: " + listOfflower.getFlower(i).getWatering().plusDays(listOfflower.getFlower(i).getFrequency()));
        }
    }

    public static void printCheckList(FlowersList flowersList) {
        for (int k = 0; k < flowersList.getSizeOfList(); k++) {
            System.out.println(
                    flowersList.getFlower(k).getName() + " "
                            + flowersList.getFlower(k).getNotes() + " "
                            + flowersList.getFlower(k).getPlanted() + " "
                            + flowersList.getFlower(k).getWatering() + " "
                            + flowersList.getFlower(k).getFrequency() + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) throws FileNotFoundException {
        FlowersList flowersList = null;
        try {
            flowersList = FlowersList.importFromFile(INPUTFILENAME);
        } catch (PlantException e) {
            System.err.println("Chyba v otevření souboru: " +e.getMessage());
        }
        flowersList.addToList(new Flower("Lilie"));
        flowersList.addToList(new Flower("Růže"));
        flowersList.addToList(new Flower("Kala"));
        flowersList.removeFromList(1);
        flowersList.exportToFile(OUTPUTFILENAME);

        try {
            flowersList = FlowersList.importFromFile(OUTPUTFILENAME);
        } catch (PlantException e) {
            System.err.println("Chyba v otevření souboru: " +e.getMessage());
        }

        printCheckList(flowersList);


//        Flower flower = new Flower("Kaktus");
//        try {
//            flower.setFrequency(0);
//        } catch (PlantException e) {
//            System.err.println("Wrong value of frequency: " + e.getMessage());
//        }

//        flower.setPlanted(LocalDate.of(2021,8,18));
//        try {
//            flower.setWatering(LocalDate.of(2021,8,10));
//        } catch (PlantException e) {
//            System.err.println("Wrong date of watering: " + e.getMessage());
//        }
        getWateringInfo(flowersList);
    }
}
