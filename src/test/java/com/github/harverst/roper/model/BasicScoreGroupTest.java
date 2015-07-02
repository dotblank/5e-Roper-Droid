package com.github.harverst.roper.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

public class BasicScoreGroupTest
{
  @Test
  public void defaultConstructorMakesSizeZero()
  {
    ScoreGroup group = new BasicScoreGroup();
  }

  @Test
  public void listConstructorInitializesData()
  {
    List<Score> scores = new ArrayList<Score>();
    scores.add(new BasicScore());
    scores.add(new BasicScore(3));
    scores.add(new BasicScore(4));
    scores.add(new BasicScore(8));
    scores.add(new BasicScore(7));
    ScoreGroup group = new BasicScoreGroup(scores);
    assertEquals("Size of group is 5", 5, group.size());
    assertEquals("Check idx 0", 0, group.get(0).getValue());
    assertEquals("Check idx 1", 3, group.get(1).getValue());
    assertEquals("Check idx 2", 4, group.get(2).getValue());
    assertEquals("Check idx 3", 8, group.get(3).getValue());
    assertEquals("Check idx 4", 7, group.get(4).getValue());
    List<ScoreComponent> mods = new ArrayList<ScoreComponent>();
    mods.add(new AdditiveScoreComponent(4, 0));
    mods.add(new MultiplicativeScoreComponent(4, 0));
    mods.add(new DivisiveScoreComponent(3, 0));
    mods.add(null);
    mods.add(new AdditiveScoreComponent(4, 0));
    try
    {
      group.addComponent(mods);
    }
    catch(ScoreGroupComponentSizeMismatchException e)
    {
      fail("List size mismatch occurred during add");
    }
    assertEquals("Size of group is still 5", 5, group.size());
    assertEquals("Modded check idx 0", 4, group.get(0).getValue());
    assertEquals("Modded check idx 1", 12, group.get(1).getValue());
    assertEquals("Modded check idx 2", 1, group.get(2).getValue());
    assertEquals("Modded check idx 3", 8, group.get(3).getValue());
    assertEquals("Modded check idx 4", 11, group.get(4).getValue());
    try
    {
      group.removeComponent(mods);
    }
    catch(ScoreGroupComponentSizeMismatchException e)
    {
      fail("List size mismatch occurred during remove");
    }
    assertEquals("Size of group still 5", 5, group.size());
    assertEquals("Removed check idx 0", 0, group.get(0).getValue());
    assertEquals("Removed check idx 1", 3, group.get(1).getValue());
    assertEquals("Removed check idx 2", 4, group.get(2).getValue());
    assertEquals("Removed check idx 3", 8, group.get(3).getValue());
    assertEquals("Removed check idx 4", 7, group.get(4).getValue());
  }
}

