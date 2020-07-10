import java.util.*;
import java.io.*;


public class Puzzle {
	static int assignments = 0;
	Cell puzzle[][] = new Cell[16][16];
	Box boxes[] = new Box[16];
	ArrayList<Cell> emptyCells = new ArrayList<Cell>();
	static final ArrayList<Character> domain = new ArrayList<Character>();
	
	Puzzle() {
		initDomain();
		init();
		initBoxes();
	}
	
	
	
	
	void updateRV(Cell cell) {
		for (int index = 0; index < 16; index++) {
			if (cell.remainingValues.contains((Character)puzzle[index][cell.col].val)) {
				cell.remainingValues.remove((Character)puzzle[index][cell.col].val);
			}
			if (cell.remainingValues.contains((Character)puzzle[cell.row][index].val)) {
				cell.remainingValues.remove((Character)puzzle[cell.row][index].val);
			}
			cell.remainingValues.removeAll(boxes[cell.box].values);
		}
	}
	
	ArrayList<Cell> selectionSort(ArrayList<Cell> cellList) {
		ArrayList<Cell> tempList = new ArrayList<Cell>(cellList);
		ArrayList<Cell> newList = new ArrayList<Cell>();
		
		
		while(!tempList.isEmpty()) {
			int smallest = 0;
			for (int i = 1; i < tempList.size(); i++) {
				if (tempList.get(smallest).compareTo(tempList.get(i)) == 1) {
					smallest = i;
				}
			}
			newList.add(tempList.remove(smallest));
		}
		
		return newList;
	}
	
	
	void load(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		int row = 0;
		while (input.hasNext()) {
			String string = input.next();
			for(int col = 0; col < string.length(); col++) {
				puzzle[row][col].val = string.charAt(col);
				if (!boxes[puzzle[row][col].box].values.contains((Character)puzzle[row][col].val) && puzzle[row][col].val != '-') {
					boxes[puzzle[row][col].box].values.add(puzzle[row][col].val);
				} else if (puzzle[row][col].val == '-') {
					emptyCells.add(puzzle[row][col]);
				}
			}
			row++;
		}
		input.close();
	}
	
	
	
	void init() {
		for (int row = 0; row < puzzle.length; row++) {
			for (int col = 0; col < puzzle[row].length; col++) {
				puzzle[row][col] = new Cell();
				puzzle[row][col].row = row;
				puzzle[row][col].col = col;
				
				if ((row >= 0 && row <= 3) && (col >= 0 && col <= 3)) {
					puzzle[row][col].box = 0;
				}
				if ((row >= 0 && row <= 3) && (col >= 4 && col <= 7)) {
					puzzle[row][col].box = 1;
				}
				if ((row >= 0 && row <= 3) && (col >= 8 && col <= 11)) {
					puzzle[row][col].box = 2;
				}
				if ((row >= 0 && row <= 3) && (col >= 12 && col <= 15)) {
					puzzle[row][col].box = 3;
				}
				if ((row >= 4 && row <= 7) && (col >= 0 && col <= 3)) {
					puzzle[row][col].box = 4;
				}
				if ((row >= 4 && row <= 7) && (col >= 4 && col <= 7)) {
					puzzle[row][col].box = 5;
				}
				if ((row >= 4 && row <= 7) && (col >= 8 && col <= 11)) {
					puzzle[row][col].box = 6;
				}
				if ((row >= 4 && row <= 7) && (col >= 12 && col <= 15)) {
					puzzle[row][col].box = 7;
				}
				if ((row >= 8 && row <= 11) && (col >= 0 && col <= 3)) {
					puzzle[row][col].box = 8;
				}
				if ((row >= 8 && row <= 11) && (col >= 4 && col <= 7)) {
					puzzle[row][col].box = 9;
				}
				if ((row >= 8 && row <= 11) && (col >= 8 && col <= 11)) {
					puzzle[row][col].box = 10;
				}
				if ((row >= 8 && row <= 11) && (col >= 12 && col <= 15)) {
					puzzle[row][col].box = 11;
				}
				if ((row >= 12 && row <= 15) && (col >= 0 && col <= 3)) {
					puzzle[row][col].box = 12;
				}
				if ((row >= 12 && row <= 15) && (col >= 4 && col <= 7)) {
					puzzle[row][col].box = 13;
				}
				if ((row >= 12 && row <= 15) && (col >= 8 && col <= 11)) {
					puzzle[row][col].box = 14;
				}
				if ((row >= 12 && row <= 15) && (col >= 12 && col <= 15)) {
					puzzle[row][col].box = 15;
				}
				
				
				
			}
			
		}
	}
	
	void initDomain() {
		domain.add('0');
		domain.add('1');
		domain.add('2');
		domain.add('3');
		domain.add('4');
		domain.add('5');
		domain.add('6');
		domain.add('7');
		domain.add('8');
		domain.add('9');
		domain.add('A');
		domain.add('B');
		domain.add('C');
		domain.add('D');
		domain.add('E');
		domain.add('F');
	}
	
	void initBoxes() {
		for (int i = 0; i < 16; i++) {
			boxes[i] = new Box();
		}
	}
}
