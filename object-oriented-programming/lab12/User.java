package lab12;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class User implements FileIO {
	String id = null;
	String name = null;
	String password = null;
	int level = 0;
	int login = 0;

	static private String preName = "User";
	static private String postName = ".dat";
	private String fileName = null;
	private String ticketName = preName + "Ticket" + postName;
	int ticket;

	User() {
		File f = new File(ticketName);
		if(!f.exists())
			try {
				FileOutputStream fout = new FileOutputStream(f);
				DataOutputStream dout = new DataOutputStream(fout);
				dout.writeBytes(1 + "\n");
				dout.close();
				fout.close();
			} catch (IOException e) {
				System.out.println("error in User()");			
			}
	}

	User(String id, String name, String password, int level, int login) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.level = level;
		this.login = login;
		File f = new File(ticketName);
		if(!f.exists())
			try {
				FileOutputStream fout = new FileOutputStream(f);
				DataOutputStream dout = new DataOutputStream(fout);
				dout.writeBytes(1 + "\n");
				dout.close();
				fout.close();
			} catch (IOException e) {
				System.out.println("error in User(String id, String name, String password, int level, int login)");			
			}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public String getFileName() {
		return fileName;
	}

	public void saveRecordToFile() {

		String slevel = String.valueOf(level);
		String slogin = String.valueOf(login);

		try {
			File f = new File(ticketName);
			FileInputStream fin = new FileInputStream(f);
			Scanner s = new Scanner(fin);
			
			// (Test4)		
			try {
				ticket = s.nextInt();
			} catch (Exception e) {
				ticket = 1;
			}

			s.close();
			fin.close();

			fileName = preName + ticket + postName;

			FileOutputStream fout = new FileOutputStream(f);
			DataOutputStream dout = new DataOutputStream(fout);

			// (Test4)
			dout.writeBytes((ticket + 1) + "\n");

			dout.close();
			fout.close();

			f = new File(fileName);
			fout = new FileOutputStream(f);
			dout = new DataOutputStream(fout);

			dout.writeBytes(id + "\n");
			dout.writeBytes(name + "\n");
			dout.writeBytes(password + "\n");
			dout.writeBytes(level + "\n");
			dout.writeBytes(login + "\n");
			
			// (Test4)		

			dout.close();
			fout.close();

		} catch (IOException e) {
			System.out.println("error in saveRecordToFile()");
		}		
	}

	public boolean getRecordFromFile(int count) {
		ticket = count;
		fileName = preName + ticket + postName;		
		String st;

		File f = new File(fileName);
		if(!f.exists()) { System.out.println("<User> file does not exists..."); return false; }
		try {
			FileInputStream fin = new FileInputStream(f);
			Scanner s = new Scanner(fin);

			// (Test1)				
			this.id = s.nextLine();
			this.name = s.nextLine();
			this.password = s.nextLine();
			this.level = s.nextInt();
			this.login = s.nextInt();

			s.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("error in getRecordFromFile()"); 
			return false;
		}

		return true;

	}

	public void updateRecordToFile() {

	}

	public void dumpFile(int count) {
		String dfileName = preName + count + postName;		

		File f = new File(dfileName);
		if(!f.exists()) { System.out.println("<User> file does not exists..."); return; }
		try {
			FileInputStream fin = new FileInputStream(f);
			Scanner s = new Scanner(fin);

			// (Test1)
			System.out.println("file-name:" + "\t\t\"" + dfileName + "\"");
			System.out.println("1st-line(id):" + "\t\t\"" + s.nextLine() + "\"");
			System.out.println("2nd-line(name):" + "\t\t\"" + s.nextLine() + "\"");
			System.out.println("3rd-line(password):" + "\t\t\"" + s.nextLine() + "\"");
			System.out.println("4th-line(level):" + "\t\t\"" + s.nextInt() + "\"");
			System.out.println("5th-line(login):" + "\t\t\"" + s.nextInt() + "\"");

			s.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("error in dumpFile()");
		}
	}

	public String toString() {
		return "\n[" + fileName + ",\t" + id + ",\t" + name + ",\t" + password + ",\t" + level + ",\t" + login + "]" ;
	}
}
