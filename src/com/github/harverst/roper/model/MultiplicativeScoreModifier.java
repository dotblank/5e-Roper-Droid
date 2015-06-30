package com.github.harverst.roper.model;

class MultiplicativeScoreModifier extends BasicScoreModifier
{
  private int multiplier;
  public MultiplicativeScoreModifier(int aMultiplier, int precedence)
  {
    super(precedence);
    multiplier = aMultiplier;
  }
  @Override
  public int modify(int oldValue)
  {
    return oldValue * multiplier;
  }
}

