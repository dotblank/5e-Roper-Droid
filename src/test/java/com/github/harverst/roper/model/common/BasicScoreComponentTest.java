package com.github.harverst.roper.model.common;

import com.github.harverst.roper.model.ScoreComponent;
import java.lang.Integer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicScoreComponentTest
{
  @Test
  public void PhaseConstructorPhaseShouldBeConfigured()
  {
    ScoreComponent<Integer> basic = new TestScoreComponent(2);
    assertEquals("Phase constructor, phase should be configured", 
      new Integer(2), basic.getPhase());
  }
}

