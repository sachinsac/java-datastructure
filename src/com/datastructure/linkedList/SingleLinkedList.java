package com.datastructure.linkedList;

public class SingleLinkedList {
	
	class Node{
		int nodeValue;
		Node nextNode;
	}
	
	Node rootNode;
	
	public SingleLinkedList() {
	}
	
	public void add(int value){
		if(rootNode == null){
			rootNode = new Node();
			rootNode.nodeValue = value;
		}else{
			Node tempRoot = rootNode;
			while(tempRoot.nextNode != null){
				tempRoot = tempRoot.nextNode;
			}
			Node nextNode = new Node();
			nextNode.nodeValue = value;
			tempRoot.nextNode = nextNode;
		}
	}
	
	public void insertAt(int index,int value){
		int startIndex = 0;
		index = index-1;
		boolean found = false;
		if(index == startIndex){
			Node tempNode = new Node();
			tempNode.nodeValue = value;
			tempNode.nextNode = rootNode;
			rootNode = tempNode;
		}else{
			Node tempNode = rootNode;
			while(tempNode.nextNode != null){
				startIndex++;
				tempNode = tempNode.nextNode;
				if(startIndex == index){
					System.out.println("Index to add has Element with value = "+tempNode.nodeValue);
					Node oldNode = tempNode;
					Node newNode = new Node();
					
					newNode.nodeValue = tempNode.nodeValue;
					newNode.nextNode = tempNode.nextNode;
					
					oldNode.nodeValue = value;
					oldNode.nextNode = newNode;
					tempNode = oldNode;
					found= true;
					break;
				}
			}
			
			if(!found){
				System.out.println("index size = "+index+" was not found, adding new element to end");
				Node lastNode = new Node();
				lastNode.nodeValue = value;
				tempNode = rootNode;
				while(tempNode.nextNode != null){
					tempNode = tempNode.nextNode;
				}
				tempNode.nextNode = lastNode;
			}
		}
	}
	
	
	public void insertInBetween(int firstNodeValue,int secondNodeValue,int nodeValue){
		if(rootNode !=null){
			Node currentNode = rootNode;
			while(currentNode.nextNode != null){
				if(currentNode.nodeValue == firstNodeValue && currentNode.nextNode.nodeValue == secondNodeValue){
					Node oldNode = currentNode;
					oldNode.nodeValue = currentNode.nodeValue;
					Node newNode = new Node();
					newNode.nodeValue = nodeValue;
					newNode.nextNode = currentNode.nextNode;
					oldNode.nextNode = newNode;
					break;
				}
				currentNode = currentNode.nextNode;
			}
		}
	}
	
	
	public int find(int nodeValue){
		int index = 0;
		Node currentNode = rootNode;
		while(currentNode != null){
			if(nodeValue == currentNode.nodeValue){
				return index;
			}
			currentNode = currentNode.nextNode;
			index++;
		}
		return -1;
	}
	
	
	public boolean deleteNode(int nodeValue){
		boolean deleted = false;
		Node currentNode = rootNode;
		Node prevNode = null;
		while(currentNode != null){
			if(nodeValue == currentNode.nodeValue){
				Node tempNode = currentNode.nextNode;
				if(tempNode == null){
					prevNode.nextNode = tempNode;
					currentNode = prevNode;
					return true;
				}
				currentNode.nodeValue = tempNode.nodeValue;
				currentNode.nextNode = tempNode.nextNode;
				return true;
			}
			prevNode = currentNode;
			currentNode = currentNode.nextNode;
		}
		return deleted;
	}
	
	public Node getList(){
		return rootNode;
	}
	
	public void displayNode(){
		Node currentNode = rootNode;
		while(currentNode != null){
			System.out.print(currentNode.nodeValue+" \t");
			currentNode = currentNode.nextNode;
		}
		System.out.println();
	}
	
	
	public static void main(String args[]){
		SingleLinkedList linkedList = new SingleLinkedList();
		
		linkedList.add(2);
		linkedList.add(3);
		linkedList.insertAt(1, 1);
		linkedList.add(5);
		linkedList.insertAt(4, 4);
		linkedList.insertAt(6, 6);
		linkedList.add(8);
		linkedList.add(9);
		linkedList.add(10);
		linkedList.insertAt(7, 7);
		linkedList.add(11);
		linkedList.add(13);
		linkedList.add(14);
		linkedList.insertInBetween(11, 13, 12);
		
		linkedList.displayNode();
		
		System.out.println(linkedList.deleteNode(14));
		
		linkedList.displayNode();
		
		/*linkedList.insertInBetween(1, 3, 2);
		
		linkedList.displayNode();*/
	}

}
