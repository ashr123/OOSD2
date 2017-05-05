public class RationalNumeric implements Numeric
{
	private int a, b;
	
	RationalNumeric(int a, int b) throws ArithmeticException
	{
		if (b==0)
			throw new ArithmeticException("/ by zero");
		int g=gcd(a, b);
		this.a=a/g;
		this.b=b/g;
	}
	
	@Override
	public Numeric transformAdd(Numeric n)
	{
		if (n instanceof RationalNumeric)
		{
			int f=gcd(getA(), ((RationalNumeric)n).getA());
			int g=gcd(getB(), ((RationalNumeric)n).getB());
			setA((getA()/f)*(((RationalNumeric)n).getB()/g)+(((RationalNumeric)n).getA()/f)*(getB()/g));
			setB(lcm(getB(), ((RationalNumeric)n).getB()));
		}
		else
			return new RealNumeric((double)getA()/getB()+((RealNumeric)n).getNum());
		return this;
	}
	
	@Override
	public Numeric transformMul(Numeric n)
	{
		if (n instanceof RationalNumeric)
		{
			RationalNumeric c=new RationalNumeric(getA(), ((RationalNumeric)n).getB());
			RationalNumeric d=new RationalNumeric(((RationalNumeric)n).getA(), getB());
			setA(c.getA()*d.getA());
			setB(c.getB()*d.getB());
		}
		else
			return new RealNumeric((double)getA()/getB()*((RealNumeric)n).getNum());
		return this;
	}
	
	int getA()
	{
		return a;
	}
	
	private void setA(int a)
	{
		this.a=a;
	}
	
	int getB()
	{
		return b;
	}
	
	private void setB(int b)
	{
		this.b=b;
	}
	
	@Override
	public String toString()
	{
		return getA()/getB()<1 ? getA()+"/"+getB() : (isInteble()? getA()/getB() :(double)getA()/getB())+"";
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof RationalNumeric)
			return (double)getA()/getB()==(double)((RationalNumeric)obj).getA()/((RationalNumeric)obj).getB();
		return obj instanceof RealNumeric && (double)getA()/getB()==((RealNumeric)obj).getNum();
	}
	
	private boolean isInteble()
	{
		return (double)getA()/getB()==getA()/getB();
	}
	
	/**
	 *
	 * @param m first number
	 * @param n second number
	 * @return greatest common divider
	 */
	private static int gcd(int m, int n)
	{
		if (m<0)
			m=-m;
		if (n<0)
			n=-n;
		if (0==n)
			return m;
		else return gcd(n, m%n);
	}
	
	/**
	 * @param m first number
	 * @param n second number
	 * @return lowest common multiplier
	 */
	private static int lcm(int m, int n)
	{
		if (m<0)
			m=-m;
		if (n<0)
			n=-n;
		return m*(n/gcd(m, n));// parentheses important to avoid overflow
	}
}