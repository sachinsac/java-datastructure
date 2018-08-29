package com.datastructure.tree;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class Tree implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = -5705338941060912068L;
		
		public int value;
		public Tree rightTree;
		public Tree leftTree;
		
		public Tree(int value) {
			this.value = value;
		}
}
