package lab12;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class FileAccessManager {

	LinkedList<FileIO> FileIOList = new LinkedList<FileIO>();	
	static private String metaFile = "FIOList.dat";

	FileAccessManager() {

	}


	void add(FileIO fio) {		 
		FileIOList.add(fio);
		fio.saveRecordToFile();
		try {
			File f = new File(metaFile);
			FileOutputStream fout = new FileOutputStream(f, true);
			DataOutputStream dout = new DataOutputStream(fout);

			if (fio instanceof User) {
				User u = (User)fio;
				dout.writeBytes(u.getFileName() + "\n");
			} else if (fio instanceof Contact) {
				Contact c = (Contact)fio;
				dout.writeBytes(c.getFileName() + "\n");
			}

			// (Test3 & 4)	

			dout.close();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error in add()");
		}		
	}


	LinkedList<FileIO> getList(Class cname) {
		LinkedList<FileIO> res = new LinkedList<FileIO>();

		try {
			File f = new File(metaFile);
			FileInputStream fin = new FileInputStream(f);
			Scanner s = new Scanner(fin);
			String type;
			int id;

			while(s.hasNext()) {
				String filename = s.nextLine();
				if (cname.equals(User.class) && filename.contains("User")) {
					User u = new User();
					u.getRecordFromFile(Integer.parseInt(filename.replaceAll("User", "").replaceAll(".dat", ""))
					);
					res.add(u);
				} else if(cname.equals(Contact.class) && filename.contains("Contact")) {
					Contact c = new Contact();
					c.getRecordFromFile(Integer.parseInt(filename.replaceAll("Contact", "").replaceAll(".dat", ""))
					);
					res.add(c);
				}
				// (Test5 & 6)				

			}

			s.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("");
		}

		return res;		 
	}


	void getFIOFromFile() {
		FileIOList.clear();

		try {
			File f = new File(metaFile);
			if(!f.exists()) return;
			FileInputStream fin = new FileInputStream(f);
			Scanner s = new Scanner(fin);
			String type;
			int id;

			while(s.hasNext()) {
				String filename = s.nextLine();
				// (Test5 & 6)
				if (filename.contains("User")) {
					User u = new User();
					u.getRecordFromFile(Integer.parseInt(filename.replaceAll("User", "").replaceAll(".dat", "")));
					FileIOList.add(u);
				} else if (filename.contains("Contact")) {
					Contact c = new Contact();
					c.getRecordFromFile(Integer.parseInt(filename.replaceAll("Contact", "").replaceAll(".dat", "")));
					FileIOList.add(c);
				}


			}

			s.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("error in getFIOFromFile()");
		}		

	}

	void clearAll() {

		// (Test7)
		//
		//   1) delete <metafile> from hard disk
		//   2) delete "UserTicket.dat"
		//   3) delete "ContactTicket.dat" 
		//   4) clear all User/Contact objects in the linked list
		//

		File delFile = new File(metaFile);
		delFile.delete();

		File delUserFile = new File("UserTicket.dat");
		delUserFile.delete();

		File delContactFile = new File("ContactTicket.dat");
		delContactFile.delete();
		
		FileIOList.clear();
//만약  유저 세부도 지워야 할때

//		String s = System.getProperty("user.dir");
//		File f = new File(s);
//		for (String filename : f.list()) {
//			if (filename.contains("User") || filename.contains("Contact")) {
//				File delcustomFile = new File(filename);
//				delcustomFile.delete();
//			}
//		}
	}
}