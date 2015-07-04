package com.github.harverst.roper.model.fifthEdition.classes;

import com.github.harverst.roper.model.fifthEdition.ScoreType;
import com.github.harverst.roper.model.fifthEdition.ScorePhase;
import com.github.harverst.roper.model.CharacterComponent;

interface CharacterClass extends CharacterComponent<ScoreType, ScorePhase>
{
  public void levelUp();
  public int getLevel();
}

