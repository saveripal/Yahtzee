

/**
 * Abstract class that extends the class Chance.
 * A hand with N dice satisfies this category only if 
 * at least N-x of the values are the same. Where x is variable based on the scoring category that
 * extend this class. For a hand that satisfies this category, 
 * the score the sum of all die values; otherwise the score is zero.
 * @author Saveri Pal
 *
 */
public abstract class XXXOfAKind extends Chance
{
	/**
	 * Constructs a scoring category with the given name.
	 * @param name category name
	 */
	protected XXXOfAKind(String name) 
	{
		super(name);	
	}

	@Override
	/**
	 * Determines whether the given hand satisfies the defined criteria for this 
	 * scoring category: This category is satisfied if N-1 all die values are same.
	 */
	public abstract boolean isSatisfiedBy(Hand hand) ;

	
	/**
	 * Gets the potential score for this hand which is,
	 * the sum of all values of die if satisfies condition
	 */
	public int getPotentialScore(Hand hand) 
	{
		int potScore = 0;
		boolean isSatisfied = isSatisfiedBy(hand);
		if(isSatisfied == true)
		{
			potScore = super.getPotentialScore(hand);		
			
		}
		return potScore;
	}
	
	/**
	 * Checks whether any number in the given array occurs 'num'-times
	 * The method checks if two consecutive values in an ascending array are same or not
	 * If same, it increments the count by 1. If not, resets count to 1.
	 * @param values int[] array
	 * @param num no. of time an element should occur
	 * @return true if any element of the int[] occurs 'num'-times, otherwise returns false
	 */
	protected boolean isFrequent(int[] values, int num)
	{
		int count = 1;
		for(int i=0; i<values.length-1; i++)
		{
				count = (values[i] == values[i+1])? count+1: 1;
				if (count == (num))
				{
					return true;
				}
		}
		
		return false;
	}
	
}
