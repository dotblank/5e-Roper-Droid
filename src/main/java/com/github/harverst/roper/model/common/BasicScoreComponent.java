package com.github.harverst.roper.model.common;

import com.github.harverst.roper.model.ScoreComponent;
import java.lang.Comparable;

/**
 * A ScoreComponent uses a component function to change the value of a score
 *
 * Implements compareTo using a protected precedence variable to determine
 * the order that the components will be applied.
 */
public abstract class BasicScoreComponent<P> implements ScoreComponent<P>
{
  /**
   * Used to determine the order in which the components are applied.
   */
  protected P phase;
  /**
   * The constructor sets the phase of the component.
   */
  public BasicScoreComponent(P aPhase)
  {
    phase = aPhase;
  }
  /**
   * Accepts the current value and returns the modified value.
   *
   * @param oldValue the value without this component
   * @return the value including this component
   */
  public abstract int composite(int oldValue);
  public P getPhase()
  {
    return phase;
  }
}

