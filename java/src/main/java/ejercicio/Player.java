package ejercicio;

public class Player {
    private String name;
    private String res;
    private int point;

    public Player(String name) {
        this.name = name;
        this.res = "";
        this.point = 0;
    }

    public String getName() {
        return name;
    }

    public String getRes() {
        return res;
    }

    public int getPoint() {
        return point;
    }

    public void addPoint() {
        point++;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
