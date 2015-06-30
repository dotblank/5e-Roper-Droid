package com.github.harverst.roper.model;

import java.lang.Comparable;

/**
 * A ScoreModifier uses a modifier function to change the value of a score
 *
 * Implements compareTo using a protected precedence variable to determine
 * the order that the modifiers will be applied.
 */
public abstract class BasicScoreModifier implements ScoreModifier
{
  /**
   * The constructor sets the order in which the modifier is executed.
   */
  public BasicScoreModifier(int order) {
    precedenceNum = order;
  }
  /**
   * Used to determine the order in which the modifiers are applied.
   */
  protected int precedenceNum;
  /**
   * Accepts the current value and returns the modified value.
   *
   * @param oldValue the unmodified value
   * @return the value after modification
   */
  public abstract int modify(int oldValue);
  public int getPrecedence() {
    return precedenceNum;
  }
  /**
   * Implemented in accord with the definition of compareTo
   */
  public int compareTo(ScoreModifier o) {
    return precedenceNum - o.getPrecedence();
  }
}

