package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Segmentflow;

public interface SegmentflowListView {
  void onSegmentflowListReloaded(List<Segmentflow> segmentflowList);

  void onSegmentflowListAppended(List<Segmentflow> segmentflowList);
}
