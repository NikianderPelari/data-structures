/*
* Name:  Nikiander Pelari
* Info:  Implements Stack object (LIFO)
*/

import java.util.LinkedList;

public class MyStack<T> {
	
	private LinkedList<T> stack;

	public MyStack(){
		stack = new LinkedList<T>();
	}
	
	//If stack is empty return null, else remove element from stack
	public T pop(){
		return (stack.size() == 0) ? null : stack.remove();
	}

	//Displays first elements in stack
	public T peek(){
		return stack.getFirst();
	}

	//Adds element to the top of stack
	public void push(T e){
		stack.addFirst(e);
	}
    
    //Only used for TwoStackQueue 
    public boolean isEmpty(){
        return stack.isEmpty();
    }
}