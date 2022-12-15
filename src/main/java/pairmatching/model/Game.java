package pairmatching.model;

public class Game {
    private Course course;
    private Level level;
    private Mission mission;
    private Pair pair;

    public Game(Course course, Level level, Mission mission, Pair pair) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pair = pair;
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }
}
