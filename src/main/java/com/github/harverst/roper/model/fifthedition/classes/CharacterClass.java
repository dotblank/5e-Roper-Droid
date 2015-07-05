package com.github.harverst.roper.model.fifthedition.classes;

import com.github.harverst.roper.model.fifthedition.FifthEditionScoreType;
import com.github.harverst.roper.model.fifthedition.FifthEditionPhase;
import com.github.harverst.roper.model.CharacterComponent;

interface CharacterClass extends CharacterComponent<FifthEditionScoreType, FifthEditionPhase>
{
  public void levelUp();
  public int getLevel();
}

