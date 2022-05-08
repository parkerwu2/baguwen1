package com.papa.baguwen1.baguwen1.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    private int index = 0;
    private List<Integer> list = new ArrayList<>();

    private void processList(List<NestedInteger> l){
        for (NestedInteger nestedInteger : l) {
            if (nestedInteger.isInteger()){
                list.add(nestedInteger.getInteger());
            } else {
                processList(nestedInteger.getList());
            }
        }
    }
    public NestedIterator(List<NestedInteger> nestedList) {
        processList(nestedList);
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return !(index == list.size());
    }

    public static void main(String[] args) {

    }
}
