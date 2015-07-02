package com.github.harverst.roper.model;

class AdditiveScoreComponent extends BasicScoreComponent
{
  private int addend;
  public AdditiveScoreComponent(int anAddend, int precedence)
  {
    super(precedence);
    addend = anAddend;
  }
  @Override
  public int composite(int oldValue)
  {
    return oldValue + addend;
  }
}

