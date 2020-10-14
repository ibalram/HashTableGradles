package DSHashTable;


public class LinkedList<K> {
	private INode<K> head;
	private INode<K> tail;

	private int count = 0;

	public LinkedList() {
		this.head = null;
		this.tail = null;
	}

	public INode find(K key) {
		INode root = head;
		while (root != null) {
			if (root.getKey().equals(key)) {
				return root;
			}
			root = root.getNext();
		}
		return null;
	}

	public void append(INode node) {
		if (head == null) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.setNext(node);
			this.tail = tail.getNext();
		}
		count++;
	}

	public void add(INode node) {
		if (head == null) {
			this.head = node;
			this.tail = node;
		} else {
			node.setNext(head);
			this.head = node;
		}
		count++;
	}

	public void addAtMiddle(INode node) {
		if (head == null) {
			System.out.println("There's no node so adding it.");
			head = node;
			tail = node;
			return;
		}
		INode slow = head;
		INode fast = head;
		while (fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		node.setNext(slow.getNext());
		slow.setNext(node);
	}

	public void insert(int pos, INode node) {
		if (head == null) {
			System.out.println("There's no node so adding it.");
			head = node;
			tail = node;
			return;
		}
		int idx = 1;
		INode root = head;
		INode prev = null;
		while (root != null && idx != pos) {
			prev = root;
			root = root.getNext();
			idx++;
		}
		if (prev != null) {
			node.setNext(prev.getNext());
			prev.setNext(node);
		} else {
			node.setNext(head);
			head = node;
		}
		count++;
	}

	public INode pop() {
		if (head == null) {
			System.out.println("There's no node in the LisnkedList");
			return null;
		}
		INode ret = head;
		head = head.getNext();
		ret.setNext(null);
		return ret;
	}

	public INode popLast() {
		if (head == null) {
			System.out.println("There's no node in the LisnkedList");
			return null;
		}
		INode prev = null;
		INode root = head;
		while (root != null && root.getNext() != null) {
			prev = root;
			root = root.getNext();
		}
		INode ret = prev.getNext();
		prev.setNext(null);
		ret.setNext(null);
		return ret;
	}

	public void printLinkedList() {
		if (head == null) {
			System.out.println("Linked List is empty");
			return;
		}
		StringBuilder str = new StringBuilder();
		INode root = head;
		str.append(root.getKey());
		root = root.getNext();
		while (root != null) {
			str.append("->" + root.getKey());
			root = root.getNext();
		}
		System.out.println(str.toString());
	}
	
	public String toString() {
		return "MyLinkedListNodes{"+head+"}";
	}

	public INode getHead() {
		return head;
	}

	public INode getTail() {
		return tail;
	}
}
