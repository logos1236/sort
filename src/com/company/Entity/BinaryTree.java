package com.company.Entity;

import com.company.TestArray;
import com.company.Window.Draw;
import com.company.Window.DrawElement.Circle;
import com.company.Window.DrawElement.Line;
import com.company.Window.Window;

import javax.swing.*;
import java.awt.*;

public class BinaryTree {
    public static class BinaryTreeNode {
        private BinaryTreeNode left_child = null;
        private BinaryTreeNode right_child = null;
        private BinaryTreeNode parent_node = null;
        private int value;
        private int height = 0;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode(BinaryTreeNode another) {
            this.value = another.value;
        }

        private void setParentNode(BinaryTreeNode parent_node) {
            this.parent_node = parent_node;
        }
        public BinaryTreeNode getParentNode() {
            return this.parent_node;
        }

        public void setLeftChild(BinaryTreeNode left_child) {
            this.left_child = left_child;

            if (left_child != null) {
                left_child.setParentNode(this);
            }
        }
        public BinaryTreeNode getLeftChild() {
            return this.left_child;
        }
        public static BinaryTreeNode getLeftChild(BinaryTreeNode node) {
            return (node != null) ? node.left_child : null;
        }

        public void setRightChild(BinaryTreeNode right_child) {
            this.right_child = right_child;

            if (right_child != null) {
                right_child.setParentNode(this);
            }
        }
        public BinaryTreeNode getRightChild() {
            return this.right_child;
        }
        public static BinaryTreeNode getRightChild(BinaryTreeNode node) {
            return (node != null) ? node.right_child : null;
        }

        public int getValue() {
            return this.value;
        }

        public void setHeight(int height) {
            this.height = height;
        }
        public int getHeight() {
            return this.height;
        }
        public static int getHeight(BinaryTreeNode node) {
            return (node != null) ? node.height : 0;
        }
    }

    private BinaryTreeNode root = null;
    private int heap_list_size = 0;

    public BinaryTree cloneTree() {
        BinaryTree new_tree = new BinaryTree();
        new_tree.root = cloneTreeRecurse(this.root);
        new_tree.calculateDepth();

        return new_tree;
    }

