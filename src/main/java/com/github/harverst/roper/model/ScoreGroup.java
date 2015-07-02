package com.github.harverst.roper.model;

import java.util.List;

interface ScoreGroup extends List<Score>
{
  public void addComponent(List<ScoreComponent> mod) 
    throws ScoreGroupComponentSizeMismatchException;
  public void removeComponent(List<ScoreComponent> mod)
    throws ScoreGroupComponentSizeMismatchException;
}

