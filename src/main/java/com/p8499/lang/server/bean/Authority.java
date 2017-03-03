package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Authority {
  public static final String TABLE = "public.F0320";
  public static final String VIEW = "public.F0320";
  public static final String NAME = "AUTHORITY";

  public static final String FIELD_AUID = "AUID";
  public static final String FIELD_AUNAME = "AUNAME";

  protected String auid = null;

  protected String auname = null;

  public Authority(String auid, String auname) {
    if (auid != null) this.auid = auid;
    if (auname != null) this.auname = auname;
  }

  public Authority() {
    this(null, null);
  }

  public Authority clone() {
    return new Authority(auid, auname);
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getAuid() {
    return auid;
  }

  public Authority setAuid(String auid) {
    this.auid = auid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getAuname() {
    return auname;
  }

  public Authority setAuname(String auname) {
    this.auname = auname;
    return this;
  }
}
