package com.p8499.lang.gen.view;

import java.util.List;
import com.p8499.lang.gen.bean.User;

public interface UserListView {
  void onUserListReloaded(List<User> userList);

  void onUserListAppended(List<User> userList);
}
