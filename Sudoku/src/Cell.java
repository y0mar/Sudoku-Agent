import java.util.*;

public class Cell implements Comparable<Cell> {
	
	ArrayList<Character> originalRV = new ArrayList<Character>();
	
	
	char val = '-';
	int row, col, box;
	ArrayList<Character> remainingValues = new ArrayList<Character>();
	int countRV;
	
	Cell(ArrayList<Character> domain) {
		originalRV = new ArrayList<Character>(domain);
		remainingValues = new ArrayList<Character>(domain);
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
