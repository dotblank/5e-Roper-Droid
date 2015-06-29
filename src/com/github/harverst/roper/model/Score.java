package com.github.harverst.roper.model;

import com.github.harverst.roper.model.ScoreModifier;

interface Score
{
  public int getValue();
  public void addModifier(ScoreModifier mod);
  public void removeModifier(ScoreModifier mod);
}

