package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Userrole;

public interface UserroleListView {
  void onUserroleListReloaded(List<Userrole> userroleList);

  void onUserroleListAppended(List<Userrole> userroleList);
}
