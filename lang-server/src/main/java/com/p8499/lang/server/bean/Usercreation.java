package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usercreation {
  public static final String TABLE = "public.F0309";
  public static final String VIEW = "public.F0309";
  public static final String NAME = "USERCREATION";

  public static final String FIELD_UCID = "UCID";
  public static final String FIELD_UCCRDT = "UCCRDT";
  public static final String FIELD_UCUPDT = "UCUPDT";
  public static final String FIELD_UCCELL = "UCCELL";
  public static final String FIELD_UCPV = "UCPV";
  public static final String FIELD_UCMV = "UCMV";
  public static final String FIELD_UCAC = "UCAC";
  public static final String FIELD_UCST = "UCST";

  public static final Integer UCAC_INITIAL = 0;

  public static final Integer UCAC_SENT = 1;

  public static final Integer UCAC_VERIFIED = 2;

  public static final Integer UCAC_FINALIZED = 3;

  public static final Integer UCST_INVALID = -1;

  public static final Integer UCST_VALID = 0;

  public static final Integer DEFAULT_UCAC = 0;

  public static final Integer DEFAULT_UCST = 0;

  protected Integer ucid = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date uccrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date ucupdt = null;

  protected String uccell = null;

  protected String ucpv = null;

  protected String ucmv = null;

  protected Integer ucac = DEFAULT_UCAC;

  protected Integer ucst = DEFAULT_UCST;

  public Usercreation(
      Integer ucid,
      java.util.Date uccrdt,
      java.util.Date ucupdt,
      String uccell,
      String ucpv,
      String ucmv,
      Integer ucac,
      Integer ucst) {
    if (ucid != null) this.ucid = ucid;
    if (uccrdt != null) this.uccrdt = uccrdt;
    if (ucupdt != null) this.ucupdt = ucupdt;
    if (uccell != null) this.uccell = uccell;
    if (ucpv != null) this.ucpv = ucpv;
    if (ucmv != null) this.ucmv = ucmv;
    if (ucac != null) this.ucac = ucac;
    if (ucst != null) this.ucst = ucst;
  }

  public Usercreation() {
    this(null, null, null, null, null, null, null, null);
  }

  public Usercreation clone() {
    return new Usercreation(ucid, uccrdt, ucupdt, uccell, ucpv, ucmv, ucac, ucst);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getUcid() {
    return ucid;
  }

  public Usercreation setUcid(Integer ucid) {
    this.ucid = ucid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getUccrdt() {
    return uccrdt;
  }

  public Usercreation setUccrdt(java.util.Date uccrdt) {
    this.uccrdt = uccrdt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  public java.util.Date getUcupdt() {
    return ucupdt;
  }

  public Usercreation setUcupdt(java.util.Date ucupdt) {
    this.ucupdt = ucupdt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getUccell() {
    return uccell;
  }

  public Usercreation setUccell(String uccell) {
    this.uccell = uccell;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 6)
  public String getUcpv() {
    return ucpv;
  }

  public Usercreation setUcpv(String ucpv) {
    this.ucpv = ucpv;
    return this;
  }

  @javax.validation.constraints.Size(max = 6)
  public String getUcmv() {
    return ucmv;
  }

  public Usercreation setUcmv(String ucmv) {
    this.ucmv = ucmv;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10)
  @javax.validation.constraints.Max(value = 10)
  public Integer getUcac() {
    return ucac;
  }

  public Usercreation setUcac(Integer ucac) {
    this.ucac = ucac;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10)
  @javax.validation.constraints.Max(value = 10)
  public Integer getUcst() {
    return ucst;
  }

  public Usercreation setUcst(Integer ucst) {
    this.ucst = ucst;
    return this;
  }
}
