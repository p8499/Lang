package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.ExamMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Exam implements Parcelable {
  public static final String TABLE = "public.F1211";
  public static final String VIEW = "public.F1211";
  public static final String NAME = "EXAM";

  public static final String FIELD_EXID = "EXID";
  public static final String FIELD_EXUSID = "EXUSID";
  public static final String FIELD_EXSI = "EXSI";
  public static final String FIELD_EXLSID = "EXLSID";
  public static final String FIELD_EXLV = "EXLV";
  public static final String FIELD_EXCRDT = "EXCRDT";
  public static final String FIELD_EXUPDT = "EXUPDT";
  public static final String FIELD_EXTS = "EXTS";
  public static final String FIELD_EXSC = "EXSC";

  public static final Integer EXLV_A = 20;

  public static final Integer EXLV_B = 10;

  protected Integer exid = null;

  protected Integer exusid = null;

  protected Integer exsi = null;

  protected String exlsid = null;

  protected Integer exlv = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date excrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date exupdt = null;

  protected Integer exts = null;

  protected Integer exsc = null;

  public Exam(
      Integer exid,
      Integer exusid,
      Integer exsi,
      String exlsid,
      Integer exlv,
      java.util.Date excrdt,
      java.util.Date exupdt,
      Integer exts,
      Integer exsc) {
    if (exid != null) this.exid = exid;
    if (exusid != null) this.exusid = exusid;
    if (exsi != null) this.exsi = exsi;
    if (exlsid != null) this.exlsid = exlsid;
    if (exlv != null) this.exlv = exlv;
    if (excrdt != null) this.excrdt = excrdt;
    if (exupdt != null) this.exupdt = exupdt;
    if (exts != null) this.exts = exts;
    if (exsc != null) this.exsc = exsc;
  }

  public Exam() {
    this(null, null, null, null, null, null, null, null, null);
  }

  public Exam clone() {
    return new Exam(exid, exusid, exsi, exlsid, exlv, excrdt, exupdt, exts, exsc);
  }

  public Exam(Parcel in) {

    this.exid = in.readInt();

    this.exusid = in.readInt();

    this.exsi = in.readInt();

    this.exlsid = in.readString();

    this.exlv = in.readInt();

    this.excrdt = DefaultDateFormatter.parse(in.readString());

    this.exupdt = DefaultDateFormatter.parse(in.readString());

    this.exts = in.readInt();

    this.exsc = in.readInt();
  }

  public Integer getExid() {
    return exid;
  }

  public Exam setExid(Integer exid) {
    this.exid = exid;
    return this;
  }

  public Integer getExusid() {
    return exusid;
  }

  public Exam setExusid(Integer exusid) {
    this.exusid = exusid;
    return this;
  }

  public Integer getExsi() {
    return exsi;
  }

  public Exam setExsi(Integer exsi) {
    this.exsi = exsi;
    return this;
  }

  public String getExlsid() {
    return exlsid;
  }

  public Exam setExlsid(String exlsid) {
    this.exlsid = exlsid;
    return this;
  }

  public Integer getExlv() {
    return exlv;
  }

  public Exam setExlv(Integer exlv) {
    this.exlv = exlv;
    return this;
  }

  public java.util.Date getExcrdt() {
    return excrdt;
  }

  public Exam setExcrdt(java.util.Date excrdt) {
    this.excrdt = excrdt;
    return this;
  }

  public java.util.Date getExupdt() {
    return exupdt;
  }

  public Exam setExupdt(java.util.Date exupdt) {
    this.exupdt = exupdt;
    return this;
  }

  public Integer getExts() {
    return exts;
  }

  public Exam setExts(Integer exts) {
    this.exts = exts;
    return this;
  }

  public Integer getExsc() {
    return exsc;
  }

  public Exam setExsc(Integer exsc) {
    this.exsc = exsc;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(exid);

    dest.writeInt(exusid);

    dest.writeInt(exsi);

    dest.writeString(exlsid);

    dest.writeInt(exlv);

    dest.writeString(DefaultDateFormatter.format(excrdt));

    dest.writeString(DefaultDateFormatter.format(exupdt));

    dest.writeInt(exts);

    dest.writeInt(exsc);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Exam) ? equals((Exam) obj, new ExamMask().all(true)) : false;
  }

  public boolean equals(Exam bean, ExamMask mask) {
    if (mask == null) mask = new ExamMask().all(true);

    if (mask.getExid()
        && !(getExid() == null && bean.getExid() == null
            || getExid() != null && bean.getExid() != null && getExid().equals(bean.getExid())))
      return false;
    if (mask.getExusid()
        && !(getExusid() == null && bean.getExusid() == null
            || getExusid() != null
                && bean.getExusid() != null
                && getExusid().equals(bean.getExusid()))) return false;
    if (mask.getExsi()
        && !(getExsi() == null && bean.getExsi() == null
            || getExsi() != null && bean.getExsi() != null && getExsi().equals(bean.getExsi())))
      return false;
    if (mask.getExlsid()
        && !(getExlsid() == null && bean.getExlsid() == null
            || getExlsid() != null
                && bean.getExlsid() != null
                && getExlsid().equals(bean.getExlsid()))) return false;
    if (mask.getExlv()
        && !(getExlv() == null && bean.getExlv() == null
            || getExlv() != null && bean.getExlv() != null && getExlv().equals(bean.getExlv())))
      return false;
    if (mask.getExcrdt()
        && !(getExcrdt() == null && bean.getExcrdt() == null
            || getExcrdt() != null
                && bean.getExcrdt() != null
                && getExcrdt().equals(bean.getExcrdt()))) return false;
    if (mask.getExupdt()
        && !(getExupdt() == null && bean.getExupdt() == null
            || getExupdt() != null
                && bean.getExupdt() != null
                && getExupdt().equals(bean.getExupdt()))) return false;
    if (mask.getExts()
        && !(getExts() == null && bean.getExts() == null
            || getExts() != null && bean.getExts() != null && getExts().equals(bean.getExts())))
      return false;
    if (mask.getExsc()
        && !(getExsc() == null && bean.getExsc() == null
            || getExsc() != null && bean.getExsc() != null && getExsc().equals(bean.getExsc())))
      return false;
    return true;
  }

  public static final Exam.Creator<Exam> CREATOR =
      new Creator<Exam>() {
        @Override
        public Exam[] newArray(int size) {
          return new Exam[size];
        }

        @Override
        public Exam createFromParcel(Parcel in) {
          return new Exam(in);
        }
      };
}
