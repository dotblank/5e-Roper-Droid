package com.github.harverst.roper.model.common;

import com.github.harverst.roper.model.ScoreComponent;
import java.lang.Integer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdditiveScoreComponentTest
{
  @Test
  public void constructorShouldSetPrecedence()
  {
    ScoreComponent mod = new AdditiveScoreComponent<Integer>(0, 5);
    assertEquals("Precedence should be set by constructor", 
      0, mod.getPhase());
  }
  @Test
  public void compositeShouldAdd()
  {
    ScoreComponent mod = new AdditiveScoreComponent<Integer>(0, 5);
    assertEquals("Result should be 4 + 5 => 9", 9, mod.composite(4));
  }
}

