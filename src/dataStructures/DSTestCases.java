package dataStructures;

public class DSTestCases {
	
	public static void stackTest() {
		MyStack stack = new MyStack(2);
		stack.pop();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		stack.push("d");
		stack.push("d");
		
		stack.print();
		
		for(int i=0; i <2; i++)
			stack.pop();
		
		stack.print();
	}
	
	public static void queueTest() {
		MyQueue queue = new MyQueue(5);
		queue.pop();
		queue.push("a");
		queue.push("b");
		queue.push("c");
		queue.push("d");
		queue.push("e");
		queue.push("f");
		
		
		queue.print();
		
		for(int i=0; i <2; i++)
			queue.pop();
		
		queue.print();
	}
	
	public static void cqueueTest() {
		CircularQueue cqueue = new CircularQueue(5);
		cqueue.pop();
		cqueue.push("a");
		cqueue.push("b");
		cqueue.push("c");
		cqueue.push("d");
		cqueue.push("e");
		cqueue.push("f");
		
		
		cqueue.print();
		
		for(int i=0; i <2; i++)
			cqueue.pop();
		
		cqueue.push("e");
		cqueue.push("f");
		cqueue.print();
	}
	
	public static void simpleList() {
		
		List list = new List(6);
		list.insert("a");
		list.insert("b");
		list.insert("c");
		list.insert("d");
		list.insert("e");
		
		list.print();
		
		list.remove(2);
		list.remove(1);
		
		list.print();
		
	}
	
	public static void linkedList() {
		
		MyLinkedList head = new MyLinkedList();
		
		head.insertAfterNth(0,3);
		head.insertAfterNth(1,5);
		head.insertAfterNth(2,4);
		head.insertAfterNth(3,2);
		head.insertAfterNth(1,10);
		head.findSize();
		head.print();
		head.reverseUsingIterative();
		head.print();
	}
	
	public static void circularLinkedList() {
		
		CircularLinkedList clinklist = new CircularLinkedList();
		
		clinklist.insertNode(5);
		clinklist.insertNode("s");
		clinklist.insertNode(6);
	}
	
	public static void dlinklinst() {
		
		DLList ddlist = new DLList();
		
		ddlist.insertNode(5);
		ddlist.insertNode("a");
		ddlist.insertNode(6);
		ddlist.insertNode("b");
		ddlist.insertNodeAtFirst("7");
		ddlist.printList();
		ddlist.deleteNodeAt(1);
		ddlist.printList();
		
	}
	
	public static void cdlinklist() {
		
		CDLList cdllist = new CDLList();
		
		cdllist.addNode(5);
		cdllist.addNodeAtFirst("b");
		cdllist.addNode(6);
		cdllist.addNode("a");
		cdllist.addNode(7);	
		cdllist.print();
		cdllist.deleteNodeAt(5);
		cdllist.print();
		
	}
	
	public static void llstack() {
		
		LLStack llstack = new LLStack();
		
		llstack.push(5);
		llstack.push(6);
		llstack.push("s");
		llstack.print();
		Object x = llstack.pop();
		System.out.print("\n"+x);
		llstack.print();
		
		
	}
	
	public static void llqueue() {
		
		LLQueue llqueue = new LLQueue();
		
		llqueue.push(5);
		llqueue.push(6);
		llqueue.push(9);
		llqueue.push("a");
		llqueue.push("9");
		llqueue.print();
		Object x = llqueue.pop();
		System.out.print("\n" + x);
		llqueue.print();
		llqueue.headElement();
		llqueue.pop();
		llqueue.pop();
		
		llqueue.push("b");
		llqueue.push("c");
		llqueue.headElement();
		llqueue.tailElement();
		llqueue.print();
	}
	
	public static void hashmap() {
		
		Map<String, Integer> map = new Map<>();
		
		map.add("This", 1);
		map.add("hello",2);
		map.add("world", 3);
		map.add("Sucks", 4);
		System.out.println(map.size());
		System.out.println(map.remove("This"));
		System.out.println(map.remove("this"));
		System.out.println(map.size());
		System.out.println(map.isEmpty());
		
	}
	
	public static void binaryNode() {
		
		BinaryTree btree = new BinaryTree();
		
		BinaryNode root = null;
		
		root = btree.insertBNode(root,5);
		root = btree.insertBNode(root,8);
		root = btree.insertBNode(root,3);
		root = btree.insertBNode(root,12);
		root = btree.insertBNode(root,7);
		root = btree.insertBNode(root,6);
		root = btree.insertBNode(root,9);
		root = btree.insertBNode(root,2);
		root = btree.insertBNode(root,4);
		
		btree.inOrderTraversal(root);
		System.out.print("\n");
		btree.preOrderTraversal(root);
		System.out.print("\n");
		btree.postOrderTraversal(root);
		System.out.print("\n");
		btree.levelOrderTraversal(root);
		
		System.out.print("\n");
		System.out.print(btree.searchNode(root, 13));
		
		System.out.print("\n");
		System.out.print("Max data is " + btree.maxNode(root));
		System.out.print("\n");
		System.out.print("Min data is " + btree.minNode(root));
		System.out.println("\n" + btree.depthOftree(root));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//stackTest();
		
		//queueTest();
		
		//cqueueTest();
		
		//simpleList();
		
		//linkedList();
		
		//circularLinkedList();
		
		//dlinklinst();
		
		//cdlinklist();
		
		//llstack();
		
		//llqueue();
		
		//hashmap();
		
		binaryNode();
		
	}
}