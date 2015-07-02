package com.github.harverst.roper.model;

import com.github.harverst.roper.model.Score;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;

class BasicScore implements Score
{
  private int baseValue;
  private TreeSet<ScoreComponent> components;
  
  public BasicScore()
  {
    baseValue = 0;
    components = new TreeSet();
  }
  
  public BasicScore(int base)
  {
    baseValue = base;
    components = new TreeSet();
  }
  
  public int getValue()
  {
    int accumulator = baseValue;
    for(Iterator<ScoreComponent> it = components.iterator(); 
      it.hasNext();)
    {
      accumulator = it.next().composite(accumulator);
    }
    return accumulator;
  }
  
  public void addComponent(ScoreComponent mod)
  {
    if(mod == null)
      return;
    components.add(mod);
  }
  
  public void removeComponent(ScoreComponent mod)
  {
    if(mod == null)
      return;
    components.remove(mod);
  }
}

