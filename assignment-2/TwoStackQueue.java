/*
* Name:   Nikiander Pelari 
* Info:   Implements Queue using two Stacks
*/

public class TwoStackQueue<T> implements MyQueue<T> {
  private MyStack<T> inbox;
  private MyStack<T> outbox;
  private int size;

  public TwoStackQueue() {
    inbox = new MyStack<T>();
    outbox = new MyStack<T>();
    size = 0;
  }

  public void enqueue(T item) {
    inbox.push(item);
    size++;
  }

  public T dequeue() {
    if (outbox.isEmpty()) {
      while (!inbox.isEmpty()) {
        outbox.push(inbox.pop());
      }
    }

    size--;
    return outbox.pop();
  }

  public boolean isEmpty() {
	  return size == 0;
  }

  public int size() {
	  return size;
  }
}
