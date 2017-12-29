package lab12;

import java.util.Scanner;

import lab12.Contact;
import lab12.FileAccessManager;

public class Lab12 {
	public static void main(String[] args) {
		FileAccessManager FAM = new FileAccessManager();
		User u1, u2, u3, u4;
		Contact c1, c2, c3, c4, c5, c6;
		int order;
		User u = new User();
		Contact c = new Contact();

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("\n==================================================================================================================");
			System.out.print("Type # of request(1:<create objects & save>, 2:<boot objects from file>, 3:<clear FileAccessManager>, 9: QUIT) ? ");
			order = scanner.nextInt();	
			System.out.println("==================================================================================================================");

			if(order == 9) break;

			switch(order) {
			case 1:

				// (Test1(10)) evaluate if <User> data files are created; tests dumpFile(), getRecordFromFile() in class <User>

				u1 = new User("20173333", "Hong Gil Dong", "hgd", 5, 897);
				u2 = new User("20174444", "Kim Chul Soo", "kcs", 3, 433);
				u3 = new User("20175555", "Park Soo Hong", "psh", 2, 246);
				u4 = new User("20176666", "Lee Sang Jin", "lsj", 1, 111);

				System.out.println("\n(Test1) ---------------------------------------------------------------------------------------------------------");
				u.dumpFile(1);
				u.dumpFile(2);
				u.dumpFile(3);
				u.dumpFile(4);

				if(u.getRecordFromFile(1)) System.out.println(u);
				if(u.getRecordFromFile(2)) System.out.println(u);
				if(u.getRecordFromFile(3)) System.out.println(u);
				if(u.getRecordFromFile(4)) System.out.println(u);


				// (Test2(10)) evaluate if <Contact> data files are created; tests dumpFile(), getRecordFromFile() in class <Contact>

				c1 = new Contact("HongGilDong", "gdhong@naver.com", "010-2353-8888", null, "Software", 23);
				c2 = new Contact("KimChulSoo", "cskim@naver.com", "010-2353-3333", "Nowon-gu", "Car", 17);
				c3 = new Contact("Ohsangbin", "sboh@naver.com", null, "Seongbuk-gu", "Art", 19);
				c4 = new Contact("ChoiMyungGil", "mgchoi@naver.com", "010-2353-4444", null, "Car", 8);
				c5 = new Contact("LeeHyunKyu", "hklee@naver.com", null, "Jongro-gu", "Software", 4);
				c6 = new Contact("ParkSooJin", "sjpark@naver.com", "010-2353-4444", "Mapo-gu", "Software", 15);

				System.out.println("\n(Test2) ---------------------------------------------------------------------------------------------------------");
				c.dumpFile(1);
				c.dumpFile(2);
				c.dumpFile(3);
				c.dumpFile(4);
				c.dumpFile(5);
				c.dumpFile(6);

				if(c.getRecordFromFile(1)) System.out.println(c);
				if(c.getRecordFromFile(2)) System.out.println(c);
				if(c.getRecordFromFile(3)) System.out.println(c);
				if(c.getRecordFromFile(4)) System.out.println(c);
				if(c.getRecordFromFile(5)) System.out.println(c);
				if(c.getRecordFromFile(6)) System.out.println(c);


				// registers User/Contact objects in <FileAccessManager>            	

				FAM.add(u1);
				FAM.add(c1);
				FAM.add(c2);
				FAM.add(u2);
				FAM.add(u3);
				FAM.add(c3);
				FAM.add(c4);
				FAM.add(c5);
				FAM.add(u4);
				FAM.add(c6);

				// (Test3(20)) print out the Contact objects registered in FileAccessManager; Contact::saveRecordToFile(), FileAccessManager::add(), FileAccessManager::getList(Contact.class)

				System.out.println("\n(Test3) ---------------------------------------------------------------------------------------------------------");
				System.out.println("Contact object list from getList(Contact.class) method: " + FAM.getList(Contact.class));

				// (Test4(20)) print out the User objects registered in FileAccessManager; User::saveRecordToFile(), FileAccessManager::add(), FileAccessManager::getList(Contact.class)

				System.out.println("\n(Test4) ---------------------------------------------------------------------------------------------------------");
				System.out.println("User object list from getList(User.class) method: " + FAM.getList(User.class));

				break;

			case 2:

				FAM.getFIOFromFile();

				// (Test5(10)) restores & print out all Contact objects saved in data files; tests getFIOFromFile()

				System.out.println("\n(Test5) ---------------------------------------------------------------------------------------------------------");
				System.out.println("Contact object list from getList(Contact.class) method: " + FAM.getList(Contact.class));

				// (Test6(10)) restores & print out all User objects saved in data files; tests getFIOFromFile()

				System.out.println("\n(Test6) ---------------------------------------------------------------------------------------------------------");
				System.out.println("User object list from getList(User.class) method: " + FAM.getList(User.class));

				break;

			case 3:

				FAM.clearAll();

				// (Test7(20)) clear FileAccessManager & metafile; tests clearAll()

				FAM.getFIOFromFile();

				System.out.println("\n(Test7) ---------------------------------------------------------------------------------------------------------");
				System.out.println("Contact object list from getList(Contact.class) method: " + FAM.getList(Contact.class));
				System.out.println("User object list from getList(User.class) method: " + FAM.getList(User.class));

				break;

			default:

				break;
			}

		} while(true);    	

	}

}


