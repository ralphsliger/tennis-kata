import java.util.List;

public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = "player1";
        this.player2Name = "player2";
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            m_score1 += 1;
        else if (playerName.equals(player2Name))
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        if (sameScore())
        {
           score = areEquals(m_score1);
        }
        else if (isOver4())
        {
            score = over4Score(getMinusResult(m_score1,m_score2));
        }
        else
        {
            score = pointValidation(m_score1, m_score2);
        }
        return score;
    }

    private boolean sameScore() {
        return m_score1==m_score2;
    }

    private boolean isOver4() {
        return m_score1>=4 || m_score2>=4;
    }

    public String areEquals(int m_score1){
        List<String> messages = List.of("Love-All", "Fifteen-All", "Thirty-All", "Deuce");
        return (m_score1 > 2) ? messages.get(3) : messages.get(m_score1) ;
    }

    public String over4Score(int minusResult) {
        switch (minusResult){
            case 1:
                return "Advantage player1";
            case -1:
                return "Advantage player2";
            default:
                return textResultOver2(minusResult);
        }

    }

    private int getMinusResult(int m_score1, int m_score2) {
        int minusResult;
        minusResult = m_score1 - m_score2;
        return minusResult;
    }

    private String textResultOver2(int minusResult) {
        return minusResult >= 2 ? "Win for player1" : "Win for player2";
    }

    private String pointValidation(int m_score1, int m_score2) {
        List<String> message = List.of("Love", "Fifteen", "Thirty", "Forty");
        return message.get(m_score1) + "-" + message.get(m_score2);
    }

}
