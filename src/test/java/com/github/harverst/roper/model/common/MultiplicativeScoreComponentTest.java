package com.github.harverst.roper.model.common;

import com.github.harverst.roper.model.ScoreComponent;
import java.lang.Integer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiplicativeScoreComponentTest
{
  @Test
  public void constructorShouldSetPrecedence()
  {
    ScoreComponent<Integer> mod = new MultiplicativeScoreComponent(0, 5);
    assertEquals("Constructor sets precedence", new Integer(0), mod.getPhase());
  }
  @Test
  public void compositeShouldMultiply()
  {
    ScoreComponent<Integer> mod = new MultiplicativeScoreComponent(0, 5);
    assertEquals("Modify should multiply", 20, mod.composite(4));
  }
}

