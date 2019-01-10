

/**
 * Scoring category for all primes. 
 * A hand satisfies this category only if all die values are prime numbers. 
 * For a hand that satisfies this category, the score the sum of all die values; 
 * otherwise the score is zero. The display name for this category is always the
 * exact string "All Primes".
 * @author Saveri Pal
 *
 */
public class AllPrimes extends Chance
{

  /**
   * Constructs a scoring category with the name "All Primes"
   */
	public AllPrimes()
    {
	    super("All Primes");
    }
	
	@Override
	/**
	 * Determines whether the given hand satisfies the defined criteria for this 
	 * scoring category: This category is satisfied if all die values are Prime.
	 */
	public boolean isSatisfiedBy(Hand hand) 
	{
		int[] values = hand.getAllValues();
		for(int i=0; i<values.length; i++)
		{
			int val = values[i];
			if(isPrime(val) == false)
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	/**
	 * Gets the potential score for this hand which is,
	 * the sum of all values of die (all values are Prime)
	 */
	public int getPotentialScore(Hand hand) 
	{	
		int potScore = super.getPotentialScore(hand);		
		return potScore;
	}
	
	/**
	 * Finds out if the given number is Prime
	 * @param number a number which will be checked if its a prime or not
	 * @return true if number is prime, false otherwise
	 */
	private boolean isPrime(int number)
	{
		int sqrt = (int) Math.sqrt(number) + 1; 
		for (int i = 2; i < sqrt; i++) 
		{ 
			if (number % i == 0) 
			{ 
				// number is perfectly divisible - no prime 
				return false; 
			} 
		}
		
		return true;
	}


			
	
  



}
