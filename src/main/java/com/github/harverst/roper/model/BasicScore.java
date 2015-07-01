package com.github.harverst.roper.model;

import com.github.harverst.roper.model.Score;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Iterator;

class BasicScore implements Score
{
  private int baseValue;
  private TreeSet<ScoreModifier> modifiers;
  
  public BasicScore()
  {
    baseValue = 0;
    modifiers = new TreeSet();
  }
  
  public BasicScore(int base)
  {
    baseValue = base;
    modifiers = new TreeSet();
  }
  
  public int getValue()
  {
    int accumulator = baseValue;
    for(Iterator<ScoreModifier> it = modifiers.descendingIterator(); 
      it.hasNext();)
    {
      accumulator = it.next().modify(accumulator);
    }
    return accumulator;
  }
  
  public void removeModifier(ScoreModifier mod)
  {
    modifiers.remove(mod);
  }
  
  public void addModifier(ScoreModifier mod)
  {
    modifiers.add(mod);
  }
}

