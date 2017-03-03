package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Article;

public interface ArticleListView {
  void onArticleListReloaded(List<Article> articleList);

  void onArticleListAppended(List<Article> articleList);
}
