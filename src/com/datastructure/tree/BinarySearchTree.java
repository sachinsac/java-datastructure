package com.datastructure.tree;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BinarySearchTree {
	
	Tree rootNode;
	
	
	public void addValue(int value){
		Tree newNode = new Tree(value);
		if(this.rootNode == null)
			rootNode = newNode; // node 1 is created i.e node-> 10, null, null
		else{
			Tree tempNode = rootNode;
			Tree parentNode;
			while(true){
				parentNode = tempNode;
				if(value < parentNode.value){
					tempNode = tempNode.leftTree;
					if(tempNode == null){
						parentNode.leftTree = newNode;
						return;
					}
				}
				else{
					tempNode = tempNode.rightTree;
					if(tempNode == null){
						parentNode.rightTree = newNode;
						return;
					}
				}
			}
		}
	}
	
	public void inverseTree(){
		Tree currentNode = rootNode;
		Tree left = currentNode.leftTree;
		currentNode.leftTree = currentNode.rightTree;
		currentNode.rightTree = left;
		inverseRightTree(currentNode.rightTree);
		inverseLeftTree(currentNode.leftTree);
	}
	
	public void inverseRightTree(Tree rightTree){
		Tree currentNode = rightTree;
		if(currentNode != null){
			Tree temp = currentNode.rightTree;
			currentNode.rightTree = currentNode.leftTree;
			currentNode.leftTree = temp;
			inverseRightTree(currentNode.rightTree);
			inverseLeftTree(currentNode.leftTree);
			
		}
	}
	
	public void inverseLeftTree(Tree leftTree){
		Tree currentNode = leftTree;
		if(currentNode != null){
			Tree temp = currentNode.leftTree;
			currentNode.leftTree = currentNode.rightTree;
			currentNode.rightTree = temp;

			inverseRightTree(currentNode.rightTree);
			inverseLeftTree(currentNode.leftTree);
		}
	}
	
	public void printTree(){
		try {
			System.out.println(new ObjectMapper().writeValueAsString(rootNode));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Tree getRootTree(){
		return rootNode;
	}
	
	
	public static void main(String args[]){
		BinarySearchTree tree = new BinarySearchTree();
		tree.addValue(15); // node = 10, null, null
		tree.addValue(7); // node = 10, Node(25,null,null), null
		tree.addValue(18);//node = 10, Node(20,null,null), Node(25,null,null)
		tree.addValue(4); //node = 10, Node(5,null,null), Node(25,null,null)
		tree.addValue(10);//node = 10, Node(5,null,null), Node(15,null,null)
		tree.addValue(17);
		tree.addValue(19);
		tree.addValue(5);
		tree.addValue(3);
		tree.addValue(9);
		tree.addValue(11);
		tree.addValue(23);
		tree.addValue(18);
		DepthTraversalTree depthTraversalTree = new DepthTraversalTree();
		System.out.println("---------------Pre Order Traversal ---------");
		depthTraversalTree.preOrderTraversal(tree.getRootTree());
		System.out.println("--------------------------------------------------");
		tree.inverseTree();
		System.out.println("--------------Tree is inverted------------------------");
		System.out.println("--------------------Pre Order Traversal --------------------");
		depthTraversalTree.preOrderTraversal(tree.getRootTree());
	}
	
}