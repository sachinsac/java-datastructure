package com.datastructure;

import java.util.Arrays;

public class MyStack <T>{

		int[] array;
		int size;
		int lastElement;
		int previousElement;
		
		public MyStack() {
			this(8);
		}
		
		public MyStack(int size) {
			array = new int[size];
			this.size = size;
		}
		
		public boolean add(int e){
			checkSize(lastElement);
			shift(lastElement,array);
			if(array[0] == previousElement){
				array[0] = e;
				lastElement++;
				previousElement = e;
				return true;
			}
			return false;
		}
		
		int[] checkSize(int lastIndex){
			if(lastIndex >= (size - 2)){
				size = size+4;
				int newarray[] = new int[size];
				newarray = Arrays.copyOfRange(array, 0, size);
				array = newarray;
			}
			return array;
		}
		
		
		public int[] shift(int lastElement,int [] array){
			if(lastElement > 0){
				int lastEntryIndex = lastElement-1;
				for(int i=lastEntryIndex;i>=0;i--){
					while(lastElement <=array.length && lastElement >= 0){
						array[lastElement] = array[i];
						break;
					}
					lastElement--;
				}
			}
			return array;
		}
		
		public int[] get(){
			if(array.length > lastElement)
				array = Arrays.copyOfRange(array, 0, lastElement);
			return array;
		}
		
		public static void main(String args[]){
			MyStack<String> q = new MyStack<String>();
			q.add(1);
			q.add(2);
			q.add(3);
			q.add(4);
			q.add(5);
			q.add(6);
			q.add(7);
			q.add(8);
			
			int result[] = q.get();
			
			for(int i=0;i<result.length;i++){
				System.out.println(result[i]);
			}
		}
}
