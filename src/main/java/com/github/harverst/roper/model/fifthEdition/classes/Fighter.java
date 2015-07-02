package com.github.harverst.roper.model.fifthEdition.classes;

import java.util.List;
import com.github.harverst.roper.model.ScoreComponent;
import com.github.harverst.roper.model.Character;
import com.github.harverst.roper.model.fifthEdition.ScoreType;

/**
 * Implements components for the character class
 */
class Fighter implements CharacterClass
{
  private List<ScoreComponent> abilityComponents;
  private List<ScoreComponent> skillComponents;
  int currentLevel;
  public void composite(Character<ScoreType> character)
  {
    currentLevel = 1;
  }
  public void levelUp()
  {
    currentLevel++;
    // Vastly different things happen for different
    switch(currentLevel)
    {
    default:
    }
  }
  public int getLevel()
  {
    return currentLevel;
  }
}
