import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		

	}

	public int kthLargestValue(BST tree, int k) {
		
		var nodeList = new ArrayList<Integer>();
		traverseTree(tree, nodeList);
		
		return 0;
	}
	
	public static void traverseTree(BST tree, ArrayList<Integer> nodeList) {
		
		if(tree.right != null)
			traverseTree(tree.right, nodeList);
		
		System.out.print(tree.value + " ");
		nodeList.add(tree.value);
		
		if(tree.left != null)
			traverseTree(tree.left, nodeList);
	}
}
