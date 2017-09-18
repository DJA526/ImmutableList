package org.jointheleague.daryan.immutablelist;

public class ListNode<T> implements ImmutableList<T> {
	
	private final T head;
	private final ImmutableList<T> tail;
	private final int length;

	public ListNode(T e, ImmutableList<T> list) {
		head = e;
		if (list == null) {
			throw new IllegalArgumentException("Tail cannot be null.");
		}
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
	
	private int count(ImmutableList<T> lst, T e) {
		if (lst.isEmpty()) {
			return 0;
		} else if (lst.head() == null && e != null) {
			return count(lst.tail(), e);
		} else if ((e == null && lst.head() == null) || lst.head().equals(e)) {
			return 1 + count(lst.tail(), e);
		} else {
			return count(lst.tail(), e);
		}
	}

	@Override
	public ImmutableList<T> remove(T e) {
		int count = count(this, e);
		if (count == 0) {
			return this;
		} if ((head != null && head.equals(e)) || (head == null && e == null)) {
			return tail.remove(e);
		} else {
			return new ListNode<T>(head, tail.remove(e));
		}
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		ImmutableList<T> lst = this;
		boolean first = true;
		while (lst.isEmpty() == false) {
			if (first) {
				first = false;
			} else {
				sb.append(" ");
			}
			if (lst.head() == null) {
				sb.append("null");
			} else {
				sb.append(lst.head().toString());				
			}
			lst = lst.tail();
		}
		sb.append(")");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result + ((tail == null) ? 0 : tail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListNode other = (ListNode) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head)) {
			return false;	
		} 
		if (!tail.equals(other.tail)) {
			return false;
		}
		return true;
	}
	
	

}
