package com.github.harverst.roper.model.fifthEdition.classes;

import com.github.harverst.roper.model.fifthEdition.FifthEditionScoreType;
import com.github.harverst.roper.model.fifthEdition.FifthEditionPhase;
import com.github.harverst.roper.model.CharacterComponent;

interface CharacterClass extends CharacterComponent<FifthEditionScoreType, FifthEditionPhase>
{
  public void levelUp();
  public int getLevel();
}

