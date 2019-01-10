  package hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import hw4.api.Die;

/**
 * This class represents values of a group of dice for a dice game such as Yahtzee in which 
 * multiple rolls per turn are allowed. The number of faces on the dice, 
 * the number of dice in the Hand, and the maximum number of rolls are configurable 
 * via the constructor. At any time some of the dice may be <em>available</em>
 * to be rolled, and the other dice are <em>fixed</em>.  Calls to the 
 * <code>roll()</code> method roll the available
 * dice only.  After the maximum number of rolls, all dice are automatically
 * fixed; before that, the client can select which dice to "keep" (change from
 * available to fixed) and which dice to "free" (change from fixed to
 * available).
 * <p>
 * Note that valid die values range from 1 through the given
 * <code>maxValue</code>. 
 * 
 * @author Saveri Pal
 */
public class Hand
{
	/**
	 * Arraylist that stores all Dice in a given hand
	 */
	private ArrayList<Die> hand;
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
	 * number of times a die has been rolled in a round
	 */
	private int numRoll;
	
	
  /**
   * Constructs a new Hand in which each die initially has the value 1.
   * @param numDice number of dice in this group
   * @param maxValue
   *   largest possible die value, where values range from 1 through maxValue
   * @param maxRolls maximum number of total rolls
   */
  public Hand(int numDice, int maxValue, int maxRolls)
  {
	 hand = new ArrayList<Die>();
	 this.numDice = numDice;
	 maxVal = maxValue;
	 maxRoll = maxRolls;
	 numRoll = 0;
	 
	 for(int i=0; i<numDice; i++)
	 {
		 Die newDice = new Die(1,maxValue);
		 hand.add(newDice);
	 }
	  
  }   
  
  /**
   * Constructs a new Hand in which each die initially has 
   * the value given by the <code>initialValues</code> array.
   * If the length of the array is greater than the number of dice, the
   * extra values are ignored.  If the length of the array is smaller
   * than the number of dice, remaining dice
   * will be initialized to the value 1.
   * <p>
   * This version of the constructor is primarily intended for testing.
   * @param numDice number of dice in this hand
   * @param maxValue largest possible die value, where values range from 1 through <code>maxValue</code>
   * @param maxRolls maximum number of total rolls
   * @param initialValues initial values for the dice
   */
  public Hand(int numDice, int maxValue, int maxRolls, int[] initialValues)
  {
	  hand = new ArrayList<Die>();
	  this.numDice = numDice;
	  maxVal = maxValue;
	  maxRoll = maxRolls;
	  numRoll = 0;
		 
	  for(int i=0; i<numDice; i++)
	  {
	      if(i<initialValues.length)
	      {
	          Die newDice = new Die(initialValues[i],maxValue);
			  hand.add(newDice);
	      }
	             
	      else
	      {
	          Die newDice = new Die(1,maxValue);
		      hand.add(newDice); 
	      }
				 
	  }		 
  }  
  
  /**
   * Returns the number of dice in this hand.
   * @return number of dice in this hand
   */
  public int getNumDice()
  {
    return numDice;
  }
  
  /**
   * Returns the maximum die value in this hand.
   * Valid values start at 1.
   * @return maximum die value
   */
  public int getMaxValue()
  {
    return maxVal;
  }
  
  
  /**
   * Rolls all available dice using the given random number generator.
   * If the number of rolls has reached the maximum, all dice are
   * marked as fixed.
   * @param rand random number generator to be used for rolling dice
   */
  public void roll(Random rand)
  {
	  // Roll all available dice
	  for(int i=0; i<hand.size(); i++)
	  {
		  if(hand.get(i).isAvailable())
		  {
			  hand.get(i).roll(rand);
			  
		  }
	  }
	  numRoll +=1;
	  // If numRoll is maximum, mark all dice as fixed
	  if(numRoll==maxRoll)
	  {
		  for(int i=0; i<hand.size(); i++)
		  {
			  hand.get(i).setAvailable(false);
		  }  
	  }
	  
  }

  /**
   * Selects a single die value to be changed from the available dice to the
   * fixed dice. If there are multiple available dice with the given value, 
   * only one is changed to be fixed. Has no effect if the given value is 
   * not among the values in the available dice.  Has no effect if
   * the number of rolls has reached the maximum.
   * @param value
   *   die value to be changed from available to fixed
   */
  public void keep(int value)
  {
	  int val = value;
	  for(int i=0; i<hand.size(); i++)
	  {
		  // check if numRoll reached maximum
		  // find die with given value and available
	      if( numRoll<maxRoll && hand.get(i).value() == val && hand.get(i).isAvailable() == true)
		  {
			 hand.get(i).setAvailable(false);
			 // whether there are multiple available dice or single, changes only first one then break
			 break;
		  }
	  } 
  }

