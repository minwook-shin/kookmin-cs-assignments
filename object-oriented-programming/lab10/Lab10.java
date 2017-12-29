package lab10;
import java.util.*;
public class Lab10 {
	
    LinkedList<Contact> contactList = new LinkedList<Contact>();

    Contact createContact(String name, String email, String phone, String address, String major) {
		Contact c = new Contact(name, email, phone, address, major);
		return c;
	}
	
	 void add(Contact con) {
		 contactList.add(con);
	 }
	 
	 void addFirst(Contact con) {
		 contactList.addFirst(con);
	 }
	 
	 void addLast(Contact con) {
		 contactList.addLast(con);
	 }
	 
	 LinkedList<Contact> list() {
		 return contactList;
	 }
	 
	 Contact get(int index) {
		 return contactList.get(index);
	 }
	 
	 Contact set(int index, Contact con) {
		 return contactList.set(index, con);
	 }
	 
	 void add(int index, Contact con) {
		 contactList.add(index, con);
	 }
	 
	 void removeFirst() {
		 contactList.removeFirst();
	 }
	 
	 void removeLast() {
		 contactList.removeLast();
	 }
	 
	 void remove(int index) {
		 contactList.remove(index);
	 }

	 void clear() {
		 contactList.clear();
	 }

//---------------------------------------------------
	 

	 void addInOrder(Contact con) {

// (Test1)
		 add(con);
		 Collections.sort(contactList);

//		 contactOrderedList.add(con);
		 
	 }

	 
	 Contact getContact(String name) {
		 Contact res = null;

// (Test2)
		 for(int index =0;index<contactList.size();index++) {
			 if(contactList.get(index).name.equals(name)) {
				 res = contactList.get(index);
				 break;
			}
		 }
		 
		 
		 return res;
	 }

	 
	 Contact getFirstContact() {
		 Contact res = null;
		 
// (Test3)
		 if(!contactList.isEmpty()) res = contactList.get(0);
		 
		 return res;
	 }

	 
	 Contact getLastContact() {
		 Contact res = null;
		 if(!contactList.isEmpty()) res = contactList.get(contactList.size() - 1);
// (Test4)
		 
		 return res;
	 }

	 
	 LinkedList<Contact> getNullPhone() {
		 LinkedList<Contact> nullPhoneList = new LinkedList<Contact>();		
		 
// (Test5)
		 for(int index =0;index<contactList.size();index++) {
			 if(contactList.get(index).phone == null) {
				 nullPhoneList.add(contactList.get(index));
				 }
		 }
		 
		 
		 return nullPhoneList;
	 }

	 
	 LinkedList<Contact> getNullAddress() {
		 LinkedList<Contact> nullAddressList = new LinkedList<Contact>();		
		 for(int index =0;index<contactList.size();index++) {
			 if(contactList.get(index).address == null) {
				 nullAddressList.add(contactList.get(index));
				 }
		 }
// (Test6)
		 
		 
		 
		 return nullAddressList;
	 }

	 
	 void setContact(Contact con) {

// (Test7)
		 for(int index =0;index<contactList.size();index++) {
			 if(contactList.get(index).name.equals(con.name)) {
				 remove(index);
				 contactList.add(index,con);
				 
			}
		 }
		 

	 }
	 
	 
	 void removeContact(String name) {

// (Test8)
		 for(int index =0;index<contactList.size();index++) {
			 if(contactList.get(index).name.equals(name)) {
				 remove(index);
			}
		 }
		 

	 }

	 
	 
	 
	
