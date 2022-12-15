package pairmatching.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CrewRepository {
    private static final HashMap<String, Crew> repository = new HashMap<>();

    public List<String> getCrewsNameByCourse(Course course) {
        List<String> crews = new ArrayList<>();
        for (String key : repository.keySet()) {
            Crew crew = repository.get(key);
            if (crew.isCourse(course)) {
                crews.add(crew.getName());
            }
        }
        return crews;
    }

    public Crew getCrewByName(String name) {
        return repository.get(name);
    }

    public void save(Crew crew) {
        repository.put(crew.getName(), crew);
    }
}
