package lab12;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Contact implements FileIO {
	private String name;
	private String email;
	private String phone;
	private String address;
	private String major;
	private int credit;

	static private String preName = "Contact";
	static private String postName = ".dat";
	private String fileName;
	private String ticketName = preName + "Ticket" + postName;
	int ticket;

	Contact() {
		File f = new File(ticketName);
		if(!f.exists())
			try {
				FileOutputStream fout = new FileOutputStream(f);
				DataOutputStream dout = new DataOutputStream(fout);
				dout.writeBytes(1 + "\n");
				dout.close();
				fout.close();
			} catch (IOException e) {
				System.out.println("error in Contact()");			
			}
	}

	Contact( String name, String email, String phone, String address, String major, int credit) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.major = major;		
		this.credit = credit;		

		File f = new File(ticketName);
		if(!f.exists())
			try {
				FileOutputStream fout = new FileOutputStream(f);
				DataOutputStream dout = new DataOutputStream(fout);
				dout.writeBytes(1 + "\n");
				dout.close();
				fout.close();
			} catch (IOException e) {
				System.out.println("error in Contact( String name, String email, String phone, String address, String major, int credit)");			
			}
	}

	public String getName()
	{
		return name;
	}

	public String getEmail()
	{
		return email;
	}

	public String getPhone()
	{
		return phone;
	}

	public String getAddress()
	{
		return address;
	}

	public String getMajor()
	{
		return major;
	}

	public int getCredit()
	{
		return credit;
	}

	public String getFileName() {
		return fileName;
	}

	public void saveRecordToFile() {

		String scredit = String.valueOf(credit);

		try {
			File f = new File(ticketName);
			FileInputStream fin = new FileInputStream(f);
			Scanner s = new Scanner(fin);

			// (Test3)	
			if(s.hasNext()) {
				ticket = s.nextInt();
				}
			else {
				ticket =1;
			}
//			try {
//				ticket = s.nextInt();
//			} catch (Exception e) {
//				ticket = 1;
//			}
			

			s.close();
			fin.close();

			fileName = preName + ticket + postName;

			FileOutputStream fout = new FileOutputStream(f);
			DataOutputStream dout = new DataOutputStream(fout);

			// (Test3)				
			dout.writeBytes((ticket + 1) + "\n");

			dout.close();
			fout.close();

			f = new File(fileName);
			fout = new FileOutputStream(f);
			dout = new DataOutputStream(fout);
			
			dout.writeBytes(name + "\n");
			dout.writeBytes(email + "\n");
			dout.writeBytes(phone + "\n");
			dout.writeBytes(address + "\n");
			dout.writeBytes(major + "\n");
			dout.writeBytes(credit + "\n");

			// (Test3)				

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
		if(!f.exists()) { System.out.println("<Contact> file does not exists..."); return false; }
		try {
			FileInputStream fin = new FileInputStream(f);
			Scanner s = new Scanner(fin);

			// (Test2)		
			this.name = s.nextLine();
			this.email = s.nextLine();
			this.phone = s.nextLine();
			this.address = s.nextLine();
			this.major = s.nextLine();
			this.credit = s.nextInt();

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
		if(!f.exists()) { System.out.println("<Contact> file does not exists..."); return; }
		try {
			FileInputStream fin = new FileInputStream(f);
			Scanner s = new Scanner(fin);

			// (Test2)		
			System.out.println("file-name:" + "\t\t\"" + dfileName + "\"");
			System.out.println("1st-line(name):" + "\t\t\"" + s.nextLine() + "\"");
			System.out.println("2nd-line(email):" + "\t\t\"" + s.nextLine() + "\"");
			System.out.println("3rd-line(phone):" + "\t\t\"" + s.nextLine() + "\"");
			System.out.println("4th-line(address):" + "\t\t\"" + s.nextLine() + "\"");
			System.out.println("5th-line(major):" + "\t\t\"" + s.nextLine() + "\"");
			System.out.println("6th-line(credit):" + "\t\t\"" + s.nextInt() + "\"");

			s.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("error in dumpFile()");
		}			

	}

	public String toString() {
		return "\n[" + fileName + ",\t" + name + ",\t" + email + ",\t" + phone + ",\t" + address + ",\t" + major + ",\t" + credit + "]" ;
	}
}
