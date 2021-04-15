package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T resp = null;
		if (!isEmpty()) {
			resp = array[top];
		}
		return resp;
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public boolean isFull() {
		return array[array.length - 1] != null;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}
		
		if (!isNull(element)) {
			top++;
			array[top] = element;
		}
		
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException();
	}
		
		T elementRemove = this.top();
		this.array[top] = null;
		top--;
		return elementRemove;
	}
	
	private boolean isNull(T element) {
		return element == null;
	}

}
