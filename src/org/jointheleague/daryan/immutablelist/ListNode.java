package org.jointheleague.daryan.immutablelist;

public class ListNode<T> implements ImmutableList<T> {
	
	private final T head;
	private final ImmutableList<T> tail;
	private final int length;

	public ListNode(T e, ImmutableList<T> list) {
		head = e;
		tail = list;
		length = tail.length() + 1;
	}

	@Override
	public boolean isEmpty() {
		return length() == 0;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public ImmutableList<T> remove(T e) {
		return new ListNode<>(e, remove(e));
	}

	@Override
	public ImmutableList<T> push(T e) {
		return new ListNode<>(e, this);
	}

	@Override
	public ImmutableList<T> append(T e) {
		return new ListNode<>(head, tail.append(e));
	}

	@Override
	public T head() {
		return head;
	}

	@Override
	public ImmutableList<T> tail() {
		return tail;
	}

}
