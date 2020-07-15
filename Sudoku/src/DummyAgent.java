

public class DummyAgent extends Agent {
	boolean performUninformedSearch(Puzzle puzzle) {
		boolean success = backTrackSearch(puzzle.emptyCells, puzzle);
		return success;
	}
}
