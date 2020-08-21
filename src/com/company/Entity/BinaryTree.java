package com.company.Entity;

import com.company.Window.Window;

import javax.swing.*;

public class BinaryTree {
    public class BinaryTreeNode {
        private BinaryTreeNode left_child = null;
        private BinaryTreeNode right_child = null;
        private int value;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public void setLeftChild(BinaryTreeNode left_child) {
            this.left_child = left_child;
        }
        public BinaryTreeNode getLeftChild() {
            return this.left_child;
        }

        public void setRightChild(BinaryTreeNode right_child) {
            this.right_child = right_child;
        }
        public BinaryTreeNode getRightChild() {
            return this.right_child;
        }

        public int getValue() {
            return this.value;
        }
    }

    private BinaryTreeNode root = null;
    private int heap_list_size = 0;

    public int getSize() {
        return heap_list_size;
    }

    public void add(int value) {
        if (heap_list_size == 0) {
            root = new BinaryTreeNode(value);
        } else {
            addTo(value, root);
        }

        heap_list_size++;
    }

    public void print() {
        /*System.out.println("=================");

        ArrayList<BinaryTreeNode> current_row = new ArrayList();
        current_row.add(root);

        while(!current_row.isEmpty()) {
            ArrayList<BinaryTreeNode> temp = new ArrayList<>(current_row);
            current_row = new ArrayList();
            StringBuilder print_string = new StringBuilder();

            for(BinaryTreeNode current_elem:temp) {
                if (current_elem.getLeftChild() != null) {
                    current_row.add(current_elem.getLeftChild());
                }
                if (current_elem.getRightChild() != null) {
                    current_row.add(current_elem.getRightChild());
                }

                if (print_string.length() != 0) {
                    print_string.append(" | ");
                }
                print_string.append(current_elem.getValue());
            }

            System.out.println(print_string);
        }

        System.out.println("");
        System.out.println("=================");*/

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Window();
            }
        });
    }

    private void addTo(int value, BinaryTreeNode node) {
        if (value <= node.getValue()) {
            if (node.getLeftChild() == null) {
                node.setLeftChild(new BinaryTreeNode(value));
            } else {
                addTo(value, node.getLeftChild());
            }
        } else {
            if (node.getRightChild() == null) {
                node.setRightChild(new BinaryTreeNode(value));
            } else {
                addTo(value, node.getRightChild());
            }
        }
    }

    public static void test() {
        BinaryTree tree = new BinaryTree();

        tree.add(8);
        tree.add(4);
        tree.add(2);
        tree.add(3);
        tree.add(10);
        tree.add(6);
        tree.add(7);

        tree.print();
    }
}
