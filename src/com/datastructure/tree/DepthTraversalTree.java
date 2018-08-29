package com.datastructure.tree;

public class DepthTraversalTree {

		Tree rootTree;
		
		public void preOrderTraversal(Tree rootTree){
			this.rootTree = rootTree;
			Tree currentTree = rootTree;
			System.out.print(currentTree.value+"\t");
			traverseLeftTree(currentTree.leftTree);
			traverseRightTree(currentTree.rightTree);
			System.out.println();
		}
		
		public void inOrderTraversal(Tree rootTree){
			this.rootTree = rootTree;
			inOrderTraverseLeft(rootTree);
			System.out.print(rootTree.value+"\t");
			inOrderTraverseRight(rootTree.rightTree);
			System.out.println();
		}
		
		public void postOrderTraversal(Tree rootTree){
			this.rootTree = rootTree;
			postOrderTraverseLeft(rootTree);
			System.out.print(rootTree.value+"\t");
		}
		
		
		// Pre order traversal
		private void traverseLeftTree(Tree rootLeftTree){
			Tree current = rootLeftTree;
			System.out.print(current.value+"\t");
			if(current.leftTree != null){
				traverseLeftTree(current.leftTree);
				if(current.rightTree != null)
					traverseRightTree(current.rightTree);
			}
		}
		
		private void traverseRightTree(Tree rootRightTree){
			Tree current = rootRightTree;
			System.out.print(current.value+"\t");
			if(current.leftTree != null){
				traverseLeftTree(current.leftTree);
				if(current.rightTree != null)
					traverseRightTree(current.rightTree);
			}
		}

		
		//In Order traversal
		private void inOrderTraverseLeft(Tree rootTree){
			Tree current = rootTree;
			if(current.leftTree != null){
				current = current.leftTree;
				inOrderTraverseLeft(current);
				System.out.print(current.value+"\t");
			}
			
			if(current.rightTree != null){
				current = current.rightTree;
				inOrderTraverseRight(current);
				System.out.print(current.value+"\t");
			}
		}
		
		private void inOrderTraverseRight(Tree rootTree){
			Tree current = rootTree;
			
			if(current.leftTree != null){
				current = current.leftTree;
				inOrderTraverseRight(current);
				System.out.print(current.value+"\t");
			}
			
			if(current.rightTree != null){
				current = current.rightTree;
				inOrderTraverseLeft(current);
				System.out.print(current.value+"\t");
			}
		}
		
		//POST Order traversal
		private void postOrderTraverseLeft(Tree rootTree){
			Tree parent = rootTree;
			Tree current;
			if(parent.leftTree != null){
				current = parent.leftTree;
				postOrderTraverseLeft(current);
				System.out.print(current.value+"\t");
			}
			
			if(parent.rightTree != null){
				current = parent.rightTree;
				postOrderTraverseRight(current);
				System.out.print(current.value+"\t");
			}
		}
		
		private void postOrderTraverseRight(Tree rootTree){
			Tree parent = rootTree;
			Tree current;
			if(parent.leftTree != null){
				current = parent.leftTree;
				postOrderTraverseLeft(current);
				System.out.print(current.value+"\t");
			}
			
			if(parent.rightTree != null){
				current = parent.rightTree;
				postOrderTraverseRight(current);
				System.out.print(current.value+"\t");
			}
		}
}
