package com.github.harverst.roper.model;

public interface ScoreModifier extends Comparable<ScoreModifier>
{
  /**
   * Used for implementation of Comparable.
   *
   * @return precedence 
   *
   * precedence must be implemented such that the modifiers that are applied
   * earlier return a higher precedence than modifiers applied later. Two
   * modifiers with the same precedence cannot exist in the same list.
   *
   * When compareTo is implemented the resulting order should place the 
   * modifiers with high precedence first and the modifiers with low
   * precedence last.
   */
  public int getPrecedence();
  /**
   * Accepts the current score and returns the modified score.
   *
   * @param oldValue the unmodified score
   * @return the score after modification
   */
  public int modify(int oldValue);
}

