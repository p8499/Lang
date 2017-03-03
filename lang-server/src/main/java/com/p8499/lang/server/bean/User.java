package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
  public static final String TABLE = "public.F0301";
  public static final String VIEW = "public.V0301";
  public static final String NAME = "USER";

  public static final String FIELD_USID = "USID";
  public static final String FIELD_USCELL = "USCELL";
  public static final String FIELD_USPSWD = "USPSWD";
  public static final String FIELD_USNAME = "USNAME";
  public static final String FIELD_USST = "USST";
  public static final String FIELD_USLSID = "USLSID";
  public static final String FIELD_USLSNAME = "USLSNAME";

  public static final Integer USST_DISABLED = -1;

  public static final Integer USST_ENABLED = 0;

  public static final Integer DEFAULT_USST = 0;

  protected Integer usid = null;

  protected String uscell = null;

  protected String uspswd = null;

  protected String usname = null;

  protected Integer usst = DEFAULT_USST;

  protected String uslsid = null;

  protected String uslsname = null;

  public User(
      Integer usid,
      String uscell,
      String uspswd,
      String usname,
      Integer usst,
      String uslsid,
      String uslsname) {
    if (usid != null) this.usid = usid;
    if (uscell != null) this.uscell = uscell;
    if (uspswd != null) this.uspswd = uspswd;
    if (usname != null) this.usname = usname;
    if (usst != null) this.usst = usst;
    if (uslsid != null) this.uslsid = uslsid;
    if (uslsname != null) this.uslsname = uslsname;
  }

  public User() {
    this(null, null, null, null, null, null, null);
  }

  public User clone() {
    return new User(usid, uscell, uspswd, usname, usst, uslsid, uslsname);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getUsid() {
    return usid;
  }

  public User setUsid(Integer usid) {
    this.usid = usid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getUscell() {
    return uscell;
  }

  public User setUscell(String uscell) {
    this.uscell = uscell;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 32)
  public String getUspswd() {
    return uspswd;
  }

  public User setUspswd(String uspswd) {
    this.uspswd = uspswd;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getUsname() {
    return usname;
  }

  public User setUsname(String usname) {
    this.usname = usname;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10)
  @javax.validation.constraints.Max(value = 10)
  public Integer getUsst() {
    return usst;
  }

  public User setUsst(Integer usst) {
    this.usst = usst;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getUslsid() {
    return uslsid;
  }

  public User setUslsid(String uslsid) {
    this.uslsid = uslsid;
    return this;
  }

  @javax.validation.constraints.Null(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getUslsname() {
    return uslsname;
  }

  public User setUslsname(String uslsname) {
    this.uslsname = uslsname;
    return this;
  }
}
