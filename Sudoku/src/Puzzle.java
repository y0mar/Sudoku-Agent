import java.util.*;
import java.io.*;


public class Puzzle {
	static int assignments = 0;
	Cell puzzle[][] = new Cell[16][16];
	
	Puzzle() {
		init();
	}
	
	
	
	
	
	
	
	void load(File file) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		int row = 0;
		while (input.hasNext()) {
			String string = input.next();
			for(int col = 0; col < string.length(); col++) {
				puzzle[row][col].val = string.charAt(col);
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
}
