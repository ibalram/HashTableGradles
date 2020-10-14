package DSHashTable;


public class Node<T> implements INode<T> {
	private T key;
	private INode next;

	public void setKey(T key) {
		this.key = key;
	}

	public void setNext(INode next) {
		this.next = (Node<T>) next;
	}

	public T getKey() {
		return key;
	}

	public INode getNext() {
		return next;
	}

	public Node() {
		this.key = null;
		this.next = null;
	}

	public Node(T key) {
		this.key = key;
		this.next = null;
	}
}
