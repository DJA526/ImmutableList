package org.jointheleague.daryan.immutablelist;

import java.util.NoSuchElementException;

public class EmptyList<T> implements ImmutableList<T> {

	@SuppressWarnings("rawtypes")
	static final EmptyList instance = new EmptyList();

	@SuppressWarnings("unchecked")
	public static ImmutableList getInstance() {
		return instance;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public int length() {
		return 0;
	}

	@Override
	public ImmutableList<T> remove(T e) {
		return this;
	}

	@Override
	public ImmutableList<T> push(T e) {
		return new ListNode<>(e, this);
	}

	@Override
	public ImmutableList<T> append(T e) {
		return new ListNode<>(e, this);
	}

	@Override
	public T head() {
		throw new NoSuchElementException("EmptyList has no head.");
	}

	@Override
	public ImmutableList<T> tail() {
		throw new NoSuchElementException("EmptyList has no tail.");
	}

	public String toString() {
		return "()";
	}

}
