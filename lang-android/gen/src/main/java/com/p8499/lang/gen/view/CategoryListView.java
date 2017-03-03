package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Category;

public interface CategoryListView {
  void onCategoryListReloaded(List<Category> categoryList);

  void onCategoryListAppended(List<Category> categoryList);
}
