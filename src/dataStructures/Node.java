package dataStructures;

public class Node {
	
	Object data;
	Node node;
	
	public Node(Object x) {
		this.data = x;
	}

	public Node() {	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}

}
