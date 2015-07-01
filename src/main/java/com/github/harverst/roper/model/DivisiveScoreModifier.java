package com.github.harverst.roper.model;

public class DivisiveScoreModifier extends BasicScoreModifier
{
  private int divisor;
  public DivisiveScoreModifier(int aDivisor, int precedence)
  {
    super(precedence);
    divisor = aDivisor;
  }
  @Override
  public int modify(int oldValue)
  {
    // Will automatically round down due to typing
    return oldValue / divisor;
  }
}

