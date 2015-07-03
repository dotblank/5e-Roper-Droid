package com.github.harverst.roper.model;

/**
 * A ScoreComponent is combined with other score components to form a score.
 *
 * The parameter P is used by a PhaseOrder object to manage the order
 * in which the components are applied
 */
public interface ScoreComponent<P>
{
  /**
   * Used for implementation of Comparable.
   *
   * @return the phase during which the component is applied
   */
  public P getPhase();
  /**
   * Accepts the current score and returns the composited score.
   *
   * @param oldValue the score not including this component
   * @return the score after including this component
   */
  public int composite(int oldValue);
}

