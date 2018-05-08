import java.util.*;

// Name : minwook-shin
// Student ID : 20171640

class DblList<T> {
	class DblListNode<U> {
		private U data; // storage for data
		private DblListNode<U> left; // link to the left node
		private DblListNode<U> right; // link to the right node

		// constructors come here
		DblListNode() {
			this.right = this;
			// the right field contains the DblListNode itself
		}

		DblListNode(U data) {
			// set the data field 
			this.data = data;
		}

		DblListNode(U data, DblListNode<U> right) {
			// set the data field and right field
			this.data = data;
			this.right = right;
		}
	};

	private DblListNode<T> first; // reference to the dummy head node
	private DblListNode<T> current; // current position of the hand
	private DblListNode<T> cutnode; // Node that has been cut

	DblList() {
		// DblList constructor. Create a dummy head node

		first = new DblListNode<T>();
		first.right = first.left = first;
		current = first; // current position of the hand
		cutnode = null; // Node that has been cut
	}

	/**
	 * Show all the elements in DblList
	 */
	public String toString() {
		//	cerr << "NEED TO IMPLEMENT" << endl;
		DblListNode<T> p = first.left;

		String str = new String();

		while (p != first) {
			if ((current.data != null) && (current.data.equals(p.data))) {
				str += ("[" + current.data + "] ");
			} else {
				str += (" " + p.data + "  ");
			}

			p = p.left;
		}
		if (cutnode != null) {
			str += (": " + cutnode.data);
		}
		if (p == first.left) {
			current = p;
		}
		return str;
	}

	boolean PutLeft() {
		//	cerr << "NEED TO IMPLEMENT" << endl;
		if (cutnode == null) {
			return false;
		} else {
			if (first != null) {

				// current.right = cutnode.right;
				// current.left = cutnode;
				// cutnode.left = current;
				// cutnode.right = current;
				// current = cutnode;

				cutnode.right = current.right;
				cutnode.left = current;
				cutnode.right.left = cutnode;
				cutnode.left.right = cutnode;
				current = cutnode;
				cutnode = null;

			}

			return true;
		}

	}

	boolean PutRight() {

		if (cutnode == null) {
			return false;
		} else {
			if (first != null || current.right.data != null) {

				// cutnode.right = current.right;
				// cutnode.left = current;
				// cutnode.right.left = cutnode;
				// cutnode.left.right = cutnode;
				// current = cutnode;

				cutnode.left = current.left;
				cutnode.right = current;
				cutnode.left.right = cutnode;
				cutnode.right.left = cutnode;
				current = cutnode;

				cutnode = null;

			}

			return true;
		}

		//	cerr << "NEED TO IMPLEMENT" << endl;
	}

	boolean MoveLeft() {
		//	cerr << "NEED TO IMPLEMENT" << endl;
		if (current.right == first) {
			return false;
		} else {

			current = current.right;

			return true;
		}

	}

	boolean MoveRight() {
		//	cerr << "NEED TO IMPLEMENT" << endl;
		if (current.left == first) {
			return false;
		} else {

			current = current.left;

			return true;
		}
	}

	void MoveEnd() {
		//	cerr << "NEED TO IMPLEMENT" << endl;

		DblListNode<T> p = first.left;

		if (first != null) {
			// show all the nodes
			while (p != first) {
				p = p.left;
			}
			current = p.right;
		}

	}

	boolean Cut() {
		if (current.data == null || cutnode != null) {
			return false;
		} else {
			if (first != null) {
				cutnode = current;

				current.left.right = current.right;
				current.right.left = current.left;

				

				current = current.left;

				

				int cnt = 0;
				DblListNode<T> p = first.left;
				while (p != first) {
					p = p.left;
					cnt++;
				}

				if (current == first.left) {
					current = current.right.left;
				} else if (cnt == 1) {
					current = current.left;
				}
				
				
			}
			if(current.data == null&&cutnode.data != null){
				this.MoveEnd();
			}
			
			return true;

		}

	}

	void InsertBack(final T e) {
		// insert the element into the back of the list
		//	cerr << "NEED TO IMPLEMENT" << endl;
		DblListNode<T> p = new DblListNode<T>(e);

		if (first == null) {
			first = p;
			p.right = first.right;
			p.left = first;
			p.right.left = p;
			p.left.right = p;
			current = p;
		} else {
			p.right = first.right;
			p.left = first;
			p.right.left = p;
			p.left.right = p;
			current = p;
		}

	}

	void Reverse() {
		// Reverse the list
		//	cerr << "NEED TO IMPLEMENT" << endl;
		DblListNode<T> t, tmp;
		t = first;
		do {
			tmp = t.right;
			t.right = t.left;
			t.left = tmp;
			t = tmp;
		} while (t != first);

	}

	boolean equals(DblList<T> dbl) {
		// check whether the two lists are equal
		//	cerr << "NEED TO IMPLEMENT" << endl;
		int len1 = 0, len2 = 0;
		DblListNode<T> p1 = this.first.left;

		// show all the nodes
		while (p1 != first) {
			len1++;
			p1 = p1.left;
		}

		DblListNode<T> p2 = dbl.first.left;

		// show all the nodes
		while (p2 != dbl.first) {
			len2++;
			p2 = p2.left;
		}

		if (len1 != len2) {
			return false;
		} else {

			DblListNode<T> p3 = this.first.left;
			DblListNode<T> p4 = dbl.first.left;

			while (p3 != first) {
				p3 = p3.left;
				p4 = p4.left;
				if (p3.data != null && p4.data != null && !(p3.data.equals(p4.data))) {
					return false;
				}
			}

			return true;
		}
	}

}
