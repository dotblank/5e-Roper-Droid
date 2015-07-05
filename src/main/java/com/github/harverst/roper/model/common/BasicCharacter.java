package com.github.harverst.roper.model.common;

import com.github.harverst.roper.model.Character;
import com.github.harverst.roper.model.Score;
import com.github.harverst.roper.model.ScoreComponent;
import com.github.harverst.roper.model.ScoreGroup;
import com.github.harverst.roper.model.Action;
import com.github.harverst.roper.model.Event;
import com.github.harverst.roper.model.
  ScoreGroupComponentSizeMismatchException;

import java.lang.Enum;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import static java.util.EnumSet.allOf;

public class BasicCharacter<S extends BasicScoreGroupType, P> implements Character<S, P>
{

  private Map<S, ScoreGroup<P> > groupMap;
  private List<Action> actions;
  private List<Event> history;
  private List<Event> failedHistory;
  /**
   * Uses a set (no repeating members) of group
   */
  public BasicCharacter(Set<S> groups)
  {
    // I don't really like how BasicScoreGroupType works right now
    groupMap = new HashMap();
    actions = new ArrayList();
    history = new ArrayList();
    for(Iterator<S> it = groups.iterator(); it.hasNext();)
    {
      S key = it.next();
      ScoreGroup<P> group = new BasicScoreGroup<P>();
      for(int c = 0; c < key.getSize(); c++)
      {
        group.add(new BasicScore<P>());
      }
      groupMap.put(key, group);
    }
  }
  
  public Score<P> getScore(S groupKey, int ordinal)
  {
    // Expand the ScoreGroup until it's large enough
    ScoreGroup<P> group = groupMap.get(groupKey);
    return group.get(ordinal);
  }
  
  /**
   * Generally should not be used directly.
   *
   * Should generally only be used internally by Events.
   *
   * @return The score group asked for.
   */
  public ScoreGroup<P> getScoreGroup(S group)
  {
    return groupMap.get(group);
  }
  
  public void addGroupComponent(S group, 
    List<ScoreComponent<P> > modification)
  {
    Event evt = new CharacterCompositingEvent<S, P>(this, group, modification);
    history.add(evt);
    if(!evt.apply())
    {
      failedHistory.add(evt);
    }
  }

  public void removeGroupComponent(S group, 
    List<ScoreComponent<P> > modification)
  {
    Event evt = new CharacterDecompositingEvent<S, P>(this, group, modification);
    history.add(evt);
    if(!evt.apply())
    {
      failedHistory.add(evt);
    }
  }

  public void addAction(Action anAction)
  {
    actions.add(anAction);
  }

  public void removeAction(Action anAction)
  {
    actions.add(anAction);
  }

  public List<Action> getActions()
  {
    return actions;
  }

  /**
   * Retrieves the full list of events.
   *
   * Ideally, the list of events could be used to reconstruct a character. This
   * gives a potential avenue for serialization that, while perhaps less 
   * efficient, I believe should be more capable.
   *
   * @return A full list of events usable to rollback a character entirely.
   */
  public List<Event> getHistory()
  {
    return history;
  }
  public List<Event> getFailedHistory()
  {
    return failedHistory;
  }
}

/**
 * An event utilized internally to handle adding components
 */
class CharacterCompositingEvent<S, P> implements Event
{
  Character<S, P> owner;
  List<ScoreComponent<P> > component;
  S group;
  /**
   * This constructor needs the owner and the component.
   *
   * @param theOwner The owner of the event.
   * @param theComponent The component added by the event.
   */
  public CharacterCompositingEvent(Character<S, P> theOwner, S theGroup, 
    List<ScoreComponent<P> > theComponents)
  {
    owner = theOwner;
    group = theGroup;
    component = theComponents;
  }
  /**
   * Applies the compositing
   */
  public boolean apply()
  {
    try
    {
      owner.getScoreGroup(group).addComponent(component);
      return true;
    }
    catch(ScoreGroupComponentSizeMismatchException e)
    {
      return false;
    }
  }
  /**
   * Rolls back the compositing
   */
  public boolean rollback()
  {
    try
    {
      owner.getScoreGroup(group).removeComponent(component);
      return true;
    }
    catch(ScoreGroupComponentSizeMismatchException e)
    {
      return false;
    }
  }
}

/**
 * An event utilized internally to handle removing components
 *
 * Effectively reverses apply and rollback
 */
class CharacterDecompositingEvent<S, P> extends CharacterCompositingEvent<S, P>
{
  public CharacterDecompositingEvent(Character<S, P> theOwner, S theGroup, 
    List<ScoreComponent<P> > theComponents)
  {
    super(theOwner, theGroup, theComponents);
  }
  @Override
  public boolean apply()
  {
    return super.rollback();
  }
  @Override
  public boolean rollback()
  {
    return super.apply();
  }
}

/**
 * 
 */
class CharacterAddActionEvent<S, P> implements Event
{
  public Character<S, P> owner;
  public Action action;
  public CharacterAddActionEvent(Character<S, P> theOwner, Action theAction)
  {
    owner = theOwner;
    action = theAction;
  }
  public boolean apply()
  {
    owner.addAction(action);
    return true;
  }
  public boolean rollback()
  {
    owner.removeAction(action);
    return true;
  }
}

/**
 * 
 */
class CharacterRemoveActionEvent<S, P> extends CharacterAddActionEvent<S, P>
{
  public CharacterRemoveActionEvent(Character<S, P> theOwner, Action theAction)
  {
    super(theOwner, theAction);
  }
  public boolean apply()
  {
    return super.rollback();
  }
  public boolean rollback()
  {
    return super.apply();
  }
}
