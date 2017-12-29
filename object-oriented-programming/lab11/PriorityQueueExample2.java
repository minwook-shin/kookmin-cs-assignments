package lab11;

import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;

 class OrderedIteratorQueue<E> extends PriorityQueue<E> {

	 OrderedIteratorQueue(int initialCapacity, Comparator<? super E> comparator) {
		 super(initialCapacity, comparator);
	 }
	 
	 public LinkedList orderedList() {
		 
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
		 return order;
	 }
 
 }

	public class PriorityQueueExample2 {

	    public static void main(String[] args)
	    {

	        FuelPriorityByLevel strategyLevel = new FuelPriorityByLevel();
	        OrderedIteratorQueue<Vehicle2> incoming = new OrderedIteratorQueue<Vehicle2>(6, strategyLevel);

// adds 6 new vehicles into the empty queue	        
	        
	        Vehicle2 v1 = new Vehicle2("Camry", 10);
	        Vehicle2 v2 = new Vehicle2("Audi", 1);
	        Vehicle2 v3 = new Vehicle2("Ferari", 12);
	        Vehicle2 v4 = new Vehicle2("Lexus", 7);
	        Vehicle2 v5 = new Vehicle2("Sonata", 20);
	        Vehicle2 v6 = new Vehicle2("Benz", 15);

	        incoming.add(v1);
	        incoming.add(v2);
	        incoming.add(v3);
	        incoming.add(v4);
	        incoming.add(v5);
	        incoming.add(v6);

	        Iterator<Vehicle2> it = incoming.iterator();
	        
	        while(it.hasNext()) {
	        	Vehicle2 v= it.next();
	        	System.out.println(v);
	        }

// printout after removing one <Vehicle2> object
	        
	        incoming.remove(v5);
	        
	        it = incoming.iterator();
	        
	        while(it.hasNext()) {
	        	Vehicle2 v= it.next();
	        	System.out.println(v);
	        }	        
	        
	        incoming.add(v5);

// sorted printout in the order of "fuelLevel"
	        
	        LinkedList<Contact> r = incoming.orderedList();
	        System.out.println(r);
	        
// sorted printout in the order of "name"
	        
	        FuelPriorityByName strategyName = new FuelPriorityByName();
	        Collections.sort(r, strategyName);
	        System.out.println(r);
	        
// sorted printout by repeated calling of poll() method
	        
	        while (!incoming.isEmpty()) {
	            System.out.println(incoming.poll());
	        }

	        it = incoming.iterator();
	        
	        while(it.hasNext()) {
	        	Vehicle2 v= it.next();
	        	System.out.println(v);
	        }	        
	        
	}
	}

	class FuelPriorityByLevel
	    implements Comparator<Object>
	{

	    public int compare(Object o1, Object o2)
	    {

	        Vehicle2 a1 = (Vehicle2)o1;
	        Vehicle2 a2 = (Vehicle2)o2;

	        return Integer.compare(a1.getFuelLevel(), a2.getFuelLevel());
	    }
	}

	class FuelPriorityByName
    implements Comparator<Object>
{

    public int compare(Object o1, Object o2)
    {

        Vehicle2 a1 = (Vehicle2)o1;
        Vehicle2 a2 = (Vehicle2)o2;

        return a1.getName().compareTo(a2.getName());
    }
}

	class Vehicle2
	{

	    private String name;
	    private int fuelLevel;

	    public Vehicle2(String name, int fuelLevel)
	    {
	        this.name = name;
	        this.fuelLevel = fuelLevel;
	    }

	    public String getName()
	    {
	        return name;
	    }

	    public int getFuelLevel()
	    {
	        return fuelLevel;
	    }

	    @Override
	    public String toString()
	    {
	        return name + "=" + fuelLevel;
	    }
	}
