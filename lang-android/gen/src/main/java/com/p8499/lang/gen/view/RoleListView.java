package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Role;

public interface RoleListView {
  void onRoleListReloaded(List<Role> roleList);

  void onRoleListAppended(List<Role> roleList);
}
