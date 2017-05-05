public class RealNumeric implements Numeric
{
	private double num;
	
	public RealNumeric(double num)
	{
		this.num=num;
	}
	
<<<<<<< Updated upstream
=======
	public double getNum()
	{
		return num;
	}
	
	public void setNum(double num)
	{
		this.num=num;
	}
	
>>>>>>> Stashed changes
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
	
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof RealNumeric)
			return num == ((RealNumeric)obj).getNum();
		if (obj instanceof RationalNumeric)
			return num == obj.g
		return super.equals(obj);
	}
	
	public double getNum()
	{
		return num;
	}
	
	public void setNum(double num)
	{
		this.num=num;
	}
}