package com.github.harverst.roper.model.common;

import com.github.harverst.roper.model.ScoreComponent;
import com.github.harverst.roper.model.PhaseOrder;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.LinkedList;

public class HighToLowPhaseOrder<P extends Comparable<P> > implements PhaseOrder<P>
{
  // use add and remove
  public List<ScoreComponent<P> > order(Collection<ScoreComponent<P> > input)
  {
    List<ScoreComponent<P> > result = new LinkedList<ScoreComponent<P> >();
    ScoreComponent<P> current = null;
    // Essentially do insertion sort
    for(Iterator<ScoreComponent<P> > iter = input.iterator(); 
      iter.hasNext();)
    {
      current = iter.next();
      int idx = 0;
      for(idx = 0; idx < result.size() && 
        current.getPhase().compareTo(result.get(idx).getPhase()) < 0; ++idx);
      result.add(idx, current);
    }
    return result;
  }
}

