

/**
 * Scoring category for a "yahtzee". A hand with N dice satisfies this category only if all N values are the same. 
 * For a hand that satisfies this category, the score is a fixed value specified in the constructor; otherwise, the score is zero.
 * @author Saveri Pal
 *
 */
public class AllOfAKind extends XXXOfAKind
{
	/**
	 * Variable stores the fixed score input that is awarded when a hand satisfies this category criteria
	 */
	private int score;
	
    /**
     * Constructs an AllOfAKind with the given display name and score.
     * @param name category name
     * @param points fixed points to be awarded if satisfied
     */
	public AllOfAKind(String name, int points) 
	{
		super(name);
		score = points;
	}

	@Override
	/**
	 * Determines whether a given hand satisfies the criteria:
	 * A hand with N dice satisfies this category only if all N values are the same.
	 */
	public boolean isSatisfiedBy(Hand hand) 
	{
		
		int n = hand.getNumDice();
		int[] values = hand.getAllValues();
		
		return super.isFrequent(values, n);
	}
	
	@Override
	/**
	 * Returns the fixed score if a given hand satisfies the criteria
	 */
	public int getPotentialScore(Hand hand) 
	{
		int potScore = 0;
		boolean isSatisfied = isSatisfiedBy(hand);
		if(isSatisfied == true)
		{
			return score;
		}
		return potScore;
	}
	
	

}
