
public class PriorityQueue {

	private PriorityCustomer[] heap;
	private int size;

	public PriorityQueue() {
		heap = new PriorityCustomer[100];
		size = 0;
	}

	public boolean isEmpty() {
		return heap[1] == null;

	}

	public PriorityCustomer getFirst() {

		PriorityCustomer serviceT = heap[1];

		return serviceT;
	}

	public void add(PriorityCustomer v) {
		int index = size + 1; // index where we'll add the new value
		heap[index] = v; // add value at that position

		while (index > 3) { // while our value has parents
			int parentIndex = index / 2; // get parent index by dividing by 2
			if (heap[parentIndex].getPriority() < v.getPriority()) { // if
																		// parent's
																		// value
																		// is
																		// lower

				PriorityCustomer tempPlace = heap[parentIndex];

				heap[parentIndex] = v;
				heap[index] = tempPlace; // perform swap
				index = parentIndex; // update index after swap
			} else { // no swap needed
				break;
			}
		}

		size++; // increase size

	}

	public PriorityCustomer remove() {
		PriorityCustomer rootValue = heap[1]; // store root value to return at
												// the end
		PriorityCustomer v = heap[size]; // store last value in heap in v
		heap[1] = v; // take v and move to root
		heap[size] = null; // delete node at last position (b/c we moved it to
							// the root)

		int index = 1;

		while (index * 2 < size) { // is there at least one child at index
			int leftIndex = index * 2;
			int rightIndex = leftIndex + 1;

			int leftValue = heap[leftIndex].getPriority();
			int rightValue = Integer.MIN_VALUE;

			if (rightIndex < size) { // there is a right child
				rightValue = heap[rightIndex].getPriority();
			}

			int maxChild, maxIndex; // find index of and value of larger child
			if (leftValue >= rightValue) { // put in '=' so you get FIFO (swap
											// with left child if values are the
											// same
				maxChild = leftValue;
				maxIndex = leftIndex;
			} else {
				maxChild = rightValue;
				maxIndex = rightIndex;
			}

			if (v.getPriority() < maxChild) { // value is less than the larger
												// child -> swap
				heap[index] = heap[maxIndex]; // perform swap with larger of two
												// children
				heap[maxIndex] = v;
				index = maxIndex;
			} else {
				break; // value is in a valid position -> stop
			}
		}

		size--; // update size

		return rootValue; // return old root
	}
}
