package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Article {
  public static final String TABLE = "public.F1110";
  public static final String VIEW = "public.V1110";
  public static final String NAME = "ARTICLE";

  public static final String FIELD_ATID = "ATID";
  public static final String FIELD_ATCGID = "ATCGID";
  public static final String FIELD_ATSI = "ATSI";
  public static final String FIELD_ATNAME = "ATNAME";
  public static final String FIELD_ATUSID = "ATUSID";
  public static final String FIELD_ATBRF = "ATBRF";
  public static final String FIELD_ATCSA = "ATCSA";
  public static final String FIELD_ATCSB = "ATCSB";
  public static final String FIELD_ATCSC = "ATCSC";
  public static final String FIELD_ATCSD = "ATCSD";
  public static final String FIELD_ATCSE = "ATCSE";
  public static final String FIELD_ATCSF = "ATCSF";
  public static final String FIELD_ATCRDT = "ATCRDT";
  public static final String FIELD_ATUPDT = "ATUPDT";

  protected Integer atid = null;

  protected Integer atcgid = null;

  protected Integer atsi = null;

  protected String atname = null;

  protected Integer atusid = null;

  protected String atbrf = null;

  protected Integer atcsa = null;

  protected Integer atcsb = null;

  protected Integer atcsc = null;

  protected Integer atcsd = null;

  protected Integer atcse = null;

  protected Integer atcsf = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date atcrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date atupdt = null;

  public Article(
      Integer atid,
      Integer atcgid,
      Integer atsi,
      String atname,
      Integer atusid,
      String atbrf,
      Integer atcsa,
      Integer atcsb,
      Integer atcsc,
      Integer atcsd,
      Integer atcse,
      Integer atcsf,
      java.util.Date atcrdt,
      java.util.Date atupdt) {
    if (atid != null) this.atid = atid;
    if (atcgid != null) this.atcgid = atcgid;
    if (atsi != null) this.atsi = atsi;
    if (atname != null) this.atname = atname;
    if (atusid != null) this.atusid = atusid;
    if (atbrf != null) this.atbrf = atbrf;
    if (atcsa != null) this.atcsa = atcsa;
    if (atcsb != null) this.atcsb = atcsb;
    if (atcsc != null) this.atcsc = atcsc;
    if (atcsd != null) this.atcsd = atcsd;
    if (atcse != null) this.atcse = atcse;
    if (atcsf != null) this.atcsf = atcsf;
    if (atcrdt != null) this.atcrdt = atcrdt;
    if (atupdt != null) this.atupdt = atupdt;
  }

  public Article() {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
  }

  public Article clone() {
    return new Article(
        atid, atcgid, atsi, atname, atusid, atbrf, atcsa, atcsb, atcsc, atcsd, atcse, atcsf, atcrdt,
        atupdt);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getAtid() {
    return atid;
  }

  public Article setAtid(Integer atid) {
    this.atid = atid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getAtcgid() {
    return atcgid;
  }

  public Article setAtcgid(Integer atcgid) {
    this.atcgid = atcgid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getAtsi() {
    return atsi;
  }

  public Article setAtsi(Integer atsi) {
    this.atsi = atsi;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getAtname() {
    return atname;
  }

  public Article setAtname(String atname) {
    this.atname = atname;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getAtusid() {
    return atusid;
  }

  public Article setAtusid(Integer atusid) {
    this.atusid = atusid;
    return this;
  }

  @javax.validation.constraints.Null(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 96)
  public String getAtbrf() {
    return atbrf;
  }

  public Article setAtbrf(String atbrf) {
    this.atbrf = atbrf;
    return this;
  }

  @javax.validation.constraints.Null(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10000)
  @javax.validation.constraints.Max(value = 10000)
  public Integer getAtcsa() {
    return atcsa;
  }

  public Article setAtcsa(Integer atcsa) {
    this.atcsa = atcsa;
    return this;
  }

  @javax.validation.constraints.Null(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10000)
  @javax.validation.constraints.Max(value = 10000)
  public Integer getAtcsb() {
    return atcsb;
  }

  public Article setAtcsb(Integer atcsb) {
    this.atcsb = atcsb;
    return this;
  }

  @javax.validation.constraints.Null(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10000)
  @javax.validation.constraints.Max(value = 10000)
  public Integer getAtcsc() {
    return atcsc;
  }

  public Article setAtcsc(Integer atcsc) {
    this.atcsc = atcsc;
    return this;
  }

  @javax.validation.constraints.Null(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10000)
  @javax.validation.constraints.Max(value = 10000)
  public Integer getAtcsd() {
    return atcsd;
  }

  public Article setAtcsd(Integer atcsd) {
    this.atcsd = atcsd;
    return this;
  }

  @javax.validation.constraints.Null(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10000)
  @javax.validation.constraints.Max(value = 10000)
  public Integer getAtcse() {
    return atcse;
  }

  public Article setAtcse(Integer atcse) {
    this.atcse = atcse;
    return this;
  }

  @javax.validation.constraints.Null(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10000)
  @javax.validation.constraints.Max(value = 10000)
  public Integer getAtcsf() {
    return atcsf;
  }

  public Article setAtcsf(Integer atcsf) {
    this.atcsf = atcsf;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getAtcrdt() {
    return atcrdt;
  }

  public Article setAtcrdt(java.util.Date atcrdt) {
    this.atcrdt = atcrdt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getAtupdt() {
    return atupdt;
  }

  public Article setAtupdt(java.util.Date atupdt) {
    this.atupdt = atupdt;
    return this;
  }
}
