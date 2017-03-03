package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Segmentflow {
  public static final String TABLE = "public.F1131";
  public static final String VIEW = "public.F1131";
  public static final String NAME = "SEGMENTFLOW";

  public static final String FIELD_TAID = "TAID";
  public static final String FIELD_TAASID = "TAASID";
  public static final String FIELD_TASI = "TASI";
  public static final String FIELD_TAPI = "TAPI";
  public static final String FIELD_TAHZ = "TAHZ";
  public static final String FIELD_TAST = "TAST";
  public static final String FIELD_TAUSID = "TAUSID";
  public static final String FIELD_TACRDT = "TACRDT";
  public static final String FIELD_TAUPDT = "TAUPDT";

  public static final Integer TAST_VOTING = 1;

  public static final Integer TAST_PASSED = 2;

  public static final Integer TAST_DENIED = 3;

  public static final Integer TAST_RECALLED = 4;

  protected Integer taid = null;

  protected Integer taasid = null;

  protected Integer tasi = null;

  protected String tapi = null;

  protected String tahz = null;

  protected Integer tast = null;

  protected Integer tausid = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date tacrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date taupdt = null;

  public Segmentflow(
      Integer taid,
      Integer taasid,
      Integer tasi,
      String tapi,
      String tahz,
      Integer tast,
      Integer tausid,
      java.util.Date tacrdt,
      java.util.Date taupdt) {
    if (taid != null) this.taid = taid;
    if (taasid != null) this.taasid = taasid;
    if (tasi != null) this.tasi = tasi;
    if (tapi != null) this.tapi = tapi;
    if (tahz != null) this.tahz = tahz;
    if (tast != null) this.tast = tast;
    if (tausid != null) this.tausid = tausid;
    if (tacrdt != null) this.tacrdt = tacrdt;
    if (taupdt != null) this.taupdt = taupdt;
  }

  public Segmentflow() {
    this(null, null, null, null, null, null, null, null, null);
  }

  public Segmentflow clone() {
    return new Segmentflow(taid, taasid, tasi, tapi, tahz, tast, tausid, tacrdt, taupdt);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getTaid() {
    return taid;
  }

  public Segmentflow setTaid(Integer taid) {
    this.taid = taid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getTaasid() {
    return taasid;
  }

  public Segmentflow setTaasid(Integer taasid) {
    this.taasid = taasid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getTasi() {
    return tasi;
  }

  public Segmentflow setTasi(Integer tasi) {
    this.tasi = tasi;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 512)
  public String getTapi() {
    return tapi;
  }

  public Segmentflow setTapi(String tapi) {
    this.tapi = tapi;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 64)
  public String getTahz() {
    return tahz;
  }

  public Segmentflow setTahz(String tahz) {
    this.tahz = tahz;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10)
  @javax.validation.constraints.Max(value = 10)
  public Integer getTast() {
    return tast;
  }

  public Segmentflow setTast(Integer tast) {
    this.tast = tast;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getTausid() {
    return tausid;
  }

  public Segmentflow setTausid(Integer tausid) {
    this.tausid = tausid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getTacrdt() {
    return tacrdt;
  }

  public Segmentflow setTacrdt(java.util.Date tacrdt) {
    this.tacrdt = tacrdt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getTaupdt() {
    return taupdt;
  }

  public Segmentflow setTaupdt(java.util.Date taupdt) {
    this.taupdt = taupdt;
    return this;
  }
}
