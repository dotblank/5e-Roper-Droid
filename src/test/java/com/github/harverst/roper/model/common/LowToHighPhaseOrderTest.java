package com.github.harverst.roper.model.common;

import com.github.harverst.roper.model.ScoreComponent;
import com.github.harverst.roper.model.PhaseOrder;
import java.lang.Integer;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LowToHighPhaseOrderTest
{
  @Test
  public void orderLowToHigh()
  {
    TestScoreComponent[] scores = {
      new TestScoreComponent(1),
      new TestScoreComponent(2),
      new TestScoreComponent(3),
      new TestScoreComponent(4)
    };
    Collection<ScoreComponent<Integer> > original = 
      new ArrayList<ScoreComponent<Integer> >();
    original.add(scores[0]);
    original.add(scores[1]);
    original.add(scores[2]);
    original.add(scores[3]);
    PhaseOrder<Integer> sorter = new LowToHighPhaseOrder();
    List<ScoreComponent<Integer> > sorted = sorter.order(original);
    assertEquals("Original and sorted should have same length", original.size(), sorted.size());
    assertSame("Idx 0 should be 1", scores[0], sorted.get(0));
    assertSame("Idx 1 should be 2", scores[1], sorted.get(1));
    assertSame("Idx 2 should be 3", scores[2], sorted.get(2));
    assertSame("Idx 3 should be 5", scores[3], sorted.get(3));
  }
}

