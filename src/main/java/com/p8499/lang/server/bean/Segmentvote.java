package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Segmentvote {
  public static final String TABLE = "public.F1132";
  public static final String VIEW = "public.F1132";
  public static final String NAME = "SEGMENTVOTE";

  public static final String FIELD_TVID = "TVID";
  public static final String FIELD_TVTAID = "TVTAID";
  public static final String FIELD_TVSI = "TVSI";
  public static final String FIELD_TVUSID = "TVUSID";
  public static final String FIELD_TVPO = "TVPO";
  public static final String FIELD_TVCRDT = "TVCRDT";
  public static final String FIELD_TVUPDT = "TVUPDT";

  public static final Integer TVPO_NEGATIVE = -1;

  public static final Integer TVPO_POSITIVE = 1;

  protected Integer tvid = null;

  protected Integer tvtaid = null;

  protected Integer tvsi = null;

  protected Integer tvusid = null;

  protected Integer tvpo = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date tvcrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date tvupdt = null;

  public Segmentvote(
      Integer tvid,
      Integer tvtaid,
      Integer tvsi,
      Integer tvusid,
      Integer tvpo,
      java.util.Date tvcrdt,
      java.util.Date tvupdt) {
    if (tvid != null) this.tvid = tvid;
    if (tvtaid != null) this.tvtaid = tvtaid;
    if (tvsi != null) this.tvsi = tvsi;
    if (tvusid != null) this.tvusid = tvusid;
    if (tvpo != null) this.tvpo = tvpo;
    if (tvcrdt != null) this.tvcrdt = tvcrdt;
    if (tvupdt != null) this.tvupdt = tvupdt;
  }

  public Segmentvote() {
    this(null, null, null, null, null, null, null);
  }

  public Segmentvote clone() {
    return new Segmentvote(tvid, tvtaid, tvsi, tvusid, tvpo, tvcrdt, tvupdt);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getTvid() {
    return tvid;
  }

  public Segmentvote setTvid(Integer tvid) {
    this.tvid = tvid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getTvtaid() {
    return tvtaid;
  }

  public Segmentvote setTvtaid(Integer tvtaid) {
    this.tvtaid = tvtaid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getTvsi() {
    return tvsi;
  }

  public Segmentvote setTvsi(Integer tvsi) {
    this.tvsi = tvsi;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getTvusid() {
    return tvusid;
  }

  public Segmentvote setTvusid(Integer tvusid) {
    this.tvusid = tvusid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100)
  @javax.validation.constraints.Max(value = 100)
  public Integer getTvpo() {
    return tvpo;
  }

  public Segmentvote setTvpo(Integer tvpo) {
    this.tvpo = tvpo;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getTvcrdt() {
    return tvcrdt;
  }

  public Segmentvote setTvcrdt(java.util.Date tvcrdt) {
    this.tvcrdt = tvcrdt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getTvupdt() {
    return tvupdt;
  }

  public Segmentvote setTvupdt(java.util.Date tvupdt) {
    this.tvupdt = tvupdt;
    return this;
  }
}
