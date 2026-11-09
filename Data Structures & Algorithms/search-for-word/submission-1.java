class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                if (word.charAt(0) != board[i][j]) continue;
                boolean [][] used = new boolean[board.length][board[0].length];
                used[i][j] = true;
                boolean res = existsWithPos(board, used, word.substring(1), i, j);
                if (res == true) return true;
            }
        }

        return false;
    }

    public boolean existsWithPos(char[][] board, boolean[][] used, String word, int x, int y) {
        if (word.equals("")) return true;
        char letter = word.charAt(0);
        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;
        if (x - 1 >= 0 && !used[x-1][y] && board[x-1][y] == letter) {
            boolean [][] deep = new boolean[used.length][];
            for (int i = 0; i < used.length; i++) {
                deep[i] = used[i] == null ? null : used[i].clone();
            }
            deep[x-1][y] = true;
            left = existsWithPos(board, deep, word.substring(1), x-1, y);
        }

        if (y - 1 >= 0 && !used[x][y-1] && board[x][y-1] == letter) {
            boolean [][] deep = new boolean[used.length][];
            for (int i = 0; i < used.length; i++) {
                deep[i] = used[i] == null ? null : used[i].clone();
            }
            deep[x][y-1] = true;
            up = existsWithPos(board, deep, word.substring(1), x, y-1);
        }

        if (x + 1 < board.length && !used[x+1][y] && board[x+1][y] == letter) {
            boolean [][] deep = new boolean[used.length][];
            for (int i = 0; i < used.length; i++) {
                deep[i] = used[i] == null ? null : used[i].clone();
            }
            deep[x+1][y] = true;
            right = existsWithPos(board, deep, word.substring(1), x+1, y);
        }

        if (y + 1 < board[0].length && !used[x][y+1] && board[x][y+1] == letter) {
            boolean [][] deep = new boolean[used.length][];
            for (int i = 0; i < used.length; i++) {
                deep[i] = used[i] == null ? null : used[i].clone();
            }
            deep[x][y+1] = true;
            down = existsWithPos(board, deep, word.substring(1), x, y+1);
        }

        return left || up || right || down;
    }
}
