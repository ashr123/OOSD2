import java.util.LinkedList;

public class Set implements Element
{
	private LinkedList<Element> set;
	
	public Set()
	{
		set=new LinkedList<>();
	}
	
	Set insert(Element e)
	{
		throw new UnsupportedOperationException();
	}
	
	Set remove(Element e)
	{
		throw new UnsupportedOperationException();
	}
	
	int size()
	{
		throw new UnsupportedOperationException();
	}
	
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
		throw new UnsupportedOperationException();
	}
	
	boolean member(Element e)
	{
		throw new UnsupportedOperationException();
	}
	
	boolean deepExistence(Element e)
	{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Element transformAdd(Numeric n)
	{
		return null;
	}
	
	@Override
	public Element transformMul(Numeric n)
	{
		return null;
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}
}