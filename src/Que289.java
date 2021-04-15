import java.util.Arrays;
import java.util.List;

/**
 * @author: hyl
 * @date: 2021/04/15
 **/
public class Que289 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int[][] res = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                int statu = 0;
                if (board[i][j] == 0) {
                    statu = checkTheDie(board, i, j);
                } else {
                    statu = checkTheAlive(board, i, j);
                }
                res[i][j] = statu;
            }
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                board[i][j] = res[i][j];
            }
        }
    }

    private int checkTheAlive(int[][] board, int i, int j) {
        List<Integer> count = getAroundZeroCount(board, i, j);
        if (count.get(1) < 2 || count.get(1) > 3) {
            return 0;
        }
        return 1;

    }

    private int checkTheDie(int[][] board, int i, int j) {
        List<Integer> count = getAroundZeroCount(board, i, j);
        if (count.get(1) == 3) {
            return 1;
        }
        return 0;

    }

    /**
     * 获取周围八个的o的个数
     *
     * @param board
     * @param i
     * @param j
     */
    private List<Integer> getAroundZeroCount(int[][] board, int i, int j) {
        int count = board.length;
        int lenth = board[0].length;

        int oneCount = 0;
        int zeroCount = 0;
        if ((i - 1) >= 0 && (j - 1) >= 0) {
            if (board[i - 1][j - 1] == 0) {
                zeroCount++;
            } else if (board[i - 1][j - 1] == 1) {
                oneCount++;
            }
        }

        if ((i - 1) >= 0) {
            if (board[i - 1][j] == 0) {
                zeroCount++;
            } else if (board[i - 1][j] == 1) {
                oneCount++;
            }
        }

        if ((i - 1) >= 0 && (j + 1) < lenth) {
            if (board[i - 1][j + 1] == 0) {
                zeroCount++;
            } else if (board[i - 1][j + 1] == 1) {
                oneCount++;
            }
        }

        if (j - 1 >= 0) {
            if (board[i][j - 1] == 0) {
                zeroCount++;
            } else if (board[i][j - 1] == 1) {
                oneCount++;
            }
        }

        if (j + 1 < lenth) {
            if (board[i][j + 1] == 0) {
                zeroCount++;
            } else if (board[i][j + 1] == 1) {
                oneCount++;
            }
        }

        if ((i + 1) < count && (j - 1) >= 0) {
            if (board[i + 1][j - 1] == 0) {
                zeroCount++;
            } else if (board[i + 1][j - 1] == 1) {
                oneCount++;
            }
        }

        if ((i + 1) < count) {
            if (board[i + 1][j] == 0) {
                zeroCount++;
            } else if (board[i + 1][j] == 1) {
                oneCount++;
            }
        }

        if ((i + 1) < count && (j + 1) < lenth) {
            if (board[i + 1][j + 1] == 0) {
                zeroCount++;
            } else if (board[i + 1][j + 1] == 1) {
                oneCount++;
            }
        }

        return Arrays.asList(zeroCount, oneCount);
    }

}
