public interface Numeric extends Element
{
	/**
	 * Adds a given {@link Numeric} number this number.
	 * @param n the number to be added.
	 * @return this {@link Numeric}
	 */
	Numeric transformAdd(Numeric n);
	
	/**
	 * Multiples a given {@link Numeric} number this number.
	 * @param n the number to be multiplied.
	 * @return this {@link Numeric}
	 */
	Numeric transformMul(Numeric n);
}
