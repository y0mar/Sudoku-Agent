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
		File file2 = new File(dialog.getDirectory() + filename);
		
		if(filename == null) {
			System.out.println("You cancelled the choice");
			input.close();
			frame.dispose();
			dialog.dispose();
			}
		else {
			System.out.println("You chose: " + filename);
			
			Puzzle sudoku1 = new Puzzle();
			Puzzle sudoku2 = new Puzzle();
			sudoku1.load(file); 
			sudoku2.load(file2);
			
			
			for (int i = 0; i < sudoku1.emptyCells.size(); i++) {
				sudoku1.updateOriginalRV(sudoku1.emptyCells.get(i));
			}
			
			
			for (int i = 0; i < sudoku2.emptyCells.size(); i++) {
				sudoku2.updateOriginalRV(sudoku2.emptyCells.get(i));
			}
			
			//System.out.println("Enter 0 for uninformed agent solution, 1 for CSP agent solution: ");
			//int choice = input.nextInt();
			
			boolean success = false;
			//if (choice == 0) {
				DummyAgent dumbo = new DummyAgent();
				success = dumbo.performUninformedSearch(sudoku1);
				System.out.println("\nUninformed search agent total assignments attempted: " + dumbo.assignments);
				
				for (int row = 0; row < sudoku1.puzzle.length; row++) {
					for (int col = 0; col < sudoku1.puzzle[row].length; col++) {
						System.out.print(sudoku1.puzzle[row][col].val);
					}
					System.out.println();
				}
				
			//} else if (choice == 1) {
				CSPAgent smarty = new CSPAgent();
				success = smarty.performMRVSearch(sudoku2);
				System.out.println("\nCSP agent total assignments attempted: " + smarty.assignments);
			//}
			
			for (int row = 0; row < sudoku2.puzzle.length; row++) {
				for (int col = 0; col < sudoku2.puzzle[row].length; col++) {
					System.out.print(sudoku2.puzzle[row][col].val);
				}
				System.out.println();
			}
			
			//used for checking next five empty cells and their # of remaining values in emtpyCell list
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
