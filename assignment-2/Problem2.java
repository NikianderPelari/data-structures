/*
*   Name:  Nikiander Pelari
*   Info:  Test main method to check operation of TwoStackQueue object.
*/ 

public class Program2
{
	public static void main(String[] args)
	{
		
		TwoStackQueue<Integer> test = new TwoStackQueue<>();

		test.enqueue(1); //Inbox = [1]				outbox = []
		test.enqueue(2); //Inbox = [2, 1]			outbox = []
		test.enqueue(3); //Inbox = [3, 2, 1]		outbox = []
		test.enqueue(4); //Inbox = [4, 3, 2, 1]	outbox = []

		System.out.println(test.dequeue()); //Inbox = []	outbox = [2, 3, 4]
		System.out.println(test.dequeue()); //Inbox = []	outbox = [3, 4]

		test.enqueue(5); //Inbox = [5]		outbox = [3, 4]
		test.enqueue(6); //Inbox = [6, 5]	outbox = [3, 4]

		System.out.println(test.dequeue()); //Inbox = [6, 5]	outbox = [4]
		System.out.println(test.dequeue()); //Inbox = [6, 5]	outbox = []
		System.out.println(test.dequeue()); //Inbox = []		outbox = [6]
		System.out.println(test.dequeue()); //Inbox = []		outbox = []
		System.out.println(test.dequeue()); //Null
		System.out.println(test.dequeue()); //Null

	}
}