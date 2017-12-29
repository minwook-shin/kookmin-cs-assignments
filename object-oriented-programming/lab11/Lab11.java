package lab11;

import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.lang.reflect.*;


class Contact {
	private String name;
	private String email;
	private String phone;
	private String address;
	private String major;
	private int credit;

	Contact( String name, String email, String phone, String address, String major, int credit) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.major = major;		
		this.credit = credit;		
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

	public String toString() {
		return "\n\t\t\t[" + name + ",\t" + email + ",\t" + phone + ",\t" + address + ",\t" + major + ",\t" + credit + "]" ;
	}
}

class PriorityByName
implements Comparator<Object>
{

	public int compare(Object o1, Object o2)
	{

		Contact a1 = (Contact)o1;
		Contact a2 = (Contact)o2;

		return a1.getName().compareTo(a2.getName());
	}
}


class PriorityByAddress
implements Comparator<Object>
{

	public int compare(Object o1, Object o2)
	{
		int res = 0;

		Contact a1 = (Contact)o1;
		Contact a2 = (Contact)o2;

		if(a1.getAddress() == null) {
			if(a2.getAddress() == null) {
				res = 0;
			}
			else {
				res = 1;
			}
		}
		else {
			if(a2.getAddress() == null) {
				res = -1;
			}
			else {
				res = a1.getAddress().compareTo(a2.getAddress());
			}
		}
		// (Test1) implement here ...4?


		return res;
	}
}


class PriorityByMajor
implements Comparator<Object>
{

	public int compare(Object o1, Object o2)
	{

		Contact a1 = (Contact)o1;
		Contact a2 = (Contact)o2;

		return a1.getMajor().compareTo(a2.getMajor());
	}
}


class PriorityByCredit
implements Comparator<Object>
{
	public int compare(Object o1, Object o2)
	{
		int res = 0;

		Contact a1 = (Contact)o1;
		Contact a2 = (Contact)o2;

		// (Test2) implement here
		res = Integer.compare(a1.getCredit(), a2.getCredit());

		return res;
	}
}



class PriorityGeneral
implements Comparator<Object>
{
String method;

PriorityGeneral(String item)
{
		this.method = "get" + String.valueOf(item.charAt(0)).toUpperCase() + item.substring(1);
}

public int compare(Object o1, Object o2)
{
		Contact a1 = (Contact)o1;Contact a2 = (Contact)o2;
		int res = 0;
	try {
		Method m = a1.getClass().getDeclaredMethod(this.method);
		Object A1 = m.invoke(a1, null);Object A2 = m.invoke(a2, null);
		if(A1 == null) {
			res = 1;
		}
		else if(A2 == null) {
			res = -1;
		}
		else if(this.method.equals("getCredit")) {
			res = Integer.compare((int) A1, (int) A2);
		}
		else {
			res = ((String) A1).compareTo((String)A2);
		}
	} catch (Exception e) {
		e.printStackTrace();
		return 0;
	}
		
// (Test5) implement here
	return res;
}
}




@FunctionalInterface
interface Filter {
	boolean evaluation(Contact c); 
}


@FunctionalInterface
interface Compute<E> {
	int evaluation(LinkedList<E> c); 
}


class OrderedIteratorQueue2<E> extends PriorityQueue<E> {

	OrderedIteratorQueue2(int initialCapacity, Comparator<? super E> comparator) {
		super(initialCapacity, comparator);
	}

	OrderedIteratorQueue2(OrderedIteratorQueue2<? extends E> c) {
		super(c);
	}

	public LinkedList<E> orderedList() {

		LinkedList<E> order = new LinkedList<E>();
		E v = null;

		int s = size();
		for(int i = 0; i < s; i++) {
			v = poll();
			order.add(v);
		}

		for(int i = 0; i < order.size(); i++) {
			v = order.get(i);
			offer(v);
		}
		// (Test3) implement here

		return order;
	}

	public LinkedList<E> filteredCreditList(int value, boolean up) {

		LinkedList<E> order = orderedList();
		E v = null;

		for(int i = 0; i < order.size(); i++) {
			v = order.get(i);
			Contact c = (Contact) v;
			if(up ? (c.getCredit() <= value):(c.getCredit() >= value)) order.remove(i--);
		}

		return order;
	}

	public LinkedList<E> filteredMajorList(String major) {
		LinkedList<E> order = orderedList();
		E v = null;

		for(int i = 0; i < order.size(); i++) {
			v = order.get(i);
			Contact c = (Contact) v;
			if(! c.getMajor().equals(major)) order.remove(i--);
		}
		// (Test6) implement here


		return order;
	}

