package busStation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VerifyLogin {
	static String ID;
	private String LEVEL;
	static String tempoID;
	public boolean Verifylogin(String username, String password,String filepath)
	{   
		boolean found=false;
		String tempUsername="";
		String tempPassword="";
		String tempID="";
		try {
			Scanner x=new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			while (x.hasNext() && !found)
			{
				tempUsername=x.next();
				tempPassword=x.next();
				tempID=x.next();
				if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim()))
				{
					found=true;
					setID(tempID);
				}
			}
		x.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		}
		return found;
	}
	public boolean VerifyEmp(String username, String password,String filepath)
	{   
		boolean found=false;
		String tempUsername="";
		String tempPassword="";
		String tempID="";
		String level="";
		try {
			Scanner x=new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
			while (x.hasNext() && !found)
			{
				tempUsername=x.next();
				tempPassword=x.next();
				tempoID=x.next();
				level=x.next();
				if (tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim()))
				{
					found=true;
					setID(tempID);
					setLEVEL(level);
					
				}
			}
		x.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		}
		return found;
	}
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 **/
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * @return the iD
	 */
	public String getLEVEL() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 **/
	public void setLEVEL(String level) {
		ID = level;
	}
}
