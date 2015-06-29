package com.github.harverst.roper.model;

import com.github.harverst.roper.model.Score;
import java.util.SortedSet;

class BasicScore implements Score
{
  private int baseValue;
  //private SortedSet modifiers;
  public BasicScore() {
    //modifiers = ConcurrentSkip;
  }
  public int getValue() {
    return 0;
  }
  /**
   * Precedence is 0 for most cases
   */
  public int precedence() {
    return 0;
  }

  public void removeModifier(ScoreModifier mod) {

  }
  public void addModifier(ScoreModifier mod) {

  }
}

