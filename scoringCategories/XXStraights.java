

/**
 * An abstract class that extends another abstract class. 
 * The isSatisfiedBy method is declared abstract as the subclasses, LargeStraight and SmallStraight has 
 * similar but different cariteria
 * @author Saveri Pal
 *
 */
public abstract class XXStraights extends AbstractScoringCategory
{

	/**
	 * Fixed score that is to be awarded if a given hand satisfies criteria
	 */
    int score;
	
	/**
	 * Constructor that constructs a category with a category name and fixed points that
	 * would be awarded if the hand satisfies the criteria
	 * @param name Name of category
	 * @param points Points to be awarded if critea satisfied
	 */
	protected XXStraights(java.lang.String name, int points)
	{
		super(name);
		score = points;
	}

	/**
	 * Abstract method: Determines whether the given hand satisfies the defined criteria for this scoring category.
	 * This method does not modify the state of this category and does not modify the hand.
	 */
	public abstract boolean isSatisfiedBy(Hand hand);

	/**
	 * Returns a fixed potential score as input in the constructor
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

	/**
	 * counts the number of cosecutive integers in an ascendingly sorted array
	 * Compares values in two consecutive indices and
	 * increments the count by 1 if integers are consecutive. If not, resets count to 1.
	 * @param hand given hand
	 * @return count of the number of consecutive integers
	 */
	protected int countConsec(Hand hand)
	{
		
		int[] values = hand.getAllValues();
		int count = 1;
		for(int i=0; i<values.length-1; i++)
		{
				count = (values[i+1] == values[i] + 1)? count+1: count; 
		}
		return count;
	}
	
	
}
