package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaLab {

    public static void main(String[] args){

        // EXERCISE 1
        System.out.println("--- 1️⃣ Exercise 1 ---");
        Predicate<String> isLong = s -> s.length() > 10;

        String str1 = "short";
        String str2 = "This is a very long string";

        System.out.println("Is '" + str1 + "' long? " + isLong.test(str1));
        System.out.println("Is '" + str2 + "' long? " + isLong.test(str2));

        // EXERCISE 2
        System.out.println("\n--- 2️⃣ Exercise 2 ---");
        List<String> callSigns = new ArrayList<>();
        callSigns.add("Alpha");
        callSigns.add("Bravo");
        callSigns.add("Archangel");
        callSigns.add("Echo");
        callSigns.add("Avenger");

        // Define a predicate with a lambda to find call signs starting with "A"
        Predicate<String> startsWithA = s -> s.startsWith("A");

        // Pass the list and the predicate (the behavior) to our method
        filterAndPrint(callSigns, startsWithA, "Call signs starting with 'A'");


        // EXERCISE 3
        System.out.println("\n--- 3️⃣ Exercise 3 ---");
        List<String> callSigns3 = new ArrayList<>();
        callSigns3.add("Alpha");
        callSigns3.add("Bravo");
        callSigns3.add("Archangel");
        callSigns3.add("Echo");
        callSigns3.add("Avenger");

        Predicate<String> startsWithA3 = s -> s.startsWith("A");
        Predicate<String> hasLengthGreaterThan5 = s -> s.length() > 5;

        // Let's find call signs that start with 'A' AND have a length > 5
        Predicate<String> complexCondition = startsWithA3.and(hasLengthGreaterThan5);
        filterAndPrint(callSigns3, complexCondition, "Starts with 'A' AND length > 5");

        // Now let's find call signs that do NOT start with 'A'
        Predicate<String> doesNotStartWithA = startsWithA3.negate();
        filterAndPrint(callSigns3, doesNotStartWithA, "Does NOT start with 'A'");







    }


    // helper function for exercise 2 and 3
    public static void filterAndPrint(List<String> list, Predicate<String> predicate, String description) {
        System.out.println("--- " + description + " ---");
        for (String item : list) {
            if (predicate.test(item)) {
                System.out.println(item);
            }
        }
        System.out.println();
    }


}
