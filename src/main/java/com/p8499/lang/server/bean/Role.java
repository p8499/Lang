package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {
  public static final String TABLE = "public.F0310";
  public static final String VIEW = "public.F0310";
  public static final String NAME = "ROLE";

  public static final String FIELD_RLID = "RLID";
  public static final String FIELD_RLNAME = "RLNAME";

  protected String rlid = null;

  protected String rlname = null;

  public Role(String rlid, String rlname) {
    if (rlid != null) this.rlid = rlid;
    if (rlname != null) this.rlname = rlname;
  }

  public Role() {
    this(null, null);
  }

  public Role clone() {
    return new Role(rlid, rlname);
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 8)
  public String getRlid() {
    return rlid;
  }

  public Role setRlid(String rlid) {
    this.rlid = rlid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getRlname() {
    return rlname;
  }

  public Role setRlname(String rlname) {
    this.rlname = rlname;
    return this;
  }
}
