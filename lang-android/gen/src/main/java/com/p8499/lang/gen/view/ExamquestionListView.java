package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Examquestion;

public interface ExamquestionListView {
  void onExamquestionListReloaded(List<Examquestion> examquestionList);

  void onExamquestionListAppended(List<Examquestion> examquestionList);
}
