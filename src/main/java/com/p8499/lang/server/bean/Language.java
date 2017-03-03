package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Language {
  public static final String TABLE = "public.F1010";
  public static final String VIEW = "public.F1010";
  public static final String NAME = "LANGUAGE";

  public static final String FIELD_LSID = "LSID";
  public static final String FIELD_LSNAME = "LSNAME";
  public static final String FIELD_LSLOC = "LSLOC";
  public static final String FIELD_LSSORT = "LSSORT";

  protected String lsid = null;

  protected String lsname = null;

  protected String lsloc = null;

  protected Integer lssort = null;

  public Language(String lsid, String lsname, String lsloc, Integer lssort) {
    if (lsid != null) this.lsid = lsid;
    if (lsname != null) this.lsname = lsname;
    if (lsloc != null) this.lsloc = lsloc;
    if (lssort != null) this.lssort = lssort;
  }

  public Language() {
    this(null, null, null, null);
  }

  public Language clone() {
    return new Language(lsid, lsname, lsloc, lssort);
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getLsid() {
    return lsid;
  }

  public Language setLsid(String lsid) {
    this.lsid = lsid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getLsname() {
    return lsname;
  }

  public Language setLsname(String lsname) {
    this.lsname = lsname;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 128)
  public String getLsloc() {
    return lsloc;
  }

  public Language setLsloc(String lsloc) {
    this.lsloc = lsloc;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10000)
  @javax.validation.constraints.Max(value = 10000)
  public Integer getLssort() {
    return lssort;
  }

  public Language setLssort(Integer lssort) {
    this.lssort = lssort;
    return this;
  }
}
