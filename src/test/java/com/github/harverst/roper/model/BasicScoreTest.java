package com.github.harverst.roper.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicScoreTest
{
  @Test
  public void defaultConstruct()
  {
    Score score = new BasicScore();
    assertEquals(
      "BasicScore default constructor must set unmodified value to 0", 
      0, score.getValue());
  }
  
  @Test
  public void intConstruct()
  {
    Score score = new BasicScore(5);
    assertEquals(
      "BasicScore int constructor must set unmodified value to given value", 
      5, score.getValue());
  }

  // TODO: add test for simple modifiers
  
  // TODO: add test for modifier precedence
  
}
