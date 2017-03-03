package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Authority;

public interface AuthorityListView {
  void onAuthorityListReloaded(List<Authority> authorityList);

  void onAuthorityListAppended(List<Authority> authorityList);
}
