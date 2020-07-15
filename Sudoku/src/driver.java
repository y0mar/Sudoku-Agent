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
		Scanner input = new Scanner(System.in);
		
		String filename = dialog.getFile();
		File file = new File(dialog.getDirectory() + filename);
		
		if(filename == null) {
			System.out.println("You cancelled the choice");
			input.close();
			frame.dispose();
			dialog.dispose();
			}
		else {
			System.out.println("You chose: " + filename);
			
			Puzzle sudoku = new Puzzle();
			sudoku.load(file);
			
			for (int i = 0; i < sudoku.emptyCells.size(); i++) {
				sudoku.updateOriginalRV(sudoku.emptyCells.get(i));
			}
			
			//sudoku.emptyCells = sudoku.selectionSort(sudoku.emptyCells);
			
			System.out.println("Enter 0 for uninformed agent solution, 1 for CSP agent solution: ");
			int choice = input.nextInt();
			
			boolean success = false;
			if (choice == 0) {
				DummyAgent dumbo = new DummyAgent();
				success = dumbo.performUninformedSearch(sudoku);
				System.out.println("\nTotal assignments attempted: " + dumbo.assignments);
			} else if (choice == 1) {
				CSPAgent smarty = new CSPAgent();
				success = smarty.performMRVSearch(sudoku);
				System.out.println("\nTotal assignments attempted: " + smarty.assignments);
			}
			
			for (int row = 0; row < sudoku.puzzle.length; row++) {
				for (int col = 0; col < sudoku.puzzle[row].length; col++) {
					System.out.print(sudoku.puzzle[row][col].val);
				}
				System.out.println();
			}
			
			/**System.out.println("Empty cells by MRV: ");
			for (int i = 0; i < sudoku.emptyCells.size(); i++) {
				System.out.print("("+sudoku.emptyCells.get(i).row+","+sudoku.emptyCells.get(i).col+"), "+sudoku.emptyCells.get(i).countRV+"\t");
				if ((i+1)%5==0) {
					System.out.print("\n");
				}
			}**/
			input.close();
			frame.dispose();
			dialog.dispose();
		}		
	}	
}