	public LinkedList<E> generalFilteredList(Filter f) {

		LinkedList<E> order = orderedList();
		E v = null;

		for(int i = 0; i < order.size(); i++) {
			v = order.get(i);
			Contact c = (Contact) v;
			if(!f.evaluation(c)) {
				order.remove(i--);
			}
		}
		// (Test7) implement here


		return order;
	}

	public int generalComputeList(Compute f) {

		LinkedList<E> order = orderedList();

		// (Test12) implement here
		int res = f.evaluation(order);

		return res;
	}

}


public class Lab11 {

	public static void main(String[] args)
	{
		OrderedIteratorQueue2<Contact> incoming;

		System.out.println("Type the field # for ordering (1:<name>, 2:<address>, 3:<major>, 4:<credit>)  ? ");
		Scanner scanner= new Scanner(System.in);
		int order = scanner.nextInt();	    	

		switch(order) {
		case 1:
			incoming = new OrderedIteratorQueue2<Contact>(6, new PriorityByName());
			break;
		case 2:
			// (Test1(10)) implements PriorityByAddress()
			incoming = new OrderedIteratorQueue2<Contact>(6, new PriorityByAddress());
			break;
		case 3:
			incoming = new OrderedIteratorQueue2<Contact>(6, new PriorityByMajor());
			break;
		case 4:
			// (Test2(10)) implements PriorityByCredit()
			incoming = new OrderedIteratorQueue2<Contact>(6, new PriorityByCredit());
			break;
		default:
			return;
		}

		// adds 6 new student Contact info into the empty queue	        

		Contact c1 = new Contact("HongGilDong", "gdhong@naver.com", "010-2353-8888", null, "Software", 23);
		Contact c2 = new Contact("KimChulSoo", "cskim@naver.com", "010-2353-3333", "Nowon-gu", "Car", 17);
		Contact c3 = new Contact("Ohsangbin", "sboh@naver.com", null, "Seongbuk-gu", "Art", 19);
		Contact c4 = new Contact("ChoiMyungGil", "mgchoi@naver.com", "010-2353-4444", null, "Car", 8);
		Contact c5 = new Contact("LeeHyunKyu", "hklee@naver.com", null, "Jongro-gu", "Software", 4);
		Contact c6 = new Contact("ParkSooJin", "sjpark@naver.com", "010-2353-4444", "Mapo-gu", "Software", 15);

		incoming.add(c1);
		incoming.add(c2);
		incoming.add(c3);
		incoming.add(c4);
		incoming.add(c5);
		incoming.add(c6);

		Iterator<Contact> it = incoming.iterator();

		int cnt = 0;
		while(it.hasNext()) {
			Contact v= it.next();
			System.out.print(v);
			cnt++;
		}
		System.out.println("\n --- add(c1...c6) & iterator() -- (total # of records = " + cnt + ") ---\n");

		// printout after removing one <Contact> object

		incoming.remove(c5);

		it = incoming.iterator();

		cnt = 0;
		while(it.hasNext()) {
			Contact v= it.next();
			System.out.print(v);
			cnt++;
		}
		System.out.println("\n --- remove(c5) -- (total # of records = " + cnt + ") ---\n");

		incoming.add(c5);

		// printout by repeated calling of poll() method

		cnt = 0;
		while (!incoming.isEmpty()) {
			System.out.print(incoming.poll());
			cnt++;
		}
		System.out.println("\n --- add(c5) & poll() -- (total # of records = " + cnt + ") ---\n");

		it = incoming.iterator();

		cnt = 0;
		while(it.hasNext()) {
			Contact v= it.next();
			System.out.print(v);
			cnt++;
		}
		System.out.println("\n --- iterator() -- (total # of records = " + cnt + ") ---\n");

		// sorted printout in the order of "name"

		incoming.add(c1);
		incoming.add(c2);
		incoming.add(c3);
		incoming.add(c4);
		incoming.add(c5);
		incoming.add(c6);

		// (Test3(10)) implements orderedList()

		LinkedList<Contact> r = incoming.orderedList();
		System.out.println(r);
		System.out.println(" --- add(c1...c6) & orderedList() -- (total # of records = " + r.size() + ") ---\n");

		// sorted printout in the order of "credit"

		PriorityByCredit strategyCredit = new PriorityByCredit();
		Collections.sort(r, strategyCredit);
		System.out.println(r);
		System.out.println(" --- sort(r, strategyCredit) -- (total # of records = " + r.size() + ") ---\n");

		// sorted printout in the order of "address"


		// (Test4(10)) implements here to sort <r> in the order of <address> by calling Collections.sort()
		//	        Collections.sort(r, ???);
		PriorityByAddress strategyAddress = new PriorityByAddress();
		Collections.sort(r, strategyAddress);

		System.out.println(r);
		System.out.println(" --- sort(r, strategyAddress) --  (total # of records = " + r.size() + ") ---\n");



		// (Test5(40)) implements PriorityGeneral()

		String ord[] = { "name", "email", "phone", "address", "major", "credit" };
		String orderedBy;

		do {
			System.out.println("Type the field # for ordering (1:<name>, 2:<email>, 3:<phone>, 4:<address>, 5:<major>, 6:<credit>), 9: QUIT  ? ");
			order = scanner.nextInt();	    	
			if(order>=1 && order<=6) orderedBy = ord[order-1];	 
			else orderedBy = ord[0]; 

			incoming = new OrderedIteratorQueue2<Contact>(6, new PriorityGeneral(orderedBy));

			incoming.add(c1);
			incoming.add(c2);
			incoming.add(c3);
			incoming.add(c4);
			incoming.add(c5);
			incoming.add(c6);

			if(order == 9) break;

			cnt = 0;
			while (!incoming.isEmpty()) {
				System.out.print(incoming.poll());
				cnt++;
			}
			System.out.println("\n --- PriorityGeneral(orderedBy) & poll() -- (total # of records = " + cnt + ") ---\n");

		} while(true);



		// list up the records whose credit value is no less than 16

		r = incoming.filteredCreditList(16, true);
		System.out.println(r);
		System.out.println(" --- filteredCreditList(16, true) ---  (total # of records = " + r.size() + ") ---\n");

		// list up the records whose major is equal to "Software"

		// (Test6(10)) implements filteredMajorList() -- 여기서부터 찾기
		r = incoming.filteredMajorList("Software");
		System.out.println(r);
		System.out.println(" --- filteredMajorList(\"Software\") --- (total # of records = " + r.size() + ") ---\n");



		// (Test7(20)) implements generalFilteredList()

		Filter fil;

		// list up the records whose  name is "LeeHyunKyu"
		fil = c -> c.getName().equals("LeeHyunKyu");
		r = incoming.generalFilteredList(fil);
		System.out.println(r);
		System.out.println(" --- generalFilteredList(find record of \"LeeHyunKyu\")) --- (total # of records = " + r.size() + ") ---\n");

		// (Test8(10)) set up the value of "fil" correctly so that <r> has all records whose credit is no greater than 15 in the list <incoming>
		//	        fil = ???;
		fil = c ->c.getCredit() <= 15;
		r = incoming.generalFilteredList(fil);
		System.out.println(r);
		System.out.println(" --- generalFilteredList(credit is no greater than 15) --- (total # of records = " + r.size() + ") ---\n");

		// (Test9(10)) set up the value of "fil" correctly so that <r> has all records whose address is null in the list <incoming>
		//	        fil = ???;
		fil = c -> c.getAddress() == null;
		r = incoming.generalFilteredList(fil);
		System.out.println(r);
		System.out.println(" --- generalFilteredList(address is null) --- (total # of records = " + r.size() + ") ---\n");

		// (Test10(10)) set up the value of "fil" correctly so that <r> has all records whose phone # is "010-2353-4444" in the list <incoming>
		//	        fil = ???;
		fil = c -> {
			if (c.getPhone() != null) {
				return c.getPhone().equals("010-2353-4444");
			} else {
				return false;
			}
		};
		r = incoming.generalFilteredList(fil);
		System.out.println(r);
		System.out.println(" --- generalFilteredList(phone # is \"010-2353-4444\") --- (total # of records = " + r.size() + ") ---\n");

		// (Test11(10)) set up the value of "fil" correctly so that <r> has all records whose major is "Car" in the list <incoming>
		//	        fil = ???;
		fil = c -> c.getMajor().equals("Car");
		r = incoming.generalFilteredList(fil);
		System.out.println(r);
		System.out.println(" --- generalFilteredList(major is \"Car\") --- (total # of records = " + r.size() + ") ---\n");


		// (Test12(10)) implements generalComputeList()

		Compute com;

		// (Test13(20)) set up the value of "com" correctly so that <cnt> has total sum of the credits in the list <incoming>	        
		com = e -> {int res = 0;for(int i=0;i<e.size();i++){Contact c = (Contact) e.get(i);res += c.getCredit();}
			return res;
		};
		cnt = incoming.generalComputeList(com);
		System.out.println(" --- generalComputeList(total sum of the credits in the list) --- (sum of credits = " + cnt + ") ---\n");

		// (Test14(20)) set up the value of "com" correctly so that <cnt> has maximum value among all the credits in the list <incoming>	        
		com = e -> {int res = 0;for(int i=0;i<e.size();i++){Contact c = (Contact) e.get(i);res = res < c.getCredit()?c.getCredit():res;}
			return res;
		};
		cnt = incoming.generalComputeList(com);
		System.out.println(" --- generalComputeList(maximum value among all the credits in the list) --- (max of credits = " + cnt + ") ---\n");

	}
}


