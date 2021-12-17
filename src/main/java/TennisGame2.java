import java.util.List;

public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";

        score = getMessage(score, P1point, P2point);

        score = getDeuce(score, P1point, P2point);

        score = getAdvantageScoreBoard(score, P1point, P2point);

        score = getScoreBoard(score, P1point, P2point, P1res, P2res);

        score = AdvantagePlayer(score, P1point, P2point);

        score = WinnerPlayer(score,  P1point,  P2point);

        return score;
    }

    private String getMessage(String score, int P1point, int P2point) {
        List<String> message = List.of("Love-All", "Fifteen-All", "Thirty-All");
        if (areEqualsAndLessThan4(P1point, P2point))
        {
            if(P1point<=2){
                score = message.get(P1point);
            }

        }
        return score;
    }

    private boolean areEqualsAndLessThan4(int P1point, int P2point) {
        return areEquals(P1point, P2point) && P1LessThan4(P1point);
    }

    private boolean P1LessThan4(int P1point) {
        return P1point < 4;
    }

    private boolean areEquals(int P1point, int P2point) {
        return P1point == P2point;
    }

    private String getDeuce(String score, int P1point, int P2point) {
        if (isEqualAndGreaterThan3(P1point, P2point))
            score = "Deuce";
        return score;
    }

    private boolean isEqualAndGreaterThan3(int P1point, int P2point) {
        return P1point==P2point && P1point>=3;
    }

    private String getAdvantageScoreBoard(String score, int P1point, int P2point) {
        List<String> message = List.of("Fifteen", "Thirty", "Forty");
        if (greaterThanZeroAndEqualZero(P1point, P2point))
        {
            score = getP1(score, P1point, message);
        }
        if (greaterThanZeroAndEqualZero(P2point, P1point))
        {
            score = getP2(score, P1point, P2point, message);
        }
        return score;
    }

    private String getP2(String score, int P1point, int P2point, List<String> message) {
        if(P1point<=2){
            score =  "Love" + "-" +message.get(P2point) ;
        }
        return score;
    }

    private String getP1(String score, int P1point, List<String> message) {
        if(P1point<=2){
            score = message.get(P1point) + "-" + "Love";
        }
        return score;
    }

    private boolean greaterThanZeroAndEqualZero(int P1point, int P2point) {
        return P1point > 0 && P2point==0;
    }

    private String getScoreBoard(String score, int P1point, int P2point, String P1res, String P2res) {
        if ( PAisGreaterThanPB(P1point, P2point))
        {
            score = getBoard(score, P1point, P2point, P1res,  P2res);
        }

        if (PAisGreaterThanPB(P2point, P1point))
        {
            score = getBoardP2(score, P1point, P2point, P1res,  P2res);
        }
        return score;
    }

    private String getBoardP2(String score, int P1point, int P2point, String P1res, String P2res) {
        P2res = getP2res(P2point, P2res);
        P1res = getP1res(P1point, P1res);
        score = P1res + "-" + P2res;
        return score;
    }

    private String getP2res(int P2point, String P2res) {
        if (P2point ==2)
            P2res="Thirty";
        if (P2point ==3)
            P2res="Forty";
        return P2res;
    }

    private String getP1res(int P1point, String P1res) {
        if (P1point ==1)
            P1res="Fifteen";
        if (P1point ==2)
            P1res="Thirty";
        return P1res;
    }

    private String getBoard(String score, int P1point, int P2point, String P1res, String P2res) {
        P2res = getP1res(P2point, P2res);
        P1res = getP2res(P1point, P1res);
        score = P1res + "-" + P2res;
        return score;
    }

    private boolean PAisGreaterThanPB(int P1point, int P2point) {
        return P1point>P2point && P1point < 4;
    }

    private String AdvantagePlayer(String score,int P1point, int P2point) {
        if (PlayerAGreaterThanPlayerBANDPlayerLessThan3Points(P1point, P2point))
        {
            score = "Advantage player1";
        }

        if (PlayerAGreaterThanPlayerBANDPlayerLessThan3Points(P2point, P1point))
        {
            score = "Advantage player2";
        }
        return score;
    }

    private boolean PlayerAGreaterThanPlayerBANDPlayerLessThan3Points(int P1point, int P2point) {
        return P1point > P2point && P2point >= 3;
    }

    private String WinnerPlayer(String score, int P1point, int P2point) {
        if (WinPlayer(P1point, P2point))
        {
            score = "Win for player1";
        }
        if (WinPlayer(P2point, P1point))
        {
            score = "Win for player2";
        }
        return score;
    }

    private boolean WinPlayer(int P1point, int P2point) {
        return GreaterOrEquals4(P1point, P2point) && PlayerAminusPlayerB(P1point, P2point) >= 2;
    }

    private int PlayerAminusPlayerB(int P1point, int P2point) {
        return P1point - P2point;
    }

    private boolean GreaterOrEquals4(int P1point, int P2point) {
        return P1point >= 4 && P2point >= 0;
    }

    public void SetP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            P1Score();
        }

    }

    public void SetP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            P2Score();
        }

    }

    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}