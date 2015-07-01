package com.github.harverst.roper.model;

import com.github.harverst.roper.model.ScoreModifier;

interface Score
{
  /**
   * Accesses the value of the score with all modifiers applied.
   *
   * @return the integer value of the score
   */
  public int getValue();
  /**
   * Adds the provided modifier to this score.
   *
   * @param mod a modifier for this score
   */
  public void addModifier(ScoreModifier mod);
  /**
   * Removes the modifier given it was previously added.
   *
   * @param mod a modifier previously added to this score
   */
  public void removeModifier(ScoreModifier mod);
}

