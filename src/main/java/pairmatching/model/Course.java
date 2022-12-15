package pairmatching.model;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static boolean isCourse(String input) {
        return Arrays.stream(values()).anyMatch(course -> course.name.equals(input));
    }

    public String getName() {
        return name;
    }
}
