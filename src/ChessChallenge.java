import java.util.ArrayList;
import java.util.List;

import exception.UnexpectedNumberOfArgsException;
import resources.chessboard.Board;
import resources.chessboard.BoardManipulator;
import resources.helper.ArgsHelper;
import resources.piece.Bishop;
import resources.piece.GenericPiece;
import resources.piece.King;
import resources.piece.Knight;
import resources.piece.Queen;
import resources.piece.Rook;

/**
 * Main class of project ChessChallenge.
 * 
 * @author Guilherme Ricci
 *
 */
public class ChessChallenge {

	/**
	 * Main function.
	 * Arguments format expected: [rows] [columns] [queens] [rooks] [knights] [kings] [bishops].
	 * Format: only numbers.
	 * 
	 * @param argsArguments passed as parameters
	 */
	public static void main(String[] args) {

		prepareNewBoard(args);

	}

	/**
	 * Validate parameters and begin to find all configurations.
	 * 
	 * @param args Arguments passed as parameters.
	 * @return
	 */
	private static void prepareNewBoard(String[] args) {

		Board chessBoard;

		try {
			ArgsHelper validator = new ArgsHelper(args);

			if (validator.hasEnoughParams()) {
				int rows = validator.convertStringToInteger(0);
				int columns = validator.convertStringToInteger(1);
				int queenAmount = validator.convertStringToInteger(2);
				int rookAmount = validator.convertStringToInteger(3);
				int knightAmount = validator.convertStringToInteger(4);
				int kingAmount = validator.convertStringToInteger(5);
				int bishopAmount = validator.convertStringToInteger(6);
				List<GenericPiece> piecesToGame = new ArrayList<>();

				for (int pieceIndex = 1; pieceIndex <= queenAmount; pieceIndex++) {
					piecesToGame.add(new Queen());
				}

				for (int pieceIndex = 1; pieceIndex <= rookAmount; pieceIndex++) {
					piecesToGame.add(new Rook());
				}

				for (int pieceIndex = 1; pieceIndex <= knightAmount; pieceIndex++) {
					piecesToGame.add(new Knight());
				}

				for (int pieceIndex = 1; pieceIndex <= kingAmount; pieceIndex++) {
					piecesToGame.add(new King());
				}

				for (int pieceIndex = 1; pieceIndex <= bishopAmount; pieceIndex++) {
					piecesToGame.add(new Bishop());
				}

				chessBoard = new Board(rows, columns, piecesToGame);

				BoardManipulator boardManipulator = new BoardManipulator();
				boardManipulator.findAllUniqueConfigurations(chessBoard);

			} else {
				throw new UnexpectedNumberOfArgsException();
			}
		} catch (UnexpectedNumberOfArgsException e) {
			System.out.println("Please, enter numeric parameters for this sequence:");
			System.out.println("[rows] [columns] [queens] [rooks] [knights] [kings] [bishops]");
		} catch (NumberFormatException e) {
			System.out.println("Please, enter only numbers.");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Parameter not found."); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
