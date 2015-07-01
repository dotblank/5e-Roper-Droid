package com.github.harverst.roper.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdditiveScoreModifierTest
{
  @Test
  public void constructorShouldSetPrecedence()
  {
    ScoreModifier mod = new AdditiveScoreModifier(5, 0);
    assertEquals("Precedence should be set by constructor", 
      0, mod.getPrecedence());
  }
  @Test
  public void modifyShouldAdd()
  {
    ScoreModifier mod = new AdditiveScoreModifier(5, 0);
    assertEquals("Result should be 4 + 5 => 9", 9, mod.modify(4));
  }
}

