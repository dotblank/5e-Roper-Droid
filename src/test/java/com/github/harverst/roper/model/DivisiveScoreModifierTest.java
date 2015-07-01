package com.github.harverst.roper.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DivisiveScoreModifierTest
{
  @Test
  public void constructorSetsPrecedence()
  {
    ScoreModifier mod = new DivisiveScoreModifier(2, 0);
    assertEquals("Precedence must be set by constructor",
      0, mod.getPrecedence());
  }
  @Test
  public void modifyRoundsDown()
  {
    ScoreModifier mod = new DivisiveScoreModifier(2, 0);
    assertEquals("Precedence must be set by constructor",
      3, mod.modify(7));
  }
}

