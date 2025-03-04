package ru.netology;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> list = parseCSV(columnMapping, fileName);
    }

    private static List<Employee> parseCSV(String[] columnMapping, String fileName) {
        List<Employee> employees = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(fileName));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Employee employee = new Employee(
                        Long.parseLong(nextLine[0]), // id
                        nextLine[1],                 // firstName
                        nextLine[2],                 // lastName
                        nextLine[3],                 // country
                        Integer.parseInt(nextLine[4]) // age
                );
                employees.add(employee);
            }


        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return employees;
    }
}

