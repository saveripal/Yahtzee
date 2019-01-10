

/**
 * Scoring category for a generalized full house.
 * A hand with N dice satisfies this category only in the following cases: 
 * If N is even, there are two different values, each occurring exactly N/2 times. 
 * If N is odd, there are two different values, one of them occurring N/2 times and 
 * the other occurring N/2 + 1 times. For a hand that satisfies this category, the 
 * score is a fixed value specified in the constructor; otherwise, the score is zero.
 * @author Saveri Pal
 *
 */
public class FullHouse extends CountOccurrences 
{

	/**
	 * Fixed score that is to be awarded if a given hand satisfies criteria
	 */
	private int score;
	
	/**
	 * Constructs a FullHouse category with the given display name and score.
	 * @param name category name
	 * @param points points to be awarded if given hand satisfies criteria
	 */
	public FullHouse(java.lang.String name, int points) 
	{
		super(name);
		score = points;
	}

	@Override
	/**
	 * Determines whether the given hand satisfies the defined criteria for this scoring category.
	 * This method does not modify the state of this category and does not modify the hand.
	 */
	public boolean isSatisfiedBy(Hand hand) 
	{
		int n = hand.getNumDice();
		int[] values = hand.getAllValues();
		boolean result = false;

		    // Counts the number of dice with same values using the superclass countNum method
			int firstCount = super.countNum(hand, values[0]);
			int secondCount = super.countNum(hand, values[n-1]);
			// Even
			if(n%2 == 0)
			{
				result = (firstCount == n/2 && secondCount == n/2);
			}
			
			// Odd
			if(n%2 == 1)
			{
				result = ((firstCount == n/2 && secondCount == n/2 +1) || (firstCount == n/2 +1 && secondCount == n/2));
			}
		return result;
	}
	
	@Override
	/**
	 * Returns the fixed score that would result from using the given hand to fill this category. 
	 * Always returns zero if the isSatisfiedBy() method returns false for the given hand. This method 
	 * does not modify the state of this category and does not modify the hand.
	 */
	public int getPotentialScore(Hand hand) 
	{
		int potScore = 0;
		boolean isSatisfied = isSatisfiedBy(hand);
		if(isSatisfied == true)
		{
			potScore = score; 
		}
		return potScore;
	}

}
