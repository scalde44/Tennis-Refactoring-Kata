package ejercicio;

public class Player {
    private String name;
    private Score res;
    private int point;

    public Player(String name) {
        this.name = name;
        this.res = Score.Love;
        this.point = 0;
    }

    public String getName() {
        return name;
    }

    public Score getRes() {
        return res;
    }

    public int getPoint() {
        return point;
    }

    public void addPoint() {
        point++;
    }

    public void setRes(Score res) {
        this.res = res;
    }
}
