import java.util.LinkedList;

/**
 * Represents a subclass of {@link Element} that represents a (finite) set of elements.
 */
public class Set implements Element
{
	private LinkedList<Element> set;
	
	/**
	 * Constructs an empty {@link #set}.
	 */
	public Set()
	{
		set=new LinkedList<>();
	}
	
	/**
	 * Insert a new element.
	 * @param e an element to be inserted.
	 * @return this {@link #set}.
	 */
	Set insert(Element e)
	{
		if (!set.contains(e))
			set.add(e);
		return this;
	}
	
	/**
	 * Removes an element from the set if it exist in it.
	 * @param e the element to be removed.
	 * @return this {@link #set}.
	 */
	Set remove(Element e)
	{
		set.remove(e);
		return this;
	}
	
	/**
	 * @return the size of the {@link #set}.
	 */
	int size()
	{
		return set.size();
	}
	
	/**
	 * Unions this set with a given set.
	 * @param s the set to be unioned with
	 * @return this {@link #set}
	 */
	Set union(Set s)
	{
		for (Element e : s.set)
			if (!member(e))
				insert(e);
		return this;
	}
	
	/**
	 * Intersects this set with a given set.
	 * @param s the set to be intersected with.
	 * @return this {@link #set}.
	 */
	Set intersect(Set s)
	{
		Set output=new Set();
		for (Element e : s.set)
			if (member(e))
				output.insert(e);
		;
		return output;
	}
	
	/**
	 * differences this set with a given set.
	 * @param s the set to be differed with.
	 * @return this {@link #set}.
	 */
	Set difference(Set s)
	{
		for (Element e : s.set)
			if (member(e))
				remove(e);
		return this;
	}
	
	/**
	 * @return a power-set of this {@link #set} by calling {@link #power(LinkedList)}.
	 */
	Set power()
	{
		return power(set);
	}
	
	/**
	 * @param subList this subset.
	 * @return a power-set of this {@link #set}.
	 */
	private static Set power(LinkedList<Element> subList)
	{
		Set output=new Set();
		if (subList.isEmpty())
		{
			output.insert(new Set());
			return output;
		}
		Element head=subList.getFirst();
		LinkedList<Element> rest=new LinkedList<>(subList.subList(1, subList.size()));
		for (Element e : power(rest).set)
		{
			Set newSet=new Set();
			newSet.insert(e);
			newSet.insert(head);
			output.insert(e);
			output.insert(newSet);
		}
		return output;
	}
	
	/**
	 * @param s a set to be compared with.
	 * @return {@code true} if this {@link #set} contains the other set or {@code false} otherwise.
	 */
	boolean contains(Set s)
	{
		return set.containsAll(s.set);
	}
	
	/**
	 * @param e an element to be checked.
	 * @return {@code true} if an {@link Element} is a member of this {@link #set}, {@code false} otherwise.
	 */
	boolean member(Element e)
	{
		for (Element myE : set)
			if (myE.equals(e))
				return true;
		return false;
	}
	
	/**
	 * @param e an element to be checked.
	 * @return {@code true} if an {@link Element} is a member of this {@link #set} and it's subsets, {@code false} otherwise.
	 */
	boolean deepExistence(Element e)
	{
		boolean output=false;
		for (Element element : set)
		{
			output=e.equals(element);
			if (element instanceof Set && !output)
				output=((Set)element).deepExistence(e);
			if (output)
				break;
		}
		return output;
	}
	
	/**
	 * Adds a given {@link Numeric} number to every element in the set.
	 * @param n the number to be added.
	 * @return this {@link #set}
	 */
	@Override
	public Element transformAdd(Numeric n)
	{
		for (Element e : set)
		{
			Element temp=e.transformAdd(n);
			if (temp!=e)
				remove(e).insert(temp);
		}
		return this;
	}
	
	/**
	 * Multiply a given {@link Numeric} number to every element in the set.
	 * @param n the number to be added.
	 * @return this {@link #set}
	 */
	@Override
	public Element transformMul(Numeric n)
	{
		for (Element e : set)
		{
			Element temp=e.transformMul(n);
			if (temp!=e)
				remove(e).insert(temp);
		}
		return this;
	}
	
	@Override
	public String toString()
	{
		StringBuilder output=new StringBuilder("{");
		for (Element e : set)
			if (!e.equals(set.getLast()))
				output.append(e).append(",");
		return output.append("}").toString();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof Set && size()==((Set)obj).size() && contains((Set)obj);
	}
}