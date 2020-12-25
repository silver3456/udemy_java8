package com.udemy.java.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FirstNamesTest {
    public static void main(String[] args) throws IOException {
        // /Users/alexander/Desktop/tasks_java8/names.txt

        Path path = Paths.get("/Users/alexander/Desktop/tasks_java8/names.txt");
        List<String> list = Files.readAllLines(path);

        //print the count of names which start with B
        System.out.println(

                list.stream()
                        .filter(name -> name.startsWith("B"))
                        .count()
        );

        //create a list of names which start with C and contains 's' in it
        List<String> names = list.stream()
                .filter(name -> name.startsWith("C"))
                .filter(name -> name.contains("s"))
                .collect(Collectors.toList());

        System.out.println(names.size());

        //print the total number fo chars for all the names starting with M

        System.out.println(

                list.stream()
                        .filter(name -> name.startsWith("M"))
                        .map(String::trim)
                        .map(String::length)
                        .mapToInt(i -> i)
                        .sum()
        );

    }
}
