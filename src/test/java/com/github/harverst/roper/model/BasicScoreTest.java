package com.github.harverst.roper.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicScoreTest
{
  @Test
  public void defaultConstruct()
  {
    Score score = new BasicScore();
    assertEquals(
      "BasicScore default constructor must set unmodified value to 0", 
      0, score.getValue());
  }
  
  @Test
  public void intConstructorSetsUnmodifiedValue()
  {
    Score score = new BasicScore(5);
    assertEquals(
      "BasicScore int constructor must set unmodified value to given value", 
      5, score.getValue());
  }

  @Test
  public void shouldIgnoreNullModifier()
  {
    Score score = new BasicScore();
    score.addModifier(null);
    assertEquals("value after adding null", 0, score.getValue());
    score.removeModifier(null);
    assertEquals("value after removing null", 0, score.getValue());
  }

  @Test
  public void singleModifierWithDefaultConstructor()
  {
    Score score = new BasicScore();
    ScoreModifier mod = new AdditiveScoreModifier(5, 0);
    score.addModifier(mod);
    assertEquals("value after adding plus 5 mod", 5, score.getValue());
    score.removeModifier(mod);
    assertEquals("value after removing plus 5 modifier", 0, score.getValue());
  }
  
  @Test
  public void singleModifierWithIntConstructor()
  {
    Score score = new BasicScore(5);
    ScoreModifier mod = new AdditiveScoreModifier(5, 0);
    score.addModifier(mod);
    assertEquals("base 5 with plus 5 mod", 10, score.getValue());
    score.removeModifier(mod);
    assertEquals("base 5 with plus 5 modifier removed", 5, score.getValue());
  }

  @Test
  public void multiModifierWithDefaultConstructor()
  {
    Score score = new BasicScore();
    ScoreModifier mod = new AdditiveScoreModifier(5, 2);
    ScoreModifier mod2 = new MultiplicativeScoreModifier(3, 1);
    score.addModifier(mod);
    assertEquals("base 0, plus 5", 5, score.getValue());
    score.addModifier(mod2);
    assertEquals("base 0, plus 5, times 3", 15, score.getValue());
    score.removeModifier(mod);
    assertEquals("base 0, times 3", 0, score.getValue());
  }

  @Test
  public void multiModifierWithIntConstructor()
  {
    Score score = new BasicScore(4);
    ScoreModifier mod = new AdditiveScoreModifier(5, 2);
    ScoreModifier mod2 = new MultiplicativeScoreModifier(3, 1);
    score.addModifier(mod);
    assertEquals("base 4, plus 5", score.getValue(), 9);
    score.addModifier(mod2);
    assertEquals("base 4, plus 5, times 3", score.getValue(), 27);
    score.removeModifier(mod);
    assertEquals("base 4, times 3", score.getValue(), 12);
  }
}
