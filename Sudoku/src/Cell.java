import java.util.*;

public class Cell implements Comparable<Cell> {
	ArrayList<Character> originalRV = new ArrayList<Character>(Puzzle.domain);
	
	
	char val = '-';
	int row, col, box;
	ArrayList<Character> remainingValues = new ArrayList<Character>(originalRV);
	int countRV;
	
	Cell() {
	}
	
	Cell(char value) {
		val = value;
	}

	@Override
	public int compareTo(Cell anotherCell) {
		if (this.originalRV.size() < anotherCell.originalRV.size()) {
			return -1;
		} else {
			return 1;
		}
	}
	
	
}
