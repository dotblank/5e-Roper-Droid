package com.github.harverst.roper.model;

/**
 * Scores are values composed of ScoreComponents.
 */
public interface Score<P>
{
  /**
   * Accesses the value of the score with all components applied.
   *
   * @return the integer value of the score
   */
  public int getValue(PhaseOrder<P> ordering);
  /**
   * Adds the provided component to this score.
   *
   * @param mod a component for this score
   */
  public void addComponent(ScoreComponent<P> component);
  /**
   * Removes the component given it was previously added.
   *
   * @param mod a component previously added to this score
   */
  public void removeComponent(ScoreComponent<P> component);
}

