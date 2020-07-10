import java.util.*;

public class Cell implements Comparable<Cell> {
	
	
	
	char val = '-';
	int row, col, box;
	ArrayList<Character> remainingValues = new ArrayList<Character>(Puzzle.domain);
	int countRV;
	
	Cell() {
	}
	
	Cell(char value) {
		val = value;
	}

	@Override
	public int compareTo(Cell anotherCell) {
		if (this.remainingValues.size() < anotherCell.remainingValues.size()) {
			return -1;
		} else {
			return 1;
		}
	}
	
	
}
