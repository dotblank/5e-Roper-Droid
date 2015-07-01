package com.github.harverst.roper.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiplicativeScoreModifierTest
{
  @Test
  public void constructorShouldSetPrecedence()
  {
    ScoreModifier mod = new MultiplicativeScoreModifier(5, 0);
    assertEquals("Constructor sets precedence", 0, mod.getPrecedence());
  }
  @Test
  public void modifyShouldMultiply()
  {
    ScoreModifier mod = new MultiplicativeScoreModifier(5, 0);
    assertEquals("Modify should multiply", 20, mod.modify(4));
  }
}

