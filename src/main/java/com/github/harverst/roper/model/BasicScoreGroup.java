package com.github.harverst.roper.model;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

class BasicScoreGroup extends ArrayList<Score> implements ScoreGroup
{
  public BasicScoreGroup()
  {
  }
  public BasicScoreGroup(List<Score> initial)
  {
    super(initial);
  }
  public void addComponent(List<ScoreComponent> mod) 
    throws ScoreGroupComponentSizeMismatchException
  {
    if(size() != mod.size())
    {
      throw new ScoreGroupComponentSizeMismatchException();
    }
    Iterator<Score> scoreIt = iterator();
    for(Iterator<ScoreComponent> modIt = mod.iterator(); modIt.hasNext();)
    {
      scoreIt.next().addComponent(modIt.next());
    }
  }
  public void removeComponent(List<ScoreComponent> mod)
    throws ScoreGroupComponentSizeMismatchException
  {
    if(size() != mod.size())
    {
      throw new ScoreGroupComponentSizeMismatchException();
    }
    Iterator<Score> scoreIt = iterator();
    for(Iterator<ScoreComponent> modIt = mod.iterator(); modIt.hasNext();)
    {
      scoreIt.next().removeComponent(modIt.next());
    }
  }
}

