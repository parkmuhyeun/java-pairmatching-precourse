package pairmatching.model;

import pairmatching.dto.GameInfoDTO;

import java.util.HashMap;

public class GameRepository {
    private static final HashMap<String, Game> repository = new HashMap<>();

    public Game saveGame(Game game) {
        repository.put(game.getCourse().getName() + game.getMission().getName(), game);
        return game;
    }

    public boolean hasGame(GameInfoDTO gameInfoDTO) {
        return repository.containsKey(gameInfoDTO.getCourse() + gameInfoDTO.getMission());
    }

    public Game findGameByCourseAndMission(GameInfoDTO gameInfoDTO) {
        String key = gameInfoDTO.getCourse() + gameInfoDTO.getMission();
        if (repository.containsKey(key)) {
            return repository.get(key);
        }
        return null;
    }

    public void deleteAll() {
        repository.clear();
    }
}
