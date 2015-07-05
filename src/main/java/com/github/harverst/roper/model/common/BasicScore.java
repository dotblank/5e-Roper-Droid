package com.github.harverst.roper.model.common;

import com.github.harverst.roper.model.Score;
import com.github.harverst.roper.model.ScoreComponent;
import com.github.harverst.roper.model.PhaseOrder;
import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class BasicScore<P> implements Score<P>
{
  private int baseValue;
  private Collection<ScoreComponent<P> > components;
  
  public BasicScore()
  {
    baseValue = 0;
    components = new ArrayList<ScoreComponent<P> >();
  }
  
  public BasicScore(int base)
  {
    baseValue = base;
    components = new ArrayList<ScoreComponent<P> >();
  }
  
  public int getValue(PhaseOrder<P> ordering)
  {
    List<ScoreComponent<P> > sorted = ordering.order(components);
    int accumulator = baseValue;
    for(Iterator<ScoreComponent<P> > it = sorted.iterator(); 
      it.hasNext();)
    {
      accumulator = it.next().composite(accumulator);
    }
    return accumulator;
  }
  
  public void addComponent(ScoreComponent<P> component)
  {
    if(component == null)
      return;
    components.add(component);
  }
  
  public void removeComponent(ScoreComponent<P> component)
  {
    if(component == null)
      return;
    components.remove(component);
  }
}

