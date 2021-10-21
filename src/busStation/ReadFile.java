package busStation;
import java.io.*;
import java.util.*;
public class ReadFile {
	private Scanner x;
	private int i=0;
	private int j=0;
	private String Uname[];
	private String Pw[];
	public void openFile(String a) {
		try {
			x=new Scanner(new File(a));
		}
		catch (Exception e) {
			System.out.println("Couldn't find file");
		}
	}
	public void readFile() {
		while (x.hasNext()) {
			Uname[i]=x.next();
			Pw[i]=x.next();
			i++;
		}
	}
	public void closeFile() {
		x.close();
	}

}