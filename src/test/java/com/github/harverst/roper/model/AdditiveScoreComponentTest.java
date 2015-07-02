package com.github.harverst.roper.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdditiveScoreComponentTest
{
  @Test
  public void constructorShouldSetPrecedence()
  {
    ScoreComponent mod = new AdditiveScoreComponent(5, 0);
    assertEquals("Precedence should be set by constructor", 
      0, mod.getPrecedence());
  }
  @Test
  public void compositeShouldAdd()
  {
    ScoreComponent mod = new AdditiveScoreComponent(5, 0);
    assertEquals("Result should be 4 + 5 => 9", 9, mod.composite(4));
  }
}

