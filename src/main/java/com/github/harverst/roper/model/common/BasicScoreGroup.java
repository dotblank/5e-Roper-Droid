package com.github.harverst.roper.model.common;

import com.github.harverst.roper.model.Score;
import com.github.harverst.roper.model.ScoreComponent;
import com.github.harverst.roper.model.ScoreGroup;
import com.github.harverst.roper.model.ScoreGroupComponentSizeMismatchException;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

class BasicScoreGroup<P> extends ArrayList<Score<P> > implements ScoreGroup<P>
{
  public BasicScoreGroup()
  {
  }
  public BasicScoreGroup(List<Score<P> > initial)
  {
    super(initial);
  }
  public void addComponent(List<ScoreComponent<P> > mod) 
    throws ScoreGroupComponentSizeMismatchException
  {
    if(size() != mod.size())
    {
      throw new ScoreGroupComponentSizeMismatchException();
    }
    Iterator<Score<P> > scoreIt = iterator();
    for(Iterator<ScoreComponent<P> > modIt = mod.iterator(); modIt.hasNext();)
    {
      scoreIt.next().addComponent(modIt.next());
    }
  }
  public void removeComponent(List<ScoreComponent<P> > mod)
    throws ScoreGroupComponentSizeMismatchException
  {
    if(size() != mod.size())
    {
      throw new ScoreGroupComponentSizeMismatchException();
    }
    Iterator<Score<P> > scoreIt = iterator();
    for(Iterator<ScoreComponent<P> > modIt = mod.iterator(); modIt.hasNext();)
    {
      scoreIt.next().removeComponent(modIt.next());
    }
  }
}

