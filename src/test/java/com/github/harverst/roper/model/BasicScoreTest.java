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
  public void shouldIgnoreNullComponent()
  {
    Score score = new BasicScore();
    score.addComponent(null);
    assertEquals("value after adding null", 0, score.getValue());
    score.removeComponent(null);
    assertEquals("value after removing null", 0, score.getValue());
  }

  @Test
  public void singleComponentWithDefaultConstructor()
  {
    Score score = new BasicScore();
    ScoreComponent mod = new AdditiveScoreComponent(5, 0);
    score.addComponent(mod);
    assertEquals("value after adding plus 5 mod", 5, score.getValue());
    score.removeComponent(mod);
    assertEquals("value after removing plus 5 modifier", 0, score.getValue());
  }
  
  @Test
  public void singleComponentWithIntConstructor()
  {
    Score score = new BasicScore(5);
    ScoreComponent mod = new AdditiveScoreComponent(5, 0);
    score.addComponent(mod);
    assertEquals("base 5 with plus 5 mod", 10, score.getValue());
    score.removeComponent(mod);
    assertEquals("base 5 with plus 5 modifier removed", 5, score.getValue());
  }

  @Test
  public void multiComponentWithDefaultConstructor()
  {
    Score score = new BasicScore();
    ScoreComponent mod = new AdditiveScoreComponent(5, 2);
    ScoreComponent mod2 = new MultiplicativeScoreComponent(3, 1);
    score.addComponent(mod);
    assertEquals("base 0, plus 5", 5, score.getValue());
    score.addComponent(mod2);
    assertEquals("base 0, plus 5, times 3", 15, score.getValue());
    score.removeComponent(mod);
    assertEquals("base 0, times 3", 0, score.getValue());
  }

  @Test
  public void multiComponentWithIntConstructor()
  {
    Score score = new BasicScore(4);
    ScoreComponent mod = new AdditiveScoreComponent(5, 2);
    ScoreComponent mod2 = new MultiplicativeScoreComponent(3, 1);
    score.addComponent(mod);
    assertEquals("base 4, plus 5", score.getValue(), 9);
    score.addComponent(mod2);
    assertEquals("base 4, plus 5, times 3", score.getValue(), 27);
    score.removeComponent(mod);
    assertEquals("base 4, times 3", score.getValue(), 12);
  }
}
