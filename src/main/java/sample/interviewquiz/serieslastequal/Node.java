package sample.interviewquiz.serieslastequal;

public class Node {

	private int value;
	private int currentResult;
	public static final int MAX_CHILDREN = 4;
	private Node[] children = new Node[MAX_CHILDREN];
	private String equation = "";

	public Node() {

	}

	public Node(int value) {
		this.value = value;
	}

	public Node(int value, int currentResult) {
		this.value = value;
		this.currentResult = currentResult;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCurrentResult() {
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public Node[] getChildren() {
		return children;
	}

	@Override
	public String toString() {
		return "value: " + value + " currentResult: " + currentResult;
	}

	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}
}
