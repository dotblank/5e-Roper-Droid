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

public class BasicCharacter<S, P> implements Character<S, P>
{

  private Map<S, ScoreGroup<P> > groupMap;
  private Set<Action> actions;
  private List<Event> history;
  /**
   * Uses a set (no repeating members) of group
   */
  BasicCharacter(Set<S> groups)
  {
    S group = null;
    groupMap = new HashMap();
    actions = new HashSet();
    history = new ArrayList();
    for(Iterator<S> it = groups.iterator(); it.hasNext(); group = it.next())
    {
      groupMap.put(group, new BasicScoreGroup<P>());
    }
  }
  
  public Score<P> getScore(S group, int ordinal)
  {
    return groupMap.get(group).get(ordinal);
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
