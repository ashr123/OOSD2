/**
 * A rational number is a number {@link #a}/{@link #b}, where {@code b≠0}.
 */
public class RationalNumeric implements Numeric
{
	private int a, b;
	
	/**
	 * Constructs a rational number.
	 * @param a a nominator
	 * @param b a denominator
	 * @throws ArithmeticException if {@code b=0}
	 */
	RationalNumeric(int a, int b) throws ArithmeticException
	{
		if (b==0)
			throw new ArithmeticException("/ by zero");
		int g=gcd(a, b);
		this.a=a/g;
		this.b=b/g;
	}
	
	/**
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
	
	@Override
	public Numeric transformAdd(Numeric n)
	{
		if (n instanceof RationalNumeric)
		{
			int f=gcd(getA(), ((RationalNumeric)n).getA());
			int g=gcd(getB(), ((RationalNumeric)n).getB());
			RationalNumeric temp=new RationalNumeric((getA()/f)*(((RationalNumeric)n).getB()/g)+
			                                         (((RationalNumeric)n).getA()/f)*(getB()/g),
			                                         lcm(getB(), ((RationalNumeric)n).getB()));
			setA(temp.getA());
			setB(temp.getB());
		}
		else
			return new RealNumeric((double)getA()/getB()+((RealNumeric)n).getNum());
		if ((double)getA()/getB()>=1)
			return new RealNumeric((double)getA()/getB());
		return this;
	}
	
	@Override
	public Numeric transformMul(Numeric n)
	{
		if (n instanceof RationalNumeric)
		{
			RationalNumeric c=new RationalNumeric(getA(), ((RationalNumeric)n).getB());
			RationalNumeric d=new RationalNumeric(((RationalNumeric)n).getA(), getB());
			RationalNumeric temp=new RationalNumeric(c.getA()*d.getA(), c.getB()*d.getB());
			setA(temp.getA());
			setB(temp.getB());
		}
		else
			return new RealNumeric((double)getA()/getB()*((RealNumeric)n).getNum());
		if ((double)getA()/getB()>=1)
			return new RealNumeric((double)getA()/getB());
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
		return getA()/getB()<1 ? getA()+"/"+getB() : (isIntable() ? getA()/getB() : (double)getA()/getB())+"";
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof RationalNumeric)
			return (double)getA()/getB()==(double)((RationalNumeric)obj).getA()/((RationalNumeric)obj).getB();
		return obj instanceof RealNumeric && (double)getA()/getB()==((RealNumeric)obj).getNum();
	}
	
	private boolean isIntable()
	{
		return (double)getA()/getB()==getA()/getB();
	}
}