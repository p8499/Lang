package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Examquestion {
  public static final String TABLE = "public.F1212";
  public static final String VIEW = "public.F1212";
  public static final String NAME = "EXAMQUESTION";

  public static final String FIELD_EQID = "EQID";
  public static final String FIELD_EQEXID = "EQEXID";
  public static final String FIELD_EQSI = "EQSI";
  public static final String FIELD_EQTQID = "EQTQID";
  public static final String FIELD_EQO = "EQO";
  public static final String FIELD_EQTS = "EQTS";
  public static final String FIELD_EQSC = "EQSC";

  protected Integer eqid = null;

  protected Integer eqexid = null;

  protected Integer eqsi = null;

  protected Integer eqtqid = null;

  protected String eqo = null;

  protected Integer eqts = null;

  protected Integer eqsc = null;

  public Examquestion(
      Integer eqid,
      Integer eqexid,
      Integer eqsi,
      Integer eqtqid,
      String eqo,
      Integer eqts,
      Integer eqsc) {
    if (eqid != null) this.eqid = eqid;
    if (eqexid != null) this.eqexid = eqexid;
    if (eqsi != null) this.eqsi = eqsi;
    if (eqtqid != null) this.eqtqid = eqtqid;
    if (eqo != null) this.eqo = eqo;
    if (eqts != null) this.eqts = eqts;
    if (eqsc != null) this.eqsc = eqsc;
  }

  public Examquestion() {
    this(null, null, null, null, null, null, null);
  }

  public Examquestion clone() {
    return new Examquestion(eqid, eqexid, eqsi, eqtqid, eqo, eqts, eqsc);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getEqid() {
    return eqid;
  }

  public Examquestion setEqid(Integer eqid) {
    this.eqid = eqid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getEqexid() {
    return eqexid;
  }

  public Examquestion setEqexid(Integer eqexid) {
    this.eqexid = eqexid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getEqsi() {
    return eqsi;
  }

  public Examquestion setEqsi(Integer eqsi) {
    this.eqsi = eqsi;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getEqtqid() {
    return eqtqid;
  }

  public Examquestion setEqtqid(Integer eqtqid) {
    this.eqtqid = eqtqid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 128)
  public String getEqo() {
    return eqo;
  }

  public Examquestion setEqo(String eqo) {
    this.eqo = eqo;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -1000)
  @javax.validation.constraints.Max(value = 1000)
  public Integer getEqts() {
    return eqts;
  }

  public Examquestion setEqts(Integer eqts) {
    this.eqts = eqts;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -1000)
  @javax.validation.constraints.Max(value = 1000)
  public Integer getEqsc() {
    return eqsc;
  }

  public Examquestion setEqsc(Integer eqsc) {
    this.eqsc = eqsc;
    return this;
  }
}
