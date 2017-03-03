package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Roleauthority;

public interface RoleauthorityListView {
  void onRoleauthorityListReloaded(List<Roleauthority> roleauthorityList);

  void onRoleauthorityListAppended(List<Roleauthority> roleauthorityList);
}
