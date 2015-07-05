package com.github.harverst.roper.model.fifthedition;

import com.github.harverst.roper.model.common.BasicCharacter;
import static java.util.EnumSet.allOf;

class FifthEditionCharacter 
  extends BasicCharacter<FifthEditionScoreType, FifthEditionPhase>
{
  FifthEditionCharacter()
  {
    super(allOf(FifthEditionScoreType.class));
  }
}
