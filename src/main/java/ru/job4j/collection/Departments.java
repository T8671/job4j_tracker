package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();

        for (String value : departments) {
            String[] parts = value.split("/");
            StringBuilder currentPath = new StringBuilder();

            for (String part : parts) {
                if (!currentPath.isEmpty()) {
                    currentPath.append("/");
                }
                currentPath.append(part);
                temp.add(currentPath.toString());
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> departments) {
        Collections.sort(departments);
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }
}
