package com.practice.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintTree {
	Node root;

	public static void buildMap(final Node head, int rank, Map<Integer, List<Node>> map) {

		if (head.left != null) {
			if (map.get(rank) != null) {
				map.get(rank).add(head.left);
			}
			else {
				map.put(rank, new ArrayList<Node>() {{
					add(head.left);
				}});
			}
			buildMap(head.left, rank + 1, map);
		}

		if (head.right != null) {
			if (map.get(rank) != null) {
				map.get(rank).add(head.right);

			}
			else {
				map.put(rank, new ArrayList<Node>() {{
					add(head.right);
				}});
			}
			buildMap(head.right, rank + 1, map);
		}

		return;
	}

	public static void main(String[] args) {
		PrintTree tree = new PrintTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(5);
		tree.root.right.right = new Node(4);

		Map<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
		int count = 1;
		List<Node> list = new ArrayList<Node>();
		list.add(tree.root);
		map.put(count, list);

		buildMap(tree.root, count + 1, map);

		System.out.println(map);

	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;

		}

		@Override public String toString() {
			return "_" + this.data + "_";
		}
	}

}
