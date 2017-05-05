import java.util.LinkedList;

public class Set implements Element
{
	private LinkedList<Element> set;
	
	//Constructor.
	public Set()
	{
		set=new LinkedList<>();
	}
	
	//Insert a new element.
	Set insert(Element e)
	{
		if (!set.contains(e))
			set.add(e);
		return this;
	}
	
	//Removes an element from the set if it exist in it.
	Set remove(Element e)
	{
		set.remove(e);
		return this;
	}
	
	//Returns the size of the set.
	int size()
	{
		return set.size();
	}
	
	//Unions the set with a given set.
	Set union(Set s)
	{
		for (Element e : s.set)
			if (!member(e))
				insert(e);
		return this;
	}
	
	Set intersect(Set s)
	{
		Set output=new Set();
		for (Element e : s.set)
			if (member(e))
				output.insert(e);;
		return output;
	}
	
	Set difference(Set s)
	{
		for (Element e : s.set)
			if (member(e))
				remove(e);
		return this;
	}
	
	Set power()
	{
		return power(set);
	}
	
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
		for (Element e: power(rest).set)
		{
			Set newSet=new Set();
			newSet.insert(e);
			newSet.insert(head);
			output.insert(e);
			output.insert(newSet);
		}
		return output;
	}
	
	boolean contains(Set s)
	{
		return set.containsAll(s.set);
	}
	
	boolean member(Element e)
	{
		for (Element myE : set)
			if (myE.equals(e))
				return true;
		return false;
	}
	
	boolean deepExistence(Element e)
	{
		throw new UnsupportedOperationException();
	}
	
	//Adds a given numeric to every element in the set.
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
	
	//Multiply a given numeric in every element in the set.
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
	
	//Returns a set as a string.
	@Override
	public String toString()
	{
		StringBuilder output=new StringBuilder("{");
		for (Element e : set)
		{
			if (e.equals(set.getLast()))
				output.append(e).append("}");
			else
				output.append(e).append(",");
		}
		return output.toString();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof Set && size()==((Set)obj).size() && contains((Set)obj);
	}
}