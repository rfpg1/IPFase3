/*
public class Move {

	private int row1;
	private int row2;
	private int col1;
	private int col2;
	private int rows;
	private int columns;

	public static boolean definesMove(int row1, int col1, int row2, int col2, int row, int columns) {
		//Pode estar mal
		if(row1 >= row || row2 >= row || row1 <= 0 || row2 <= 0) {
			return false;
		}
		if(col1 >= columns || col2 >= columns || col1 <= 0 || col2 <= 0) {
			return false;
		}
		if(row1 == row2 && col1 > col2) {
			return false;
		}
		//row1 == row2 && col1 != col2?
		//mesmo para colunas iguais
		if(col1 == col2 && row1 < row2) {
			return false;
		}
		if(row2 - row1 == col2 - col1) {
			if(col1 > col2) {
				return false;
			}
		}
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

	public Direction direction(){
		if( col1 == col2 )
			return Direction.VERTICAL;
		else if ( row1 == row2 )
			return Direction.HORIZONTAL;
		else if ( row1 < row2 && col1 < col2)
			return Direction.DIAGONAL_LEFT;
		else
			return Direction.DIAGONAL_RIGHT;
	}

	public int rows() {
		return this.rows;
	}

	public int columns() {
		return this.columns;
	}
}
*/
public class Move{

  private int row1;
  private int row2;
  private int col1;
  private int col2;
  private int rows;
  private int columns;

  public static boolean definesMove(int row1, int col1, int row2, int col2, int rows, int columns){

    boolean move = false;
    int i = row1;
    int k = col1;

    if((row1 <= rows && row1 > 0) && (row2 <= rows && row2 > 0) && (col1 <= columns && col1 > 0) && (col2 <= columns && col2 > 0)){

      if((row1 < row2) && (col1 == col2))
        move = true;

      if((row1 == row2) && (col1 < col2))
        move = true;

      if(row1 < row2 && col1 < col2){
        while( move == false && i < row2+1 && k < col2+1 ){
          if(i == row2 && k == col2)
            move = true;
          k++;
          i++;
          }
        i = row1;
        k = col1;
      }
      else if ( row1 > row2 && col1 < col2){
        while( move == false && i > row2-1 && k < col2+1 ){
          if( i == row2 && k == col2 )
            move = true;
          i--;
          k++;
        }
      }
    }
  return move;
  }

  public Move(int row1, int col1, int row2, int col2, int rows, int columns){
    this.row1 = row1;
    this.col1 = col1;
    this.row2 = row2;
    this.col2 = col2;
    this.rows = rows;
    this.columns = columns;
  }

  public int startRow(){
    return row1;
  }

  public int startColumn(){
    return col1;
  }

  public int endRow(){
    return row2;
  }

  public int endColumn(){
    return col2;
  }

  public Direction direction(){
    if( col1 == col2 )
      return Direction.VERTICAL;
    else if ( row1 == row2 )
      return Direction.HORIZONTAL;
    else if ( row1 < row2 && col1 < col2)
      return Direction.DIAGONAL_RIGHT;
    else
      return Direction.DIAGONAL_LEFT;
  }

  public int rows(){
    return rows;
  }

  public int columns(){
    return columns;
  }

}
