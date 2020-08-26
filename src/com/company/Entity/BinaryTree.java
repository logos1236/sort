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
        private BinaryTreeNode parent_node = null;
        private int value;
        private int height = 1;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        private void setParentNode(BinaryTreeNode parent_node) {
            this.parent_node = parent_node;

            if (parent_node != null) {
                calculateNodeHeight(parent_node);
            }
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

        public void setRightChild(BinaryTreeNode right_child) {
            this.right_child = right_child;
            if (right_child != null) {
                right_child.setParentNode(this);
            }
        }
        public BinaryTreeNode getRightChild() {
            return this.right_child;
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

        private void calculateNodeHeight(BinaryTreeNode node) {
            int node_height = 0;
            if (node != null) {
                if (node.left_child != null) {
                    node_height = node.left_child.height + 1;
                }
                if (node.right_child != null) {
                    node_height = node_height > (node.right_child.height + 1) ? node_height : (node.right_child.height + 1);
                }

                if (node.height != node_height) {
                    node.height = node_height;
                    calculateNodeHeight(node.parent_node);
                }
            }
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
    }

    public void print() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Draw draw = new Draw();
                int space_between_circles = getDepth();
                drawNodeRecurse(draw, getRoot(), 300, 0, space_between_circles, Color.BLACK);

                new Window(draw);
            }
        });
    }

    public static void drawNodeRecurse(Draw draw, BinaryTreeNode node, int start_x, int start_y, int space_between_circles, Color color) {
        if (node != null) {
            space_between_circles--;

            int offset_x_circle = (int)(Circle.getRadius()*(space_between_circles-0.5));
            int offset_x_line = (int)(Circle.getRadius()*(space_between_circles-0.5));

            draw.addDrawElement(new Circle(start_x, start_y, color, String.valueOf(node.getValue())+"/"+String.valueOf(node.getHeight())));

            if (node.getLeftChild() != null) {
                draw.addDrawElement(new Line(start_x+Circle.getRadius()/2, start_y+Circle.getRadius(), Color.BLACK, start_x-offset_x_line+Circle.getRadius()/2,start_y + Circle.getRadius()*2));
                drawNodeRecurse(draw, node.getLeftChild(), start_x-offset_x_circle,start_y + Circle.getRadius()*2, space_between_circles, Color.BLACK);
            }
            if (node.getRightChild() != null) {
                System.out.println(space_between_circles);

                draw.addDrawElement(new Line(start_x+Circle.getRadius()/2, start_y+Circle.getRadius(), Color.RED, start_x+Circle.getRadius()/2+offset_x_line,start_y + Circle.getRadius()*2));
                drawNodeRecurse(draw, node.getRightChild(), start_x+offset_x_circle,start_y + Circle.getRadius()*2, space_between_circles, Color.RED);
            }
        }
    }

    public int getDepth() {
        return getDepthRecurse(0, this.getRoot());
    }

    public static int getDepthRecurse(int depth, BinaryTreeNode node) {
        if (node != null) {
            depth++;
            int max_depth = depth;

            if (node.getLeftChild() != null) {
                max_depth = getDepthRecurse(depth, node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                int current_depth = getDepthRecurse(depth, node.getRightChild());
                max_depth = (max_depth > current_depth) ? max_depth : current_depth;
            }

            depth = max_depth;
        }

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

    private void normalizeTree(BinaryTreeNode node) {
        if (node != null) {
            int left_height = (node.left_child == null) ? 0 : node.left_child.height;
            int right_height = (node.right_child == null) ? 0 : node.right_child.height;

            if (Math.abs(left_height - right_height) >= 2) {

            }

            normalizeTree(node.parent_node);
        }
    }

    private BinaryTreeNode rotateLeft(BinaryTreeNode a) {
        BinaryTreeNode c = a.left_child;
        BinaryTreeNode f = (c != null) ? c.left_child : null;

        int insert_pace_flag = 0;
        BinaryTreeNode parent_node = a.parent_node;
        if (a.parent_node != null) {
            insert_pace_flag = (parent_node.getLeftChild() == a) ? -1 : 1;
        }

        a.setRightChild(f);
        if (c != null) {
            c.setLeftChild(a);
        }

        if (insert_pace_flag != 0) {
            if (insert_pace_flag == -1) {
                parent_node.setLeftChild(c);
            } else {
                parent_node.setRightChild(c);
            }
        }

        return c;
    }

    private BinaryTreeNode rotateLeftBig(BinaryTreeNode a) {
        BinaryTreeNode b = a.left_child;
        BinaryTreeNode c = a.right_child;
        BinaryTreeNode f = (c != null) ? c.left_child : null;
        BinaryTreeNode g = (c != null) ? c.right_child : null;
        BinaryTreeNode j = (f != null) ? f.left_child : null;
        BinaryTreeNode k = (f != null) ? f.right_child : null;

        int insert_pace_flag = 0;
        BinaryTreeNode parent_node = a.parent_node;
        if (a.parent_node != null) {
            insert_pace_flag = (parent_node.getLeftChild() == a) ? -1 : 1;
        }

        c.setRightChild(j);

        if (c != null) {
            c.setLeftChild(k);
            c.setRightChild(g);
        }

        if (f != null) {
            f.setLeftChild(a);
            f.setRightChild(c);
        }

        if (insert_pace_flag != 0) {
            if (insert_pace_flag == -1) {
                parent_node.setLeftChild(f);
            } else {
                parent_node.setRightChild(f);
            }
        }

        return f;
    }

    private BinaryTreeNode rotateRight(BinaryTreeNode a) {
        BinaryTreeNode b = a.left_child;
        BinaryTreeNode c = a.right_child;
        BinaryTreeNode d = (b != null) ? b.left_child : null;
        BinaryTreeNode e = (b != null) ? b.right_child : null;

        int insert_pace_flag = 0;
        BinaryTreeNode parent_node = a.parent_node;
        if (a.parent_node != null) {
            insert_pace_flag = (parent_node.getLeftChild() == a) ? -1 : 1;
        }

        a.setLeftChild(e);
        if (b != null) {
            b.setRightChild(a);
        }

        if (insert_pace_flag != 0) {
            if (insert_pace_flag == -1) {
                parent_node.setLeftChild(b);
            } else {
                parent_node.setRightChild(b);
            }
        }

        return b;
    }

    private BinaryTreeNode rotateRightBig(BinaryTreeNode a) {
        BinaryTreeNode b = a.left_child;
        BinaryTreeNode c = a.right_child;
        BinaryTreeNode d = (b != null) ? b.left_child : null;
        BinaryTreeNode e = (b != null) ? b.right_child : null;
        BinaryTreeNode h = (e != null) ? e.left_child : null;
        BinaryTreeNode i = (e != null) ? e.right_child : null;

        int insert_pace_flag = 0;
        BinaryTreeNode parent_node = a.parent_node;
        if (a.parent_node != null) {
            insert_pace_flag = (parent_node.getLeftChild() == a) ? -1 : 1;
        }

        a.setLeftChild(i);
        a.setRightChild(c);

        if (b != null) {
            a.setLeftChild(d);
            a.setRightChild(h);
        }

        if (e!= null) {
            e.setLeftChild(b);
            e.setRightChild(a);
        }

        if (insert_pace_flag != 0) {
            if (insert_pace_flag == -1) {
                parent_node.setLeftChild(e);
            } else {
                parent_node.setRightChild(e);
            }
        }

        return e;
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

        //tree.RightRotation(tree.searchNodeByVal(12));

        tree.print();
    }
}
