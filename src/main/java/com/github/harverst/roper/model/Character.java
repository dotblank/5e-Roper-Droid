package com.github.harverst.roper.model;

import java.lang.Enum;
import java.util.List;

/**
 * Highly abstract and parameterized interface used to define characters.
 *
 * The template parameter S could be an enum that lists the different
 * types of scores available in the game system referenced.
 *
 * The template parameter, P, defines the phases that can be used to
 * order a score, usually an enum or numeric class.
 */
public interface Character<S, P>
{
  /**
   * Retrieves a score group of the given type.
   *
   * Note, this should be primarily used read-only as modifiers applied via
   * the returned value will not be added to the history log.
   *
   * @param group The type of group being sought.
   */
  public ScoreGroup<P> getScoreGroup(S group);
  
  /**
   * Retrieves a score from the given type.
   *
   * Note that if a score stands alone, ordinal can be left as 0.
   *
   * @param group The type of score for a finite set of scores desired
   * @param ordinal The index in the order of the score
   */
  public Score<P> getScore(S group, int ordinal);
  /**
   * Adds a set of components to the given group.
   * 
   * @param group The type of group to composite with.
   * @param component The components to add
   */
  public void addGroupComponent(S group, List<ScoreComponent<P> > component);
  /**
   * Removes the components from the given group.
   *
   * @param group The type of group to remove the component from.
   * @param component The components to remove
   */
  public void removeGroupComponent(S group, List<ScoreComponent<P> > component);
  /**
   * Adds a capability to the character.
   *
   * @param anAction The capability being added to the character.
   */
  public void addAction(Action anAction);
  /**
   * Removes a capability from the character.
   *
   * @param anAction The capability being removed from the character.
   */
  public void removeAction(Action anAction);
  /**
   * Gets the set of actions the character is capable.
   * 
   * This should mostly match up with actions as defined in DnD
   * Only case in which it might not match up is while out of battle
   */
  public List<Action> getActions();
  /**
   * Log of actions that have happened to the character in chronological order.
   *
   * @return A full list of events usable to rollback a character entirely.
   */
  public List<Event> getHistory();
  /**
   * Logs actions that have failed, such as by throwing an exception.
   *
   * Note, this is particularly necessary for
   *
   * @return A full list of list of failed actions.
   */
  public List<Event> getFailedHistory();
}

