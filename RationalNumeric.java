public class RationalNumeric implements Numeric
{
	private int a, b;
	
	public RationalNumeric(int a, int b)
	{
		this.a=a;
		this.b=b;
	}
	
	@Override
	public Numeric transformAdd(Numeric n)
	{
		return null;
	}
	
	@Override
	public Numeric transformMul(Numeric n)
	{
		return null;
	}
	
	public int getA()
	{
		return a;
	}
	
	public void setA(int a)
	{
		this.a=a;
	}
	
	public int getB()
	{
		return b;
	}
	
	public void setB(int b)
	{
		this.b=b;
	}
	
	@Override
	public String toString()
	{
		
		return getA()/getB()<1 ? getA()+"/"+getB() : (isInteble()? getA()/getB()+"" :(double)getA()/getB()+"");
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof RationalNumeric)
			return (double)getA()/getB()==(double)((RationalNumeric)obj).getA()/((RationalNumeric)obj).getB();
			if (obj instanceof RealNumeric)
				return getA()/getB()==
		return (obj instanceof Numeric) && true;
	}
	
	private boolean isInteble()
	{
		return (double)getA()/getB()==getA()/getB();
	}
}