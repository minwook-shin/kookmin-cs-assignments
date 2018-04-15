import java.util.*;
// Name : minwook-shin

class Chain<T> {
	class ChainNode<U> {
		private U data; // storage for data
		private ChainNode<U> link; // link to the next node

		// constructors come here
		ChainNode() {
			this.link = null;
			// the link field is null 
		}

		ChainNode(U data) {
			// set the data field only 
			this.data = data;
		}

		ChainNode(U data, ChainNode<U> link) {
			// set the data field and link field
			this.data = data;
			this.link = link;
		}
	};

	private ChainNode<T> first; // reference to the fist node

	Chain() {
		first = null;
	}

	boolean IsEmpty() {
		return first == null;
	}

	/**
	 * Show all the elements in the Chain in sequence
	 */
	public String toString() {
		ChainNode<T> p = first;

		String str = new String();
		str = String.format("List (%d) : ", Size());

		// show all the nodes
		while (p != null) {
			str += p.data + " ";
			p = p.link;
		}
		return str;
	}

	/**
	 * insert theElement in theIndex
	 */

	boolean Insert(int theIndex, T theElement) {
		ChainNode<T> p = first;
		if (theIndex < 0) {
			return false;
		}
		if (theIndex == 0){
			first = new ChainNode<T>(theElement, first);
			System.err.println("ins"+ " " + theIndex + " " + theElement);
		}
		else {
			for (int i = 0; i < theIndex - 1; i++) {
				if (p == null) {
					return false;
				}
				p = p.link;
			}
			if (p == null) {
				return false;
			}
			System.err.println("ins"+ " " + theIndex + " " + theElement);
			p.link = new ChainNode<T>(theElement, p.link);
		}
		return true;

	}

	/**
	 * delete an element from the first 
	 */
	T DeleteFront() {
		
		if (first == null) {
			return null;
		} else {
			T temp = first.data;
			first = first.link;
			System.err.println("delf");
			return temp;
		}
		
	}

	/**
	 * return the number of elements in Chain
	 */
	final int Size() {
		ChainNode<T> p = first;
		int cnt = 0;

		while (p != null) {
			p = p.link;
			cnt++;
		}

		return cnt;
	}

}
