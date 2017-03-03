package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.SegmentMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Segment implements Parcelable {
  public static final String TABLE = "public.F1130";
  public static final String VIEW = "public.F1130";
  public static final String NAME = "SEGMENT";

  public static final String FIELD_TRASID = "TRASID";
  public static final String FIELD_TRPI = "TRPI";
  public static final String FIELD_TRHZ = "TRHZ";
  public static final String FIELD_TRST = "TRST";
  public static final String FIELD_TRUSID = "TRUSID";
  public static final String FIELD_TRCRDT = "TRCRDT";
  public static final String FIELD_TRUPDT = "TRUPDT";

  public static final Integer TRST_DISABLED = -1;

  public static final Integer TRST_ENABLED = 0;

  public static final Integer DEFAULT_TRST = 0;

  protected Integer trasid = null;

  protected String trpi = null;

  protected String trhz = null;

  protected Integer trst = DEFAULT_TRST;

  protected Integer trusid = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date trcrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date trupdt = null;

  public Segment(
      Integer trasid,
      String trpi,
      String trhz,
      Integer trst,
      Integer trusid,
      java.util.Date trcrdt,
      java.util.Date trupdt) {
    if (trasid != null) this.trasid = trasid;
    if (trpi != null) this.trpi = trpi;
    if (trhz != null) this.trhz = trhz;
    if (trst != null) this.trst = trst;
    if (trusid != null) this.trusid = trusid;
    if (trcrdt != null) this.trcrdt = trcrdt;
    if (trupdt != null) this.trupdt = trupdt;
  }

  public Segment() {
    this(null, null, null, null, null, null, null);
  }

  public Segment clone() {
    return new Segment(trasid, trpi, trhz, trst, trusid, trcrdt, trupdt);
  }

  public Segment(Parcel in) {

    this.trasid = in.readInt();

    this.trpi = in.readString();

    this.trhz = in.readString();

    this.trst = in.readInt();

    this.trusid = in.readInt();

    this.trcrdt = DefaultDateFormatter.parse(in.readString());

    this.trupdt = DefaultDateFormatter.parse(in.readString());
  }

  public Integer getTrasid() {
    return trasid;
  }

  public Segment setTrasid(Integer trasid) {
    this.trasid = trasid;
    return this;
  }

  public String getTrpi() {
    return trpi;
  }

  public Segment setTrpi(String trpi) {
    this.trpi = trpi;
    return this;
  }

  public String getTrhz() {
    return trhz;
  }

  public Segment setTrhz(String trhz) {
    this.trhz = trhz;
    return this;
  }

  public Integer getTrst() {
    return trst;
  }

  public Segment setTrst(Integer trst) {
    this.trst = trst;
    return this;
  }

  public Integer getTrusid() {
    return trusid;
  }

  public Segment setTrusid(Integer trusid) {
    this.trusid = trusid;
    return this;
  }

  public java.util.Date getTrcrdt() {
    return trcrdt;
  }

  public Segment setTrcrdt(java.util.Date trcrdt) {
    this.trcrdt = trcrdt;
    return this;
  }

  public java.util.Date getTrupdt() {
    return trupdt;
  }

  public Segment setTrupdt(java.util.Date trupdt) {
    this.trupdt = trupdt;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(trasid);

    dest.writeString(trpi);

    dest.writeString(trhz);

    dest.writeInt(trst);

    dest.writeInt(trusid);

    dest.writeString(DefaultDateFormatter.format(trcrdt));

    dest.writeString(DefaultDateFormatter.format(trupdt));
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Segment) ? equals((Segment) obj, new SegmentMask().all(true)) : false;
  }

  public boolean equals(Segment bean, SegmentMask mask) {
    if (mask == null) mask = new SegmentMask().all(true);

    if (mask.getTrasid()
        && !(getTrasid() == null && bean.getTrasid() == null
            || getTrasid() != null
                && bean.getTrasid() != null
                && getTrasid().equals(bean.getTrasid()))) return false;
    if (mask.getTrpi()
        && !(getTrpi() == null && bean.getTrpi() == null
            || getTrpi() != null && bean.getTrpi() != null && getTrpi().equals(bean.getTrpi())))
      return false;
    if (mask.getTrhz()
        && !(getTrhz() == null && bean.getTrhz() == null
            || getTrhz() != null && bean.getTrhz() != null && getTrhz().equals(bean.getTrhz())))
      return false;
    if (mask.getTrst()
        && !(getTrst() == null && bean.getTrst() == null
            || getTrst() != null && bean.getTrst() != null && getTrst().equals(bean.getTrst())))
      return false;
    if (mask.getTrusid()
        && !(getTrusid() == null && bean.getTrusid() == null
            || getTrusid() != null
                && bean.getTrusid() != null
                && getTrusid().equals(bean.getTrusid()))) return false;
    if (mask.getTrcrdt()
        && !(getTrcrdt() == null && bean.getTrcrdt() == null
            || getTrcrdt() != null
                && bean.getTrcrdt() != null
                && getTrcrdt().equals(bean.getTrcrdt()))) return false;
    if (mask.getTrupdt()
        && !(getTrupdt() == null && bean.getTrupdt() == null
            || getTrupdt() != null
                && bean.getTrupdt() != null
                && getTrupdt().equals(bean.getTrupdt()))) return false;
    return true;
  }

  public static final Segment.Creator<Segment> CREATOR =
      new Creator<Segment>() {
        @Override
        public Segment[] newArray(int size) {
          return new Segment[size];
        }

        @Override
        public Segment createFromParcel(Parcel in) {
          return new Segment(in);
        }
      };
}
