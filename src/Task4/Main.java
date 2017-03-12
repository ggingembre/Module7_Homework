package Task4;

import Task1_2.Order;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Guillaume Gingembre on 12/03/2017.
 */
public class Main{

    public static void main(String[] args) {

        // populating small lists of integers
        System.out.println("Measuring add method\n");
        List<Integer> integerSmallList = new ArrayList<>();
        Instant start = Instant.now();
        for (int i = 0; i <=1000; i++) integerSmallList.add(i);
        Instant end = Instant.now();
        System.out.println("Time to populate small integer ArrayList: " + Duration.between(start, end));

        LinkedList<Integer> integerSmallLinkedList = new LinkedList<>();
        start = Instant.now();
        for (int i = 0; i <=1000; i++) integerSmallLinkedList.add(i);
        end = Instant.now();
        System.out.println("Time to populate small integer LinkedList: " + Duration.between(start, end));

        // populating small lists of strings

        List<String> stringSmallList = new ArrayList<>();
        start = Instant.now();
        for (int i = 0; i <=1000; i++) stringSmallList.add("Some String" + i);
        end = Instant.now();
        System.out.println("Time to populate small string ArrayList: " + Duration.between(start, end));

        LinkedList<String> stringSmallLinkedList = new LinkedList<>();
        start = Instant.now();
        for (int i = 0; i <=1000; i++) stringSmallLinkedList.add("Some String" + i);
        end = Instant.now();
        System.out.println("Time to populate small string LinkedList: " + Duration.between(start, end)+ "\n");


        // printing large lists of integers
        List<Integer> integerLargeList = new ArrayList<>();
        start = Instant.now();
        for (int i = 0; i <=10000; i++) integerLargeList.add(i);
        end = Instant.now();
        System.out.println("Time to populate large integer ArrayList: " + Duration.between(start, end));

        LinkedList<Integer> integerLargeLinkedList = new LinkedList<>();
        start = Instant.now();
        for (int i = 0; i <=10000; i++) integerLargeLinkedList.add(i);
        end = Instant.now();
        System.out.println("Time to populate large integer LinkedList: " + Duration.between(start, end));

        // populating large lists of strings

        List<String> stringLargeList = new ArrayList<>();
        start = Instant.now();
        for (int i = 0; i <=10000; i++) stringLargeList.add("Some String" + i);
        end = Instant.now();
        System.out.println("Time to populate large string ArrayList: " + Duration.between(start, end));

        LinkedList<String> stringLargeLinkedList = new LinkedList<>();
        start = Instant.now();
        for (int i = 0; i <=10000; i++) stringLargeLinkedList.add("Some String" + i);
        end = Instant.now();
        System.out.println("Time to populate large string LinkedList: " + Duration.between(start, end)+"\n");


        //Measuring set method, I will update all fields of the arrays
        System.out.println("Measuring set method\n");
        start = Instant.now();
        for (int i = 0; i <=1000; i++) integerSmallList.set(i, i+i);
        end = Instant.now();
        System.out.println("Time to update small integer ArrayList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <=1000; i++) integerSmallLinkedList.set(i, i+i);
        end = Instant.now();
        System.out.println("Time to update small integer LinkedList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <=1000; i++) stringSmallList.set(i, "Updated String" + i+i);
        end = Instant.now();
        System.out.println("Time to update small string ArrayList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <=1000; i++) stringSmallLinkedList.set(i, "Updated String" + i+i);
        end = Instant.now();
        System.out.println("Time to update small string LinkedList with set method: " + Duration.between(start, end)+"\n");

        start = Instant.now();
        for (int i = 0; i <=10000; i++) integerLargeList.set(i, i+i);
        end = Instant.now();
        System.out.println("Time to update large integer ArrayList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <=10000; i++) integerLargeLinkedList.set(i, i+i);
        end = Instant.now();
        System.out.println("Time to update large integer LinkedList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <=10000; i++) stringLargeList.set(i, "Updated String" + i+i);
        end = Instant.now();
        System.out.println("Time to update large string ArrayList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <=10000; i++) stringLargeLinkedList.set(i, "Updated String" + i+i);
        end = Instant.now();
        System.out.println("Time to update large string LinkedList with set method: " + Duration.between(start, end)+"\n");

        // measuring get methods

        System.out.println("Measuring get method\n");
        start = Instant.now();
        for (int i = 0; i <=1000; i++) integerSmallList.get(i);
        end = Instant.now();
        System.out.println("Time to get small integer ArrayList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <=1000; i++) integerSmallLinkedList.get(i);
        end = Instant.now();
        System.out.println("Time to get small integer LinkedList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <=1000; i++) stringSmallList.get(i);
        end = Instant.now();
        System.out.println("Time to get small string ArrayList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <=1000; i++) stringSmallLinkedList.get(i);
        end = Instant.now();
        System.out.println("Time to get small string LinkedList with set method: " + Duration.between(start, end)+"\n");

        start = Instant.now();
        for (int i = 0; i <=10000; i++) integerLargeList.get(i);
        end = Instant.now();
        System.out.println("Time to get large integer ArrayList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <=10000; i++) integerLargeLinkedList.get(i);
        end = Instant.now();
        System.out.println("Time to get large integer LinkedList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <=10000; i++) stringLargeList.get(i);
        end = Instant.now();
        System.out.println("Time to get large string ArrayList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <=10000; i++) stringLargeLinkedList.get(i);
        end = Instant.now();
        System.out.println("Time to get large string LinkedList with set method: " + Duration.between(start, end)+"\n");

        // measuring remove method

        System.out.println("Measuring remove method\n");
        start = Instant.now();
        for (int i = 0; i < integerSmallList.size(); i++) integerSmallList.remove(i);
        end = Instant.now();
        System.out.println("Time to remove small integer ArrayList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <integerSmallLinkedList.size(); i++) integerSmallLinkedList.remove(i);
        end = Instant.now();
        System.out.println("Time to remove small integer LinkedList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <stringSmallList.size(); i++) stringSmallList.get(i);
        end = Instant.now();
        System.out.println("Time to get small string ArrayList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <stringSmallLinkedList.size(); i++) stringSmallLinkedList.remove(i);
        end = Instant.now();
        System.out.println("Time to remove small string LinkedList with set method: " + Duration.between(start, end)+"\n");

        start = Instant.now();
        for (int i = 0; i <integerLargeList.size(); i++) integerLargeList.remove(i);
        end = Instant.now();
        System.out.println("Time to remove large integer ArrayList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <integerLargeLinkedList.size(); i++) integerLargeLinkedList.remove(i);
        end = Instant.now();
        System.out.println("Time to remove large integer LinkedList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <stringLargeList.size(); i++) stringLargeList.remove(i);
        end = Instant.now();
        System.out.println("Time to remove large string ArrayList with set method: " + Duration.between(start, end));

        start = Instant.now();
        for (int i = 0; i <stringLargeLinkedList.size(); i++) stringLargeLinkedList.remove(i);
        end = Instant.now();
        System.out.println("Time to remove large string LinkedList with set method: " + Duration.between(start, end)+"\n");
    }
}
