package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {
  public static final String TABLE = "public.F1201";
  public static final String VIEW = "public.F1201";
  public static final String NAME = "QUESTION";

  public static final String FIELD_TQID = "TQID";
  public static final String FIELD_TQLSID = "TQLSID";
  public static final String FIELD_TQLV = "TQLV";
  public static final String FIELD_TQTY = "TQTY";
  public static final String FIELD_TQCONT = "TQCONT";
  public static final String FIELD_TQO = "TQO";
  public static final String FIELD_TQST = "TQST";

  public static final String TQTY_SINGLE = "S";

  public static final String TQTY_MULTIPLE = "M";

  public static final String TQTY_FILLING = "F";

  public static final Integer TQST_ENABLED = 0;

  public static final Integer TQST_DISABLED = -1;

  protected Integer tqid = null;

  protected String tqlsid = null;

  protected Integer tqlv = null;

  protected String tqty = null;

  protected String tqcont = null;

  protected String tqo = null;

  protected Integer tqst = null;

  public Question(
      Integer tqid,
      String tqlsid,
      Integer tqlv,
      String tqty,
      String tqcont,
      String tqo,
      Integer tqst) {
    if (tqid != null) this.tqid = tqid;
    if (tqlsid != null) this.tqlsid = tqlsid;
    if (tqlv != null) this.tqlv = tqlv;
    if (tqty != null) this.tqty = tqty;
    if (tqcont != null) this.tqcont = tqcont;
    if (tqo != null) this.tqo = tqo;
    if (tqst != null) this.tqst = tqst;
  }

  public Question() {
    this(null, null, null, null, null, null, null);
  }

  public Question clone() {
    return new Question(tqid, tqlsid, tqlv, tqty, tqcont, tqo, tqst);
  }

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getTqid() {
    return tqid;
  }

  public Question setTqid(Integer tqid) {
    this.tqid = tqid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getTqlsid() {
    return tqlsid;
  }

  public Question setTqlsid(String tqlsid) {
    this.tqlsid = tqlsid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -100)
  @javax.validation.constraints.Max(value = 100)
  public Integer getTqlv() {
    return tqlv;
  }

  public Question setTqlv(Integer tqlv) {
    this.tqlv = tqlv;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 1)
  public String getTqty() {
    return tqty;
  }

  public Question setTqty(String tqty) {
    this.tqty = tqty;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 128)
  public String getTqcont() {
    return tqcont;
  }

  public Question setTqcont(String tqcont) {
    this.tqcont = tqcont;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 128)
  public String getTqo() {
    return tqo;
  }

  public Question setTqo(String tqo) {
    this.tqo = tqo;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Min(value = -10)
  @javax.validation.constraints.Max(value = 10)
  public Integer getTqst() {
    return tqst;
  }

  public Question setTqst(Integer tqst) {
    this.tqst = tqst;
    return this;
  }
}
