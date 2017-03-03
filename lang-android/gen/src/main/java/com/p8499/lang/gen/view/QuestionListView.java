package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Question;

public interface QuestionListView {
  void onQuestionListReloaded(List<Question> questionList);

  void onQuestionListAppended(List<Question> questionList);
}
