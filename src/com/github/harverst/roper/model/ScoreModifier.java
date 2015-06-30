package com.github.harverst.roper.model;

public interface ScoreModifier extends Comparable<ScoreModifier>
{
  /**
   * Used for implementation of Comparable.
   * 
   * @return 
   * 
   * precedence must be implemented such that the modifiers that are applied 
   * earlier return a higher precedence than modifiers applied later. The order
   * of modifiers that return the same value is undefined.
   */
  public int precedence();
  /**
   * Accepts the current score and returns the modified score.
   * 
   * @param oldValue the unmodified score
   * @return the score after modification
   */
  public int modify(int oldValue);
}

