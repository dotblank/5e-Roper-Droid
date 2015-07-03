package com.github.harverst.roper.model.common;

import com.github.harverst.roper.model.Score;
import com.github.harverst.roper.model.ScoreComponent;
import com.github.harverst.roper.model.PhaseOrder;
import java.lang.Integer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicScoreTest
{
  @Test
  public void defaultConstruct()
  {
    PhaseOrder<Integer> ordering = new LowToHighPhaseOrder();
    Score<Integer> score = new BasicScore();
    assertEquals(
      "BasicScore default constructor must set unmodified value to 0", 
      0, score.getValue(ordering));
  }
  
  @Test
  public void IntegerConstructorSetsUnmodifiedValue()
  {
    PhaseOrder<Integer> ordering = new LowToHighPhaseOrder();
    Score<Integer> score = new BasicScore(5);
    assertEquals(
      "BasicScore Integer constructor must set unmodified value to given value", 
      5, score.getValue(ordering));
  }

  @Test
  public void shouldIgnoreNullComponent()
  {
    PhaseOrder<Integer> ordering = new LowToHighPhaseOrder();
    Score<Integer> score = new BasicScore();
    score.addComponent(null);
    assertEquals("value after adding null", 0, score.getValue(ordering));
    score.removeComponent(null);
    assertEquals("value after removing null", 0, score.getValue(ordering));
  }

  @Test
  public void singleComponentWithDefaultConstructor()
  {
    PhaseOrder<Integer> ordering = new LowToHighPhaseOrder();
    Score<Integer> score = new BasicScore();
    ScoreComponent<Integer> mod = new AdditiveScoreComponent(0, 5);
    score.addComponent(mod);
    assertEquals("value after adding plus 5 mod", 5, 
      score.getValue(ordering));
    score.removeComponent(mod);
    assertEquals("value after removing plus 5 modifier", 0, 
      score.getValue(ordering));
  }
  
  @Test
  public void singleComponentWithIntConstructor()
  {
    PhaseOrder<Integer> ordering = new LowToHighPhaseOrder();
    Score score = new BasicScore(5);
    ScoreComponent mod = new AdditiveScoreComponent(0, 5);
    score.addComponent(mod);
    assertEquals("base 5 with plus 5 mod", 10, score.getValue(ordering));
    score.removeComponent(mod);
    assertEquals("base 5 with plus 5 modifier removed", 5, 
      score.getValue(ordering));
  }

  @Test
  public void multiComponentWithDefaultConstructor()
  {
    PhaseOrder<Integer> ordering = new HighToLowPhaseOrder();
    Score score = new BasicScore();
    ScoreComponent mod = new AdditiveScoreComponent(2, 5);
    ScoreComponent mod2 = new MultiplicativeScoreComponent(1, 3);
    score.addComponent(mod);
    assertEquals("base 0, plus 5", 5, score.getValue(ordering));
    score.addComponent(mod2);
    assertEquals("base 0, plus 5, times 3", 15, score.getValue(ordering));
    score.removeComponent(mod);
    assertEquals("base 0, times 3", 0, score.getValue(ordering));
  }

  @Test
  public void multiComponentWithIntConstructor()
  {
    PhaseOrder<Integer> ordering = new HighToLowPhaseOrder();
    Score score = new BasicScore(4);
    ScoreComponent mod = new AdditiveScoreComponent(2, 5);
    ScoreComponent mod2 = new MultiplicativeScoreComponent(1, 3);
    score.addComponent(mod);
    assertEquals("base 4, plus 5", score.getValue(ordering), 9);
    score.addComponent(mod2);
    assertEquals("base 4, plus 5, times 3", score.getValue(ordering), 27);
    score.removeComponent(mod);
    assertEquals("base 4, times 3", score.getValue(ordering), 12);
  }
}
