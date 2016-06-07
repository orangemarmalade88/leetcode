package model;

import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public class NestedInteger {

	Integer integer;
	List<NestedInteger> list;
	boolean isInteger;

	public NestedInteger(int integer) {
		this.integer = integer;
		isInteger = true;
	}

	public NestedInteger(List<NestedInteger> list) {
		this.list = list;
		isInteger = false;
	}

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger() {
		return isInteger;
	}

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		return integer;
	}

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		return list;
	}
}