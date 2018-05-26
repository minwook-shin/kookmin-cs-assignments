import java.util.*;

// Name : 
// Student ID :
@SuppressWarnings("unchecked")
class BST<T extends KeyValue> {

	class TreeNode<U extends KeyValue> {
		U data; // storage for data : in HW 3, T will be Item
		TreeNode<U> leftChild; // link to the left Child
		TreeNode<U> rightChild; // link to the right Child

		// constructors come here
		TreeNode() {
			leftChild = rightChild = null;
		}

		TreeNode(U d) {
			// data is given
			data = d;
			// the leftChild and rightChild field are null
			leftChild = rightChild = null;
		}
	};

	TreeNode<T> root;// the reference to the root node

	BST() {
		// BST constructor.
		root = null;
	}

	void Show() {

		System.out.print("Pre  Order : ");
		PreOrder(root);
		System.out.println("");
		System.out.print("In   Order : ");
		InOrder(root);
		System.out.println("");
		System.out.print("Post Order : ");
		PostOrder(root);
		System.out.println("");
		System.out.print("Count      : ");
		System.out.print(Count(root));
		System.out.println("");
		System.out.print("Height      : ");
		System.out.println(Height(root));
		System.out.println("");
	}

	// IMPLEMENT THE FOLLOWING FUNCTIONS

	boolean Insert(T item) {
		// first search the key

		TreeNode<T> ptr, parent;
		ptr = root;

		if (ptr == null) {
			TreeNode<T> tmp = new TreeNode<T>(item);
			root = tmp;
			return true;
		}
		parent = null;
		while (true) {
			parent = ptr;
			if (item.GetKey() == ptr.data.GetKey()) {
				ptr.data = item;
				return false;
			}
			if (item.GetKey() < ptr.data.GetKey()) {
				ptr = ptr.leftChild;
				if (ptr == null) {
					TreeNode<T> tmp2 = new TreeNode<T>(item);
					parent.leftChild = tmp2;
					return true;
				}
			} else {
				ptr = ptr.rightChild;
				if (ptr == null) {
					TreeNode<T> tmp3 = new TreeNode<T>(item);
					parent.rightChild = tmp3;
					return true;
				}
			}
		}

	}

	T Get(T item) {
		// use the key field of item and find the node
		// do not use val field of item
		TreeNode<T> ptr;
		ptr = root;

		while (ptr != null) {
			if (item.GetKey() < ptr.data.GetKey()) {
				ptr = ptr.leftChild;
			} else if (item.GetKey() > ptr.data.GetKey()) {
				ptr = ptr.rightChild;
			} else {
				return ptr.data;
			}
		}
		return null;
	}

	boolean Delete(T item) {
		if (root == null) {
			return false; // non existing key
		}
		TreeNode<T> parent = root;
		TreeNode<T> curr = root;
		boolean isLeft = false;
		while (curr.data.GetKey() != item.GetKey()) {
			parent = curr;
			if (curr.data.GetKey() > item.GetKey()) {
				isLeft = true;
				curr = curr.leftChild;
			} else {
				isLeft = false;
				curr = curr.rightChild;
			}
			if (curr == null) {
				return false;
			}
		}
		if (curr.leftChild == null && curr.rightChild == null) {
			if (curr == root) {
				root = null;
			}
			if (isLeft == true) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		}

		else if (curr.rightChild == null) {
			if (curr == root) {
				root = curr.leftChild;
			} else if (isLeft == true) {
				parent.leftChild = curr.leftChild;
			} else {
				parent.rightChild = curr.leftChild;
			}
		} else if (curr.leftChild == null) {
			if (curr == root) {
				root = curr.rightChild;
			} else if (isLeft == true) {
				parent.leftChild = curr.rightChild;
			} else {
				parent.rightChild = curr.rightChild;
			}
		}

		else if (curr.leftChild != null && curr.rightChild != null) {
			TreeNode<T> tmp = null;
			TreeNode<T> parent2 = null;
			TreeNode<T> curr2 = curr.rightChild;
			while (curr2 != null) {
				parent2 = tmp;
				tmp = curr2;
				curr2 = curr2.leftChild;
			}
			if (tmp != curr.rightChild) {
				parent2.leftChild = tmp.rightChild;
				tmp.rightChild = curr.rightChild;
			}
			TreeNode<T> s = tmp;
			if (curr == root) {
				root = s;
			} else if (isLeft == true) {
				parent.leftChild = s;
			} else {
				parent.rightChild = s;
			}
			s.leftChild = curr.leftChild;
		}
		return true;
	}

	void PreOrder(TreeNode<T> t) {
		if (t != null) {
			System.out.print(t.data.GetKey() + "(" + t.data.GetValue() + ") ");
			PreOrder(t.leftChild);
			PreOrder(t.rightChild);
		}

	}

	void InOrder(TreeNode<T> t) {
		if (t != null) {
			InOrder(t.leftChild);
			System.out.print(t.data.GetKey() + "(" + t.data.GetValue() + ") ");
			InOrder(t.rightChild);
		}

	}

	void PostOrder(TreeNode<T> t) {
		if (t != null) {
			PostOrder(t.leftChild);
			PostOrder(t.rightChild);
			System.out.print(t.data.GetKey() + "(" + t.data.GetValue() + ") ");
		}
	}

	int Count(TreeNode<T> t) {
		int tmp;

		if (t == null) {
			tmp = 0;
		} else {
			tmp = Count(t.leftChild) + Count(t.rightChild) + 1;
		}
		return tmp;
	}

	int Height(TreeNode<T> t) {
		int tmp = 0;
		int tmpl = 0;
		int tmpr = 0;

		if (t == null) {
			tmp = 0;
		} else {
			tmpl = Height(t.leftChild);
			tmpr = Height(t.rightChild);
			if (tmpl >= tmpr) {
				tmp = tmpl + 1;
			} else {
				tmp = tmpr + 1;
			}
		}

		return tmp;
	}
}
