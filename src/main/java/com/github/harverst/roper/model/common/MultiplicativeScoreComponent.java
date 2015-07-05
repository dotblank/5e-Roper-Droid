package com.github.harverst.roper.model.common;

public class MultiplicativeScoreComponent<P> extends BasicScoreComponent<P>
{
  private int multiplier;
  public MultiplicativeScoreComponent(P aPhase, int aMultiplier)
  {
    super(aPhase);
    multiplier = aMultiplier;
  }
  @Override
  public int composite(int oldValue)
  {
    return oldValue * multiplier;
  }
}

