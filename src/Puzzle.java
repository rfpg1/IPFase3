
public class Puzzle {
	public Puzzle(char[][] board, String[] validHidden) {
		// TODO Auto-generated constructor stub
	}

	private static boolean isHidden(char[][] board, String word) {
		//Linhas
		for (int i = 0; i < board.length; i++) {
			StringBuilder bob = new StringBuilder(new String(board[i]));
			if(bob.toString().contains(word) || bob.reverse().toString().contains(word)) {
				return true;
			}
		}

		//Colunas
		for (int i = 0; i < board[0].length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < board.length; j++) {
				sb.append(board[j][i]);
			}

			StringBuilder bob = new StringBuilder(sb.toString());

			if(bob.toString().contains(word) || bob.reverse().toString().contains(word)) {
				return true;
			}
		}
		//Diagonal Direita
		String[] diagonalD = diagonalD(board);
		for(String s : diagonalD) {
			if(s.equals(word)) {
				return true;
			}
		}

		//Diagonal Esquerda
		String[] diagonalL = diagonalL(board);
		for(String s : diagonalL) {
			if(s.equals(word)) {
				return true;
			}
		}

		return false;
	}

	private static String[] diagonalD (char[][] board) {
		String[] result = new String[board.length + board[0].length - 1];
		int index = 0;
		//print first half
		int row =0;
		int col;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				
			}
		}
		while(row<board.length){
			col =0;
			int rowTemp = row;
			StringBuilder bob = new StringBuilder();
			while(rowTemp>=0 && col < board[0].length){
				bob.append(board[rowTemp][col]);
				rowTemp--;
				col++;
			}
			result[index] = bob.toString();
			index++;
			row++;
		}

		//print second half
		col = 1;

		while(col<board[0].length){
			int colTemp = col;
			row = board.length-1;
			StringBuilder bob = new StringBuilder();
			while(colTemp<=board[0].length-1){
				bob.append(board[row][colTemp]);
				row--;
				colTemp++;
			}
			result[index] = bob.toString();
			index++;
			col++;
		}

		return result;
	}

	private static String[] diagonalL (char[][] board) {
		String[] result = new String[board.length + board[0].length - 1];
		int index = 0;
		for(int j=board[0].length-1; j>=0; j--){
			StringBuilder bob = new StringBuilder();
			for(int k=0; k<board.length; k++){
				if((j + k) < board[0].length){
					bob.append(board[k][j + k]);
				} else {
					break;
				}
			}
			result[index] = bob.toString();
			index++;
		}
		for(int i=1; i<board.length; i++){
			StringBuilder bob = new StringBuilder();
			for(int j=i, k=0; j<board.length && k<board[0].length; j++, k++){
				bob.append(board[j][k]);
			}
			result[index] = bob.toString();
			index++;
		}
		return result;
	}

	public static boolean definesPuzzle(char[][] board, String[] invalidHidden) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getWord(Move move) {
		// TODO Auto-generated method stub
		return null;
	}

	public char[][] board() {
		// TODO Auto-generated method stub
		return null;
	}

	public int numberHiddenWords() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int rows() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int columns() {
		// TODO Auto-generated method stub
		return 0;
	}
}
