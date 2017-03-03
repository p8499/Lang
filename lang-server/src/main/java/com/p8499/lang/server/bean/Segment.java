package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Segment {
  public static final String TABLE = "public.F1130";
  public static final String VIEW = "public.F1130";
  public static final String NAME = "SEGMENT";

  public static final String FIELD_TRASID = "TRASID";
  public static final String FIELD_TRPI = "TRPI";
  public static final String FIELD_TRHZ = "TRHZ";
  public static final String FIELD_TRST = "TRST";
  public static final String FIELD_TRUSID = "TRUSID";
  public static final String FIELD_TRCRDT = "TRCRDT";
  public static final String FIELD_TRUPDT = "TRUPDT";

  public static final Integer TRST_DISABLED = -1;

  public static final Integer TRST_ENABLED = 0;

  public static final Integer DEFAULT_TRST = 0;

  protected Integer trasid = null;

  protected String trpi = null;

  protected String trhz = null;

  protected Integer trst = DEFAULT_TRST;

  protected Integer trusid = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date trcrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date trupdt = null;

  public Segment(
      Integer trasid,
      String trpi,
      String trhz,
      Integer trst,
      Integer trusid,
      java.util.Date trcrdt,
      java.util.Date trupdt) {
    if (trasid != null) this.trasid = trasid;
    if (trpi != null) this.trpi = trpi;
    if (trhz != null) this.trhz = trhz;
    if (trst != null) this.trst = trst;
    if (trusid != null) this.trusid = trusid;
    if (trcrdt != null) this.trcrdt = trcrdt;
    if (trupdt != null) this.trupdt = trupdt;
  }

  public Segment() {
    this(null, null, null, null, null, null, null);
  }

  public Segment clone() {
    return new Segment(trasid, trpi, trhz, trst, trusid, trcrdt, trupdt);
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getTrasid() {
    return trasid;
  }

  public Segment setTrasid(Integer trasid) {
    this.trasid = trasid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 512)
  public String getTrpi() {
    return trpi;
  }

  public Segment setTrpi(String trpi) {
    this.trpi = trpi;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 64)
  public String getTrhz() {
    return trhz;
  }

  public Segment setTrhz(String trhz) {
    this.trhz = trhz;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10)
  @javax.validation.constraints.Max(value = 10)
  public Integer getTrst() {
    return trst;
  }

  public Segment setTrst(Integer trst) {
    this.trst = trst;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getTrusid() {
    return trusid;
  }

  public Segment setTrusid(Integer trusid) {
    this.trusid = trusid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getTrcrdt() {
    return trcrdt;
  }

  public Segment setTrcrdt(java.util.Date trcrdt) {
    this.trcrdt = trcrdt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getTrupdt() {
    return trupdt;
  }

  public Segment setTrupdt(java.util.Date trupdt) {
    this.trupdt = trupdt;
    return this;
  }
}
