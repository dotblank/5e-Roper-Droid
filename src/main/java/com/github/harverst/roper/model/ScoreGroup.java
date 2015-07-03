package com.github.harverst.roper.model;

import java.util.List;

public interface ScoreGroup<P> extends List<Score<P> >
{
  public void addComponent(List<ScoreComponent<P> > mod) 
    throws ScoreGroupComponentSizeMismatchException;
  public void removeComponent(List<ScoreComponent<P> > mod)
    throws ScoreGroupComponentSizeMismatchException;
}

