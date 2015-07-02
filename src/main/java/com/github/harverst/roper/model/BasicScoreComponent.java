package com.github.harverst.roper.model;

import java.lang.Comparable;

/**
 * A ScoreComponent uses a component function to change the value of a score
 *
 * Implements compareTo using a protected precedence variable to determine
 * the order that the components will be applied.
 */
public abstract class BasicScoreComponent implements ScoreComponent
{
  /**
   * The constructor sets the order in which the component is executed.
   */
  public BasicScoreComponent(int order)
  {
    precedenceNum = order;
  }
  /**
   * Used to determine the order in which the components are applied.
   */
  protected int precedenceNum;
  /**
   * Accepts the current value and returns the modified value.
   *
   * @param oldValue the value without this component
   * @return the value including this component
   */
  public abstract int composite(int oldValue);
  public int getPrecedence()
  {
    return precedenceNum;
  }
  /**
   * Implemented in accord with the definition of compareTo.
   *
   * @return The difference in precedence
   */
  public int compareTo(ScoreComponent o)
  {
    return o.getPrecedence() - precedenceNum;
  }
}

