package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {
  public static final String TABLE = "public.F1030";
  public static final String VIEW = "public.F1030";
  public static final String NAME = "CATEGORY";

  public static final String FIELD_CGID = "CGID";
  public static final String FIELD_CGLSID = "CGLSID";
  public static final String FIELD_CGSI = "CGSI";
  public static final String FIELD_CGPSI = "CGPSI";
  public static final String FIELD_CGUSID = "CGUSID";
  public static final String FIELD_CGNAME = "CGNAME";

  protected Integer cgid = null;

  protected String cglsid = null;

  protected Integer cgsi = null;

  protected Integer cgpsi = null;

  protected Integer cgusid = null;

  protected String cgname = null;

  public Category(
      Integer cgid, String cglsid, Integer cgsi, Integer cgpsi, Integer cgusid, String cgname) {
    if (cgid != null) this.cgid = cgid;
    if (cglsid != null) this.cglsid = cglsid;
    if (cgsi != null) this.cgsi = cgsi;
    if (cgpsi != null) this.cgpsi = cgpsi;
    if (cgusid != null) this.cgusid = cgusid;
    if (cgname != null) this.cgname = cgname;
  }

  public Category() {
    this(null, null, null, null, null, null);
  }

  public Category clone() {
    return new Category(cgid, cglsid, cgsi, cgpsi, cgusid, cgname);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getCgid() {
    return cgid;
  }

  public Category setCgid(Integer cgid) {
    this.cgid = cgid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getCglsid() {
    return cglsid;
  }

  public Category setCglsid(String cglsid) {
    this.cglsid = cglsid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getCgsi() {
    return cgsi;
  }

  public Category setCgsi(Integer cgsi) {
    this.cgsi = cgsi;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getCgpsi() {
    return cgpsi;
  }

  public Category setCgpsi(Integer cgpsi) {
    this.cgpsi = cgpsi;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getCgusid() {
    return cgusid;
  }

  public Category setCgusid(Integer cgusid) {
    this.cgusid = cgusid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getCgname() {
    return cgname;
  }

  public Category setCgname(String cgname) {
    this.cgname = cgname;
    return this;
  }
}
