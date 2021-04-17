package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		if (!isNull(element)) {
			try {
				stack1.push(element);
			} catch (StackOverflowException e) {}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T resp = null;
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		Stack<T> unstacked1 = desempilha(stack1, stack2);
		try {
			resp = unstacked1.pop();
		} catch (StackUnderflowException e) {}
		stack1 = desempilha(unstacked1, stack2);
		return resp;
	}

	@Override
	public T head() {
		Stack<T> unstacked1 = desempilha(stack1, stack2);
		T resp = unstacked1.top();
		stack1 = desempilha(unstacked1, stack1);
		return resp;
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull();
	}
	
	private Stack<T> desempilha(Stack<T> stack, Stack<T> emptyStack) {
		//s1 deve ser uma pilha que nao deve estar vazia
		//s2 deve ser sempre uma pilha vazia
		Stack<T> stackReturn = emptyStack;
		Stack<T> stackAux = stack;
		if (emptyStack.isEmpty()) {
			while (!stackAux.isEmpty()) {
				try {
					stackReturn.push(stackAux.pop());
				} catch (StackOverflowException | StackUnderflowException e) {}
			}
		}
		return stackReturn;
	}
	
	private boolean isNull(T element) {
		return element == null;
	}

}
