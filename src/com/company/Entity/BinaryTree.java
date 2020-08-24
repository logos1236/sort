package com.company.Entity;

import com.company.Window.Draw;
import com.company.Window.DrawElement.Circle;
import com.company.Window.DrawElement.Line;
import com.company.Window.Window;

import javax.swing.*;
import java.awt.*;

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

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void add(int value) {
        if (heap_list_size == 0) {
            root = new BinaryTreeNode(value);
        } else {
            addTo(value, root);
        }

        heap_list_size++;
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

    public void print() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Draw draw = new Draw();
                int space_between_circles = getDepth();
                drawNodeRegular(draw, getRoot(), 300, 0, space_between_circles, Color.BLACK);

                new Window(draw);
            }
        });
    }

    public static void drawNodeRegular(Draw draw, BinaryTreeNode node, int start_x, int start_y, int space_between_circles, Color color) {
        if (node != null) {
            space_between_circles--;

            int offset_x_circle = (int)(Circle.getRadius()*(space_between_circles-0.5));
            int offset_x_line = (int)(Circle.getRadius()*(space_between_circles-0.5));

            draw.addDrawElement(new Circle(start_x, start_y, color, String.valueOf(node.getValue())));

            if (node.getLeftChild() != null) {
                draw.addDrawElement(new Line(start_x+Circle.getRadius()/2, start_y+Circle.getRadius(), Color.BLACK, start_x-offset_x_line+Circle.getRadius()/2,start_y + Circle.getRadius()*2));
                drawNodeRegular(draw, node.getLeftChild(), start_x-offset_x_circle,start_y + Circle.getRadius()*2, space_between_circles, Color.BLACK);
            }
            if (node.getRightChild() != null) {
                System.out.println(space_between_circles);

                draw.addDrawElement(new Line(start_x+Circle.getRadius()/2, start_y+Circle.getRadius(), Color.RED, start_x+Circle.getRadius()/2+offset_x_line,start_y + Circle.getRadius()*2));
                drawNodeRegular(draw, node.getRightChild(), start_x+offset_x_circle,start_y + Circle.getRadius()*2, space_between_circles, Color.RED);
            }
        }
    }

    public static int getDepthRegular(int depth, BinaryTreeNode node) {
        if (node != null) {
            depth++;
            int max_depth = depth;

            if (node.getLeftChild() != null) {
                max_depth = getDepthRegular(depth, node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                int current_depth = getDepthRegular(depth, node.getRightChild());
                max_depth = (max_depth > current_depth) ? max_depth : current_depth;
            }

            depth = max_depth;
        }

        return depth;
    }

    public int getDepth() {
        return getDepthRegular(0, this.getRoot());
    }

    public BinaryTreeNode searchValue(int val) {
        return searchValueRecurse(val, this.getRoot());
    }

    private static BinaryTreeNode searchValueRecurse(int val, BinaryTreeNode node) {
        BinaryTreeNode result = null;
        if (node != null) {
            if (node.getValue() != val) {
                if (val < node.getValue()) {
                    result = searchValueRecurse(val, node.getLeftChild());
                } else {
                    result = searchValueRecurse(val, node.getRightChild());
                }
            } else {
                result = node;
            }
        }

        return result;
    }

    public static void test() {
        BinaryTree tree = new BinaryTree();

        tree.add(8);
        tree.add(4);
        tree.add(10);
        tree.add(3);
        tree.add(7);
        tree.add(9);
        tree.add(12);
        tree.add(4);
        tree.add(3);
        tree.add(54);
        tree.add(33);

        System.out.print(tree.searchValue(54));
    }
}
