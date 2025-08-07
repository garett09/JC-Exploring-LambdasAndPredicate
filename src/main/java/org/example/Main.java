package org.example;
import java.util.function.Predicate;
import java.util.List;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void filterAndPrint(List<String> list, Predicate<String> predicate, String description) {
        System.out.println("--- " + description + " ---");
        for (String item : list) {
            if (predicate.test(item)) {
                System.out.println(item);
            }
        }
        System.out.println(); // Add a blank line for readability
    }
    public static void main(String[] args) {

        Predicate<String> isLong = s -> s.length() > 10;

        String str1 = "short";
        String str2 = "This is a very long string";

        System.out.println("Is '" + str1 + "' long? " + isLong.test(str1));
        System.out.println("Is '" + str2 + "' long? " + isLong.test(str2));

        System.out.println();

        List<String> callSigns = new ArrayList<>();
        callSigns.add("Alpha");
        callSigns.add("Bravo");
        callSigns.add("Archangel");
        callSigns.add("Echo");
        callSigns.add("Avenger");

        // Define a predicate with a lambda to find call signs starting with "A"
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> hasLengthGreaterThan5 = s -> s.length() > 5;

        // Pass the list and the predicate (the behavior) to our method
        filterAndPrint(callSigns, startsWithA, "Call signs starting with 'A'");


        // Let's find call signs that start with 'A' AND have a length > 5
        Predicate<String> complexCondition = startsWithA.and(hasLengthGreaterThan5);
        filterAndPrint(callSigns, complexCondition, "Starts with 'A' AND length > 5");

        // Now let's find call signs that do NOT start with 'A'
        Predicate<String> doesNotStartWithA = startsWithA.negate();
        filterAndPrint(callSigns, doesNotStartWithA, "Does NOT start with 'A'");


    }
}