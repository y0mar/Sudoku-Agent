import java.util.*;

public class Agent {
	int assignments = 0;
	
	
	boolean backTrackSearch(ArrayList<Cell> emptyCellList, Puzzle puzzle) {
		boolean success = false;
		while (!emptyCellList.isEmpty()) {
			if (assignments == 395) {
				System.out.println("395 assignments");
			}
			puzzle.updateRV(emptyCellList.get(0));
			while (!emptyCellList.get(0).remainingValues.isEmpty()) {
				
				puzzle.puzzle[emptyCellList.get(0).row][emptyCellList.get(0).col].val = emptyCellList.get(0).remainingValues.get(0);
				this.assignments++;
				puzzle.boxes[emptyCellList.get(0).box].values.add(emptyCellList.get(0).remainingValues.get(0));
				ArrayList<Cell> newEmptyCellList = new ArrayList<Cell>(emptyCellList);
				newEmptyCellList.remove(0);
				/**for (int i = 0; i < newEmptyCellList.size(); i++) {
					puzzle.updateRV(newEmptyCellList.get(i));
				}
				newEmptyCellList = puzzle.selectionSort(newEmptyCellList);**/
				//printNextEmptyCells(newEmptyCellList); printPuzzle(puzzle);
				success = backTrackSearch(newEmptyCellList, puzzle);
				if (puzzle.goalTest()) {
					return true;
				}
				if (!success) {
					puzzle.boxes[emptyCellList.get(0).box].values.remove(emptyCellList.get(0).remainingValues.get(0));
				}
				emptyCellList.get(0).remainingValues.remove(0); emptyCellList.get(0).countRV = emptyCellList.get(0).remainingValues.size();
			}
			
			if (emptyCellList.isEmpty()) {
				success = true;
			}
			if (success) {
				emptyCellList.remove(0);
			} else {
				emptyCellList.get(0).remainingValues = new ArrayList<Character>(emptyCellList.get(0).originalRV);
				emptyCellList.get(0).countRV = emptyCellList.get(0).remainingValues.size();
				puzzle.puzzle[emptyCellList.get(0).row][emptyCellList.get(0).col].val = '-';
				return false;
			}
		}
		
		return success;
	}
	
	void printNextEmptyCells(ArrayList<Cell> emptyCellList) {
		if (emptyCellList.size() > 4) {
			System.out.println();
			for (int i = 0; i < 5; i++) {
				System.out.print("("+emptyCellList.get(i).row+","+emptyCellList.get(i).col+"), "+emptyCellList.get(i).countRV+"\t");
			}
		}
		System.out.println();
	}
	
	void printPuzzle(Puzzle puzzle) {
		for (int row = 0; row < puzzle.puzzle.length; row++) {
			for (int col = 0; col < puzzle.puzzle[row].length; col++) {
				System.out.print(puzzle.puzzle[row][col].val);
			}
			System.out.println();
		}
	}

}
