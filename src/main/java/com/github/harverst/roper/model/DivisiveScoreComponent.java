package com.github.harverst.roper.model;

public class DivisiveScoreComponent extends BasicScoreComponent
{
  private int divisor;
  public DivisiveScoreComponent(int aDivisor, int precedence)
  {
    super(precedence);
    divisor = aDivisor;
  }
  @Override
  public int composite(int oldValue)
  {
    // Will automatically round down due to typing
    return oldValue / divisor;
  }
}

