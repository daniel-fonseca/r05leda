package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		
		if (!isNull(element)) {
			if (isEmpty()) {
				head++;
			}
			tail++;
			elements++;
			array[tail] = element;
			}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T element = array[head];
		if (hasOnlyOne()) {
			head = -1;
			tail = -1;
		} else {
			head = ((head + 1) % array.length);
		}
		
		elements--;
		return element;
	}

	@Override
	public T head() {
		T element = null;
		if (!isEmpty()) {
			element = array[head];
		}
		return element;
	}

	@Override
	public boolean isEmpty() {
		return elements == 0;
	}

	@Override
	public boolean isFull() {
		return elements == array.length;
	}
	
	private boolean hasOnlyOne() {
		return elements == 1;
	}
	
	private boolean isNull(T element) {
		return element == null;
	}
	
}
