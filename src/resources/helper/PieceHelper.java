package resources.helper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import resources.piece.GenericPiece;

public class PieceHelper {

	public static Set<String> possibleSequences;
	public static Set<List<GenericPiece>> possiblePiecesSequences;

	/**
	 * Return all possible combinations of order without repetition.
	 * Used as a recursive function with his overloaded method
	 * 
	 * @param pieces List containing all pieces to be iterated.
	 * @return Set<List<GenericPiece>> getAllPiecesSequence(List<GenericPiece> currentPieces, List<GenericPiece> lastSequence)
	 * 
	 * @see Set<>
	 * @see List<>
	 */
	public Set<List<GenericPiece>> getAllPiecesSequence(List<GenericPiece> pieces) {
		possiblePiecesSequences = new HashSet<>();
		getAllPiecesSequence(pieces, new ArrayList<GenericPiece>());
		return possiblePiecesSequences;
	}

	/**
	 * Creates specific to be called as a recursive method.
	 * Return a new possible sequence until use all elements from main list (currentPieces).
	 * This method can return duplicated sequences.
	 * 
	 * @param currentPieces Main list, containing all elements to be put in order.
	 * @param lastSequence Parameter filled by recursion with possible sequence using all elements from currentPieces.
	 */
	private static void getAllPiecesSequence(List<GenericPiece> currentPieces, List<GenericPiece> lastSequence) {
		int index = currentPieces.size();
		if (index == 0) {
			possiblePiecesSequences.add(lastSequence);
		} else {
			for (int i = 0; i < index; i++) {
				List<GenericPiece> tempLastCopy = new ArrayList<GenericPiece>(lastSequence);
				List<GenericPiece> tempCurrentCopy = new ArrayList<GenericPiece>(currentPieces);
				tempLastCopy.add(tempCurrentCopy.remove(i));
				getAllPiecesSequence(tempCurrentCopy, tempLastCopy);
			}
		}
	}
}
