package hw4;

import java.util.ArrayList;

import hw4.api.ScoringCategory;

/**
 * @author Saveri Pal
 * -------------------------------------------- INHERITANCE HIERARCHY ---------------------------------------------------------
 * 
 * 1. Interface 'ScoringCategory' from hw4.api has implemented by an Abstract Class named
 *    AbstractScoringCategory.
 *    
 * 2. The abstract class, AbstractScoringCategory is further extended by two categories and an abstract class; 
 *    namely, CountOccurrences, Chance and XXStraights respectively.
 *    --> Reason:
 *       The major differences in the categories is the isSatisfiedBy() and getPotentialScore() methods. The three sub-classes
 *       are created to group the categories so that the duplication of code can be reduced.
 *       i) The abstract class XXStraight has a fixed scoring policy that is, if satisfied, the score is a fixed value determined
 *       by the user.
 *       ii) Chance has a scoring policy based on the summation of all the die values.
 *       iii) CountOccurrences has a scoring policy based on the number of a specific targetValues present in the hand
 *       So the above three classes are put in separate groups based on their scoring criteria
 *       These super classes have subclasses that utilize their methods and constructors.
 *       
 * 3. CountOccurrences category is extended by the FullHouse category.
 *    --> Reason:
 *        CountOccurrences has an additional method countNum (Hand hand, int targetVal), that counts the number of target die values
 *        in a hand. The FullHouse category has a satisfaction criteria that there must be two values N/2 times or N/2 + 1 times.
 *        FullHouse uses the countNum() method from its super class.
 *        
 * 4. XXStraights abstract class is extended by LargeStraight and SmallStraight.
 *    --> Reason:
 *        The abstract class contains countConsec(Hand hand) method that counts the number of cosecutive integers in an ascendingly sorted array
 *        LargeStraight and SmallStraight utilizes this method, which reduces a considerable amount of code duplication. Also the abstract super 
 *        class has a getPotentialScore() method that us utilized by both the subclasses.
 *        
 * 5. Chance class is extended by AllPrimes category and abstact class XXXOfAKind.
 *    --> Reason:
 *        This done to utilize the getPotentialScore() method of Chance, which calculates the summation of all die values in a hand.
 *        This class has three different category subclasses that benefit from its  getPotentialScore() method.
 *        
 * 6. The abstract class XXXOfAKind is extended by subclasses AllButOneOfAKind, AllButTwoOfAKind and AllOfAKind
 *    --> Reason:
 *        This abstract class has tailor made constructor, isSatisfiedBy() and getPotentialScore() that suits the subclasses.
 *        I was able to reduce a lot of duplication using this abstract class.
 *        
 * -------------------------------------------------------------------------------------------------------------------------------------------
 *       
 * Game state for a dice game such as Yahtzee. The game consists
 * of a list of <code>ScoringCategory</code> objects, each of which is responsible
 * for keeping track of the dice used to satisfy it and of its own 
 * contribution to the total score. Clients interact directly with the
 * category objects, which are obtained using method <code>getCategories()</code>.
 * The total score for the game may be obtained via the <code>getScore</code>
 * method.  This class also keeps track of several game
 * attributes: the number of dice being used in the game, the maximum
 * value (number of "sides") of the dice, and the number of times the
 * dice may be re-rolled in each round.
 *          
 */
public class DiceGame
{

	/**
	 * List to store all the scoring categories
	 */
	private ArrayList<ScoringCategory> catList;
	/**
	 * Number of dice in the game
	 */
	private int numDice;
	/**
	 * Maximum value of a dice; number of faces of a die in this hand
	 */
	private int maxVal;
	/**
	 * Max number of times the dice can be rolled
	 */
	private int maxRoll;
	/**
	 * Score of the game; summation of scores from all categories
	 */
	private int gameScore;
  
  /**
   * Constructs a new DiceGame based on the given parameters. Initially the list of categories is empty.
   * @param numDice
   *   number of dice used in this game
   * @param maxDieValue
   *   maximum face value (number of faces) for each die
   * @param numRolls
   *   number of times the dice can be rolled in each round
   */
  public DiceGame(int numDice, int maxDieValue, int numRolls) 
  {
	  catList = new ArrayList<ScoringCategory>();
	  this.numDice = numDice;
	  maxVal = maxDieValue;
	  maxRoll = numRolls;
	  gameScore = 0;
  }
  
  /**
   * Adds a scoring category to this game.
   * @param category
   *   scoring category to add
   */
  public void addCategory(ScoringCategory category)
  {
    catList.add(category);
    gameScore = gameScore + category.getScore();
  }
  
  
  /**
   * Returns the list of categories in this game.
   * @return
   *   list of categories 
   */
  public ArrayList<ScoringCategory> getCategories()
  {
    return catList;
  }
  
  /**
   * Returns a new Hand corresponding to the number of dice,
   * maximum die value, and number of rolls for this game.
   * Initially all dice in the hand are available to be rolled.
   * @return
   *   new Hand based on this game's parameters
   */
  public Hand createNewHand()
  {
    Hand hand = new Hand(numDice, maxVal, maxRoll);
    return hand;
  }
  
  /**
   * Returns the current total score for all categories.
   * @return
   *   total score for all categories
   */
  public int getScore()
  {
    return gameScore;
  }

}
