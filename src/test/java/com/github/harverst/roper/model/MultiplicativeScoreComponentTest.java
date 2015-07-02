package com.github.harverst.roper.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiplicativeScoreComponentTest
{
  @Test
  public void constructorShouldSetPrecedence()
  {
    ScoreComponent mod = new MultiplicativeScoreComponent(5, 0);
    assertEquals("Constructor sets precedence", 0, mod.getPrecedence());
  }
  @Test
  public void compositeShouldMultiply()
  {
    ScoreComponent mod = new MultiplicativeScoreComponent(5, 0);
    assertEquals("Modify should multiply", 20, mod.composite(4));
  }
}

