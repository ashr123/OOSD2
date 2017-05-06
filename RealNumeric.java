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
		return (isInteble() ? (int)getNum() : getNum())+"";
	}
	
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof Numeric && obj.equals(this);
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
	private boolean isInteble()
	{
		return getNum()==(int)getNum();
	}
}