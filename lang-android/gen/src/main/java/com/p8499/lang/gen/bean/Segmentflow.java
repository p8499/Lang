package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.SegmentflowMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Segmentflow implements Parcelable {
  public static final String TABLE = "public.F1131";
  public static final String VIEW = "public.F1131";
  public static final String NAME = "SEGMENTFLOW";

  public static final String FIELD_TAID = "TAID";
  public static final String FIELD_TAASID = "TAASID";
  public static final String FIELD_TASI = "TASI";
  public static final String FIELD_TAPI = "TAPI";
  public static final String FIELD_TAHZ = "TAHZ";
  public static final String FIELD_TAST = "TAST";
  public static final String FIELD_TAUSID = "TAUSID";
  public static final String FIELD_TACRDT = "TACRDT";
  public static final String FIELD_TAUPDT = "TAUPDT";

  public static final Integer TAST_VOTING = 1;

  public static final Integer TAST_PASSED = 2;

  public static final Integer TAST_DENIED = 3;

  public static final Integer TAST_RECALLED = 4;

  protected Integer taid = null;

  protected Integer taasid = null;

  protected Integer tasi = null;

  protected String tapi = null;

  protected String tahz = null;

  protected Integer tast = null;

  protected Integer tausid = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date tacrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date taupdt = null;

  public Segmentflow(
      Integer taid,
      Integer taasid,
      Integer tasi,
      String tapi,
      String tahz,
      Integer tast,
      Integer tausid,
      java.util.Date tacrdt,
      java.util.Date taupdt) {
    if (taid != null) this.taid = taid;
    if (taasid != null) this.taasid = taasid;
    if (tasi != null) this.tasi = tasi;
    if (tapi != null) this.tapi = tapi;
    if (tahz != null) this.tahz = tahz;
    if (tast != null) this.tast = tast;
    if (tausid != null) this.tausid = tausid;
    if (tacrdt != null) this.tacrdt = tacrdt;
    if (taupdt != null) this.taupdt = taupdt;
  }

  public Segmentflow() {
    this(null, null, null, null, null, null, null, null, null);
  }

  public Segmentflow clone() {
    return new Segmentflow(taid, taasid, tasi, tapi, tahz, tast, tausid, tacrdt, taupdt);
  }

  public Segmentflow(Parcel in) {

    this.taid = in.readInt();

    this.taasid = in.readInt();

    this.tasi = in.readInt();

    this.tapi = in.readString();

    this.tahz = in.readString();

    this.tast = in.readInt();

    this.tausid = in.readInt();

    this.tacrdt = DefaultDateFormatter.parse(in.readString());

    this.taupdt = DefaultDateFormatter.parse(in.readString());
  }

  public Integer getTaid() {
    return taid;
  }

  public Segmentflow setTaid(Integer taid) {
    this.taid = taid;
    return this;
  }

  public Integer getTaasid() {
    return taasid;
  }

  public Segmentflow setTaasid(Integer taasid) {
    this.taasid = taasid;
    return this;
  }

  public Integer getTasi() {
    return tasi;
  }

  public Segmentflow setTasi(Integer tasi) {
    this.tasi = tasi;
    return this;
  }

  public String getTapi() {
    return tapi;
  }

  public Segmentflow setTapi(String tapi) {
    this.tapi = tapi;
    return this;
  }

  public String getTahz() {
    return tahz;
  }

  public Segmentflow setTahz(String tahz) {
    this.tahz = tahz;
    return this;
  }

  public Integer getTast() {
    return tast;
  }

  public Segmentflow setTast(Integer tast) {
    this.tast = tast;
    return this;
  }

  public Integer getTausid() {
    return tausid;
  }

  public Segmentflow setTausid(Integer tausid) {
    this.tausid = tausid;
    return this;
  }

  public java.util.Date getTacrdt() {
    return tacrdt;
  }

  public Segmentflow setTacrdt(java.util.Date tacrdt) {
    this.tacrdt = tacrdt;
    return this;
  }

  public java.util.Date getTaupdt() {
    return taupdt;
  }

  public Segmentflow setTaupdt(java.util.Date taupdt) {
    this.taupdt = taupdt;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(taid);

    dest.writeInt(taasid);

    dest.writeInt(tasi);

    dest.writeString(tapi);

    dest.writeString(tahz);

    dest.writeInt(tast);

    dest.writeInt(tausid);

    dest.writeString(DefaultDateFormatter.format(tacrdt));

    dest.writeString(DefaultDateFormatter.format(taupdt));
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Segmentflow)
        ? equals((Segmentflow) obj, new SegmentflowMask().all(true))
        : false;
  }

  public boolean equals(Segmentflow bean, SegmentflowMask mask) {
    if (mask == null) mask = new SegmentflowMask().all(true);

    if (mask.getTaid()
        && !(getTaid() == null && bean.getTaid() == null
            || getTaid() != null && bean.getTaid() != null && getTaid().equals(bean.getTaid())))
      return false;
    if (mask.getTaasid()
        && !(getTaasid() == null && bean.getTaasid() == null
            || getTaasid() != null
                && bean.getTaasid() != null
                && getTaasid().equals(bean.getTaasid()))) return false;
    if (mask.getTasi()
        && !(getTasi() == null && bean.getTasi() == null
            || getTasi() != null && bean.getTasi() != null && getTasi().equals(bean.getTasi())))
      return false;
    if (mask.getTapi()
        && !(getTapi() == null && bean.getTapi() == null
            || getTapi() != null && bean.getTapi() != null && getTapi().equals(bean.getTapi())))
      return false;
    if (mask.getTahz()
        && !(getTahz() == null && bean.getTahz() == null
            || getTahz() != null && bean.getTahz() != null && getTahz().equals(bean.getTahz())))
      return false;
    if (mask.getTast()
        && !(getTast() == null && bean.getTast() == null
            || getTast() != null && bean.getTast() != null && getTast().equals(bean.getTast())))
      return false;
    if (mask.getTausid()
        && !(getTausid() == null && bean.getTausid() == null
            || getTausid() != null
                && bean.getTausid() != null
                && getTausid().equals(bean.getTausid()))) return false;
    if (mask.getTacrdt()
        && !(getTacrdt() == null && bean.getTacrdt() == null
            || getTacrdt() != null
                && bean.getTacrdt() != null
                && getTacrdt().equals(bean.getTacrdt()))) return false;
    if (mask.getTaupdt()
        && !(getTaupdt() == null && bean.getTaupdt() == null
            || getTaupdt() != null
                && bean.getTaupdt() != null
                && getTaupdt().equals(bean.getTaupdt()))) return false;
    return true;
  }

  public static final Segmentflow.Creator<Segmentflow> CREATOR =
      new Creator<Segmentflow>() {
        @Override
        public Segmentflow[] newArray(int size) {
          return new Segmentflow[size];
        }

        @Override
        public Segmentflow createFromParcel(Parcel in) {
          return new Segmentflow(in);
        }
      };
}
