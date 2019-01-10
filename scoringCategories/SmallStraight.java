package hw4;

/**
 * Scoring category for a "small straight". A hand with N dice satisfies this category only if
 * there are N-1 distinct consecutive values. For a hand that satisfies this category, the score
 * is a fixed value specified in the constructor; otherwise, the score is zero.
 * @author Saveri Pal
 *
 */
public class SmallStraight extends XXStraights
{
	/**
	 * Constructs a SmallStraight category with the given display name and score.
	 * 
	 * @param name name of this category
	 * @param points points awarded for a dice group that satisfies this category
	 */
	public SmallStraight(java.lang.String name, int points) 
	{
		super(name, points);
	}

	@Override
	/**
	 * Determines if a given hand contains N-1 consecutive values
	 */
	public boolean isSatisfiedBy(Hand hand) 
	{
		// number of dice in the given hand
		int n = hand.getNumDice();
		int count = countConsec(hand);
		if (count == (n-1))
		{
			return true;
		}
	    return false;
	}

}