  /**
   * Selects a die value to be moved from the fixed dice to
   * the available dice (i.e. so it will be re-rolled in the
   * next call to <code>roll()</code>). If there are multiple fixed dice 
   * with the given value, only one is changed be available. 
   * Has no effect if the given value is 
   * not among the values in the fixed dice. Has no effect if
   * the number of rolls has reached the maximum.
   * @param value
   *   die value to be moved
   */
  public void free(int value)
  {
	  int val = value;
	  for(int i=0; i<hand.size(); i++)
	  {
		  // check if numRoll reached maximum
		  // find die with given value and not available
	      if( numRoll<maxRoll && hand.get(i).value() == val && hand.get(i).isAvailable() == false)
		  {
			 hand.get(i).setAvailable(true);
			// whether there are multiple available dice or single, changes only first one
			 break;
		  }
	  } 
  }
  
  /**
   * Causes all die values to be changed from available to fixed.
   * Has no effect if the number of rolls has reached the maximum.
   */
  public void keepAll()
  {
	  for(int i=0; i<hand.size(); i++)
	  {
	      if( numRoll<=maxRoll)
		  {
			 hand.get(i).setAvailable(false);
		  }
	  } 
  }
  
  
  /**
   * Causes all die values to be changed from fixed to available. 
   * Has no effect if the number of rolls has reached the maximum.
   */
  public void freeAll()
  {
	  for(int i=0; i<hand.size(); i++)
	  {
	      if( numRoll<maxRoll)
		  {
			 hand.get(i).setAvailable(true);
		  }
	  } 
  }
  
  /**
   * Determines whether there are any dice available to be 
   * rolled in this hand.
   * @return
   *   true if there are no available dice, false otherwise
   */
  public boolean isComplete()
  {

	  for(int i=0; i<hand.size(); i++)
	  {
		    // If atleast one die is available, then not complete
			if(hand.get(i).isAvailable() == true)
			{
				return false;
			}
	  } 
    return true;
  }

  /**
   * Gets an array of all fixed dice
   * @return an array of fixed dice
   */
  public Die[] getFixedDice()
  {
      ArrayList <Die> fixedArr = new ArrayList<>();
      // Deep copy all fixed dice in an Arraylist
	  for(int i=0; i<hand.size(); i++)
	  {
	      if(hand.get(i).isAvailable() == false)
		  {
	    	 Die d = new Die(hand.get(i));
			 fixedArr.add(d);
		  }
	  } 
	  
	  // Converting from ArrayList to Array
	  Die[] fixedDieArr = new Die[fixedArr.size()];
	  for(int i=0; i<fixedArr.size(); i++)
	  {
		  Die d = new Die(fixedArr.get(i));
		  fixedDieArr[i] = d;
	  }
	  
	DieComparator comp = new DieComparator();
	Arrays.sort(fixedDieArr,comp);
    return fixedDieArr;
  }

  /**
   * Gets an array of all available dice
   * @return an array of all available dice
   */
  public Die[] getAvailableDice()
  {
	  ArrayList <Die> availableArr = new ArrayList<>();
      // Deep copy all available dice in an Arraylist
	  for(int i=0; i<hand.size(); i++)
	  {
	      if(hand.get(i).isAvailable() == true)
		  {
	    	 Die d = new Die(hand.get(i));
	    	 availableArr.add(d);
		  }
	  } 
	  
	  // Converting from ArrayList to Array
	  Die[] availableDieArr = new Die[availableArr.size()];
	  for(int i=0; i<availableArr.size(); i++)
	  {
		  Die d = new Die(availableArr.get(i));
		  availableDieArr[i] = d;
	  }
	
	DieComparator comp = new DieComparator();
    Arrays.sort(availableDieArr,comp);
    return availableDieArr;
  }
  
 
  /**
   * Returns all die values in this hand, in ascending order.
   * @return
   *  an integer array all die values in this hand, arranged in ascending order
   */
  public int[] getAllValues()
  {
	  // Create an array of Die from Arraylist of Die 
	  Die[] dieArr = new Die[hand.size()];
	  for(int i=0; i<hand.size(); i++)
	  {
		  Die d = new Die(hand.get(i));
		  dieArr[i] = d;
	  }
	  
	  // Sort array of Die in ascending order
	  DieComparator comp = new DieComparator();
	  Arrays.sort(dieArr,comp);
	  
	  // Copy dice values in an array that is to be returned
	  int[] valArr = new int[dieArr.length];
	  for(int i=0; i<valArr.length; i++)
	  {
		  valArr[i] = dieArr[i].value();
	  }
	  
    return valArr;
  }
  
  /**
   * Returns an array of all the dice in this hand sorted in ascending order
   * @return
   *  Die array of all dice 
   */
  public Die[] getAllDice()
  {
	  // Create an array of Die from Arraylist of Die 
	  Die[] dieArr = new Die[hand.size()];
	  for(int i=0; i<hand.size(); i++)
	  {
		  Die d = new Die(hand.get(i));
		  dieArr[i] = d;
	  }
	  
	// Sort array of Die in ascending order
	  DieComparator comp = new DieComparator();
	  Arrays.sort(dieArr,comp);
      return dieArr;
  } 
    
}
