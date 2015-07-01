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
  public void addModifier(List<ScoreModifier> mod) 
    throws ScoreGroupModifierListSizeMismatchException
  {
    if(size() != mod.size())
    {
      throw new ScoreGroupModifierListSizeMismatchException();
    }
    Iterator<Score> scoreIt = iterator();
    for(Iterator<ScoreModifier> modIt = mod.iterator(); modIt.hasNext();)
    {
      scoreIt.next().addModifier(modIt.next());
    }
  }
  public void removeModifier(List<ScoreModifier> mod)
    throws ScoreGroupModifierListSizeMismatchException
  {
    if(size() != mod.size())
    {
      throw new ScoreGroupModifierListSizeMismatchException();
    }
    Iterator<Score> scoreIt = iterator();
    for(Iterator<ScoreModifier> modIt = mod.iterator(); modIt.hasNext();)
    {
      scoreIt.next().removeModifier(modIt.next());
    }
  }
}

