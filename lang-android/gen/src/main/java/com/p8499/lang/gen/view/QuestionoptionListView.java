package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Questionoption;

public interface QuestionoptionListView {
  void onQuestionoptionListReloaded(List<Questionoption> questionoptionList);

  void onQuestionoptionListAppended(List<Questionoption> questionoptionList);
}
