package com.github.harverst.roper.model;

import java.util.List;

interface ScoreGroup extends List<Score>
{
  public void addModifier(List<ScoreModifier> mod) 
    throws ScoreGroupModifierListSizeMismatchException;
  public void removeModifier(List<ScoreModifier> mod)
    throws ScoreGroupModifierListSizeMismatchException;
}

