package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.WordMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Word implements Parcelable {
  public static final String TABLE = "public.F1040";
  public static final String VIEW = "public.F1040";
  public static final String NAME = "WORD";

  public static final String FIELD_WOID = "WOID";
  public static final String FIELD_WOLSID = "WOLSID";
  public static final String FIELD_WOPT = "WOPT";
  public static final String FIELD_WOHZ = "WOHZ";
  public static final String FIELD_WOCL = "WOCL";
  public static final String FIELD_WOST = "WOST";
  public static final String FIELD_WOSR = "WOSR";
  public static final String FIELD_WOSORT = "WOSORT";
  public static final String FIELD_WOCRDT = "WOCRDT";
  public static final String FIELD_WOUPDT = "WOUPDT";

  public static final String WOCL_UNIT = "U";

  public static final String WOCL_MULTIPLE = "M";

  public static final Integer WOST_DISABLED = -1;

  public static final Integer WOST_ENABLED = 0;

  public static final String WOSR_MANUAL = "M";

  public static final String WOSR_DICTIONARY = "D";

  public static final String WOSR_SEGMENT = "S";

  public static final Integer DEFAULT_WOST = 0;

  public static final String DEFAULT_WOSR = "M";

  protected Integer woid = null;

  protected String wolsid = null;

  protected String wopt = null;

  protected String wohz = null;

  protected String wocl = null;

  protected Integer wost = DEFAULT_WOST;

  protected String wosr = DEFAULT_WOSR;

  protected Integer wosort = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date wocrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date woupdt = null;

  public Word(
      Integer woid,
      String wolsid,
      String wopt,
      String wohz,
      String wocl,
      Integer wost,
      String wosr,
      Integer wosort,
      java.util.Date wocrdt,
      java.util.Date woupdt) {
    if (woid != null) this.woid = woid;
    if (wolsid != null) this.wolsid = wolsid;
    if (wopt != null) this.wopt = wopt;
    if (wohz != null) this.wohz = wohz;
    if (wocl != null) this.wocl = wocl;
    if (wost != null) this.wost = wost;
    if (wosr != null) this.wosr = wosr;
    if (wosort != null) this.wosort = wosort;
    if (wocrdt != null) this.wocrdt = wocrdt;
    if (woupdt != null) this.woupdt = woupdt;
  }

  public Word() {
    this(null, null, null, null, null, null, null, null, null, null);
  }

  public Word clone() {
    return new Word(woid, wolsid, wopt, wohz, wocl, wost, wosr, wosort, wocrdt, woupdt);
  }

  public Word(Parcel in) {

    this.woid = in.readInt();

    this.wolsid = in.readString();

    this.wopt = in.readString();

    this.wohz = in.readString();

    this.wocl = in.readString();

    this.wost = in.readInt();

    this.wosr = in.readString();

    this.wosort = in.readInt();

    this.wocrdt = DefaultDateFormatter.parse(in.readString());

    this.woupdt = DefaultDateFormatter.parse(in.readString());
  }

  public Integer getWoid() {
    return woid;
  }

  public Word setWoid(Integer woid) {
    this.woid = woid;
    return this;
  }

  public String getWolsid() {
    return wolsid;
  }

  public Word setWolsid(String wolsid) {
    this.wolsid = wolsid;
    return this;
  }

  public String getWopt() {
    return wopt;
  }

  public Word setWopt(String wopt) {
    this.wopt = wopt;
    return this;
  }

  public String getWohz() {
    return wohz;
  }

  public Word setWohz(String wohz) {
    this.wohz = wohz;
    return this;
  }

  public String getWocl() {
    return wocl;
  }

  public Word setWocl(String wocl) {
    this.wocl = wocl;
    return this;
  }

  public Integer getWost() {
    return wost;
  }

  public Word setWost(Integer wost) {
    this.wost = wost;
    return this;
  }

  public String getWosr() {
    return wosr;
  }

  public Word setWosr(String wosr) {
    this.wosr = wosr;
    return this;
  }

  public Integer getWosort() {
    return wosort;
  }

  public Word setWosort(Integer wosort) {
    this.wosort = wosort;
    return this;
  }

  public java.util.Date getWocrdt() {
    return wocrdt;
  }

  public Word setWocrdt(java.util.Date wocrdt) {
    this.wocrdt = wocrdt;
    return this;
  }

  public java.util.Date getWoupdt() {
    return woupdt;
  }

  public Word setWoupdt(java.util.Date woupdt) {
    this.woupdt = woupdt;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(woid);

    dest.writeString(wolsid);

    dest.writeString(wopt);

    dest.writeString(wohz);

    dest.writeString(wocl);

    dest.writeInt(wost);

    dest.writeString(wosr);

    dest.writeInt(wosort);

    dest.writeString(DefaultDateFormatter.format(wocrdt));

    dest.writeString(DefaultDateFormatter.format(woupdt));
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Word) ? equals((Word) obj, new WordMask().all(true)) : false;
  }

  public boolean equals(Word bean, WordMask mask) {
    if (mask == null) mask = new WordMask().all(true);

    if (mask.getWoid()
        && !(getWoid() == null && bean.getWoid() == null
            || getWoid() != null && bean.getWoid() != null && getWoid().equals(bean.getWoid())))
      return false;
    if (mask.getWolsid()
        && !(getWolsid() == null && bean.getWolsid() == null
            || getWolsid() != null
                && bean.getWolsid() != null
                && getWolsid().equals(bean.getWolsid()))) return false;
    if (mask.getWopt()
        && !(getWopt() == null && bean.getWopt() == null
            || getWopt() != null && bean.getWopt() != null && getWopt().equals(bean.getWopt())))
      return false;
    if (mask.getWohz()
        && !(getWohz() == null && bean.getWohz() == null
            || getWohz() != null && bean.getWohz() != null && getWohz().equals(bean.getWohz())))
      return false;
    if (mask.getWocl()
        && !(getWocl() == null && bean.getWocl() == null
            || getWocl() != null && bean.getWocl() != null && getWocl().equals(bean.getWocl())))
      return false;
    if (mask.getWost()
        && !(getWost() == null && bean.getWost() == null
            || getWost() != null && bean.getWost() != null && getWost().equals(bean.getWost())))
      return false;
    if (mask.getWosr()
        && !(getWosr() == null && bean.getWosr() == null
            || getWosr() != null && bean.getWosr() != null && getWosr().equals(bean.getWosr())))
      return false;
    if (mask.getWosort()
        && !(getWosort() == null && bean.getWosort() == null
            || getWosort() != null
                && bean.getWosort() != null
                && getWosort().equals(bean.getWosort()))) return false;
    if (mask.getWocrdt()
        && !(getWocrdt() == null && bean.getWocrdt() == null
            || getWocrdt() != null
                && bean.getWocrdt() != null
                && getWocrdt().equals(bean.getWocrdt()))) return false;
    if (mask.getWoupdt()
        && !(getWoupdt() == null && bean.getWoupdt() == null
            || getWoupdt() != null
                && bean.getWoupdt() != null
                && getWoupdt().equals(bean.getWoupdt()))) return false;
    return true;
  }

  public static final Word.Creator<Word> CREATOR =
      new Creator<Word>() {
        @Override
        public Word[] newArray(int size) {
          return new Word[size];
        }

        @Override
        public Word createFromParcel(Parcel in) {
          return new Word(in);
        }
      };
}
