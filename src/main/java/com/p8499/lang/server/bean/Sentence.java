package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sentence {
  public static final String TABLE = "public.F1120";
  public static final String VIEW = "public.V1120";
  public static final String NAME = "SENTENCE";

  public static final String FIELD_ASID = "ASID";
  public static final String FIELD_ASATID = "ASATID";
  public static final String FIELD_ASSI = "ASSI";
  public static final String FIELD_ASCONT = "ASCONT";
  public static final String FIELD_ASST = "ASST";
  public static final String FIELD_ASCS = "ASCS";
  public static final String FIELD_ASUSID = "ASUSID";
  public static final String FIELD_ASCRDT = "ASCRDT";
  public static final String FIELD_ASUPDT = "ASUPDT";

  public static final Integer ASST_DISABLED = -1;

  public static final Integer ASST_ENABLED = 0;

  public static final Integer DEFAULT_ASST = 0;

  protected Integer asid = null;

  protected Integer asatid = null;

  protected Integer assi = null;

  protected String ascont = null;

  protected Integer asst = DEFAULT_ASST;

  protected String ascs = null;

  protected Integer asusid = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date ascrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date asupdt = null;

  public Sentence(
      Integer asid,
      Integer asatid,
      Integer assi,
      String ascont,
      Integer asst,
      String ascs,
      Integer asusid,
      java.util.Date ascrdt,
      java.util.Date asupdt) {
    if (asid != null) this.asid = asid;
    if (asatid != null) this.asatid = asatid;
    if (assi != null) this.assi = assi;
    if (ascont != null) this.ascont = ascont;
    if (asst != null) this.asst = asst;
    if (ascs != null) this.ascs = ascs;
    if (asusid != null) this.asusid = asusid;
    if (ascrdt != null) this.ascrdt = ascrdt;
    if (asupdt != null) this.asupdt = asupdt;
  }

  public Sentence() {
    this(null, null, null, null, null, null, null, null, null);
  }

  public Sentence clone() {
    return new Sentence(asid, asatid, assi, ascont, asst, ascs, asusid, ascrdt, asupdt);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getAsid() {
    return asid;
  }

  public Sentence setAsid(Integer asid) {
    this.asid = asid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getAsatid() {
    return asatid;
  }

  public Sentence setAsatid(Integer asatid) {
    this.asatid = asatid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getAssi() {
    return assi;
  }

  public Sentence setAssi(Integer assi) {
    this.assi = assi;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 64)
  public String getAscont() {
    return ascont;
  }

  public Sentence setAscont(String ascont) {
    this.ascont = ascont;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10)
  @javax.validation.constraints.Max(value = 10)
  public Integer getAsst() {
    return asst;
  }

  public Sentence setAsst(Integer asst) {
    this.asst = asst;
    return this;
  }

  @javax.validation.constraints.Null(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 1)
  public String getAscs() {
    return ascs;
  }

  public Sentence setAscs(String ascs) {
    this.ascs = ascs;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getAsusid() {
    return asusid;
  }

  public Sentence setAsusid(Integer asusid) {
    this.asusid = asusid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getAscrdt() {
    return ascrdt;
  }

  public Sentence setAscrdt(java.util.Date ascrdt) {
    this.ascrdt = ascrdt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getAsupdt() {
    return asupdt;
  }

  public Sentence setAsupdt(java.util.Date asupdt) {
    this.asupdt = asupdt;
    return this;
  }
}
