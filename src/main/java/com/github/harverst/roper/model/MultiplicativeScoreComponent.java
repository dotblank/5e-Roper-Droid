package com.github.harverst.roper.model;

class MultiplicativeScoreComponent extends BasicScoreComponent
{
  private int multiplier;
  public MultiplicativeScoreComponent(int aMultiplier, int precedence)
  {
    super(precedence);
    multiplier = aMultiplier;
  }
  @Override
  public int composite(int oldValue)
  {
    return oldValue * multiplier;
  }
}

