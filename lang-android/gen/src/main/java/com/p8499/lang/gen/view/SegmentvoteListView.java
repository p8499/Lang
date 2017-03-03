package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Segmentvote;

public interface SegmentvoteListView {
  void onSegmentvoteListReloaded(List<Segmentvote> segmentvoteList);

  void onSegmentvoteListAppended(List<Segmentvote> segmentvoteList);
}
