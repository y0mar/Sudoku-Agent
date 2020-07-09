import java.util.*;
import java.awt.*;
import javax.swing.*;

public class driver {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		FileDialog dialog = new FileDialog(frame, "Select a file", FileDialog.LOAD);
		dialog.setDirectory("C://");
		dialog.setFile("*.txt");
		dialog.setVisible(true);
		String filename = dialog.getFile();
		
		if(filename == null) {
			System.out.println("You cancelled the choice");
			}
		else {
			System.out.println("You chose: " + filename);
		}
		
	}
	
}
