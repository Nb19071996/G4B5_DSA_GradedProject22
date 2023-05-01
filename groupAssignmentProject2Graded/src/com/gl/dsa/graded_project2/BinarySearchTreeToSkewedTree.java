package com.gl.dsa.graded_project2;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

public class BinarySearchTreeToSkewedTree {

    public static TreeNode rightRotate(TreeNode node) {
        TreeNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;
    }

    public static TreeNode skewedTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = rightRotate(root);
        }
        root.right = skewedTree(root.right);
        return root;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Creating a complete BST
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(10);
        root.right.left = new TreeNode(55);

        // Converting the BST to skewed tree
        TreeNode skewedTree = skewedTree(root);

        // Printing the skewed tree in ascending order
        inorderTraversal(skewedTree);
    }
}
