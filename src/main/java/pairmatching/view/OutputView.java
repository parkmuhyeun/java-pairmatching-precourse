package pairmatching.view;

import pairmatching.dto.MatchingResultDTO;
import java.util.List;

public class OutputView {
    private static final String DELIMITER = " : ";
    private static final String NEW_LINE = "\n";

    public void outputMatchingResult(MatchingResultDTO matchingResultDTO) {
        List<String> crew = matchingResultDTO.getCrew();
        List<List<String>> partner = matchingResultDTO.getPartner();
        StringBuilder stringBuilder = new StringBuilder();
        for (int crewIndex = 0; crewIndex < crew.size(); crewIndex++) {
            stringBuilder.append(crew.get(crewIndex));
            for (int partnerIndex = 0; partnerIndex < partner.size(); partnerIndex++) {
                stringBuilder.append(DELIMITER + partner.get(partnerIndex));
            }
            stringBuilder.append(NEW_LINE);
        }
        System.out.println(stringBuilder.toString());
    }
}
