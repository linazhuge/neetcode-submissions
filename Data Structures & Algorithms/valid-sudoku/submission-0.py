class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [[False] * 9 for _ in range(9)]
        columns = [[False] * 9 for _ in range(9)]
        cells = [[False] * 9 for _ in range(9)]
        for i in range(9):
            for j in range(9):
                row = i
                column = j
                cell = i // 3 * 3 + j // 3
                valStr = board[i][j]
                if valStr != ".":
                    val = int(valStr) - 1
                    if rows[row][val]:
                        return False
                    rows[row][val] = True

                    if columns[column][val]:
                        return False
                    columns[column][val] = True

                    if cells[cell][val]:
                        return False
                    cells[cell][val] = True
        return True