package pairmatching.model;

import java.util.HashMap;

public class GameRepository {
    private static final HashMap<String, Game> repository = new HashMap<>();

    public Game saveGame(Game game) {
        repository.put(game.getCourse().getName() + game.getMission().getName(), game);
        return game;
    }
}
