package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentCircularQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	
	
	public Queue<Integer> fullQueue1;
	public Queue<Integer> emptyQueue1;
	
	public Queue<Integer> fullQueue5;
	public Queue<Integer> emptyQueue5;
	public Queue<Integer> queue5;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);
		
		//fila cheia com 1 elemento
		fullQueue1.enqueue(25);
		
		//fila cheia com 5 elementos
		fullQueue5.enqueue(25);
		fullQueue5.enqueue(32);
		fullQueue5.enqueue(-24);
		fullQueue5.enqueue(8);
		fullQueue5.enqueue(7);
		
		//fila com capacidade para 5 elementos, porem com apenas 3
		queue5.enqueue(13);
		queue5.enqueue(22);
		queue5.enqueue(-77);
		
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new CircularQueue<Integer>(5);
		queue2 = new CircularQueue<Integer>(2);
		queue3 = new CircularQueue<Integer>(5);
		
		//filas com capacidade para 1 elemento
		fullQueue1 = new CircularQueue<Integer>(1);
		emptyQueue1 = new CircularQueue<Integer>(1);
		
		//filas com capacidade para 5 elementos
		fullQueue5 = new CircularQueue<Integer>(5);
		emptyQueue5 = new CircularQueue<Integer>(5);
		queue5 = new CircularQueue<Integer>(5);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}
	
	
	//mais testes abaixo
	
	//filas com capacidade para 1 unico elemento
	@Test
	public void testFullQueue1Head() {
		assertTrue(25 == fullQueue1.head());
	}
	
	@Test
	public void testEmptyQueue1Head() {
		assertTrue(null == emptyQueue1.head());
	}
	
	@Test
	public void testFullQueue1IsntEmpty() {
		assertFalse(fullQueue1.isEmpty());
	}
	
	@Test
	public void testFullQueue1IsFull() {
		assertTrue(fullQueue1.isFull());
	}
	
	@Test
	public void testEmptyQueue1IsEmpty() {
		assertTrue(emptyQueue1.isEmpty());
	}
	
	@Test
	public void testEmptyQueue1IsntFull() {
		assertFalse(emptyQueue1.isFull());
	}
	
	@Test(expected = QueueOverflowException.class)
	public void testFullQueue1Enqueue() throws QueueOverflowException {
		fullQueue1.enqueue(33);
	}
	
	@Test
	public void testFullQueue1Dequeue() throws QueueUnderflowException {
		fullQueue1.dequeue();
		assertTrue(fullQueue1.isEmpty());
		assertFalse(fullQueue1.isFull());
		assertTrue(fullQueue1.head() == null);
	}
	
	@Test
	public void testEmptyQueue1Enqueue() throws QueueOverflowException {
		emptyQueue1.enqueue(27);
		assertTrue(emptyQueue1.isFull());
		assertFalse(emptyQueue1.isEmpty());
		assertTrue(27 == emptyQueue1.head());
	}
	
	@Test(expected = QueueUnderflowException.class)
	public void testEmptyQueue1Dequeue() throws QueueUnderflowException {
		emptyQueue1.dequeue();
	}
	
	@Test
	public void testEmptyQueue1EnqueueNull() throws QueueOverflowException {
		emptyQueue1.enqueue(null);
		assertTrue(emptyQueue1.isEmpty() == true);
	}
	
	@Test(expected = QueueOverflowException.class)
	public void testFullQueue1EnqueueNull() throws QueueOverflowException {
		fullQueue1.enqueue(null);
	}
	
	//filas com capacidade para mais de 1 elemento
	
	@Test
	public void testFullQueue5Head() {
		assertTrue (fullQueue5.head() == 25);
	}
	
	@Test
	public void testQueue5Head() {
		assertTrue(queue5.head() == 13);
	}
	
	@Test
	public void testEmptyQueue5Head() {
		assertTrue(emptyQueue5.head() == null);
	}
	
	@Test
	public void testFullQueue5IsntEmpty() {
		assertFalse(fullQueue5.isEmpty());
	}
	
	@Test
	public void testQueue5IsntEmpty() {
		assertFalse(queue5.isEmpty());
	}
	
	@Test
	public void testEmptyQueue5IsEmpty() {
		assertTrue(emptyQueue5.isEmpty());
	}
	
	@Test
	public void testFullQueue5IsFull() {
		assertTrue(fullQueue5.isFull());
	}
	
	@Test
	public void testQueue5IsntFull() {
		assertFalse(queue5.isFull());
	}
	
	@Test
	public void testEmptyQueue5IsntFull() {
		assertFalse(emptyQueue5.isFull());
	}
	
	@Test(expected = QueueOverflowException.class)
	public void testFullQueue5Enqueue() throws QueueOverflowException {
		fullQueue5.enqueue(22);
	}
	
	@Test
	public void testQueue5Enqueue() throws QueueOverflowException {
		queue5.enqueue(23);
		assertFalse(queue5.isEmpty());
		assertFalse(queue5.isFull());
		assertTrue(13 == queue5.head());
		queue5.enqueue(24);
		assertFalse(queue5.isEmpty());
		assertTrue(queue5.isFull());
		assertTrue(13 == queue5.head());
	}
	
	@Test
	public void testEmptyQueue5Enqueue() throws QueueOverflowException {
		emptyQueue5.enqueue(11);
	}
	
	@Test
	public void testFullQueue5Dequeue() throws QueueUnderflowException {
		fullQueue5.dequeue();
		assertFalse(fullQueue5.isFull());
		assertFalse(fullQueue5.isEmpty());
		assertTrue(fullQueue5.head() == 32);
	}
	
	@Test
	public void testQueue5Dequeue() throws QueueUnderflowException {
		queue5.dequeue();
		assertFalse(queue5.isFull());
		assertFalse(queue5.isEmpty());
		assertTrue(22 == queue5.head());
	}
	
	@Test(expected = QueueUnderflowException.class)
	public void testEmptyQueue5Dequeue() throws QueueUnderflowException {
		emptyQueue5.dequeue();
	}
	
	@Test(expected = QueueOverflowException.class)
	public void testFullQueue5EnqueueNull() throws QueueOverflowException {
		fullQueue5.enqueue(null);
	}
	
	@Test
	public void testQueue5EnqueueNull() throws QueueOverflowException {
		queue5.enqueue(null);
		assertTrue(queue5.head() == 13);
		assertFalse(queue5.isFull());
		queue5.enqueue(null);
		assertFalse(queue5.isFull());
	}
	
	@Test
	public void testEmptyQueue5EnqueueNull() throws QueueOverflowException {
		emptyQueue5.enqueue(null);
		assertTrue(emptyQueue5.isEmpty());
		assertTrue(emptyQueue5.head() == null);
	}
	
}