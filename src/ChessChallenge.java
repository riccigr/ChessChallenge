import java.util.ArrayList;
import java.util.List;

import resources.chessboard.Board;
import resources.chessboard.BoardManipulator;
import resources.piece.Knight;
import resources.piece.GenericPiece;
import resources.piece.Rook;

/**
 * Main class of project ChessChallenge.
 * 
 * @author Guilherme Ricci
 *
 */
public class ChessChallenge {

	public static void main(String[] args) {
		
		List<GenericPiece> piecesToGame = new ArrayList<>();
//		piecesToGame.add(new King());
		piecesToGame.add(new Knight());
		piecesToGame.add(new Knight());
		piecesToGame.add(new Rook());
//		piecesToGame.add(new King());		
		Board chessBoard = new Board(3,3, piecesToGame);
		
		BoardManipulator boardManipulator = new BoardManipulator();
		boardManipulator.findAllUniqueConfigurations(chessBoard);
		
	}

}
