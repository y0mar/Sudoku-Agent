

public class DummyAgent extends Agent {
	boolean performUninformedSearch(Puzzle puzzle) {
		/**System.out.println();
		for (int i = 0; i < puzzle.emptyCells.size(); i++) {
			System.out.print("(" + puzzle.emptyCells.get(i).row + "," + puzzle.emptyCells.get(i).col + "), " 
		+ puzzle.emptyCells.get(i).countRV + " ");
			if (i % 15 == 0) {
				System.out.println();
			}
		}**/
		boolean success = backTrackSearch(puzzle.emptyCells, puzzle);
		return success;
	}
}
