package com.github.harverst.roper.model;

class AdditiveScoreModifier extends BasicScoreModifier
{
  private int addend;
  public AdditiveScoreModifier(int anAddend, int precedence)
  {
    super(precedence);
    addend = anAddend;
  }
  @Override
  public int modify(int oldValue)
  {
    return oldValue + addend;
  }
}

