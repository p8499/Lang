package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Userrole {
  public static final String TABLE = "public.F0311";
  public static final String VIEW = "public.F0311";
  public static final String NAME = "USERROLE";

  public static final String FIELD_URID = "URID";
  public static final String FIELD_URUSID = "URUSID";
  public static final String FIELD_URRLID = "URRLID";

  protected Integer urid = null;

  protected Integer urusid = null;

  protected String urrlid = null;

  public Userrole(Integer urid, Integer urusid, String urrlid) {
    if (urid != null) this.urid = urid;
    if (urusid != null) this.urusid = urusid;
    if (urrlid != null) this.urrlid = urrlid;
  }

  public Userrole() {
    this(null, null, null);
  }

  public Userrole clone() {
    return new Userrole(urid, urusid, urrlid);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getUrid() {
    return urid;
  }

  public Userrole setUrid(Integer urid) {
    this.urid = urid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getUrusid() {
    return urusid;
  }

  public Userrole setUrusid(Integer urusid) {
    this.urusid = urusid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 8)
  public String getUrrlid() {
    return urrlid;
  }

  public Userrole setUrrlid(String urrlid) {
    this.urrlid = urrlid;
    return this;
  }
}
