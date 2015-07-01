package com.github.harverst.roper.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static java.lang.Integer.signum;

import org.junit.Test;

public class BasicScoreModifierTest
{
  @Test
  public void intConstructorPrecedenceShouldBeConfigured()
  {
    ScoreModifier basic = new TestScoreModifier(2);
    assertEquals("Int constructor precedence should be configured", 
      2, basic.getPrecedence());
  }
  
  @Test
  public void compareToShouldConform()
  {
    // Ensure Comparable is correctly implemented
    ScoreModifier first = new TestScoreModifier(5);
    ScoreModifier second = new TestScoreModifier(4);
    ScoreModifier third = new TestScoreModifier(3);
    assertEquals("must satisfy: sgn(x.compareTo(y)) == -sgn(y.compareTo(x))", 
      signum(first.compareTo(second)), -signum(second.compareTo(first)));
    assertTrue("first must precede second",
      second.compareTo(first) > 0);
    assertTrue("second must precede third",
      third.compareTo(second) > 0);
    assertTrue("first must precede third",
      third.compareTo(first) > 0);
    // No two modifiers can have 
    assertEquals("Comparison to self must result in zero",
      0, first.compareTo(first));
  }
}