     public static void main(String args[]) {
    	 
    	 Lab10 lab = new Lab10();


// (EXAMPLE RUN) STARTING ==============================================================         

    	 System.out.println("\n(EXAMPLE RUN) STARTING =====================================================================");

    	 
//
    	 
    	 Contact c1 = lab.createContact("HongGilDong", "hong@naver.com", "010-2353-8888", null, "Software");
    	 Contact c2 = lab.createContact("KimChulSoo", "kim@naver.com", "010-2353-3333", null, "Car");
    	 Contact c3 = lab.createContact("Ohsangbin", "oh@naver.com", null, "Seongbuk-gu", "Art");
    	 Contact c4 = lab.createContact("ChoiMyungGil", "choi@naver.com", "010-2353-4444", null, "Car");
    	 Contact c5 = lab.createContact("LeeHyunKyu", "lee@naver.com", null, "Jongro-gu", null);
    	 
    	 lab.add(c1);
    	 lab.add(c2);
    	 lab.add(c3);
    	 lab.add(c4);
    	 lab.add(c5);

         System.out.println("Contact List Content: " + lab.list());   	 
    	 

//
         Contact cFirst = lab.createContact("First Item", null, null, null, null);
    	 Contact cLast = lab.createContact("Last Item", null, null, null, null);
         lab.addFirst(cFirst);
         lab.addLast(cLast);
         
         System.out.println("Contact List Content after addition: " + lab.list());

         
//
         Object first = lab.get(0);
         System.out.println("First element: " +first);
         Contact cChangedFirst = lab.createContact("Changed first item", null, null, null, null);         
         lab.set(0, cChangedFirst);
         Object first2 = lab.get(0);
         System.out.println("First element after update by set method: " +first2);
         
         
//
         lab.removeFirst();
         lab.removeLast();
         System.out.println("Contact List after deletion of first and last element: " + lab.list());

         
//
         Contact cAdd = lab.createContact("Newly added item", null, null, null, null);         
         lab.add(0, cAdd);
         lab.remove(2);
         System.out.println("Final Content: " + lab.list()); 

         
         
// (Test) STARTING ==============================================================         

    	 System.out.println("\n(Test) STARTING =========================================================================");
         
         
// (Test1) addInOrder(<Contact object>): construct list in the ascending order of "name" in <Contact object>.

    	 lab.clear();

    	 lab.addInOrder(c1);
    	 lab.addInOrder(c2);
    	 lab.addInOrder(c3);
    	 lab.addInOrder(c4);
    	 lab.addInOrder(c5);

    	 System.out.println("\n(Test1) ------------------------------------------");
         System.out.println("Contact List Content: " + lab.list());   	 

         
// (Test2) getContact(<name>): find a Contact object whose name is corresponding to the input argument <name>.
         
         Object c99 = lab.getContact("Ohsangbin");      
         
    	 System.out.println("\n(Test2) ------------------------------------------");
         System.out.println("Contact object after getContact method: " + c99);

         
// (Test3) getFirstContact(): find the first Contact object in the order list.
               
         c99 = lab.getFirstContact();      
               
    	 System.out.println("\n(Test3) ------------------------------------------");
         System.out.println("Contact object after getFirstContact method: " + c99);

               
// (Test4) getLastContact(): find the last Contact object in the order list.
                     
         c99 = lab.getLastContact();      
                     
    	 System.out.println("\n(Test4) ------------------------------------------");
         System.out.println("Contact object after getLastContact method: " + c99);
         
         
// (Test5) getNullPhone(): find a subset of Contact objects that have no phone #.
         
    	 System.out.println("\n(Test5) ------------------------------------------");
         System.out.println("Contact object after getNullPhone method: " + lab.getNullPhone());
         
         
// (Test6) getNullAddress(): find a subset of Contact objects that have no address information.
         
    	 System.out.println("\n(Test6) ------------------------------------------");
         System.out.println("Contact object after getNullAddress method: " + lab.getNullAddress());
         

// (Test7) setContact(<Contact object>): updates a contact object with new information.
         
    	 c2.address = "Gangseo-gu";
    	 c5.phone = "010-2353-7777";
         lab.setContact(c2);         
         lab.setContact(c5);         
         
    	 System.out.println("\n(Test7) -------------------------------------------------------------------");
         System.out.println("Contact object after updating address/phone data by setContact method: " + lab.list());
        
         
// (Test8) removeContact(<name>): remove a Contact object whose name is corresponding to the input argument <name>.
         
         lab.removeContact("KimChulSoo");      
         
    	 System.out.println("\n(Test8) ------------------------------------------");
         System.out.println("Contact object after removeContact method: " + lab.list());
        
         
     }
     

     
/* (target result printout) --------------------------------------------------------------------------------


     (EXAMPLE RUN) STARTING =====================================================================
     Contact List Content: [
     			[HongGilDong,	hong@naver.com,	010-2353-8888,	null,	Software], 
     			[KimChulSoo,	kim@naver.com,	010-2353-3333,	null,	Car], 
     			[Ohsangbin,	oh@naver.com,	null,	Seongbuk-gu,	Art], 
     			[ChoiMyungGil,	choi@naver.com,	010-2353-4444,	null,	Car], 
     			[LeeHyunKyu,	lee@naver.com,	null,	Jongro-gu,	null]]
     Contact List Content after addition: [
     			[First Item,	null,	null,	null,	null], 
     			[HongGilDong,	hong@naver.com,	010-2353-8888,	null,	Software], 
     			[KimChulSoo,	kim@naver.com,	010-2353-3333,	null,	Car], 
     			[Ohsangbin,	oh@naver.com,	null,	Seongbuk-gu,	Art], 
     			[ChoiMyungGil,	choi@naver.com,	010-2353-4444,	null,	Car], 
     			[LeeHyunKyu,	lee@naver.com,	null,	Jongro-gu,	null], 
     			[Last Item,	null,	null,	null,	null]]
     First element: 
     			[First Item,	null,	null,	null,	null]
     First element after update by set method: 
     			[Changed first item,	null,	null,	null,	null]
     Contact List after deletion of first and last element: [
     			[HongGilDong,	hong@naver.com,	010-2353-8888,	null,	Software], 
     			[KimChulSoo,	kim@naver.com,	010-2353-3333,	null,	Car], 
     			[Ohsangbin,	oh@naver.com,	null,	Seongbuk-gu,	Art], 
     			[ChoiMyungGil,	choi@naver.com,	010-2353-4444,	null,	Car], 
     			[LeeHyunKyu,	lee@naver.com,	null,	Jongro-gu,	null]]
     Final Content: [
     			[Newly added item,	null,	null,	null,	null], 
     			[HongGilDong,	hong@naver.com,	010-2353-8888,	null,	Software], 
     			[Ohsangbin,	oh@naver.com,	null,	Seongbuk-gu,	Art], 
     			[ChoiMyungGil,	choi@naver.com,	010-2353-4444,	null,	Car], 
     			[LeeHyunKyu,	lee@naver.com,	null,	Jongro-gu,	null]]

     (Test) STARTING =========================================================================

     (Test1) ------------------------------------------
     Contact List Content: [
     			[ChoiMyungGil,	choi@naver.com,	010-2353-4444,	null,	Car], 
     			[HongGilDong,	hong@naver.com,	010-2353-8888,	null,	Software], 
     			[KimChulSoo,	kim@naver.com,	010-2353-3333,	null,	Car], 
     			[LeeHyunKyu,	lee@naver.com,	null,	Jongro-gu,	null], 
     			[Ohsangbin,	oh@naver.com,	null,	Seongbuk-gu,	Art]]

     (Test2) ------------------------------------------
     Contact object after getContact method: 
     			[Ohsangbin,	oh@naver.com,	null,	Seongbuk-gu,	Art]

     (Test3) ------------------------------------------
     Contact object after getFirstContact method: 
     			[ChoiMyungGil,	choi@naver.com,	010-2353-4444,	null,	Car]

     (Test4) ------------------------------------------
     Contact object after getLastContact method: 
     			[Ohsangbin,	oh@naver.com,	null,	Seongbuk-gu,	Art]

     (Test5) ------------------------------------------
     Contact object after getNullPhone method: [
     			[LeeHyunKyu,	lee@naver.com,	null,	Jongro-gu,	null], 
     			[Ohsangbin,	oh@naver.com,	null,	Seongbuk-gu,	Art]]

     (Test6) ------------------------------------------
     Contact object after getNullAddress method: [
     			[ChoiMyungGil,	choi@naver.com,	010-2353-4444,	null,	Car], 
     			[HongGilDong,	hong@naver.com,	010-2353-8888,	null,	Software], 
     			[KimChulSoo,	kim@naver.com,	010-2353-3333,	null,	Car]]

     (Test7) -------------------------------------------------------------------
     Contact object after updating address/phone data by setContact method: [
     			[ChoiMyungGil,	choi@naver.com,	010-2353-4444,	null,	Car], 
     			[HongGilDong,	hong@naver.com,	010-2353-8888,	null,	Software], 
     			[KimChulSoo,	kim@naver.com,	010-2353-3333,	Gangseo-gu,	Car], 
     			[LeeHyunKyu,	lee@naver.com,	010-2353-7777,	Jongro-gu,	null], 
     			[Ohsangbin,	oh@naver.com,	null,	Seongbuk-gu,	Art]]

     (Test8) ------------------------------------------
     Contact object after removeContact method: [
     			[ChoiMyungGil,	choi@naver.com,	010-2353-4444,	null,	Car], 
     			[HongGilDong,	hong@naver.com,	010-2353-8888,	null,	Software], 
     			[LeeHyunKyu,	lee@naver.com,	010-2353-7777,	Jongro-gu,	null], 
     			[Ohsangbin,	oh@naver.com,	null,	Seongbuk-gu,	Art]]


------------------------------------------------------------------------------- */
     
}