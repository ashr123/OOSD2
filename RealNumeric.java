public class RealNumeric implements Numeric
{
	private double num;
	
	public RealNumeric(double num)
	{
		this.num=num;
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
	
	public double getNum()
	{
		return num;
	}
	
	public void setNum(double num)
	{
		this.num=num;
	}
}