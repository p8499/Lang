package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.ExamquestionMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Examquestion implements Parcelable {
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

  public Examquestion(Parcel in) {

    this.eqid = in.readInt();

    this.eqexid = in.readInt();

    this.eqsi = in.readInt();

    this.eqtqid = in.readInt();

    this.eqo = in.readString();

    this.eqts = in.readInt();

    this.eqsc = in.readInt();
  }

  public Integer getEqid() {
    return eqid;
  }

  public Examquestion setEqid(Integer eqid) {
    this.eqid = eqid;
    return this;
  }

  public Integer getEqexid() {
    return eqexid;
  }

  public Examquestion setEqexid(Integer eqexid) {
    this.eqexid = eqexid;
    return this;
  }

  public Integer getEqsi() {
    return eqsi;
  }

  public Examquestion setEqsi(Integer eqsi) {
    this.eqsi = eqsi;
    return this;
  }

  public Integer getEqtqid() {
    return eqtqid;
  }

  public Examquestion setEqtqid(Integer eqtqid) {
    this.eqtqid = eqtqid;
    return this;
  }

  public String getEqo() {
    return eqo;
  }

  public Examquestion setEqo(String eqo) {
    this.eqo = eqo;
    return this;
  }

  public Integer getEqts() {
    return eqts;
  }

  public Examquestion setEqts(Integer eqts) {
    this.eqts = eqts;
    return this;
  }

  public Integer getEqsc() {
    return eqsc;
  }

  public Examquestion setEqsc(Integer eqsc) {
    this.eqsc = eqsc;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(eqid);

    dest.writeInt(eqexid);

    dest.writeInt(eqsi);

    dest.writeInt(eqtqid);

    dest.writeString(eqo);

    dest.writeInt(eqts);

    dest.writeInt(eqsc);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Examquestion)
        ? equals((Examquestion) obj, new ExamquestionMask().all(true))
        : false;
  }

  public boolean equals(Examquestion bean, ExamquestionMask mask) {
    if (mask == null) mask = new ExamquestionMask().all(true);

    if (mask.getEqid()
        && !(getEqid() == null && bean.getEqid() == null
            || getEqid() != null && bean.getEqid() != null && getEqid().equals(bean.getEqid())))
      return false;
    if (mask.getEqexid()
        && !(getEqexid() == null && bean.getEqexid() == null
            || getEqexid() != null
                && bean.getEqexid() != null
                && getEqexid().equals(bean.getEqexid()))) return false;
    if (mask.getEqsi()
        && !(getEqsi() == null && bean.getEqsi() == null
            || getEqsi() != null && bean.getEqsi() != null && getEqsi().equals(bean.getEqsi())))
      return false;
    if (mask.getEqtqid()
        && !(getEqtqid() == null && bean.getEqtqid() == null
            || getEqtqid() != null
                && bean.getEqtqid() != null
                && getEqtqid().equals(bean.getEqtqid()))) return false;
    if (mask.getEqo()
        && !(getEqo() == null && bean.getEqo() == null
            || getEqo() != null && bean.getEqo() != null && getEqo().equals(bean.getEqo())))
      return false;
    if (mask.getEqts()
        && !(getEqts() == null && bean.getEqts() == null
            || getEqts() != null && bean.getEqts() != null && getEqts().equals(bean.getEqts())))
      return false;
    if (mask.getEqsc()
        && !(getEqsc() == null && bean.getEqsc() == null
            || getEqsc() != null && bean.getEqsc() != null && getEqsc().equals(bean.getEqsc())))
      return false;
    return true;
  }

  public static final Examquestion.Creator<Examquestion> CREATOR =
      new Creator<Examquestion>() {
        @Override
        public Examquestion[] newArray(int size) {
          return new Examquestion[size];
        }

        @Override
        public Examquestion createFromParcel(Parcel in) {
          return new Examquestion(in);
        }
      };
}
