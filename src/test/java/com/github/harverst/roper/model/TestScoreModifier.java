package com.github.harverst.roper.model;

// This is a helper class for BasicScoreModifierTest
public class TestScoreModifier extends BasicScoreModifier
{
  TestScoreModifier(int order) {
    super(order);
  }
  public int modify(int oldValue)
  {
    return oldValue;
  }
}

