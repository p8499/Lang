package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.SegmentvoteMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Segmentvote implements Parcelable {
  public static final String TABLE = "public.F1132";
  public static final String VIEW = "public.F1132";
  public static final String NAME = "SEGMENTVOTE";

  public static final String FIELD_TVID = "TVID";
  public static final String FIELD_TVTAID = "TVTAID";
  public static final String FIELD_TVSI = "TVSI";
  public static final String FIELD_TVUSID = "TVUSID";
  public static final String FIELD_TVPO = "TVPO";
  public static final String FIELD_TVCRDT = "TVCRDT";
  public static final String FIELD_TVUPDT = "TVUPDT";

  public static final Integer TVPO_NEGATIVE = -1;

  public static final Integer TVPO_POSITIVE = 1;

  protected Integer tvid = null;

  protected Integer tvtaid = null;

  protected Integer tvsi = null;

  protected Integer tvusid = null;

  protected Integer tvpo = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date tvcrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date tvupdt = null;

  public Segmentvote(
      Integer tvid,
      Integer tvtaid,
      Integer tvsi,
      Integer tvusid,
      Integer tvpo,
      java.util.Date tvcrdt,
      java.util.Date tvupdt) {
    if (tvid != null) this.tvid = tvid;
    if (tvtaid != null) this.tvtaid = tvtaid;
    if (tvsi != null) this.tvsi = tvsi;
    if (tvusid != null) this.tvusid = tvusid;
    if (tvpo != null) this.tvpo = tvpo;
    if (tvcrdt != null) this.tvcrdt = tvcrdt;
    if (tvupdt != null) this.tvupdt = tvupdt;
  }

  public Segmentvote() {
    this(null, null, null, null, null, null, null);
  }

  public Segmentvote clone() {
    return new Segmentvote(tvid, tvtaid, tvsi, tvusid, tvpo, tvcrdt, tvupdt);
  }

  public Segmentvote(Parcel in) {

    this.tvid = in.readInt();

    this.tvtaid = in.readInt();

    this.tvsi = in.readInt();

    this.tvusid = in.readInt();

    this.tvpo = in.readInt();

    this.tvcrdt = DefaultDateFormatter.parse(in.readString());

    this.tvupdt = DefaultDateFormatter.parse(in.readString());
  }

  public Integer getTvid() {
    return tvid;
  }

  public Segmentvote setTvid(Integer tvid) {
    this.tvid = tvid;
    return this;
  }

  public Integer getTvtaid() {
    return tvtaid;
  }

  public Segmentvote setTvtaid(Integer tvtaid) {
    this.tvtaid = tvtaid;
    return this;
  }

  public Integer getTvsi() {
    return tvsi;
  }

  public Segmentvote setTvsi(Integer tvsi) {
    this.tvsi = tvsi;
    return this;
  }

  public Integer getTvusid() {
    return tvusid;
  }

  public Segmentvote setTvusid(Integer tvusid) {
    this.tvusid = tvusid;
    return this;
  }

  public Integer getTvpo() {
    return tvpo;
  }

  public Segmentvote setTvpo(Integer tvpo) {
    this.tvpo = tvpo;
    return this;
  }

  public java.util.Date getTvcrdt() {
    return tvcrdt;
  }

  public Segmentvote setTvcrdt(java.util.Date tvcrdt) {
    this.tvcrdt = tvcrdt;
    return this;
  }

  public java.util.Date getTvupdt() {
    return tvupdt;
  }

  public Segmentvote setTvupdt(java.util.Date tvupdt) {
    this.tvupdt = tvupdt;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(tvid);

    dest.writeInt(tvtaid);

    dest.writeInt(tvsi);

    dest.writeInt(tvusid);

    dest.writeInt(tvpo);

    dest.writeString(DefaultDateFormatter.format(tvcrdt));

    dest.writeString(DefaultDateFormatter.format(tvupdt));
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Segmentvote)
        ? equals((Segmentvote) obj, new SegmentvoteMask().all(true))
        : false;
  }

  public boolean equals(Segmentvote bean, SegmentvoteMask mask) {
    if (mask == null) mask = new SegmentvoteMask().all(true);

    if (mask.getTvid()
        && !(getTvid() == null && bean.getTvid() == null
            || getTvid() != null && bean.getTvid() != null && getTvid().equals(bean.getTvid())))
      return false;
    if (mask.getTvtaid()
        && !(getTvtaid() == null && bean.getTvtaid() == null
            || getTvtaid() != null
                && bean.getTvtaid() != null
                && getTvtaid().equals(bean.getTvtaid()))) return false;
    if (mask.getTvsi()
        && !(getTvsi() == null && bean.getTvsi() == null
            || getTvsi() != null && bean.getTvsi() != null && getTvsi().equals(bean.getTvsi())))
      return false;
    if (mask.getTvusid()
        && !(getTvusid() == null && bean.getTvusid() == null
            || getTvusid() != null
                && bean.getTvusid() != null
                && getTvusid().equals(bean.getTvusid()))) return false;
    if (mask.getTvpo()
        && !(getTvpo() == null && bean.getTvpo() == null
            || getTvpo() != null && bean.getTvpo() != null && getTvpo().equals(bean.getTvpo())))
      return false;
    if (mask.getTvcrdt()
        && !(getTvcrdt() == null && bean.getTvcrdt() == null
            || getTvcrdt() != null
                && bean.getTvcrdt() != null
                && getTvcrdt().equals(bean.getTvcrdt()))) return false;
    if (mask.getTvupdt()
        && !(getTvupdt() == null && bean.getTvupdt() == null
            || getTvupdt() != null
                && bean.getTvupdt() != null
                && getTvupdt().equals(bean.getTvupdt()))) return false;
    return true;
  }

  public static final Segmentvote.Creator<Segmentvote> CREATOR =
      new Creator<Segmentvote>() {
        @Override
        public Segmentvote[] newArray(int size) {
          return new Segmentvote[size];
        }

        @Override
        public Segmentvote createFromParcel(Parcel in) {
          return new Segmentvote(in);
        }
      };
}
