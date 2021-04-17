import java.util.Arrays;
import java.util.List;

/**
 * @author: hyl
 * @date: 2021/04/15
 **/
public class Que289 {

    /**
     * 解决方案一
     * 新建一个数组,然后将统计的数组放到新建的数组,然后计算即可
     *
     * @param board
     */
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

    /**
     * 判断当前活着的细胞,是否会死去
     * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡
     * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡
     * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
    private int checkTheAlive(int[][] board, int i, int j) {
        List<Integer> count = getAroundZeroCount(board, i, j);
        if (count.get(1) < 2 || count.get(1) > 3) {
            return 0;
        }
        return 1;

    }

    /**
     * 判断当前死着的细胞,是否会变活
     * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
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

    /**
     * 解决方案二
     * 使用原地数组,如果由死变活,则标记为2;如果由活变死,标记为-1
     *
     * @param board
     */
    public void gameOfLife1(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                int statu = 0;
                if (board[i][j] == 0) {
                    statu = checkTheDie(board, i, j);
                } else {
                    statu = checkTheAlive(board, i, j);
                }
                board[i][j] = statu;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }

    /**
     * 判断当前活着的细胞,是否会死去
     * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡
     * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡
     * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
    private int checkTheAlive1(int[][] board, int i, int j) {
        List<Integer> count = getAroundZeroCount(board, i, j);
        if (count.get(1) < 2 || count.get(1) > 3) {
            return -1;
        }
        return 1;

    }

    /**
     * 判断当前死着的细胞,是否会变活
     * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
    private int checkTheDie1(int[][] board, int i, int j) {
        List<Integer> count = getAroundZeroCount(board, i, j);
        if (count.get(1) == 3) {
            return 2;
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
    private List<Integer> getAroundZeroCount1(int[][] board, int i, int j) {
        int count = board.length;
        int lenth = board[0].length;

        int oneCount = 0;
        int zeroCount = 0;
        if ((i - 1) >= 0 && (j - 1) >= 0) {
            //如果绝对值为1,则说明为活着的,或者是由活变死的
            if (Math.abs(board[i - 1][j - 1]) == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        if ((i - 1) >= 0) {
            if (Math.abs(board[i - 1][j]) == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        if ((i - 1) >= 0 && (j + 1) < lenth) {
            if (Math.abs(board[i - 1][j + 1]) == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        if (j - 1 >= 0) {
            if (Math.abs(board[i][j - 1]) == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        if (j + 1 < lenth) {
            if (Math.abs(board[i][j + 1]) == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        if ((i + 1) < count && (j - 1) >= 0) {
            if (Math.abs(board[i + 1][j - 1]) == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        if ((i + 1) < count) {
            if (Math.abs(board[i + 1][j]) == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        if ((i + 1) < count && (j + 1) < lenth) {
            if (Math.abs(board[i + 1][j + 1]) == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        return Arrays.asList(zeroCount, oneCount);
    }

}
