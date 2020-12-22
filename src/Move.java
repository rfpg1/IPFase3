
public class Move {
	
	private int row1;
	private int row2;
	private int col1;
	private int col2;
	private int rows;
	private int columns;
	
	public static boolean definesMove(int row1, int col1, int row2, int col2, int row, int columns) {
		
		return true;
	}
	
	public Move(int row1, int col1, int row2, int col2, int rows, int columns) {
		this.row1 = row1;
		this.row2 = row2;
		this.col1 = col1;
		this.col2 = col2;
		this.rows = rows;
		this.columns = columns;
	}
	
	public int startRow() {
		return this.row1;
	}
	
	public int startColumn() {
		return this.col1;
	}
	
	public int endRow() {
		return this.row2;
	}
	
	public int endColumn() {
		return this.col2;
	}
	
	public Direction direction() {
		if(this.row1 == this.row2) {
			return Direction.HORIZONTAL;
		} else if(this.col1 == this.col2) {
			return Direction.VERTICAL;
		} else {
			if(this.row1 > this.row2) {
				return Direction.DIAGONAL_LEFT;
			} else {
				return Direction.DIAGONAL_RIGHT;
			}
		}
	}
	
	public int rows() {
		return this.rows;
	}
	
	public int columns() {
		return this.columns;
	}
}
