package pairmatching.dto;

import java.util.List;

public class MatchingResultDTO {
    private List<String> crew;
    private List<List<String>> partner;

    public MatchingResultDTO(List<String> crew, List<List<String>> partner) {
        this.crew = crew;
        this.partner = partner;
    }

    public List<String> getCrew() {
        return crew;
    }

    public List<List<String>> getPartner() {
        return partner;
    }
}
