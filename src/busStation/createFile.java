package busStation;
import java.util.*;

public class createFile {
	private Formatter x;
	public void openFile() {
		try {
			x=new Formatter("Ahmed.txt");
		}
		catch (Exception e) {
			System.out.println("Error opening File");
		}
	}
	public void writeFile() {
		x.format("%s %s %s","20","Ahmed","whatever");
	}
	public void closeFile() {
		x.close();
	}
}
