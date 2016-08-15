package resources.helper;

/**
 * Functions to be used in complement to Square object.
 * 
 * @author Guilherme Ricci 
 *
 */
public class SquareHelper {
	
	/**
	 * Return a integer value of offset to be used as a index to a 2dimension matrix.
	 * 
	 * @param currentRow current position of axis X
	 * @param currentColumn current position of axis Y
	 * @param maxSizeColumn maximum size of Column from 2dimension matrix(board) used.
	 * @return
	 */
	public int calculateOffset(int currentRow, int currentColumn,  int maxSizeColumn){		
		return ((currentRow - 1) * maxSizeColumn) + currentColumn;		
	}
	
	/**
	 * Return position of row once it receive a offset as a index.
	 * Row means a position of a axis X.
	 * 
	 * @param offset
	 * @param totalOfRows
	 * @return
	 */
	public int getRowBasedOnOffset(int offset, int totalOfRows){
		int row = (offset / totalOfRows);
		if((offset % totalOfRows) != 0){
			row +=1;
		}
		return row;
	}
	
	/**
	 * Return position of column once it receive a offset as a index.
	 * Column means a position of a axis Y
	 * 
	 * @param offset
	 * @param totalOfRows
	 * @param totalOfColumns
	 * @return
	 */
	public int getColumnBasedOnOffset(int offset, int totalOfRows, int totalOfColumns){
		int column = offset % totalOfRows;
		if((offset % totalOfRows) == 0){
			column = totalOfColumns;
		}
		return column;
	}

}
