package com.github.harverst.roper.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DivisiveScoreComponentTest
{
  @Test
  public void constructorSetsPrecedence()
  {
    ScoreComponent mod = new DivisiveScoreComponent(2, 0);
    assertEquals("Precedence must be set by constructor",
      0, mod.getPrecedence());
  }
  @Test
  public void compositeRoundsDown()
  {
    ScoreComponent mod = new DivisiveScoreComponent(2, 0);
    assertEquals("Precedence must be set by constructor",
      3, mod.composite(7));
  }
}

