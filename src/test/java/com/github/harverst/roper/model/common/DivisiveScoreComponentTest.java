package com.github.harverst.roper.model.common;

import com.github.harverst.roper.model.ScoreComponent;
import java.lang.Integer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DivisiveScoreComponentTest
{
  @Test
  public void constructorSetsPrecedence()
  {
    ScoreComponent<Integer> mod = new DivisiveScoreComponent(0, 2);
    assertEquals("Precedence must be set by constructor",
      new Integer(0), mod.getPhase());
  }
  @Test
  public void compositeRoundsDown()
  {
    ScoreComponent<Integer> mod = new DivisiveScoreComponent(0, 2);
    assertEquals("Precedence must be set by constructor",
      3, mod.composite(7));
  }
}

