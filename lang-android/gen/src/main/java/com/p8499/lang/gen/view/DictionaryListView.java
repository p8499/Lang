package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Dictionary;

public interface DictionaryListView {
  void onDictionaryListReloaded(List<Dictionary> dictionaryList);

  void onDictionaryListAppended(List<Dictionary> dictionaryList);
}
