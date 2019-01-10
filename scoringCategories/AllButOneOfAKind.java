

/**
 * Scoring category for (N-1) of a kind. A hand with N dice satisfies this category only if 
 * at least N - 1 of the values are the same. For a hand that satisfies this category, 
 * the score the sum of all die values; otherwise the score is zero.
 * @author Saveri Pal
 *
 */
public class AllButOneOfAKind extends XXXOfAKind
{
	/**
	 * Constructs an AllButOneOfAKind category with the given display name.
	 * @param name Name of category
	 */
	public AllButOneOfAKind( java.lang.String name) 
	{
		super(name);		
	}
	
	@Override
	/**
	 * Determines whether the given hand satisfies the defined criteria for this 
	 * scoring category: This category is satisfied if N-1 all die values are same.
	 */
	public boolean isSatisfiedBy(Hand hand) 
	{
		int n = hand.getNumDice();
		int[] values = hand.getAllValues();
		
		return super.isFrequent(values, n-1);
	}		
}
