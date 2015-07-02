package com.github.harverst.roper.model;

public interface ScoreComponent extends Comparable<ScoreComponent>
{
  /**
   * Used for implementation of Comparable.
   *
   * @return precedence 
   *
   * precedence must be implemented such that the components that are applied
   * earlier return a higher precedence than components applied later. Two
   * components with the same precedence cannot exist in the same list.
   *
   * When compareTo is implemented the resulting order should place the 
   * components with high precedence first and the components with low
   * precedence last.
   */
  public int getPrecedence();
  /**
   * Accepts the current score and returns the composited score.
   *
   * @param oldValue the score not including this component
   * @return the score after including this component
   */
  public int composite(int oldValue);
}

