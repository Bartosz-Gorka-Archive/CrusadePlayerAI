package put.ai.games.blackpower;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import put.ai.games.game.Board;
import put.ai.games.game.Move;
import put.ai.games.game.Player.Color;
import put.ai.games.game.Player;

/**
 * SI - Player
 */
public class BlackPower extends Player {

    /**
     * Random to ensure make next move
     */
    private Random random = new Random();

    /**
     * Player name
     */
    @Override
    public String getName() {
        return "MyPlayerName";
    }

    /**
     * Make next move in game
     * @param b Board
     * @return Move in the next round
     */
    @Override
    public Move nextMove(Board b) {
        int startCount = countStones(b);
        List<Move> moves = b.getMovesFor(getColor());

        List<Move> point_0 = new ArrayList();
        List<Move> point_1 = new ArrayList();
        List<Move> point_2 = new ArrayList();
        List<Move> point_3 = new ArrayList();
        List<Move> point_4 = new ArrayList();
        List<Move> point_5 = new ArrayList();
        List<Move> point_6 = new ArrayList();
        List<Move> point_7 = new ArrayList();
        List<Move> point_8 = new ArrayList();

        for (Move move : moves) {
            Board myBoard = b.clone();

            myBoard.doMove(move);

            int stones = countStones(myBoard);
            int result = stones - startCount;

            switch (result) {
                case 0:
                    point_0.add(move);
                    break;
                case 1:
                    point_1.add(move);
                    break;
                case 2:
                    point_2.add(move);
                    break;
                case 3:
                    point_3.add(move);
                    break;
                case 4:
                    point_4.add(move);
                    break;
                case 5:
                    point_5.add(move);
                    break;
                case 6:
                    point_6.add(move);
                    break;
                case 7:
                    point_7.add(move);
                    break;
                case 8:
                    point_8.add(move);
                    break;
            }
        }

        if (!point_8.isEmpty()) {
          return point_8.get(random.nextInt(point_8.size()));
        }
        if (!point_7.isEmpty()) {
          return point_7.get(random.nextInt(point_7.size()));
        }
        if (!point_6.isEmpty()) {
          return point_6.get(random.nextInt(point_6.size()));
        }
        if (!point_5.isEmpty()) {
          return point_5.get(random.nextInt(point_5.size()));
        }
        if (!point_4.isEmpty()) {
          return point_4.get(random.nextInt(point_4.size()));
        }
        if (!point_3.isEmpty()) {
          return point_3.get(random.nextInt(point_3.size()));
        }
        if (!point_2.isEmpty()) {
          return point_2.get(random.nextInt(point_2.size()));
        }
        if (!point_1.isEmpty()) {
          return point_1.get(random.nextInt(point_1.size()));
        }
        if (!point_0.isEmpty()) {
          return point_0.get(random.nextInt(point_0.size()));
        }
    }

    /**
     * Count my stones on Board
     * @param b Board
     * @return Count stones on board
     */
    private int countStones(Board b) {
        int count = 0;
        Color myPlayer = getColor();

        for (int x = 0; x < b.getSize(); x++) {
            for (int y = 0; y < b.getSize(); y++) {
                if(b.getState(x, y) == myPlayer) {
                    count++;
                }
            }
        }

        return count;
    }
}
