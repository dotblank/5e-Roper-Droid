package com.github.harverst.roper.model;

import java.lang.Enum;

/**
 * An action
 */
public interface Action
{
  /**
   * Perform the action
   */
  public void forward();
  /**
   * Undo the action
   */
  public void reverse();
}

