/**
 * Represents a real number {@link #num}.
 */
public class RealNumeric implements Numeric
{
	private double num;
	
	/**
	 * Creates a new real number.
	 * @param num the number to be created.
	 */
	RealNumeric(double num)
	{
		this.num=num;
	}
	
	@Override
	public Numeric transformAdd(Numeric n)
	{
		if (n instanceof RationalNumeric)
			setNum(getNum()+(double)((RationalNumeric)n).getA()/((RationalNumeric)n).getB());
		else
			setNum(getNum()+((RealNumeric)n).getNum());
		return this;
	}
	
	@Override
	public Numeric transformMul(Numeric n)
	{
		if (n instanceof RationalNumeric)
			setNum(getNum()*(double)((RationalNumeric)n).getA()/((RationalNumeric)n).getB());
		else
			setNum(getNum()*((RealNumeric)n).getNum());
		return this;
	}
	
	@Override
	public String toString()
	{
		return isIntable() ? (int)getNum()+"" : getNum()+"";
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof RealNumeric)
			return getNum()==((RealNumeric)obj).getNum();
		return obj instanceof RationalNumeric &&
		       getNum()==(double)((RationalNumeric)obj).getA()/((RationalNumeric)obj).getB();
	}
	
	double getNum()
	{
		return num;
	}
	
	private void setNum(double num)
	{
		this.num=num;
	}
	
	/**
	 * @return {@code true} if this number can be convert to integer without loss of information, {@code false} otherwise.
	 */
	private boolean isIntable()
	{
		return getNum()==(int)getNum();
	}
}