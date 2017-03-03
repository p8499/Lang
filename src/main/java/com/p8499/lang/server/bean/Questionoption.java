package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Questionoption {
  public static final String TABLE = "public.F1202";
  public static final String VIEW = "public.F1202";
  public static final String NAME = "QUESTIONOPTION";

  public static final String FIELD_TOID = "TOID";
  public static final String FIELD_TOTQID = "TOTQID";
  public static final String FIELD_TOO = "TOO";
  public static final String FIELD_TOCONT = "TOCONT";

  protected Integer toid = null;

  protected Integer totqid = null;

  protected String too = null;

  protected String tocont = null;

  public Questionoption(Integer toid, Integer totqid, String too, String tocont) {
    if (toid != null) this.toid = toid;
    if (totqid != null) this.totqid = totqid;
    if (too != null) this.too = too;
    if (tocont != null) this.tocont = tocont;
  }

  public Questionoption() {
    this(null, null, null, null);
  }

  public Questionoption clone() {
    return new Questionoption(toid, totqid, too, tocont);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getToid() {
    return toid;
  }

  public Questionoption setToid(Integer toid) {
    this.toid = toid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100000000)
  @javax.validation.constraints.Max(value = 100000000)
  public Integer getTotqid() {
    return totqid;
  }

  public Questionoption setTotqid(Integer totqid) {
    this.totqid = totqid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 1)
  public String getToo() {
    return too;
  }

  public Questionoption setToo(String too) {
    this.too = too;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 32)
  public String getTocont() {
    return tocont;
  }

  public Questionoption setTocont(String tocont) {
    this.tocont = tocont;
    return this;
  }
}
