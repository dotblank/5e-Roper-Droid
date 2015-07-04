package com.github.harverst.roper.model;

import java.lang.Enum;
import java.util.Set;
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
   * Retrieves a score from the given type.
   *
   * Note that if a score stands alone, ordinal can be left as 0.
   *
   * @param group The type of score for a finite set of scores desired
   * @param ordinal The index in the order of the score
   */
  public Score<P> getScore(S group, int ordinal);
  /**
   * Retrieves a group of scores from the given type.
   * 
   * Note that the score group does not need to be a reference internally but
   * the Scores do.
   *
   * @param group The type of score to retrieve the group for.
   */
  public ScoreGroup<P> getScoreGroup(S group);
  /**
   * Gets the set of actions the character is capable.
   * 
   * This should mostly match up with actions as defined in DnD
   * Only case in which it might not match up is while out of battle
   */
  public Set<Action> getActions();
  /**
   * Log of actions that have happened to the character in chronological order.
   */
  public List<Event> getHistory();
}

