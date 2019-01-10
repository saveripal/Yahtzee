

import api.Die;

/**
 * Scoring category that is based on counting occurrences of a particular target value 
 * (specified in the constructor). This category is satisfied by any hand. The score is 
 * the sum of just the die values that match the target value.
 * @author Saveri
 *
 */
public class CountOccurrences extends AbstractScoringCategory
{
	/**
	 * the value whose number of occurrences is to be counted
	 */
	private int targetVal;

	
	/**
	 * Constructs a CountOccurrences category with the given display name and target value.
	 * @param name category name
	 * @param number target value whose no. of occurrences to be counted
	 */
	public CountOccurrences(java.lang.String name, int number)
	{
		super(name);
		targetVal = number;
	}
	
	/**
	 * Constructs a CountOccurrences category with the given display name
	 * @param name category name
	 */
	protected CountOccurrences(java.lang.String name)
	{
		super(name);
	}
	
	
	/**
	 *
	 * Determines whether the given hand satisfies the defined criteria for this scoring category.
	 *  The criteria are determined by the concrete type implementing the interface. This method 
	 *  does not modify the state of this category and does not modify the hand.
	 */
	public boolean isSatisfiedBy(Hand hand) {
		
		int count = countNum(hand, targetVal);
		boolean satisfied = (count != 0)? true: false;
		return satisfied;
	}

	
	/**
	 * 
	 * Returns the potential score that would result from using the given hand to fill this 
	 * category. Always returns zero if the isSatisfiedBy() method returns false for the given
	 * hand. This method does not modify the state of this category and does not modify the hand.
	 */
	public int getPotentialScore(Hand hand) {
		
		int potScore = 0;
		boolean isSatisfied = isSatisfiedBy(hand);
		if(isSatisfied == true)
		{
			int count = countNum(hand, targetVal);
			potScore = targetVal*count;
		}

		return potScore;
	}
	
	/**
	 * Counts the number of occurrences of the target value
	 * @param hand a given hand
	 * @return count of target value occurences
	 */
	protected int countNum (Hand hand, int targetVal)
	{
		int target = targetVal;
		int count = 0;
		Die[] currHand = hand.getAllDice();
		for(int i=0; i<currHand.length; i++)
		{
			if(currHand[i].value() == target)
			{
				count +=1;
			}
		}
		
		return count;
	}


	
	

}
