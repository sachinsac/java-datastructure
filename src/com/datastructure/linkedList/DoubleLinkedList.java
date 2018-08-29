package com.datastructure.linkedList;

public class DoubleLinkedList {

		class Node{
			int nodeValue;
			Node nextNode;
			Node prevNode;
			
			Node(){}
			
			Node(int value){
				this.nodeValue = value;
			}
		}
		
		Node rootNode;
		Node lastNode;
		
		public void add(int nodeValue){
			if(rootNode == null){
				rootNode = new Node(nodeValue);
				lastNode = rootNode;
			}else{
				Node tempNode = rootNode;
				Node prevNode = null;
				if(tempNode.nextNode != null){
					prevNode = tempNode;
					tempNode = tempNode.nextNode;
					tempNode.prevNode = prevNode;
				}
				prevNode = tempNode;
				Node newNode = new Node(nodeValue);
				newNode.prevNode = prevNode;
				tempNode.nextNode = newNode;
				lastNode = tempNode.nextNode;
			}
		}
		
		public void displayNextNode(){
			Node tempNode = rootNode;
			while(tempNode != null){
				System.out.print(tempNode.nodeValue);
				tempNode = tempNode.nextNode;
				if(tempNode != null)
					System.out.print(" --> ");
			}
			System.out.println();
		}
		
		public void displayPreviousNode(){
			Node tempNode = lastNode;
			while(tempNode != null){
				System.out.print(tempNode.nodeValue);
				tempNode = tempNode.prevNode;
				if(tempNode != null)
					System.out.print(" --> ");
			}
			System.out.println();
		}
		
		public static void main(String args[]){
			DoubleLinkedList linkedList = new DoubleLinkedList();
			
			linkedList.add(1);
			linkedList.add(2);
			linkedList.add(3);
			
			linkedList.displayNextNode();
			linkedList.displayPreviousNode();
		}
}
