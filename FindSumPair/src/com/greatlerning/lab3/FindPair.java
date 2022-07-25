package com.greatlerning.lab3;

import java.util.HashSet;


public class FindPair {
	static class Node{
	int nodeData;
	Node leftNode,rightNode;
	};
	

	
	static Node newNode(int nodeData)
	{
		Node temp = new Node();
		temp.nodeData = nodeData;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
		
	}
	public Node insert (Node root, int key)
	{
		if(root == null) //root null
			return newNode(key); //new node = 40
		if (key<root.nodeData) // root 40 and key 20
			root.leftNode = insert(root.leftNode,key);
		else
			root.rightNode = insert(root.rightNode,key);
		
		return root;
	}
		public boolean findPairUtil(Node root, int sum, HashSet<Integer> set) {
			if (root ==null)
				return false;
			
			if (findPairUtil (root.leftNode, sum, set))
				return true;
			if (set.contains(sum-root.nodeData)) {
				System.out.println("pair is found (" + (sum-root.nodeData)+"," + root.nodeData +")");
				return true;
			}
			else
				set.add(root.nodeData);
			return findPairUtil(root.rightNode,sum,set);
			
		}
		
		public void findPairwithgivensum(Node root,int sum)
		{
			HashSet<Integer> set = new HashSet<Integer>();
			
			if (!findPairUtil(root,sum,set))
				System.out.println ("print nodes are not found" + "\n");
			
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Node root = null;
		FindPair fp = new FindPair();
		root = fp.insert(root,40);
		root = fp.insert(root,20);
		root = fp.insert(root,60);
		root = fp.insert(root,10);
		root = fp.insert(root,30);
		root = fp.insert(root,50);
		root = fp.insert(root,70);
int sum = 300;
fp.findPairwithgivensum (root,sum);

	}

}
