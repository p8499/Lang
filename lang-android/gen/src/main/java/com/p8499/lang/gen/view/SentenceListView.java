package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Sentence;

public interface SentenceListView {
  void onSentenceListReloaded(List<Sentence> sentenceList);

  void onSentenceListAppended(List<Sentence> sentenceList);
}
