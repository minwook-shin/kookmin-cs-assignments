
// HW 184, QuickSort
// Name :
// Student ID :

import java.util.*;

class QuickSort {
	int[] arr; // array
	int arrSize; // number of elements in arr

	QuickSort() {
		arr = new int[1024];
		arrSize = 0;
	}

	void Show(int s, int e) {
		// Show all the element in the arr
		if (s > e)
			return;
		String str = new String();
		str = "arr : ";

		// print all the nodes in the arr
		for (int i = 0; i < arrSize; i++) {
			if (i == s)
				str += "[";
			else
				str += " ";
			str += arr[i];
			if (i == e)
				str += "]";
			else
				str += " ";
		}
		System.out.println(str);
	}

	void Init(int[] es, int n) {
		// fill the arr array by the input
		arrSize = n;
		for (int i = 0; i < n; i++)
			arr[i] = es[i];
	}

	void Sort() {
		// sort arr[0:arrSize-1] into nonincreasing order
		// This is an invoking method to the Partition() and QSort()
		QSort(0, arrSize - 1); // quick sort from 0 to n-1
	}

	void QSort(int s, int e) {
		// sort arr[s:e] into nonincreasing order
		System.out.println("Sort in [" + s + "," + e + "]");
		Show(s, e);
		if (s >= e) {
			return;
		}
		int p = 0;
		if ((arr[s] <= arr[(s + e) / 2] && arr[s] >= arr[e]) || (arr[s] <= arr[e] && arr[s] >= arr[(s + e) / 2])) {
			p = s;
		}
		if ((arr[e] <= arr[(s + e) / 2] && arr[e] >= arr[s]) || (arr[e] <= arr[s] && arr[e] >= arr[(s + e) / 2])) {
			p = e;
		}
		if ((arr[(s + e) / 2] <= arr[s] && arr[(s + e) / 2] >= arr[e])
				|| (arr[(s + e) / 2] <= arr[e] && arr[(s + e) / 2] >= arr[s])) {
			p = (s + e) / 2;
		}

		int temp = arr[s];
		arr[s] = arr[p];
		arr[p] = temp;

		if (s < e) {
			int i = s;
			int j = e + 1;
			int pivot = arr[s];

			while (i < j) {
				i++;
				while (arr[i] > pivot) {
					i++;
				}

				j--;
				while (arr[j] < pivot) {
					j--;
				}
				if (i < j) {
					int temp2 = arr[i];
					arr[i] = arr[j];
					arr[j] = temp2;
				}
			}

			int temp3 = arr[s];
			arr[s] = arr[j];
			arr[j] = temp3;

			QSort(s, j - 1);
			QSort(j + 1, e);
		}

		// "NEED TO IMPLEMENT"

	}

}
