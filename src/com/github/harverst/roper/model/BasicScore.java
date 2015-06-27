package com.github.harverst.roper.model;

import com.github.harverst.roper.model.Score;
import java.util.SortedSet;

class BasicScore implements Score 
{
  private int baseValue;
  private SortedSet modifiers;
  public BasicScore() {
    modifiers = ConcurrentSkip
  }
  public int getValue() {
  }
  /**
   * Precedence is 0 for most cases
   */
  public int precedence() {
    return 0;
  }
}

