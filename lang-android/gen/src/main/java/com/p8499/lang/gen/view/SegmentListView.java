package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Segment;

public interface SegmentListView {
  void onSegmentListReloaded(List<Segment> segmentList);

  void onSegmentListAppended(List<Segment> segmentList);
}
