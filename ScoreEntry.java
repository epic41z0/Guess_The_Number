package GameMaking;

public class ScoreEntry {
    private String name;
    private int score;
    

    public ScoreEntry(int score, String name) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }
    
    public int getScore() {
        return this.score;
    }

    
}
