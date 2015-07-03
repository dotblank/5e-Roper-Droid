package com.github.harverst.roper.model.common;

class AdditiveScoreComponent<P> extends BasicScoreComponent<P>
{
  private int addend;
  public AdditiveScoreComponent(P aPhase, int anAddend)
  {
    super(aPhase);
    addend = anAddend;
  }
  @Override
  public int composite(int oldValue)
  {
    return oldValue + addend;
  }
}

