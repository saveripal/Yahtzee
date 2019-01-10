package hw4;

/**
 * Scoring category for a "large straight". A hand with N dice satisfies this category only if
 * there are N distinct consecutive values. For a hand that satisfies this category, the score
 * is a fixed value specified in the constructor; otherwise, the score is zero.
 * 
 * @author Saveri Pal
 *
 */
public class LargeStraight extends XXStraights
{

	/**
	 * 
	 * Constructs a LargeStraight category with the given display name and score.
	 * @param name category name
	 * @param points points to be awarded if given hand satisfies criteria
	 */
	public LargeStraight(java.lang.String name, int points) 
	{
		super(name, points);
	}

	@Override
	/**
	 * Determines if a given hand contains N consecutive values
	 */
	public boolean isSatisfiedBy(Hand hand) 
	{
		// number if dice an the given hand
		int n = hand.getNumDice();
		int count = countConsec(hand);
		if (count == (n))
		{
			return true;
		}
	    return false;
	}


}
