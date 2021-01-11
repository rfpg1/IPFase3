import java.util.HashSet;
import java.util.Set;
/*
public class Puzzle {
	private char[][] board;
	private String[] hiddenWords;	

	public Puzzle(char[][] board, String[] hiddenWords) {
		this.board = new char[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				this.board[i][j] = board[i][j];
			}
		}

		this.hiddenWords = new String[hiddenWords.length];
		for (int i = 0; i < hiddenWords.length; i++) {
			this.hiddenWords[i] = hiddenWords[i];
		}
	}

	private static boolean isHidden(char[][] board, String word) {
		//TODO Fazer isto bem
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
			StringBuilder sb = new StringBuilder();
			sb.append(s);
			if(sb.toString().contains(word) || sb.reverse().toString().contains(word)) {
				return true;
			}
		}

		//Diagonal Esquerda
		String[] diagonalL = diagonalL(board);
		for(String s : diagonalL) {
			StringBuilder sb = new StringBuilder();
			sb.append(s);
			if(sb.toString().contains(word) || sb.reverse().toString().contains(word)) {
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

	public static boolean definesPuzzle(char[][] board, String[] hiddenWords) {
		if(hiddenWords.length < 0) {
			return false;
		}
		Set<String> hiddenWordsUnique = new HashSet<String>();
		for (int i = 0; i < hiddenWords.length; i++) {
			if(!hiddenWordsUnique.add(hiddenWords[i])){
				return false;
			}
		}
		for (int i = 0; i < hiddenWords.length; i++) {
			if(hiddenWords[i].length() < 0 && !isHidden(board, hiddenWords[i])) {
				return false;
			}
		}
		return true;
	}
	//TODO meter diagonal esquerda bem
	public String getWord(Move move) {
		String word = null;

		Direction moveDirection = move.direction();

		if( moveDirection == Direction.HORIZONTAL)
			word = getWordHorizontal(move);
		else if( moveDirection == Direction.VERTICAL){
			word = getWordVertical(move);
		}
		else if( moveDirection == Direction.DIAGONAL_LEFT)
			word = getWordDiagonalLeft(move);
		else
			word = getWordDiagonalRight(move);

		return word;
		/*
		if(move.direction() == Direction.HORIZONTAL) {
			StringBuilder sb = new StringBuilder();
			for (int i = move.startRow() - 1; i < move.endRow(); i++) {//Verificar menor ou menor ou igual
				for (int j = move.startColumn() - 1; j < move.endColumn(); j++) {
					sb.append(board[i][j]);
				}
			}
			if(estaEscondida(sb.toString())){
				return sb.toString();
			} else if(estaEscondida(sb.reverse().toString())) {
				return sb.toString();
			} else {
				return null;
			}
		} else if(move.direction() == Direction.VERTICAL) {
			StringBuilder sb = new StringBuilder();
			for (int i = move.startColumn() -1; i < move.endColumn(); i++) {
				for (int j = move.startRow() - 1; j < move.endRow(); j++) {
					sb.append(board[j][i]);
				}
			}
			if(estaEscondida(sb.toString())){
				return sb.toString();
			} else if(estaEscondida(sb.reverse().toString())) {
				return sb.toString();
			} else {
				return null;
			}
		} else if(move.direction() == Direction.DIAGONAL_LEFT){
			StringBuilder sb = new StringBuilder();
			//int diferença = Math.abs(move.endRow() - move.startRow());
			for (int i = move.startRow() - 1; i < move.endRow(); i++) {//Verificar menor ou menor ou igual
				for (int j = move.startColumn() - 1; j < move.endColumn(); j++) {
//					if(i - diferença == j - diferença) {
//						sb.append(board[i][j]);
//					}	
					if(i - j == move.startRow() - 1) {
						sb.append(board[i][j]);
					}	
				}
			}
			if(estaEscondida(sb.toString())){
				return sb.toString();
			} else if(estaEscondida(sb.reverse().toString())) {
				return sb.toString();
			} else {
				return null;
			}
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i = move.startRow() - 1; i >= move.endRow() - 1; i--) {//Verificar menor ou menor ou igual
				for (int j = move.startColumn() - 1; j < move.endColumn(); j++) {
					if(i + j == move.startRow() - 1) {
						sb.append(board[i][j]);
					}
				}
			}
			if(estaEscondida(sb.toString())){
				return sb.toString();
			} else if(estaEscondida(sb.reverse().toString())) {
				return sb.toString();
			} else {
				return null;
			}
		}
 */