/* (correct printout results)

Type the field # for ordering (1:<name>, 2:<address>, 3:<major>, 4:<credit>)  ? 
1

			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8]
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]
			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19]
			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17]
			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4]
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]
 --- add(c1...c6) & iterator() -- (total # of records = 6) ---


			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8]
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]
			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19]
			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17]
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]
 --- remove(c5) -- (total # of records = 5) ---


			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8]
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]
			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17]
			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4]
			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19]
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]
 --- add(c5) & poll() -- (total # of records = 6) ---


 --- iterator() -- (total # of records = 0) ---

[
			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8], 
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23], 
			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17], 
			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4], 
			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19], 
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]]
 --- add(c1...c6) & orderedList() -- (total # of records = 6) ---

[
			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4], 
			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8], 
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15], 
			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17], 
			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19], 
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]]
 --- sort(r, strategyCredit) -- (total # of records = 6) ---

[
			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4], 
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15], 
			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17], 
			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19], 
			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8], 
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]]
 --- sort(r, strategyAddress) --  (total # of records = 6) ---

Type the field # for ordering (1:<name>, 2:<email>, 3:<phone>, 4:<address>, 5:<major>, 6:<credit>), 9: QUIT  ? 
6

			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4]
			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8]
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]
			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17]
			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19]
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]
 --- PriorityGeneral(orderedBy) & poll() -- (total # of records = 6) ---

Type the field # for ordering (1:<name>, 2:<email>, 3:<phone>, 4:<address>, 5:<major>, 6:<credit>), 9: QUIT  ? 
5

			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19]
			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8]
			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17]
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]
			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4]
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]
 --- PriorityGeneral(orderedBy) & poll() -- (total # of records = 6) ---

Type the field # for ordering (1:<name>, 2:<email>, 3:<phone>, 4:<address>, 5:<major>, 6:<credit>), 9: QUIT  ? 
4

			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4]
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]
			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17]
			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19]
			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8]
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]
 --- PriorityGeneral(orderedBy) & poll() -- (total # of records = 6) ---

Type the field # for ordering (1:<name>, 2:<email>, 3:<phone>, 4:<address>, 5:<major>, 6:<credit>), 9: QUIT  ? 
3

			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17]
			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8]
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]
			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19]
			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4]
 --- PriorityGeneral(orderedBy) & poll() -- (total # of records = 6) ---

Type the field # for ordering (1:<name>, 2:<email>, 3:<phone>, 4:<address>, 5:<major>, 6:<credit>), 9: QUIT  ? 
2

			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17]
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]
			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4]
			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8]
			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19]
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]
 --- PriorityGeneral(orderedBy) & poll() -- (total # of records = 6) ---

Type the field # for ordering (1:<name>, 2:<email>, 3:<phone>, 4:<address>, 5:<major>, 6:<credit>), 9: QUIT  ? 
1

			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8]
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]
			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17]
			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4]
			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19]
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]
 --- PriorityGeneral(orderedBy) & poll() -- (total # of records = 6) ---

Type the field # for ordering (1:<name>, 2:<email>, 3:<phone>, 4:<address>, 5:<major>, 6:<credit>), 9: QUIT  ? 
9
[
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23], 
			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17], 
			[Ohsangbin,	sboh@naver.com,	null,	Seongbuk-gu,	Art,	19]]
 --- filteredCreditList(16, true) ---  (total # of records = 3) ---

[
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23], 
			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4], 
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]]
 --- filteredMajorList("Software") --- (total # of records = 3) ---

[
			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4]]
 --- generalFilteredList(find record of "LeeHyunKyu")) --- (total # of records = 1) ---

[
			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8], 
			[LeeHyunKyu,	hklee@naver.com,	null,	Jongro-gu,	Software,	4], 
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]]
 --- generalFilteredList(credit is no greater than 15) --- (total # of records = 3) ---

[
			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8], 
			[HongGilDong,	gdhong@naver.com,	010-2353-8888,	null,	Software,	23]]
 --- generalFilteredList(address is null) --- (total # of records = 2) ---

[
			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8], 
			[ParkSooJin,	sjpark@naver.com,	010-2353-4444,	Mapo-gu,	Software,	15]]
 --- generalFilteredList(phone # is "010-2353-4444") --- (total # of records = 2) ---

[
			[ChoiMyungGil,	mgchoi@naver.com,	010-2353-4444,	null,	Car,	8], 
			[KimChulSoo,	cskim@naver.com,	010-2353-3333,	Nowon-gu,	Car,	17]]
 --- generalFilteredList(major is "Car") --- (total # of records = 2) ---

 --- generalComputeList(total sum of the credits in the list) --- (sum of credits = 86) ---

 --- generalComputeList(maximum value among all the credits in the list) --- (max of credits = 23) ---


 */