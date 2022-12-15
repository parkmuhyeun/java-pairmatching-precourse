package pairmatching.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Crew {
    private Course course;
    private String name;
    private HashMap<String, HashSet<String>> exclusion = new HashMap();

    public Crew(Course course, String name, HashMap<String, HashSet<String>> exclusion) {
        this.course = course;
        this.name = name;
        this.exclusion = exclusion;
        initExclusion(exclusion);
    }

    private void initExclusion(HashMap<String, HashSet<String>> exclusion) {
        Arrays.stream(Level.values()).forEach(level -> exclusion.put(level.getName(), new HashSet<>()));
    }

    public boolean isCourse(Course course) {
        return this.course == course;
    }

    public String getName() {
        return name;
    }

    public boolean checkPair(String level, String partner) {
        HashSet<String> priorPartner = exclusion.get(level);
        return priorPartner.contains(partner);
    }

    public void addExclusion(String level, String partner) {
        HashSet<String> priorPartner = exclusion.get(level);
        priorPartner.add(partner);
    }
}
