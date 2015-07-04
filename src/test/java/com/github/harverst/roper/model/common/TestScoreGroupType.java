package com.github.harverst.roper.model.common;

public enum TestScoreGroupType implements BasicScoreGroupType
{
  ABILITIES(6),
  SKILLS(10);
  private int size;
  TestScoreGroupType(int aSize)
  {
    size = aSize;
  }
  public int getSize()
  {
    return size;
  }
}

