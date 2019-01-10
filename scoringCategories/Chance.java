

/**
 * A Scoring category that is satisfied by any hand. The score is the sum of all die values.
 * @author Saveri Pal
 *
 */
public class Chance extends AbstractScoringCategory
{

	/**
	 * Constructs a Chance category with the given display name.
	 * @param name category name
	 */
	public Chance(java.lang.String name)
	{
		super(name);	
	}
	
	
	/**
	 * Determines whether the given hand satisfies the defined criteria for this 
	 * scoring category: This category is satisfied by any hand.
	 */
	public boolean isSatisfiedBy(Hand hand) {

		return true;
	}


	/**
	 * Gets the potential score for this hand which is,
	 * the sum of the values of all die
	 */
	public int getPotentialScore(Hand hand) 
	{
		// Local variable that stores potential score
		int potScore = 0;
		boolean isSatisfied = isSatisfiedBy(hand);
		if(isSatisfied == true)
		{
			int[] val = hand.getAllValues();
			
			for(int i=0; i<val.length; i++)
			{
				potScore = potScore + val[i];
			}
		}
		
		return potScore;
	}
	
}
