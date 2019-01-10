

import api.ScoringCategory;

/**
 * An abstract class that implements the ScoringCategory interface. Methods that are common to most
 * subclasses are implemented here. The isSatisfiedBy and getPotentialScore methods are left abstract
 * @author Saveri Pal
 *
 */
public abstract class AbstractScoringCategory implements ScoringCategory
{

	/**
	 * Name of category
	 */
	private String catName;
	/**
	 * Score awarded for this category
	 */
	private int catScore;
	/**
	 * hand used to fill this category
	 */
	private Hand catHand;
	/**
	 * Determines if a category has been filled by a hand or not
	 */
	private boolean isCatFilled;
	
 /**
  * Constructs a category with the given name
  * @param name name of a category
  */
	protected AbstractScoringCategory(java.lang.String name)	
    {
		catName = name;
		catScore = 0;
    }
	
   
	/**
	 * Gets the name of the category
	 */
	public String getDisplayName() 
    {
	    return catName;	
    }
 
  
	/**
	 * Abstract method that defines if a given hand satisfies a category
	 */
	public abstract boolean isSatisfiedBy(Hand hand);
  
  
	/**
	 * Abstract method that defines the potential score of a category for a given hand
	 */
	public abstract int getPotentialScore(Hand hand);
  
  
	/**
	 * Permanently sets the hand being used to fill this category. The score is set to the value 
	 * of getPotentialScore for the given hand. Throws IllegalStateException if the category has 
	 * already been filled or if the given hand is not complete (as defined by the Hand.isComplete method).
	 */
	public void fill(Hand hand) throws IllegalStateException 
    {
		
		boolean complt = hand.isComplete();
		if(isFilled() || complt == false)
		{
			throw new IllegalStateException();
		}
		// Permanently setting the given hand to fill category
		catHand = hand;
	    //catHand = new Hand(hand.getNumDice(), hand.getMaxValue(), hand.getMaxRoll(), hand.getAllValues());
	    // Setting flag to category filled
	    isCatFilled = true;	
		// Update category score (= potential score)
		catScore = getPotentialScore(hand);
		
    }
  
  
	/**
	 * Determines whether this category is filled.
	 * true if this category has been permanently filled, false otherwise
	 */
	public boolean isFilled()
    {
		return isCatFilled;
    }
  
  
	/**
	 * If the category has been filled, returns the score for the permanently 
	 * saved hand that was used to fill it; otherwise returns 0.
	 * returns score for the category or zero if not filled
	 */
	public int getScore() 
    {		
		return catScore;
    }
  
  
	/**
	 * Returns the Hand that was used to fill this category, or null if not filled.
	 */
	public Hand getHand() 
    {
		return catHand;
    }


  
  
  
  
}