    private BinaryTreeNode cloneTreeRecurse(BinaryTreeNode another_node) {
        BinaryTreeNode result = new BinaryTreeNode(another_node);

        if (another_node.left_child != null) {
            result.setLeftChild(cloneTreeRecurse(another_node.left_child));
        }
        if (another_node.right_child != null) {
            result.setRightChild(cloneTreeRecurse(another_node.right_child));
        }

        return result;
    }

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
            addRecurse(value, root);
        }

        heap_list_size++;
    }

    private void addRecurse(int value, BinaryTreeNode node) {
        if (value <= node.getValue()) {
            if (node.getLeftChild() == null) {
                BinaryTreeNode new_node = new BinaryTreeNode(value);
                node.setLeftChild(new_node);
            } else {
                addRecurse(value, node.getLeftChild());
            }
        } else {
            if (node.getRightChild() == null) {
                BinaryTreeNode new_node = new BinaryTreeNode(value);
                node.setRightChild(new_node);
            } else {
                addRecurse(value, node.getRightChild());
            }
        }
        node.height++;
    }

    public void print() {
        BinaryTree print_tree = this.cloneTree();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Draw draw = new Draw();
                int space_between_circles = print_tree.getRoot().height+1;

                drawNodeRecurse(draw, print_tree.getRoot(), 300, 0, space_between_circles, Color.BLACK);

                new Window(draw);
            }
        });
    }

    public static void drawNodeRecurse(Draw draw, BinaryTreeNode node, int start_x, int start_y, int space_between_circles, Color color) {
        if (node != null) {
            space_between_circles--;

            int offset_x_circle = (int)(Circle.getRadius()*(Math.abs(space_between_circles-0.5)));
            int offset_x_line = (int)(Circle.getRadius()*(Math.abs(space_between_circles-0.5)));

            draw.addDrawElement(new Circle(start_x, start_y, color, String.valueOf(node.getValue())+"/"+String.valueOf(node.getHeight())));

            if (node.getLeftChild() != null) {
                draw.addDrawElement(new Line(start_x+Circle.getRadius()/2, start_y+Circle.getRadius(), Color.BLACK, start_x-offset_x_line+Circle.getRadius()/2,start_y + Circle.getRadius()*2));
                drawNodeRecurse(draw, node.getLeftChild(), start_x-offset_x_circle,start_y + Circle.getRadius()*2, space_between_circles, Color.BLACK);
            }
            if (node.getRightChild() != null) {
                draw.addDrawElement(new Line(start_x+Circle.getRadius()/2, start_y+Circle.getRadius(), Color.RED, start_x+Circle.getRadius()/2+offset_x_line,start_y + Circle.getRadius()*2));
                drawNodeRecurse(draw, node.getRightChild(), start_x+offset_x_circle,start_y + Circle.getRadius()*2, space_between_circles, Color.RED);
            }
        }
    }

    public int calculateDepth() {
        return calculateDepthRecurse(this.getRoot());
    }

    private static int calculateDepthRecurse(BinaryTreeNode node) {
        int depth = -1;

        if (node != null) {
            if (node.getLeftChild() != null) {
                depth = calculateDepthRecurse(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                int current_depth = calculateDepthRecurse(node.getRightChild());
                depth = (depth > current_depth) ? depth : current_depth;
            }
        }
        depth++;

        node.setHeight(depth);

        return depth;
    }

    public BinaryTreeNode searchNodeByVal(int val) {
        return searchNodeByValRecurse(val, this.getRoot());
    }

    private static BinaryTreeNode searchNodeByValRecurse(int val, BinaryTreeNode node) {
        BinaryTreeNode result = null;
        if (node != null) {
            if (node.getValue() != val) {
                if (val < node.getValue()) {
                    result = searchNodeByValRecurse(val, node.getLeftChild());
                } else {
                    result = searchNodeByValRecurse(val, node.getRightChild());
                }
            } else {
                result = node;
            }
        }

        return result;
    }

    public void normalizeTree() {
        normalizeTreeRecurse(this.root);
    }

    private void normalizeTreeRecurse(BinaryTreeNode a) {
        if (a != null) {
            BinaryTreeNode b = BinaryTreeNode.getLeftChild(a);
            BinaryTreeNode c = BinaryTreeNode.getRightChild(a);

            BinaryTreeNode d = BinaryTreeNode.getLeftChild(b);
            BinaryTreeNode e = BinaryTreeNode.getRightChild(b);

            BinaryTreeNode f = BinaryTreeNode.getLeftChild(c);
            BinaryTreeNode g = BinaryTreeNode.getRightChild(c);

            if (Math.abs(BinaryTreeNode.getHeight(b) - BinaryTreeNode.getHeight(c)) >= 2) {
                    if (BinaryTreeNode.getHeight(f) <= BinaryTreeNode.getHeight(g) && (f != null || g != null)) {
                        rotateLeft(a);
                    }

                    if ((BinaryTreeNode.getHeight(f) > BinaryTreeNode.getHeight(g)) && (f != null || g != null)) {
                        rotateLeftBig(a);
                    }

                    if ((BinaryTreeNode.getHeight(e) <= BinaryTreeNode.getHeight(d)) && (e != null || d != null)) {
                        rotateRight(a);
                    }

                    if ((BinaryTreeNode.getHeight(e) > BinaryTreeNode.getHeight(d)) && (e != null || d != null)) {
                        rotateRightBig(a);
                    }

                    if (b != null) {
                        normalizeTreeRecurse(b);
                    }
                    if (c != null) {
                        normalizeTreeRecurse(c);
                    }
            }
        }
    }

    private BinaryTreeNode rotateLeft(BinaryTreeNode a) {
        BinaryTreeNode c = BinaryTreeNode.getRightChild(a);
        BinaryTreeNode f = BinaryTreeNode.getLeftChild(c);

        int insert_pace_flag = 0;
        BinaryTreeNode parent_node = a.parent_node;
        if (parent_node != null) {
            insert_pace_flag = (parent_node.left_child == a) ? -1 : 1;
        }

        a.setRightChild(f);
        if (c != null) {
            c.setLeftChild(a);
        }

        if (insert_pace_flag == 0) {
            c.parent_node = null;
            this.root = c;
        } else if (insert_pace_flag == -1) {
            parent_node.setLeftChild(c);
        } else {
            parent_node.setRightChild(c);
        }

        if (c != null) {
            calculateDepth();
        }

        return c;
    }

    private BinaryTreeNode rotateLeftBig(BinaryTreeNode a) {
        BinaryTreeNode c = BinaryTreeNode.getRightChild(a);

        BinaryTreeNode f = BinaryTreeNode.getLeftChild(c);
        BinaryTreeNode g = BinaryTreeNode.getRightChild(c);

        BinaryTreeNode j = BinaryTreeNode.getLeftChild(f);
        BinaryTreeNode k = BinaryTreeNode.getRightChild(f);

        int insert_pace_flag = 0;
        BinaryTreeNode parent_node = a.parent_node;
        if (a.parent_node != null) {
            insert_pace_flag = (parent_node.getLeftChild() == a) ? -1 : 1;
        }

        a.setRightChild(j);

        if (c != null) {
            c.setLeftChild(k);
            c.setRightChild(g);
        }

        if (f != null) {
            f.setLeftChild(a);
            f.setRightChild(c);
        }

        if (insert_pace_flag == 0) {
            f.parent_node = null;
            this.root = f;
        } else if (insert_pace_flag == -1) {
            parent_node.setLeftChild(f);
        } else {
            parent_node.setRightChild(f);
        }

        if (f != null) {
            calculateDepth();
        }

        return f;
    }

    private BinaryTreeNode rotateRight(BinaryTreeNode a) {
        BinaryTreeNode b = BinaryTreeNode.getLeftChild(a);
        BinaryTreeNode e = BinaryTreeNode.getRightChild(b);

        int insert_pace_flag = 0;
        BinaryTreeNode parent_node = a.parent_node;
        if (parent_node != null) {
            insert_pace_flag = (parent_node.getLeftChild() == a) ? -1 : 1;
        }

        a.setLeftChild(e);
        if (b != null) {
            b.setRightChild(a);
        }

        if (insert_pace_flag == 0) {
            b.parent_node = null;
            this.root = b;
        } else if (insert_pace_flag == -1) {
            parent_node.setLeftChild(b);
        } else {
            parent_node.setRightChild(b);
        }

        if (b != null) {
            calculateDepth();
        }

        return b;
    }

    private BinaryTreeNode rotateRightBig(BinaryTreeNode a) {
        BinaryTreeNode b = BinaryTreeNode.getLeftChild(a);

        BinaryTreeNode d = BinaryTreeNode.getLeftChild(b);
        BinaryTreeNode e = BinaryTreeNode.getRightChild(b);

        BinaryTreeNode h = BinaryTreeNode.getLeftChild(e);
        BinaryTreeNode i = BinaryTreeNode.getRightChild(e);

        int insert_pace_flag = 0;
        BinaryTreeNode parent_node = a.parent_node;
        if (a.parent_node != null) {
            insert_pace_flag = (parent_node.getLeftChild() == a) ? -1 : 1;
        }

        a.setLeftChild(i);

        if (b != null) {
            b.setLeftChild(d);
            b.setRightChild(h);
        }

        if (e!= null) {
            e.setLeftChild(b);
            e.setRightChild(a);
        }

        if (insert_pace_flag == 0) {
            e.parent_node = null;
            this.root = e;
        } else if (insert_pace_flag == -1) {
            parent_node.setLeftChild(e);
        } else {
            parent_node.setRightChild(e);
        }

        if (e != null) {
            calculateDepth();
        }

        return e;
    }

    public static void test() {
        BinaryTree tree = new BinaryTree();

        int array_size = 20;
        int[] unsorted_array = new TestArray(array_size).getArray();

        for(int i:unsorted_array) {
            tree.add(i);
        }

        tree.print();
        tree.normalizeTree();
        tree.print();

        /*tree.add(100);
        tree.add(150);


        tree.add(160);
        tree.add(170);
        tree.add(190);
        tree.print();

        tree.normalizeTree();
        tree.print();*/
    }
}
