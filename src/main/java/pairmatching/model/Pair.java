package pairmatching.model;

import java.util.List;

public class Pair {
    private List<String> crew;
    private List<List<String>> partner;

    public Pair(List<String> crew, List<List<String>> partner) {
        this.crew = crew;
        this.partner = partner;
    }

    public List<String> getCrew() {
        return crew;
    }

    public List<List<String>> getPartner() {
        return partner;
    }

    public void addPair(String crew, List<String> partner) {
        this.crew.add(crew);
        this.partner.add(partner);
    }

    public int getSize() {
        return crew.size();
    }
}