/*
	}


	private boolean estaEscondida(String word) {
		for (int i = 0; i < hiddenWords.length; i++) {
			if(hiddenWords[i].equals(word)) {
				return true;
			}
		}
		return false;
	}

	public char[][] board() {
		char[][] result = new char[rows()][columns()];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = board[i][j];
			}
		}
		return result;

	}

	public String getWordHorizontal(Move move){

		int beginRow = move.startRow()-1;
		int beginColumn = move.startColumn()-1;
		int endColumn = move.endColumn()-1;

		StringBuilder word = new StringBuilder();
		String returnString = null;

		do {
			word.append(board[beginRow][beginColumn]);
			beginColumn++;
		} while ( beginColumn <= endColumn );

		for(int i = 0; i < hiddenWords.length; i++ ){
			if( hiddenWords[i].equals(word.toString()) || hiddenWords[i].equals(word.reverse().toString()) )
				returnString = hiddenWords[i];
		}
		return returnString;
	}

	public String getWordVertical(Move move){

		int beginRow = move.startRow() - 1;
		int beginColumn = move.startColumn() - 1;
		int endRow = move.endRow() - 1;

		StringBuilder word = new StringBuilder();
		String returnString = null;

		do {
			word.append(board[beginRow][beginColumn]);
			beginRow++;
		} while ( beginRow <= endRow );

		for(int i = 0; i < hiddenWords.length; i++ ){
			if( hiddenWords[i].equals(word.toString()) || hiddenWords[i].equals(word.reverse().toString()) )
				returnString = hiddenWords[i];
		}
		return returnString;
	}

	public String getWordDiagonalLeft(Move move){

		int beginRow = move.startRow() - 1;
		int beginColumn = move.startColumn() - 1;
		int endRow = move.endRow() - 1;

		StringBuilder word = new StringBuilder();
		String returnString = null;

		do{
			word.append(board[beginRow][beginColumn]);
			beginRow++;
			beginColumn++;
		}while( beginRow <= endRow );

		for(int i = 0; i < hiddenWords.length; i++ ){
			if( hiddenWords[i].equals(word.toString()) || hiddenWords[i].equals(word.reverse().toString()) )
				returnString = hiddenWords[i];
		}
		return returnString;
	}

	public String getWordDiagonalRight(Move move){

		int beginRow = move.startRow() - 1;
		int beginColumn = move.startColumn() - 1;
		int endRow = move.endRow() - 1;

		StringBuilder word = new StringBuilder();
		String returnString = null;

		do{
			word.append(board[beginRow][beginColumn]);
			beginRow++;
			beginColumn--;
		}while( beginRow <= endRow );

		for(int i = 0; i < hiddenWords.length; i++ ){
			if( hiddenWords[i].equals(word.toString()) || hiddenWords[i].equals(word.reverse().toString()) )
				returnString = hiddenWords[i];
		}
		return returnString;
	}


	public int numberHiddenWords() {
		return hiddenWords.length;
	}

	public int rows() {
		return board.length;
	}

	public int columns() {
		return board[0].length;
	}
}
 */
public class Puzzle{

