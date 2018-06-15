
// Lab 012	: Natural Merge
// Name :
// Student ID :

import java.util.*;

class NaturalMerge {
	int noe; // the number of elements
	private int[] inputArray; // input array
	int[] outputArray; // output array

	NaturalMerge() {
		// Graph constructor.
		noe = 0;
	}

	public String toString() {
		String str = new String();
		str = "Input : ";
		for (int i = 0; i < noe; i++) {
			str += inputArray[i] + " ";
		}
		str += "\nOutput : ";
		for (int i = 0; i < noe; i++) {
			str += outputArray[i] + " ";
		}
		return str;
	}

	void Init(int[] arr, int n) {
		noe = n;
		inputArray = new int[noe];
		System.arraycopy(arr, 0, inputArray, 0, n);

		outputArray = new int[noe];
	}

	void Merge() {
		int n = noe;
		int m = 0;
		// NEED TO IMPLEMENT
		for (m = 0; m < n; m++) {
			if (inputArray[m] > inputArray[m + 1]) {
				m++;
				break;
			}
		}

		// for (int i = 0; i < m; i++) {
		// System.out.print(inputArray[i] + " ");
		// }
		// System.out.println();

		// for (int i = m; i < n; i++) {
		// System.out.print(inputArray[i] + " ");
		// }
		// System.out.println();

		String str = new String();
		int left = m;
		int right = n;

		int aPos = 0;
		int bPos = m;
		int outPos = 0;
		while (aPos < left && bPos < right) {
			if (inputArray[aPos] == inputArray[bPos]) {
				outputArray[outPos++] = inputArray[aPos++];
				str += "L ";
				while (inputArray[aPos] == inputArray[bPos]) {
					if (inputArray[aPos] == inputArray[bPos]) {
						outputArray[outPos++] = inputArray[aPos++];
						str += "L ";
					} else {
						outputArray[outPos++] = inputArray[bPos++];
						str += "R ";
					}
				}

			} else if (inputArray[aPos] < inputArray[bPos]) {
				outputArray[outPos++] = inputArray[aPos++];
				str += "L ";
			} else if (inputArray[aPos] > inputArray[bPos]) {
				outputArray[outPos++] = inputArray[bPos++];
				str += "R ";
			}
		}
		for (; aPos < left; aPos++) {
			outputArray[outPos++] = inputArray[aPos];
		}
		for (; bPos < right; bPos++) {
			outputArray[outPos++] = inputArray[bPos];
		}

		System.out.println("n = " + n + ", m = " + m);
		System.out.println(str);
	}
}
