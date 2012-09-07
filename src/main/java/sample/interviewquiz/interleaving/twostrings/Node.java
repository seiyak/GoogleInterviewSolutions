package sample.interviewquiz.interleaving.twostrings;

public class Node {

	private String str;
	private Node[] children = new Node[2];
	private String kind;

	public Node(String str) {
		this.setStr( str );
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "str: " + str;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
}
