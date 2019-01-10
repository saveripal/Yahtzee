package hw4;

import java.util.Comparator;

import hw4.api.Die;

/**
 * Comparator for ordering Die objects. Dice are ordered first
 * by value; dice with the same value are ordered by their max value, and dice
 * with the same value and the same max value are ordered by whether they are
 * available, with available dice preceding non-available dice.
 * 
 * Orders in ascending order
 * @author Saveri Pal
 */
public class DieComparator implements Comparator<Die>
{
  @Override
  /**
   * Compares two dies according to the given ordering specification.
   * First checks for the value in each die, if they have different values, returns their difference
   * If they have same values, it proceeds to the next step of comparison, checks the max value of each die
   * If the max value is different, returns their difference else proceeds to the third level of comparison
   * In the third level, it compares the avalability of a die. Available die precedes non-available dice.
   * If all criteria is same, returns zero
   */
  public int compare(Die left, Die right)
  {
	  /**
	   * Value of a die
	   */
	  int val;
	  /**
	   * maximum value of a die
	   */
	  int maxVal;
	  
	  // Level 1 comparison
	  val = left.value() - right.value();
	  if(val != 0)
	  {
		  return val;
	  }
	  
	  // Level 2 comparison
	  maxVal = left.maxValue() - right.maxValue();
	  if(maxVal != 0)
	  {
		  return maxVal;
	  }
	  
	  // Level 3 comparison
	  if(val==0 && maxVal==0)
	  {

			  if(left.isAvailable() == true && right.isAvailable()== false)
			  {
				  return -1;
			  }
			  else if (left.isAvailable() == false && right.isAvailable() == true)
			  {
				  return 1;
			  }
	  }
	  
	  return 0;   
 
  }
  
}