/*

===============================================================
| (1st run) reset <FileAccessManager> and delete "metafile"   |
|                                                             |
|          request sequence:  3 -> 2 -> 1 -> 9                |
===============================================================


==================================================================================================================
Type # of request(1:<create objects & save>, 2:<boot objects from file>, 3:<clear FileAccessManager>, 9: QUIT) ? 3
==================================================================================================================

(Test7) ---------------------------------------------------------------------------------------------------------
Contact object list from getList(Contact.class) method: []
User object list from getList(User.class) method: []

==================================================================================================================
Type # of request(1:<create objects & save>, 2:<boot objects from file>, 3:<clear FileAccessManager>, 9: QUIT) ? 2
==================================================================================================================

(Test5) ---------------------------------------------------------------------------------------------------------
Contact object list from getList(Contact.class) method: []

(Test6) ---------------------------------------------------------------------------------------------------------
User object list from getList(User.class) method: []

==================================================================================================================
Type # of request(1:<create objects & save>, 2:<boot objects from file>, 3:<clear FileAccessManager>, 9: QUIT) ? 1
==================================================================================================================

(Test1) ---------------------------------------------------------------------------------------------------------
<User> file does not exists...
<User> file does not exists...
<User> file does not exists...
<User> file does not exists...
<User> file does not exists...
<User> file does not exists...
<User> file does not exists...
<User> file does not exists...

(Test2) ---------------------------------------------------------------------------------------------------------
<Contact> file does not exists...
<Contact> file does not exists...
<Contact> file does not exists...
<Contact> file does not exists...
<Contact> file does not exists...
<Contact> file does not exists...
<Contact> file does not exists...
<Contact> file does not exists...
<Contact> file does not exists...
<Contact> file does not exists...
<Contact> file does not exists...
<Contact> file does not exists...

(Test3) ---------------------------------------------------------------------------------------------------------
Contact object list from getList(Contact.class) method: [
[Contact1.dat,	HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23], 
[Contact2.dat,	KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17], 
[Contact3.dat,	Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19], 
[Contact4.dat,	ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8], 
[Contact5.dat,	LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4], 
[Contact6.dat,	ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]]

(Test4) ---------------------------------------------------------------------------------------------------------
User object list from getList(User.class) method: [
[User1.dat,	20173333,	Hong Gil Dong,	hgd,	5,	897], 
[User2.dat,	20174444,	Kim Chul Soo,	kcs,	3,	433], 
[User3.dat,	20175555,	Park Soo Hong,	psh,	2,	246], 
[User4.dat,	20176666,	Lee Sang Jin,	lsj,	1,	111]]

==================================================================================================================
Type # of request(1:<create objects & save>, 2:<boot objects from file>, 3:<clear FileAccessManager>, 9: QUIT) ? 9
==================================================================================================================


===============================================================
|    (2nd run)     <REAL TEST run>    -->    "7 Tests"        |
|                                                             |
|          request sequence:  2 -> 3 -> 1 -> 2 -> 9           |
===============================================================


==================================================================================================================
Type # of request(1:<create objects & save>, 2:<boot objects from file>, 3:<clear FileAccessManager>, 9: QUIT) ? 2
==================================================================================================================

(Test5) ---------------------------------------------------------------------------------------------------------
Contact object list from getList(Contact.class) method: [
[Contact1.dat,	HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23], 
[Contact2.dat,	KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17], 
[Contact3.dat,	Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19], 
[Contact4.dat,	ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8], 
[Contact5.dat,	LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4], 
[Contact6.dat,	ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]]

(Test6) ---------------------------------------------------------------------------------------------------------
User object list from getList(User.class) method: [
[User1.dat,	20173333,	Hong Gil Dong,	hgd,	5,	897], 
[User2.dat,	20174444,	Kim Chul Soo,	kcs,	3,	433], 
[User3.dat,	20175555,	Park Soo Hong,	psh,	2,	246], 
[User4.dat,	20176666,	Lee Sang Jin,	lsj,	1,	111]]

==================================================================================================================
Type # of request(1:<create objects & save>, 2:<boot objects from file>, 3:<clear FileAccessManager>, 9: QUIT) ? 3
==================================================================================================================

(Test7) ---------------------------------------------------------------------------------------------------------
Contact object list from getList(Contact.class) method: []
User object list from getList(User.class) method: []

==================================================================================================================
Type # of request(1:<create objects & save>, 2:<boot objects from file>, 3:<clear FileAccessManager>, 9: QUIT) ? 1
==================================================================================================================

(Test1) ---------------------------------------------------------------------------------------------------------

file-name: 		"User1.dat"
1st-line(id): 		20173333
2nd-line(name): 	Hong Gil Dong
3rd-line(password): 	hgd
4th-line(level): 	5
5th-line(login): 	897

file-name: 		"User2.dat"
1st-line(id): 		20174444
2nd-line(name): 	Kim Chul Soo
3rd-line(password): 	kcs
4th-line(level): 	3
5th-line(login): 	433

file-name: 		"User3.dat"
1st-line(id): 		20175555
2nd-line(name): 	Park Soo Hong
3rd-line(password): 	psh
4th-line(level): 	2
5th-line(login): 	246

file-name: 		"User4.dat"
1st-line(id): 		20176666
2nd-line(name): 	Lee Sang Jin
3rd-line(password): 	lsj
4th-line(level): 	1
5th-line(login): 	111

[User1.dat,	20173333,	Hong Gil Dong,	hgd,	5,	897]

[User2.dat,	20174444,	Kim Chul Soo,	kcs,	3,	433]

[User3.dat,	20175555,	Park Soo Hong,	psh,	2,	246]

[User4.dat,	20176666,	Lee Sang Jin,	lsj,	1,	111]

(Test2) ---------------------------------------------------------------------------------------------------------

<file-name>: 		"Contact1.dat"
1st-line(name): 		HongGilDong
2nd-line(email): 	gdhong@naver.com
3rd-line(phone): 	010-2353-8888
4th-line(address): 	null
5th-line(major): 	Software
6th-line(credit): 	23

<file-name>: 		"Contact2.dat"
1st-line(name): 		KimChulSoo
2nd-line(email): 	cskim@naver.com
3rd-line(phone): 	010-2353-3333
4th-line(address): 	Nowon-gu
5th-line(major): 	Car
6th-line(credit): 	17

<file-name>: 		"Contact3.dat"
1st-line(name): 		Ohsangbin
2nd-line(email): 	sboh@naver.com
3rd-line(phone): 	null
4th-line(address): 	Seongbuk-gu
5th-line(major): 	Art
6th-line(credit): 	19

<file-name>: 		"Contact4.dat"
1st-line(name): 		ChoiMyungGil
2nd-line(email): 	mgchoi@naver.com
3rd-line(phone): 	010-2353-4444
4th-line(address): 	null
5th-line(major): 	Car
6th-line(credit): 	8

<file-name>: 		"Contact5.dat"
1st-line(name): 		LeeHyunKyu
2nd-line(email): 	hklee@naver.com
3rd-line(phone): 	null
4th-line(address): 	Jongro-gu
5th-line(major): 	Software
6th-line(credit): 	4

<file-name>: 		"Contact6.dat"
1st-line(name): 		ParkSooJin
2nd-line(email): 	sjpark@naver.com
3rd-line(phone): 	010-2353-4444
4th-line(address): 	Mapo-gu
5th-line(major): 	Software
6th-line(credit): 	15

[Contact1.dat,	HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]

[Contact2.dat,	KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17]

[Contact3.dat,	Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19]

[Contact4.dat,	ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8]

[Contact5.dat,	LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4]

[Contact6.dat,	ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]

(Test3) ---------------------------------------------------------------------------------------------------------
Contact object list from getList(Contact.class) method: [
[Contact1.dat,	HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23], 
[Contact2.dat,	KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17], 
[Contact3.dat,	Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19], 
[Contact4.dat,	ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8], 
[Contact5.dat,	LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4], 
[Contact6.dat,	ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]]

(Test4) ---------------------------------------------------------------------------------------------------------
User object list from getList(User.class) method: [
[User1.dat,	20173333,	Hong Gil Dong,	hgd,	5,	897], 
[User2.dat,	20174444,	Kim Chul Soo,	kcs,	3,	433], 
[User3.dat,	20175555,	Park Soo Hong,	psh,	2,	246], 
[User4.dat,	20176666,	Lee Sang Jin,	lsj,	1,	111]]

==================================================================================================================
Type # of request(1:<create objects & save>, 2:<boot objects from file>, 3:<clear FileAccessManager>, 9: QUIT) ? 2
==================================================================================================================

(Test5) ---------------------------------------------------------------------------------------------------------
Contact object list from getList(Contact.class) method: [
[Contact1.dat,	HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23], 
[Contact2.dat,	KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17], 
[Contact3.dat,	Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19], 
[Contact4.dat,	ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8], 
[Contact5.dat,	LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4], 
[Contact6.dat,	ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]]

(Test6) ---------------------------------------------------------------------------------------------------------
User object list from getList(User.class) method: [
[User1.dat,	20173333,	Hong Gil Dong,	hgd,	5,	897], 
[User2.dat,	20174444,	Kim Chul Soo,	kcs,	3,	433], 
[User3.dat,	20175555,	Park Soo Hong,	psh,	2,	246], 
[User4.dat,	20176666,	Lee Sang Jin,	lsj,	1,	111]]

==================================================================================================================
Type # of request(1:<create objects & save>, 2:<boot objects from file>, 3:<clear FileAccessManager>, 9: QUIT) ? 9
==================================================================================================================


 */