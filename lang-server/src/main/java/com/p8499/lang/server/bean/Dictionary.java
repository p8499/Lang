package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dictionary {
  public static final String TABLE = "public.F1011";
  public static final String VIEW = "public.F1011";
  public static final String NAME = "DICTIONARY";

  public static final String FIELD_DCID = "DCID";
  public static final String FIELD_DCLSID = "DCLSID";
  public static final String FIELD_DCHZ = "DCHZ";
  public static final String FIELD_DCPT = "DCPT";
  public static final String FIELD_DCRM = "DCRM";

  protected Integer dcid = null;

  protected String dclsid = null;

  protected String dchz = null;

  protected String dcpt = null;

  protected String dcrm = null;

  public Dictionary(Integer dcid, String dclsid, String dchz, String dcpt, String dcrm) {
    if (dcid != null) this.dcid = dcid;
    if (dclsid != null) this.dclsid = dclsid;
    if (dchz != null) this.dchz = dchz;
    if (dcpt != null) this.dcpt = dcpt;
    if (dcrm != null) this.dcrm = dcrm;
  }

  public Dictionary() {
    this(null, null, null, null, null);
  }

  public Dictionary clone() {
    return new Dictionary(dcid, dclsid, dchz, dcpt, dcrm);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getDcid() {
    return dcid;
  }

  public Dictionary setDcid(Integer dcid) {
    this.dcid = dcid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getDclsid() {
    return dclsid;
  }

  public Dictionary setDclsid(String dclsid) {
    this.dclsid = dclsid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 4)
  public String getDchz() {
    return dchz;
  }

  public Dictionary setDchz(String dchz) {
    this.dchz = dchz;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 32)
  public String getDcpt() {
    return dcpt;
  }

  public Dictionary setDcpt(String dcpt) {
    this.dcpt = dcpt;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 64)
  public String getDcrm() {
    return dcrm;
  }

  public Dictionary setDcrm(String dcrm) {
    this.dcrm = dcrm;
    return this;
  }
}
