package org.jointheleague.daryan.immutablelist;

public class ListNode<T> implements ImmutableList<Integer> {

	public ListNode<T>(T e, ImmutableList<T> list) {
		
	}

	@Override
	public boolean isEmpty() {
		return length() == 0;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ImmutableList<Integer> remove(Integer e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImmutableList<Integer> push(Integer e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImmutableList<Integer> append(Integer e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer head() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImmutableList<Integer> tail() {
		// TODO Auto-generated method stub
		return null;
	}

}
