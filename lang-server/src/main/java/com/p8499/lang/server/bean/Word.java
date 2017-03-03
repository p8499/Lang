package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Word {
  public static final String TABLE = "public.F1040";
  public static final String VIEW = "public.F1040";
  public static final String NAME = "WORD";

  public static final String FIELD_WOID = "WOID";
  public static final String FIELD_WOLSID = "WOLSID";
  public static final String FIELD_WOPT = "WOPT";
  public static final String FIELD_WOHZ = "WOHZ";
  public static final String FIELD_WOCL = "WOCL";
  public static final String FIELD_WOST = "WOST";
  public static final String FIELD_WOSR = "WOSR";
  public static final String FIELD_WOSORT = "WOSORT";
  public static final String FIELD_WOCRDT = "WOCRDT";
  public static final String FIELD_WOUPDT = "WOUPDT";

  public static final String WOCL_UNIT = "U";

  public static final String WOCL_MULTIPLE = "M";

  public static final Integer WOST_DISABLED = -1;

  public static final Integer WOST_ENABLED = 0;

  public static final String WOSR_MANUAL = "M";

  public static final String WOSR_DICTIONARY = "D";

  public static final String WOSR_SEGMENT = "S";

  public static final Integer DEFAULT_WOST = 0;

  public static final String DEFAULT_WOSR = "M";

  protected Integer woid = null;

  protected String wolsid = null;

  protected String wopt = null;

  protected String wohz = null;

  protected String wocl = null;

  protected Integer wost = DEFAULT_WOST;

  protected String wosr = DEFAULT_WOSR;

  protected Integer wosort = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date wocrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date woupdt = null;

  public Word(
      Integer woid,
      String wolsid,
      String wopt,
      String wohz,
      String wocl,
      Integer wost,
      String wosr,
      Integer wosort,
      java.util.Date wocrdt,
      java.util.Date woupdt) {
    if (woid != null) this.woid = woid;
    if (wolsid != null) this.wolsid = wolsid;
    if (wopt != null) this.wopt = wopt;
    if (wohz != null) this.wohz = wohz;
    if (wocl != null) this.wocl = wocl;
    if (wost != null) this.wost = wost;
    if (wosr != null) this.wosr = wosr;
    if (wosort != null) this.wosort = wosort;
    if (wocrdt != null) this.wocrdt = wocrdt;
    if (woupdt != null) this.woupdt = woupdt;
  }

  public Word() {
    this(null, null, null, null, null, null, null, null, null, null);
  }

  public Word clone() {
    return new Word(woid, wolsid, wopt, wohz, wocl, wost, wosr, wosort, wocrdt, woupdt);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getWoid() {
    return woid;
  }

  public Word setWoid(Integer woid) {
    this.woid = woid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getWolsid() {
    return wolsid;
  }

  public Word setWolsid(String wolsid) {
    this.wolsid = wolsid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 64)
  public String getWopt() {
    return wopt;
  }

  public Word setWopt(String wopt) {
    this.wopt = wopt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 8)
  public String getWohz() {
    return wohz;
  }

  public Word setWohz(String wohz) {
    this.wohz = wohz;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 1)
  public String getWocl() {
    return wocl;
  }

  public Word setWocl(String wocl) {
    this.wocl = wocl;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10)
  @javax.validation.constraints.Max(value = 10)
  public Integer getWost() {
    return wost;
  }

  public Word setWost(Integer wost) {
    this.wost = wost;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 1)
  public String getWosr() {
    return wosr;
  }

  public Word setWosr(String wosr) {
    this.wosr = wosr;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10000)
  @javax.validation.constraints.Max(value = 10000)
  public Integer getWosort() {
    return wosort;
  }

  public Word setWosort(Integer wosort) {
    this.wosort = wosort;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getWocrdt() {
    return wocrdt;
  }

  public Word setWocrdt(java.util.Date wocrdt) {
    this.wocrdt = wocrdt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getWoupdt() {
    return woupdt;
  }

  public Word setWoupdt(java.util.Date woupdt) {
    this.woupdt = woupdt;
    return this;
  }
}
