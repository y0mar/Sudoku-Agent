import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class driver {
	
	public static void main(String[] args) throws IOException {
		JFrame frame = new JFrame();
		FileDialog dialog = new FileDialog(frame, "Select a file", FileDialog.LOAD);
		dialog.setDirectory("C://");
		dialog.setFile("*.txt");
		dialog.setVisible(true);
		
		String filename = dialog.getFile();
		File file = new File(dialog.getDirectory() + filename);
		
		if(filename == null) {
			System.out.println("You cancelled the choice");
			}
		else {
			System.out.println("You chose: " + filename);
			
			Puzzle sudoku = new Puzzle();
			sudoku.load(file);
			
			for (int i = 0; i < sudoku.emptyCells.size(); i++) {
				sudoku.updateRV(sudoku.emptyCells.get(i));
			}
			
			sudoku.emptyCells = sudoku.selectionSort(sudoku.emptyCells);
			
			for (int row = 0; row < sudoku.puzzle.length; row++) {
				for (int col = 0; col < sudoku.puzzle[row].length; col++) {
					System.out.print(sudoku.puzzle[row][col].val);
				}
				System.out.println();
			}
			
			System.out.println("Empty cells by MRV: ");
			for (int i = 0; i < sudoku.emptyCells.size(); i++) {
				System.out.print("("+sudoku.emptyCells.get(i).row+","+sudoku.emptyCells.get(i).col+"), "+sudoku.emptyCells.get(i).countRV+"\t");
				if ((i+1)%5==0) {
					System.out.print("\n");
				}
			}
		}		
	}	
}
