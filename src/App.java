import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		int root = 10;
		BST myBST = new BST(root);
		
		myBST.insert(5);
		myBST.insert(15);
		myBST.insert(2);
		myBST.insert(5);
		myBST.insert(13);
		myBST.insert(22);
		myBST.insert(1);
		myBST.insert(14);
		myBST.insert(12);
		
		System.out.println("myBST: " + myBST);
		
		int k = 1;
		System.out.print("kthLargestValue for k = " + k + ": ");
		System.out.println(kthLargestValue(myBST, k));
		

	}

	public static int kthLargestValue(BST tree, int k) {
		
		var nodeList = new ArrayList<Integer>();
		traverseTree(tree, nodeList);
		//System.out.println(nodeList.get(k - 1));
		
		return nodeList.get(k - 1);
	}
	
	public static void traverseTree(BST tree, ArrayList<Integer> nodeList) {
		
		if(tree.right != null)
			traverseTree(tree.right, nodeList);
		
		//System.out.print(tree.value + " ");
		nodeList.add(tree.value);
		
		if(tree.left != null)
			traverseTree(tree.left, nodeList);
	}
}
