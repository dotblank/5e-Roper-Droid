package com.github.harverst.roper.model;

// This is a helper class for BasicScoreComponentTest
public class TestScoreComponent extends BasicScoreComponent
{
  TestScoreComponent(int order) {
    super(order);
  }
  public int composite(int oldValue)
  {
    return oldValue;
  }
}

