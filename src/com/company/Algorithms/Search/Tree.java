package com.company.Algorithms.Search;

import com.company.Algorithms.AlgorithmSearch;
import com.company.Entity.BinaryTree;
import com.company.TestArray;

public class Tree extends AlgorithmSearch {
    private BinaryTree tree = new BinaryTree();

    public Tree(int[] test_array, int search_value) {
        super(test_array, search_value);

        for(int i:test_array) {
            tree.add(i);
        }

        tree.normalizeTree();
    }

    @Override
    public int start() {
        return (tree.searchNodeByVal(getSearchValue()) != null) ? 1 : -1;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
