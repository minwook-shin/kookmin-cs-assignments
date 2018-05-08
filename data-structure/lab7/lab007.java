import java.util.*;

import java.lang.reflect.*;

/**
 * Generic version of the MinHeap class.
 * @param <T> the type of the value being added
 */

class MinHeap<T extends Comparable> {
	private T[] heapArray;
	private int heapSize; // number of heap elements

	/**
	 * Create an empty MinHeap of size capacity
	 */
	MinHeap(Class<T> elemType, int capacity) {
		heapArray = (T[]) Array.newInstance(elemType, capacity);
		heapSize = 0;
	}

	/**
	 * Insert item into the MinHeap
	 */
	void Insert(T item) {
		int i = ++heapSize;
		while (i != 1 && heapArray[i / 2].compareTo(item) > 0) {
			heapArray[i] = heapArray[i / 2];
			i /= 2;
		}
		heapArray[i] = item;

	}

	void PostOrder(final int idx) {
		if (idx > heapSize) {
			return;
		} else {
			if (idx != 0) {
				PostOrder((idx) * 2);
				PostOrder((idx) * 2 + 1);
				System.out.print(heapArray[idx] + " ");
			}

		}

	}

	public String toString() {
		String a = new String();
		a = "Min Heap : - ";
		for (int i = 1; i <= heapSize; i++) {
			a += heapArray[i] + "  ";
		}
		return a;
	}
};
