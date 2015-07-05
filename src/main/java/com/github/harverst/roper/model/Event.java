package com.github.harverst.roper.model;

public interface Event
{
  /**
   * Causes the event to occur.
   *
   * @return whether the event applies successfully.
   */
  public boolean apply();
  /**
   * Reverts the event.
   *
   * @return whether reversion is successful.
   */
  public boolean rollback();
}

