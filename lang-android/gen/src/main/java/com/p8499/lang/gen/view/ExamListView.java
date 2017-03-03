package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Exam;

public interface ExamListView {
  void onExamListReloaded(List<Exam> examList);

  void onExamListAppended(List<Exam> examList);
}
