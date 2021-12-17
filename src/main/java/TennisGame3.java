
public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = "player1";
        this.p2N = "player2";
    }

    public String getScore() {
        if (lessThan4AndDifferentFrom6()) {
            return getScoreMessage();
        }else{
            return getAdvantageWinOrDeuce();
        }
    }

    private String getAdvantageWinOrDeuce() {
        if(p1AndP2areEquals()) {
           return "Deuce";
       }
        return getAdvantageWin();
    }

    private boolean p1AndP2areEquals() {
        return p1 == p2;
    }

    private String getAdvantageWin() {
        String s = getS();
        return Equals1() ? "Advantage " + s : "Win for " + s;
    }

    private boolean Equals1() {
        return getP1minusP2() * getP1minusP2() == 1;
    }

    private int getP1minusP2() {
        return p1-p2;
    }

    private String getS() {
        String s;
        s = p1 > p2 ? p1N : p2N;
        return s;
    }

    private String getScoreMessage() {
        String s;
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        s = p[p1];
        return (p1 == p2) ? s + "-All" : s + "-" + p[p2];
    }

    private boolean lessThan4AndDifferentFrom6() {
        return lessThan4() && differentFrom6();
    }

    private boolean differentFrom6() {
        return !(p1 + p2 == 6);
    }

    private boolean lessThan4() {
        return p1 < 4 && p2 < 4;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
