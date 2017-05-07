import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SetTests
{
	@Test
	void insert()
	{
		Set set = new Set();
		set.insert(new RealNumeric(4.5));
		set.insert(new RationalNumeric(5,2));
		assertEquals("{4.5,2.5}",set.toString());
	}
	
	@Test
	void remove()
	{
		Set set = new Set();
		set.insert(new RealNumeric(3));
		set.insert(new RealNumeric(9));
		set.insert(new RealNumeric(4));
		set.insert(new RealNumeric(8));
		assertEquals("{3,9,8}",set.remove(new RealNumeric(4)).toString());
	}
	
	@Test
	void size()
	{
		Set set = new Set();
		set.insert(new RealNumeric(4.5));
		set.insert(new RationalNumeric(5,3));
		assertEquals(2,set.size());
	}
	
	@Test
	void union()
	{
		Set set1 = new Set();
		Set set2 = new Set();
		set1.insert(new RealNumeric(3));
		set1.insert(new RealNumeric(5));
		set2.insert(new RealNumeric(5));
		set2.insert(new RealNumeric(4));
		assertEquals("{3,5,4}",set1.union(set2).toString());
	}
	
	@Test
	void intersect()
	{
		Set set1 = new Set();
		Set set2 = new Set();
		set1.insert(new RealNumeric(3));
		set1.insert(new RealNumeric(5));
		set2.insert(new RealNumeric(5));
		set2.insert(new RealNumeric(4));
		assertEquals("{5}",set1.intersect(set2).toString());
	}
	
	@Test
	void difference()
	{
		Set set1 = new Set();
		Set set2 = new Set();
		set1.insert(new RealNumeric(3));
		set1.insert(new RealNumeric(5));
		set2.insert(new RealNumeric(5));
		set2.insert(new RealNumeric(4));
		assertEquals("{3}",set1.difference(set2).toString());
		
	}
	
	@Test
	void power()
	{
		Set set =new Set();
		set.insert(new RealNumeric(1));
		set.insert(new RealNumeric(2));
		assertEquals("{{},{2},{1},{1,2}}",set.power().toString());
		
	}
	
	@Test
	void contains()
	{
		Set set =new Set();
		set.insert(new RealNumeric(1));
		set.insert(new RealNumeric(2));
		set.insert(new RealNumeric(3));
		Set setExpected = new Set();
		setExpected.insert(new RealNumeric(2));
		assertEquals(true,set.contains(setExpected));
	}
	
	@Test
	void member()
	{
		Set set =new Set();
		set.insert(new RealNumeric(1));
		set.insert(new RealNumeric(2));
		set.insert(new RealNumeric(3));
		set.insert(new RealNumeric(4));
		set.insert(new RealNumeric(5));
		set.insert(new RealNumeric(6));
		assertEquals(true,set.member(new RealNumeric(2)));
		assertEquals(false,set.member(new RealNumeric(9)));
	}
	
	@Test
	void deepExistence()
	{
		Set set = new Set();
		set.insert(new RealNumeric(1));
		set.insert(new RealNumeric(2));
		Set setInside = new Set();
		setInside.insert(new RealNumeric(4));
		set.insert(setInside);
		set.insert(new RealNumeric(3));
		assertEquals(true,set.deepExistence(new RealNumeric(4)));
		assertEquals(false,set.deepExistence(new RealNumeric(5)));
	}
	
	@Test
	void transformAdd()
	{
		Set set = new Set();
		set.insert(new RealNumeric(1));
		set.insert(new RealNumeric(2.5));
		set.insert(new RealNumeric(3));
		set.insert(new RationalNumeric(3,4));
		assertEquals("{3,4.5,5,2.75}",set.transformAdd(new RealNumeric(2)).toString());
		
	}
	
	@Test
	void transformMul()
	{
		Set set = new Set();
		set.insert(new RealNumeric(1));
		set.insert(new RealNumeric(2.5));
		set.insert(new RealNumeric(3));
		set.insert(new RationalNumeric(3,4));
		assertEquals("{2,5,6,1.5}",set.transformMul(new RealNumeric(2)).toString());
	}
	
}