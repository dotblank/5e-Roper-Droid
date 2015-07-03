package com.github.harverst.roper.model.common;

public class DivisiveScoreComponent<P> extends BasicScoreComponent<P>
{
  private int divisor;
  public DivisiveScoreComponent(P aPhase, int aDivisor)
  {
    super(aPhase);
    divisor = aDivisor;
  }
  @Override
  public int composite(int oldValue)
  {
    // Will automatically round down due to typing
    return oldValue / divisor;
  }
}

