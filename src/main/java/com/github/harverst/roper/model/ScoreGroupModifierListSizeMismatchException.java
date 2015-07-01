package com.github.harverst.roper.model;

import java.lang.Exception;

public class ScoreGroupModifierListSizeMismatchException extends Exception
{
  public ScoreGroupModifierListSizeMismatchException()
  {
    super("Score group size and modifier list size do not match");
  }
}
