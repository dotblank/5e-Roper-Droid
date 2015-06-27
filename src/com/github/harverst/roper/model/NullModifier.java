package com.github.harverst.roper.model;

import com.github.harverst.roper.model.ScoreModifier;

/**
 * Acts as a placeholder when a modifier is programatically necessary but 
 * functionally unnecessary.
 */
class NullModifier implements ScoreModifier
{
  public int getPrecedence() { return 0; }
  public int modify(int oldValue) { return oldValue; }
}
