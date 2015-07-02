package com.github.harverst.roper.model;

import java.lang.Exception;

public class ScoreGroupComponentSizeMismatchException extends Exception
{
  public ScoreGroupComponentSizeMismatchException()
  {
    super("Score group size and component list size do not match");
  }
}
