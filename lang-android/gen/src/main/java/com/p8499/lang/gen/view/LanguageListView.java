package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Language;

public interface LanguageListView {
  void onLanguageListReloaded(List<Language> languageList);

  void onLanguageListAppended(List<Language> languageList);
}
