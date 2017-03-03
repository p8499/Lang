package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.QuestionMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question implements Parcelable {
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

  public Question(Parcel in) {

    this.tqid = in.readInt();

    this.tqlsid = in.readString();

    this.tqlv = in.readInt();

    this.tqty = in.readString();

    this.tqcont = in.readString();

    this.tqo = in.readString();

    this.tqst = in.readInt();
  }

  public Integer getTqid() {
    return tqid;
  }

  public Question setTqid(Integer tqid) {
    this.tqid = tqid;
    return this;
  }

  public String getTqlsid() {
    return tqlsid;
  }

  public Question setTqlsid(String tqlsid) {
    this.tqlsid = tqlsid;
    return this;
  }

  public Integer getTqlv() {
    return tqlv;
  }

  public Question setTqlv(Integer tqlv) {
    this.tqlv = tqlv;
    return this;
  }

  public String getTqty() {
    return tqty;
  }

  public Question setTqty(String tqty) {
    this.tqty = tqty;
    return this;
  }

  public String getTqcont() {
    return tqcont;
  }

  public Question setTqcont(String tqcont) {
    this.tqcont = tqcont;
    return this;
  }

  public String getTqo() {
    return tqo;
  }

  public Question setTqo(String tqo) {
    this.tqo = tqo;
    return this;
  }

  public Integer getTqst() {
    return tqst;
  }

  public Question setTqst(Integer tqst) {
    this.tqst = tqst;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(tqid);

    dest.writeString(tqlsid);

    dest.writeInt(tqlv);

    dest.writeString(tqty);

    dest.writeString(tqcont);

    dest.writeString(tqo);

    dest.writeInt(tqst);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Question) ? equals((Question) obj, new QuestionMask().all(true)) : false;
  }

  public boolean equals(Question bean, QuestionMask mask) {
    if (mask == null) mask = new QuestionMask().all(true);

    if (mask.getTqid()
        && !(getTqid() == null && bean.getTqid() == null
            || getTqid() != null && bean.getTqid() != null && getTqid().equals(bean.getTqid())))
      return false;
    if (mask.getTqlsid()
        && !(getTqlsid() == null && bean.getTqlsid() == null
            || getTqlsid() != null
                && bean.getTqlsid() != null
                && getTqlsid().equals(bean.getTqlsid()))) return false;
    if (mask.getTqlv()
        && !(getTqlv() == null && bean.getTqlv() == null
            || getTqlv() != null && bean.getTqlv() != null && getTqlv().equals(bean.getTqlv())))
      return false;
    if (mask.getTqty()
        && !(getTqty() == null && bean.getTqty() == null
            || getTqty() != null && bean.getTqty() != null && getTqty().equals(bean.getTqty())))
      return false;
    if (mask.getTqcont()
        && !(getTqcont() == null && bean.getTqcont() == null
            || getTqcont() != null
                && bean.getTqcont() != null
                && getTqcont().equals(bean.getTqcont()))) return false;
    if (mask.getTqo()
        && !(getTqo() == null && bean.getTqo() == null
            || getTqo() != null && bean.getTqo() != null && getTqo().equals(bean.getTqo())))
      return false;
    if (mask.getTqst()
        && !(getTqst() == null && bean.getTqst() == null
            || getTqst() != null && bean.getTqst() != null && getTqst().equals(bean.getTqst())))
      return false;
    return true;
  }

  public static final Question.Creator<Question> CREATOR =
      new Creator<Question>() {
        @Override
        public Question[] newArray(int size) {
          return new Question[size];
        }

        @Override
        public Question createFromParcel(Parcel in) {
          return new Question(in);
        }
      };
}
