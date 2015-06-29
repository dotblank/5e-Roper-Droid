package com.github.harverst.roper.model;

import java.lang.Comparable;

/**
 * A ScoreModifier uses a modifier function to change the value of a score
 *
 * Implements compareTo using a protected precedence variable to determine
 * the order that the modifiers will be applied.
 */
public abstract class ScoreModifier implements Comparable<ScoreModifier>
{
  /**
   * Used to determine the order in which the modifiers are applied.
   */
  protected int precedence;
  /**
   * Accepts the current value and returns the modified value.
   *
   * @param oldValue the unmodified value
   * @return the value after modification
   */
  public abstract int modify(int oldValue);
  public int compareTo(ScoreModifier o) {
    return precedence - o.precedence;
  }
}

