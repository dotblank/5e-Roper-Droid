package com.github.harverst.roper.model.fifthEdition.classes;

import java.util.List;
import com.github.harverst.roper.model.ScoreComponent;
import com.github.harverst.roper.model.Character;
import com.github.harverst.roper.model.fifthEdition.FifthEditionScoreType;
import com.github.harverst.roper.model.fifthEdition.FifthEditionPhase;

/**
 * Implements components for the character class
 * TODO: implement fighter class
 */
public class Fighter implements CharacterClass
{
  private List<ScoreComponent> abilityComponents;
  private List<ScoreComponent> skillComponents;
  int currentLevel;
  public Fighter()
  {
  }
  public void composite(Character<FifthEditionScoreType, 
    FifthEditionPhase> character)
  {
    currentLevel = 1;
  }
  /**
   *
   */
  public void seperate(Character<FifthEditionScoreType, 
    FifthEditionPhase> character)
  {
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
