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
			set.addLast(e);
		return this;
	}
	
	//Removes an element from the set if it exist in it.
	Set remove(Element e)
	{
		if (set.contains(e))
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
		throw new UnsupportedOperationException();
	}
	
	Set intersect(Set s)
	{
		throw new UnsupportedOperationException();
	}
	
	Set difference(Set s)
	{
		throw new UnsupportedOperationException();
	}
	
	Set power()
	{
		throw new UnsupportedOperationException();
	}
	
	boolean contains(Set s)
	{
		for (Element e : s.set)
		{
			if (!this.set.contains(e))
				return false;
		}
		return true;
	}
	
	boolean member(Element e)
	{
		throw new UnsupportedOperationException();
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
			e.transformAdd(n);
		return this;
	}
	
	//Multiply a given numeric in every element in the set.
	@Override
	public Element transformMul(Numeric n)
	{
		for (Element e : set)
			e.transformMul(n);
		return this;
	}
	
	//Returns a set as a string.
	@Override
	public String toString()
	{
		StringBuilder output =new StringBuilder("{");
		for (Element e: set){
			if (e.equals(set.getLast())){
				output.append(e).append("}");
			}
			else {
				output.append(e).append(",");
			}
		}
		return output.toString();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}
}