package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Certificate {
  public static final String TABLE = "public.F0331";
  public static final String VIEW = "public.V0331";
  public static final String NAME = "CERTIFICATE";

  public static final String FIELD_CRID = "CRID";
  public static final String FIELD_CRUSID = "CRUSID";
  public static final String FIELD_CRLSID = "CRLSID";
  public static final String FIELD_CRLSNAME = "CRLSNAME";
  public static final String FIELD_CRLSLOC = "CRLSLOC";
  public static final String FIELD_CRLV = "CRLV";
  public static final String FIELD_CREFDT = "CREFDT";
  public static final String FIELD_CREXDT = "CREXDT";

  public static final Integer CRLV_B = 10;

  public static final Integer CRLV_A = 20;

  protected Integer crid = null;

  protected Integer crusid = null;

  protected String crlsid = null;

  protected String crlsname = null;

  protected String crlsloc = null;

  protected Integer crlv = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date crefdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date crexdt = null;

  public Certificate(
      Integer crid,
      Integer crusid,
      String crlsid,
      String crlsname,
      String crlsloc,
      Integer crlv,
      java.util.Date crefdt,
      java.util.Date crexdt) {
    if (crid != null) this.crid = crid;
    if (crusid != null) this.crusid = crusid;
    if (crlsid != null) this.crlsid = crlsid;
    if (crlsname != null) this.crlsname = crlsname;
    if (crlsloc != null) this.crlsloc = crlsloc;
    if (crlv != null) this.crlv = crlv;
    if (crefdt != null) this.crefdt = crefdt;
    if (crexdt != null) this.crexdt = crexdt;
  }

  public Certificate() {
    this(null, null, null, null, null, null, null, null);
  }

  public Certificate clone() {
    return new Certificate(crid, crusid, crlsid, crlsname, crlsloc, crlv, crefdt, crexdt);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getCrid() {
    return crid;
  }

  public Certificate setCrid(Integer crid) {
    this.crid = crid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getCrusid() {
    return crusid;
  }

  public Certificate setCrusid(Integer crusid) {
    this.crusid = crusid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getCrlsid() {
    return crlsid;
  }

  public Certificate setCrlsid(String crlsid) {
    this.crlsid = crlsid;
    return this;
  }

  @javax.validation.constraints.Null(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getCrlsname() {
    return crlsname;
  }

  public Certificate setCrlsname(String crlsname) {
    this.crlsname = crlsname;
    return this;
  }

  @javax.validation.constraints.Null(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 128)
  public String getCrlsloc() {
    return crlsloc;
  }

  public Certificate setCrlsloc(String crlsloc) {
    this.crlsloc = crlsloc;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100)
  @javax.validation.constraints.Max(value = 100)
  public Integer getCrlv() {
    return crlv;
  }

  public Certificate setCrlv(Integer crlv) {
    this.crlv = crlv;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getCrefdt() {
    return crefdt;
  }

  public Certificate setCrefdt(java.util.Date crefdt) {
    this.crefdt = crefdt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getCrexdt() {
    return crexdt;
  }

  public Certificate setCrexdt(java.util.Date crexdt) {
    this.crexdt = crexdt;
    return this;
  }
}
