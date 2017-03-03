package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.Usercreation;

public interface UsercreationListView {
  void onUsercreationListReloaded(List<Usercreation> usercreationList);

  void onUsercreationListAppended(List<Usercreation> usercreationList);
}
