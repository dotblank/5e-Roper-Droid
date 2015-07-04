package com.github.harverst.roper.model.common;

import com.github.harverst.roper.model.Character;
import com.github.harverst.roper.model.Score;
import com.github.harverst.roper.model.ScoreGroup;
import com.github.harverst.roper.model.Action;
import com.github.harverst.roper.model.Event;

import java.lang.Enum;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class BasicCharacter<S extends BasicScoreGroupType, P> implements Character<S, P>
{

  private Map<S, ScoreGroup<P> > groupMap;
  private Set<Action> actions;
  private List<Event> history;
  /**
   * Uses a set (no repeating members) of group
   */
  BasicCharacter(Set<S> groups)
  {
    // I don't really like how BasicScoreGroupType works right now
    S key = null;
    groupMap = new HashMap();
    actions = new HashSet();
    history = new ArrayList();
    for(Iterator<S> it = groups.iterator(); it.hasNext(); key = it.next())
    {
      ScoreGroup<P> group = new BasicScoreGroup<P>();
      for(int c = 0; c < key.getSize(); c++)
      {
        group.add(new BasicScore<P>());
      }
      groupMap.put(key, new BasicScoreGroup<P>());
    }
  }
  
  public Score<P> getScore(S groupKey, int ordinal)
  {
    // Expand the ScoreGroup until it's large enough
    ScoreGroup<P> group = groupMap.get(groupKey);
    return group.get(ordinal);
  }
  
  public ScoreGroup<P> getScoreGroup(S group)
  {
    return groupMap.get(group);
  }

  public Set<Action> getActions()
  {
    return actions;
  }

  public List<Event> getHistory()
  {
    return history;
  }

}
