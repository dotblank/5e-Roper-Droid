package com.github.harverst.roper.model.common;

// Using int as the phase class in Test classes due to laziness
// not recommending using int for phases generally

import java.lang.Integer;

// This is a helper class for BasicScoreComponentTest
public class TestScoreComponent extends BasicScoreComponent<Integer>
{
  TestScoreComponent(Integer order) {
    super(order);
  }
  public int composite(int oldValue)
  {
    return oldValue;
  }
}

