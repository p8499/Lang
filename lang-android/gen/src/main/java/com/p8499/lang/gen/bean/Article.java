package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.ArticleMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Article implements Parcelable {
  public static final String TABLE = "public.F1110";
  public static final String VIEW = "public.V1110";
  public static final String NAME = "ARTICLE";

  public static final String FIELD_ATID = "ATID";
  public static final String FIELD_ATCGID = "ATCGID";
  public static final String FIELD_ATSI = "ATSI";
  public static final String FIELD_ATNAME = "ATNAME";
  public static final String FIELD_ATUSID = "ATUSID";
  public static final String FIELD_ATBRF = "ATBRF";
  public static final String FIELD_ATCSA = "ATCSA";
  public static final String FIELD_ATCSB = "ATCSB";
  public static final String FIELD_ATCSC = "ATCSC";
  public static final String FIELD_ATCSD = "ATCSD";
  public static final String FIELD_ATCSE = "ATCSE";
  public static final String FIELD_ATCSF = "ATCSF";
  public static final String FIELD_ATCRDT = "ATCRDT";
  public static final String FIELD_ATUPDT = "ATUPDT";

  protected Integer atid = null;

  protected Integer atcgid = null;

  protected Integer atsi = null;

  protected String atname = null;

  protected Integer atusid = null;

  protected String atbrf = null;

  protected Integer atcsa = null;

  protected Integer atcsb = null;

  protected Integer atcsc = null;

  protected Integer atcsd = null;

  protected Integer atcse = null;

  protected Integer atcsf = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date atcrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date atupdt = null;

  public Article(
      Integer atid,
      Integer atcgid,
      Integer atsi,
      String atname,
      Integer atusid,
      String atbrf,
      Integer atcsa,
      Integer atcsb,
      Integer atcsc,
      Integer atcsd,
      Integer atcse,
      Integer atcsf,
      java.util.Date atcrdt,
      java.util.Date atupdt) {
    if (atid != null) this.atid = atid;
    if (atcgid != null) this.atcgid = atcgid;
    if (atsi != null) this.atsi = atsi;
    if (atname != null) this.atname = atname;
    if (atusid != null) this.atusid = atusid;
    if (atbrf != null) this.atbrf = atbrf;
    if (atcsa != null) this.atcsa = atcsa;
    if (atcsb != null) this.atcsb = atcsb;
    if (atcsc != null) this.atcsc = atcsc;
    if (atcsd != null) this.atcsd = atcsd;
    if (atcse != null) this.atcse = atcse;
    if (atcsf != null) this.atcsf = atcsf;
    if (atcrdt != null) this.atcrdt = atcrdt;
    if (atupdt != null) this.atupdt = atupdt;
  }

  public Article() {
    this(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
  }

  public Article clone() {
    return new Article(
        atid, atcgid, atsi, atname, atusid, atbrf, atcsa, atcsb, atcsc, atcsd, atcse, atcsf, atcrdt,
        atupdt);
  }

  public Article(Parcel in) {

    this.atid = in.readInt();

    this.atcgid = in.readInt();

    this.atsi = in.readInt();

    this.atname = in.readString();

    this.atusid = in.readInt();

    this.atbrf = in.readString();

    this.atcsa = in.readInt();

    this.atcsb = in.readInt();

    this.atcsc = in.readInt();

    this.atcsd = in.readInt();

    this.atcse = in.readInt();

    this.atcsf = in.readInt();

    this.atcrdt = DefaultDateFormatter.parse(in.readString());

    this.atupdt = DefaultDateFormatter.parse(in.readString());
  }

  public Integer getAtid() {
    return atid;
  }

  public Article setAtid(Integer atid) {
    this.atid = atid;
    return this;
  }

  public Integer getAtcgid() {
    return atcgid;
  }

  public Article setAtcgid(Integer atcgid) {
    this.atcgid = atcgid;
    return this;
  }

  public Integer getAtsi() {
    return atsi;
  }

  public Article setAtsi(Integer atsi) {
    this.atsi = atsi;
    return this;
  }

  public String getAtname() {
    return atname;
  }

  public Article setAtname(String atname) {
    this.atname = atname;
    return this;
  }

  public Integer getAtusid() {
    return atusid;
  }

  public Article setAtusid(Integer atusid) {
    this.atusid = atusid;
    return this;
  }

  public String getAtbrf() {
    return atbrf;
  }

  public Article setAtbrf(String atbrf) {
    this.atbrf = atbrf;
    return this;
  }

  public Integer getAtcsa() {
    return atcsa;
  }

  public Article setAtcsa(Integer atcsa) {
    this.atcsa = atcsa;
    return this;
  }

  public Integer getAtcsb() {
    return atcsb;
  }

  public Article setAtcsb(Integer atcsb) {
    this.atcsb = atcsb;
    return this;
  }

  public Integer getAtcsc() {
    return atcsc;
  }

  public Article setAtcsc(Integer atcsc) {
    this.atcsc = atcsc;
    return this;
  }

  public Integer getAtcsd() {
    return atcsd;
  }

  public Article setAtcsd(Integer atcsd) {
    this.atcsd = atcsd;
    return this;
  }

  public Integer getAtcse() {
    return atcse;
  }

  public Article setAtcse(Integer atcse) {
    this.atcse = atcse;
    return this;
  }

  public Integer getAtcsf() {
    return atcsf;
  }

  public Article setAtcsf(Integer atcsf) {
    this.atcsf = atcsf;
    return this;
  }

  public java.util.Date getAtcrdt() {
    return atcrdt;
  }

  public Article setAtcrdt(java.util.Date atcrdt) {
    this.atcrdt = atcrdt;
    return this;
  }

  public java.util.Date getAtupdt() {
    return atupdt;
  }

  public Article setAtupdt(java.util.Date atupdt) {
    this.atupdt = atupdt;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(atid);

    dest.writeInt(atcgid);

    dest.writeInt(atsi);

    dest.writeString(atname);

    dest.writeInt(atusid);

    dest.writeString(atbrf);

    dest.writeInt(atcsa);

    dest.writeInt(atcsb);

    dest.writeInt(atcsc);

    dest.writeInt(atcsd);

    dest.writeInt(atcse);

    dest.writeInt(atcsf);

    dest.writeString(DefaultDateFormatter.format(atcrdt));

    dest.writeString(DefaultDateFormatter.format(atupdt));
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Article) ? equals((Article) obj, new ArticleMask().all(true)) : false;
  }

  public boolean equals(Article bean, ArticleMask mask) {
    if (mask == null) mask = new ArticleMask().all(true);

    if (mask.getAtid()
        && !(getAtid() == null && bean.getAtid() == null
            || getAtid() != null && bean.getAtid() != null && getAtid().equals(bean.getAtid())))
      return false;
    if (mask.getAtcgid()
        && !(getAtcgid() == null && bean.getAtcgid() == null
            || getAtcgid() != null
                && bean.getAtcgid() != null
                && getAtcgid().equals(bean.getAtcgid()))) return false;
    if (mask.getAtsi()
        && !(getAtsi() == null && bean.getAtsi() == null
            || getAtsi() != null && bean.getAtsi() != null && getAtsi().equals(bean.getAtsi())))
      return false;
    if (mask.getAtname()
        && !(getAtname() == null && bean.getAtname() == null
            || getAtname() != null
                && bean.getAtname() != null
                && getAtname().equals(bean.getAtname()))) return false;
    if (mask.getAtusid()
        && !(getAtusid() == null && bean.getAtusid() == null
            || getAtusid() != null
                && bean.getAtusid() != null
                && getAtusid().equals(bean.getAtusid()))) return false;
    if (mask.getAtbrf()
        && !(getAtbrf() == null && bean.getAtbrf() == null
            || getAtbrf() != null && bean.getAtbrf() != null && getAtbrf().equals(bean.getAtbrf())))
      return false;
    if (mask.getAtcsa()
        && !(getAtcsa() == null && bean.getAtcsa() == null
            || getAtcsa() != null && bean.getAtcsa() != null && getAtcsa().equals(bean.getAtcsa())))
      return false;
    if (mask.getAtcsb()
        && !(getAtcsb() == null && bean.getAtcsb() == null
            || getAtcsb() != null && bean.getAtcsb() != null && getAtcsb().equals(bean.getAtcsb())))
      return false;
    if (mask.getAtcsc()
        && !(getAtcsc() == null && bean.getAtcsc() == null
            || getAtcsc() != null && bean.getAtcsc() != null && getAtcsc().equals(bean.getAtcsc())))
      return false;
    if (mask.getAtcsd()
        && !(getAtcsd() == null && bean.getAtcsd() == null
            || getAtcsd() != null && bean.getAtcsd() != null && getAtcsd().equals(bean.getAtcsd())))
      return false;
    if (mask.getAtcse()
        && !(getAtcse() == null && bean.getAtcse() == null
            || getAtcse() != null && bean.getAtcse() != null && getAtcse().equals(bean.getAtcse())))
      return false;
    if (mask.getAtcsf()
        && !(getAtcsf() == null && bean.getAtcsf() == null
            || getAtcsf() != null && bean.getAtcsf() != null && getAtcsf().equals(bean.getAtcsf())))
      return false;
    if (mask.getAtcrdt()
        && !(getAtcrdt() == null && bean.getAtcrdt() == null
            || getAtcrdt() != null
                && bean.getAtcrdt() != null
                && getAtcrdt().equals(bean.getAtcrdt()))) return false;
    if (mask.getAtupdt()
        && !(getAtupdt() == null && bean.getAtupdt() == null
            || getAtupdt() != null
                && bean.getAtupdt() != null
                && getAtupdt().equals(bean.getAtupdt()))) return false;
    return true;
  }

  public static final Article.Creator<Article> CREATOR =
      new Creator<Article>() {
        @Override
        public Article[] newArray(int size) {
          return new Article[size];
        }

        @Override
        public Article createFromParcel(Parcel in) {
          return new Article(in);
        }
      };
}