	private char[][] board;
	private String[] hiddenWords;

	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	public Puzzle(char[][] board, String[] hiddenWords){
		this.board = new char[board.length][board[0].length];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++ ){
				this.board[i][j] = board[i][j];
			}
		}

		this.hiddenWords = new String[hiddenWords.length];
		for( int i = 0; i < hiddenWords.length; i++ ){
			this.hiddenWords[i] = hiddenWords[i];
		}
	}

	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	private static boolean isHidden(char[][] board, String word){

		boolean isHidden = false;

		if( diagonalLeftRightCheck(board, word) || diagonalRightLeftCheck(board, word) || RowColumCheck(board, word) )
			isHidden = true;

		return isHidden;
	}
	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	public static boolean RowColumCheck(char[][] board, String word){
		boolean isValid = false;
		StringBuilder wordCheck = new StringBuilder();
		StringBuilder hiddenWord = new StringBuilder(word);

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				wordCheck.append(board[i][j]);
			}

			String wordCheckString = wordCheck.toString();
			if( wordCheckString.contains(hiddenWord) || wordCheckString.contains(hiddenWord.reverse()) )
				isValid = true;

			wordCheck.setLength(0);
		}

		for(int i = 0; i < board[0].length; i++){
			for(int j = 0; j < board.length; j++){
				wordCheck.append(board[j][i]);
			}

			String wordCheckString = wordCheck.toString();
			if( wordCheckString.contains(hiddenWord) || wordCheckString.contains(hiddenWord.reverse()) )
				isValid = true;

			wordCheck.setLength(0);
		}

		return isValid;
	}


	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	public static boolean diagonalRightLeftCheck(char[][] board, String word){

		boolean isValid = false;
		StringBuilder wordCheck = new StringBuilder();
		StringBuilder hiddenWord = new StringBuilder(word);
		int rows = 0;
		int columns = 0;

		for(int i = 1; i < board.length; i++){
			do{
				wordCheck.append(board[rows][columns]);
				rows++;
				columns++;
			}while( rows < board.length && columns < board[0].length);

			String wordCheckString = wordCheck.toString();
			if( wordCheckString.contains(hiddenWord) || wordCheckString.contains(hiddenWord.reverse()) )
				isValid = true;

			rows = i;
			columns = 0;
			wordCheck.setLength(0);
		}

		rows = 0;
		columns = 0;

		for(int i = 1; i < board[0].length; i++){
			do {
				wordCheck.append(board[rows][columns]);
				rows++;
				columns++;
			} while( rows < board.length && columns < board[0].length );

			String wordCheckString = wordCheck.toString();
			if( wordCheckString.contains(hiddenWord) || wordCheckString.contains(hiddenWord.reverse()) )
				isValid = true;

			rows = 0;
			columns = i;
			wordCheck.setLength(0);
		}

		return isValid;
	}

	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	public static boolean diagonalLeftRightCheck(char[][] board, String word){

		boolean isValid = false;
		StringBuilder wordCheck = new StringBuilder();
		StringBuilder hiddenWord = new StringBuilder(word);
		int rows = 0;
		int columns = board[0].length - 1;

		for(int i = 1; i < board.length ; i++ ){
			do {
				wordCheck.append(board[rows][columns]);
				rows++;
				columns--;
			} while ( rows < board.length && columns > -1);

			String wordCheckString = wordCheck.toString();
			if( wordCheckString.contains(hiddenWord) || wordCheckString.contains(hiddenWord.reverse()) )
				isValid = true;

			rows = i;
			columns = board[0].length - 1;
			wordCheck.setLength(0);
		}

		rows = 0;
		columns = board[0].length - 1;

		for(int i = board[0].length - 2; i > -1; i--){
			do {
				wordCheck.append(board[rows][columns]);
				rows++;
				columns--;
			} while (rows < board.length && columns > -1);

			String wordCheckString = wordCheck.toString();
			if( wordCheckString.contains(hiddenWord) || wordCheckString.contains(hiddenWord.reverse()) )
				isValid = true;

			rows = 0;
			columns = i;
			wordCheck.setLength(0);
		}

		return isValid;

	}

	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	public static boolean definesPuzzle(char[][] board, String[] hiddenWords){

		boolean isValid = true;

		if( board.length > 0 ){
			for(int i = 0; i < hiddenWords.length ; i++){
				for(int j = 0; j < hiddenWords.length; j++){
					if( i != j ){
						if ( hiddenWords[i].equals(hiddenWords[j]) )
							isValid = false;
					}
				}
				if ( hiddenWords[i].length() < 1)
					isValid = false;

				if ( !isHidden(board, hiddenWords[i]) )
					isValid = false;

			}
		}
		else
			isValid = false;

		return isValid;
	}

	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	public int columns(){
		return board[0].length;
	}

	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	public int rows(){
		return board.length;
	}

	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	public int numberHiddenWords(){
		return hiddenWords.length;
	}

	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 */
	public char[][] board(){

		char[][] boardCopy = new char[board.length][board[0].length];

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				boardCopy[i][j] = board[i][j];
			}
		}

		return boardCopy;
	}

	/*
	 *
	 *
	 *
	 *
	 * @requires move is valid
	 *
	 */
	public String getWord(Move move){

		String word = null;

		Direction moveDirection = move.direction();

		if( moveDirection == Direction.HORIZONTAL)
			word = getWordHorizontal(move);
		else if( moveDirection == Direction.VERTICAL){
			word = getWordVertical(move);
		}
		else if( moveDirection == Direction.DIAGONAL_LEFT)
			word = getWordDiagonalLeft(move);
		else
			word = getWordDiagonalRight(move);

		return word;

	}

	/*
	 *
	 *
	 *
	 *
	 * @requires move is valid
	 *
	 */
	public String getWordHorizontal(Move move){

		int beginRow = move.startRow() - 1;
		int beginColumn = move.startColumn() - 1;
		int endColumn = move.endColumn() - 1;

		StringBuilder word = new StringBuilder();
		String returnString = null;

		do {
			word.append(board[beginRow][beginColumn]);
			beginColumn++;
		} while ( beginColumn <= endColumn );

		for(int i = 0; i < hiddenWords.length; i++ ){
			if( hiddenWords[i].equals(word.toString()) || hiddenWords[i].equals(word.reverse().toString()) )
				returnString = hiddenWords[i];
		}
		return returnString;
	}

	/*
	 *
	 *
	 *
	 *
	 * @requires move is valid
	 *
	 */
	public String getWordVertical(Move move){

		int beginRow = move.startRow() - 1;
		int beginColumn = move.startColumn() - 1;
		int endRow = move.endRow() - 1;

		StringBuilder word = new StringBuilder();
		String returnString = null;

		do {
			word.append(board[beginRow][beginColumn]);
			beginRow++;
		} while ( beginRow <= endRow );

		for(int i = 0; i < hiddenWords.length; i++ ){
			if( hiddenWords[i].equals(word.toString()) || hiddenWords[i].equals(word.reverse().toString()) )
				returnString = hiddenWords[i];
		}
		return returnString;
	}

	/*
	 *
	 *
	 *
	 *
	 * @requires move is valid
	 *
	 */
	public String getWordDiagonalLeft(Move move){
		int beginRow = move.startRow() - 1;
		int beginColumn = move.startColumn() - 1;
		int endRow = move.endRow() - 1;

		StringBuilder word = new StringBuilder();
		String returnString = null;

		do{
			word.append(board[beginRow][beginColumn]);
			beginRow++;
			beginColumn--;
		}while( beginRow <= endRow );

		for(int i = 0; i < hiddenWords.length; i++ ){
			if( hiddenWords[i].equals(word.toString()) || hiddenWords[i].equals(word.reverse().toString()) )
				returnString = hiddenWords[i];
		}
		return returnString;
	}

	/*
	 *
	 *
	 *
	 *
	 * @requires move is valid
	 *
	 */
	public String getWordDiagonalRight(Move move){
		
		int beginRow = move.startRow() - 1;
		int beginColumn = move.startColumn() - 1;
		int endRow = move.endRow() - 1;

		StringBuilder word = new StringBuilder();
		String returnString = null;

		do{
			word.append(board[beginRow][beginColumn]);
			beginRow++;
			beginColumn++;
		}while( beginRow <= endRow );

		for(int i = 0; i < hiddenWords.length; i++ ){
			if( hiddenWords[i].equals(word.toString()) || hiddenWords[i].equals(word.reverse().toString()) )
				returnString = hiddenWords[i];
		}
		return returnString;
	}

}
