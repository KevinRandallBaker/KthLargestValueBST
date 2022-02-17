import java.util.ArrayList;
import java.util.List;

public class BST {
	
	public int value;
	public BST left = null;
	public BST right = null;
	
	public BST(int value) {
		
		this.value = value;
	}
	
	public BST insert(int value) {
		
		if (value < this.value) {
			if(left == null) {
				left = new BST(value);
				return this;
			}else {
				left.insert(value);
			}
		}else if(value >= this.value) {
			if(right == null) {
				right = new BST(value);
				return this;
			}else {
				right.insert(value);
			}
		}
		
		return this;
	}
	
	public boolean contains(int value) {
		
		if(value < this.value) {
			if(left == null)
				return false;
			else {
				return left.contains(value);
			}
		}else if(value > this.value) {
			if(right == null) 
				return false;
			else {
				return right.contains(value);
			}
		}else {
			System.out.println(value + " found.");
			return true;
		}
	}
	
	public BST remove(int value) {
		
		remove(value, null);
		
		return this;
	}
	
	public void remove(int value, BST parent) {
		
		if(value < this.value) {
			if(left != null)
				left.remove(value, this);
		}else if(value > this.value) {
			if(right != null)
				right.remove(value, this);
		}else {
			if(left != null && right != null) {
				this.value = right.getMinValue();
				right.remove(this.value, this);
			}else if(parent == null) {
				if(left != null) {
					this.value = left.value;
					right = left.right;
					left = left.left;
				}else if(right != null) {
					this.value = right.value;
					left = right.left;
					right = right.right;
				}else {
					// Do nothing in a single node tree.
				}
			}else if(parent.left == this)
				parent.left = left != null ? left : right;
			else if(parent.right == this)
				parent.right = left != null ? left : right;
		}
	}
	
	public int getMinValue() {
		
		if(left == null)
			return this.value;
		else
			return left.getMinValue();
	}
	
	@Override
	public String toString() {
		
		String output = "";
		List<Integer> array = new ArrayList<Integer>();
		array = preOrderTraverse(this, array);
		
		int root = this.value;
		output += "root: " + root + "\n";
		
		output += array + "\n";
		
		output += "left values: ";
		int current = root;
		int i = 1;
		while (current <= root) {
			output += current + " ";
			current = array.get(i++);
		}
		output += "\n";
		
		output += "right values: ";
		while(i < array.size()) {
			output += current + " ";
			current = array.get(i++);
		}
		
		output += "\n~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-";
		
		return output;
	}
	
	public static List<Integer> preOrderTraverse(BST tree, List<Integer> array){
		
		array.add(tree.value);
		
		if(tree.left != null)
			preOrderTraverse(tree.left, array);
		
		if(tree.right != null)
			preOrderTraverse(tree.right, array);
		
		return array;
	}
	
	
}
