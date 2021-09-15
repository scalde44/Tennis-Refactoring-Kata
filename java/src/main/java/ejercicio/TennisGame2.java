package ejercicio;

public class TennisGame2 implements TennisGame {
    private Player player1;
    private Player player2;
    private String score;

    public TennisGame2(Player player1, Player player2) {
        if (player1 == null || player2 == null) {
            throw new IllegalArgumentException("No debe de mandar objetos null");
        }
        this.player1 = player1;
        this.player2 = player2;
        this.score = "";
    }

    public boolean empate() {
        return player1.getPoint() == player2.getPoint();
    }

    public boolean ventajaPlayer1() {
        return player1.getPoint() > player2.getPoint();
    }

    public String empateConMenosDe3Puntos(int player1Point) {
        String rs = "";
        if (player1Point == 0)
            rs = "Love";
        if (player1Point == 1)
            rs = "Fifteen";
        if (player1Point == 2)
            rs = "Thirty";
        rs += "-All";
        return rs;
    }

    public String resultadoDiferencia(Player p1, Player p2) {
        String rs = "";
        int p1Point = p1.getPoint();
        int p2Point = p2.getPoint();
        if (p2Point == 0) {
            if (p1Point == 1)
                p1.setRes("Fifteen");
            if (p1Point == 2)
                p1.setRes("Thirty");
            if (p1Point == 3)
                p1.setRes("Forty");
            p2.setRes("Love");
            rs = (p1Point > p2Point) ? p1.getRes() + "-" + p2.getRes() : p2.getRes() + "-" + p1.getRes();
        } else if (p1Point < 4) {
            if (p1Point == 2)
                p1.setRes("Thirty");
            if (p1Point == 3)
                p1.setRes("Forty");
            if (p2Point == 1)
                p2.setRes("Fifteen");
            if (p2Point == 2)
                p2.setRes("Thirty");
            rs = (p1Point > p2Point) ? p1.getRes() + "-" + p2.getRes() : p2.getRes() + "-" + p1.getRes();
        } else {
            if ((p1Point - p2Point) > 1) {
                rs = "Win for " + p1.getName();
            } else {
                rs = "Advantage " + p1.getName();
            }
        }
        return rs;
    }

    public String resultadoVentajaPlayer2(Player p1, Player p2) {
        String rs = "";
        return rs;
    }

    public String getScore() {
        if (empate()) {
            score = (player1.getPoint() < 3) ? empateConMenosDe3Puntos(player1.getPoint()) : "Deuce";
        } else if (ventajaPlayer1()) {
            score = resultadoDiferencia(player1, player2);
        } else {
            score = resultadoDiferencia(player2, player1);
        }
        return score;
    }

    public void setPlayerScore(Player player, int number) {
        for (int i = 0; i < number; i++) {
            player.addPoint();
        }

    }

    public void wonPoint(Player player) {
        player.addPoint();
    }

    public static void main(String[] args) {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        TennisGame2 tennisGame2 = new TennisGame2(player1, player2);
        tennisGame2.setPlayerScore(player1, 4);
        tennisGame2.setPlayerScore(player2, 6);
        System.out.println(tennisGame2.getScore());
    }
}