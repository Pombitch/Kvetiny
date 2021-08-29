package com.engeto.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlowersList {
    public static final String DELIMITER = "\t";
    private List<Flower> listOfFlowers = new ArrayList<>();

    public void addToList(Flower flower) {
        listOfFlowers.add(flower);
    }

    public void removeFromList(int index) {
        listOfFlowers.remove(index);
    }

    public Flower getFlower(int index) {
        Flower flowerFromList = listOfFlowers.get(index);
        return flowerFromList;
    }

    public int getSizeOfList() {
        int sizeOfList = listOfFlowers.size();
        return sizeOfList;
    }

    public static FlowersList importFromFile(String fileName) throws PlantException {
        FlowersList inputList = new FlowersList();
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNextLine()) {
                String inputLine = scanner.nextLine();
                String[] inputArray = inputLine.split("\t");
                if (inputArray.length !=5)
                    throw new PlantException("Chybně definovaný objekt" + inputLine);
                inputList.addToList(new Flower(
                    inputArray[0], //name
                    inputArray[1], //note
                    LocalDate.parse(inputArray[4]), //planted
                    LocalDate.parse(inputArray[3]), //watered
                    Integer.parseInt(inputArray[2]))); //frequency
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor " + fileName + " nenalezen. " +e.getLocalizedMessage());
        }
        return inputList;
    }

    public void exportToFile(String fileName) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            for (Flower flower : listOfFlowers) {
                writer.println(
                        flower.getName() + DELIMITER
                                + flower.getNotes() + DELIMITER
                                + flower.getFrequency() + DELIMITER
                                + flower.getWatering() + DELIMITER
                                + flower.getPlanted());
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Soubor nenalezen: " +e.getLocalizedMessage());
        }
    }

}
