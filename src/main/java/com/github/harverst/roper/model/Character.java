package com.github.harverst.roper.model;

import java.lang.Enum;
import java.util.Set;
import java.util.List;

/**
 * Highly abstract and parameterized interface used to define characters.
 *
 * The template parameter S could be an enum that lists the different
 * types of scores available in the game system referenced.
 */
public interface Character<S>
{
  /**
   * Retrieves a score from the given type.
   *
   * Note that if a score stands alone, ordinal can be left as 0.
   *
   * @param group The type of score for a finite set of scores desired
   * @param ordinal The index in the order of the score
   */
  public Score getScore(S group, int ordinal);
  /**
   * Retrieves a group of scores from the given type.
   * 
   * Note that the score group does not need to be a reference internally but
   * the Scores do.
   *
   * @param group The type of score to retrieve the group for.
   */
  public ScoreGroup getScoreGroup(S group);
  /**
   * Gets the set of actions the character is capable.
   * 
   * This should mostly match up with actions as defined in DnD
   * Only case in which it might not match up is while out of battle
   */
  public Set<Action<S> > getActions();
  /**
   * Log of actions that have happened to the character in chronological order.
   */
  public List<Event> getHistory();
  /**
   * Adds a character component to this character.
   *
   * @param component The component to add to this character.
   */
  public void addComponent(CharacterComponent<S> component);
}

