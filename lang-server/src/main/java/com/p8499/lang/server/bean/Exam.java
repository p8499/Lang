package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Exam {
  public static final String TABLE = "public.F1211";
  public static final String VIEW = "public.F1211";
  public static final String NAME = "EXAM";

  public static final String FIELD_EXID = "EXID";
  public static final String FIELD_EXUSID = "EXUSID";
  public static final String FIELD_EXSI = "EXSI";
  public static final String FIELD_EXLSID = "EXLSID";
  public static final String FIELD_EXLV = "EXLV";
  public static final String FIELD_EXCRDT = "EXCRDT";
  public static final String FIELD_EXUPDT = "EXUPDT";
  public static final String FIELD_EXTS = "EXTS";
  public static final String FIELD_EXSC = "EXSC";

  public static final Integer EXLV_A = 20;

  public static final Integer EXLV_B = 10;

  protected Integer exid = null;

  protected Integer exusid = null;

  protected Integer exsi = null;

  protected String exlsid = null;

  protected Integer exlv = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date excrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date exupdt = null;

  protected Integer exts = null;

  protected Integer exsc = null;

  public Exam(
      Integer exid,
      Integer exusid,
      Integer exsi,
      String exlsid,
      Integer exlv,
      java.util.Date excrdt,
      java.util.Date exupdt,
      Integer exts,
      Integer exsc) {
    if (exid != null) this.exid = exid;
    if (exusid != null) this.exusid = exusid;
    if (exsi != null) this.exsi = exsi;
    if (exlsid != null) this.exlsid = exlsid;
    if (exlv != null) this.exlv = exlv;
    if (excrdt != null) this.excrdt = excrdt;
    if (exupdt != null) this.exupdt = exupdt;
    if (exts != null) this.exts = exts;
    if (exsc != null) this.exsc = exsc;
  }

  public Exam() {
    this(null, null, null, null, null, null, null, null, null);
  }

  public Exam clone() {
    return new Exam(exid, exusid, exsi, exlsid, exlv, excrdt, exupdt, exts, exsc);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getExid() {
    return exid;
  }

  public Exam setExid(Integer exid) {
    this.exid = exid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getExusid() {
    return exusid;
  }

  public Exam setExusid(Integer exusid) {
    this.exusid = exusid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getExsi() {
    return exsi;
  }

  public Exam setExsi(Integer exsi) {
    this.exsi = exsi;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getExlsid() {
    return exlsid;
  }

  public Exam setExlsid(String exlsid) {
    this.exlsid = exlsid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100)
  @javax.validation.constraints.Max(value = 100)
  public Integer getExlv() {
    return exlv;
  }

  public Exam setExlv(Integer exlv) {
    this.exlv = exlv;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getExcrdt() {
    return excrdt;
  }

  public Exam setExcrdt(java.util.Date excrdt) {
    this.excrdt = excrdt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getExupdt() {
    return exupdt;
  }

  public Exam setExupdt(java.util.Date exupdt) {
    this.exupdt = exupdt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -1000)
  @javax.validation.constraints.Max(value = 1000)
  public Integer getExts() {
    return exts;
  }

  public Exam setExts(Integer exts) {
    this.exts = exts;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -1000)
  @javax.validation.constraints.Max(value = 1000)
  public Integer getExsc() {
    return exsc;
  }

  public Exam setExsc(Integer exsc) {
    this.exsc = exsc;
    return this;
  }
}
