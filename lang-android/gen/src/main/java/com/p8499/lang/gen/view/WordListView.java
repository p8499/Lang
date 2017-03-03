package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Word;

public interface WordListView {
  void onWordListReloaded(List<Word> wordList);

  void onWordListAppended(List<Word> wordList);
}
