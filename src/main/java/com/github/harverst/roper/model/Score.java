package com.github.harverst.roper.model;

interface Score
{
  /**
   * Accesses the value of the score with all components applied.
   *
   * @return the integer value of the score
   */
  public int getValue();
  /**
   * Adds the provided component to this score.
   *
   * @param mod a component for this score
   */
  public void addComponent(ScoreComponent mod);
  /**
   * Removes the component given it was previously added.
   *
   * @param mod a component previously added to this score
   */
  public void removeComponent(ScoreComponent mod);
}

