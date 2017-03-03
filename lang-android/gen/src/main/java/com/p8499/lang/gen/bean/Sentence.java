package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.SentenceMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sentence implements Parcelable {
  public static final String TABLE = "public.F1120";
  public static final String VIEW = "public.V1120";
  public static final String NAME = "SENTENCE";

  public static final String FIELD_ASID = "ASID";
  public static final String FIELD_ASATID = "ASATID";
  public static final String FIELD_ASSI = "ASSI";
  public static final String FIELD_ASCONT = "ASCONT";
  public static final String FIELD_ASST = "ASST";
  public static final String FIELD_ASCS = "ASCS";
  public static final String FIELD_ASUSID = "ASUSID";
  public static final String FIELD_ASCRDT = "ASCRDT";
  public static final String FIELD_ASUPDT = "ASUPDT";

  public static final Integer ASST_DISABLED = -1;

  public static final Integer ASST_ENABLED = 0;

  public static final Integer DEFAULT_ASST = 0;

  protected Integer asid = null;

  protected Integer asatid = null;

  protected Integer assi = null;

  protected String ascont = null;

  protected Integer asst = DEFAULT_ASST;

  protected String ascs = null;

  protected Integer asusid = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date ascrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date asupdt = null;

  public Sentence(
      Integer asid,
      Integer asatid,
      Integer assi,
      String ascont,
      Integer asst,
      String ascs,
      Integer asusid,
      java.util.Date ascrdt,
      java.util.Date asupdt) {
    if (asid != null) this.asid = asid;
    if (asatid != null) this.asatid = asatid;
    if (assi != null) this.assi = assi;
    if (ascont != null) this.ascont = ascont;
    if (asst != null) this.asst = asst;
    if (ascs != null) this.ascs = ascs;
    if (asusid != null) this.asusid = asusid;
    if (ascrdt != null) this.ascrdt = ascrdt;
    if (asupdt != null) this.asupdt = asupdt;
  }

  public Sentence() {
    this(null, null, null, null, null, null, null, null, null);
  }

  public Sentence clone() {
    return new Sentence(asid, asatid, assi, ascont, asst, ascs, asusid, ascrdt, asupdt);
  }

  public Sentence(Parcel in) {

    this.asid = in.readInt();

    this.asatid = in.readInt();

    this.assi = in.readInt();

    this.ascont = in.readString();

    this.asst = in.readInt();

    this.ascs = in.readString();

    this.asusid = in.readInt();

    this.ascrdt = DefaultDateFormatter.parse(in.readString());

    this.asupdt = DefaultDateFormatter.parse(in.readString());
  }

  public Integer getAsid() {
    return asid;
  }

  public Sentence setAsid(Integer asid) {
    this.asid = asid;
    return this;
  }

  public Integer getAsatid() {
    return asatid;
  }

  public Sentence setAsatid(Integer asatid) {
    this.asatid = asatid;
    return this;
  }

  public Integer getAssi() {
    return assi;
  }

  public Sentence setAssi(Integer assi) {
    this.assi = assi;
    return this;
  }

  public String getAscont() {
    return ascont;
  }

  public Sentence setAscont(String ascont) {
    this.ascont = ascont;
    return this;
  }

  public Integer getAsst() {
    return asst;
  }

  public Sentence setAsst(Integer asst) {
    this.asst = asst;
    return this;
  }

  public String getAscs() {
    return ascs;
  }

  public Sentence setAscs(String ascs) {
    this.ascs = ascs;
    return this;
  }

  public Integer getAsusid() {
    return asusid;
  }

  public Sentence setAsusid(Integer asusid) {
    this.asusid = asusid;
    return this;
  }

  public java.util.Date getAscrdt() {
    return ascrdt;
  }

  public Sentence setAscrdt(java.util.Date ascrdt) {
    this.ascrdt = ascrdt;
    return this;
  }

  public java.util.Date getAsupdt() {
    return asupdt;
  }

  public Sentence setAsupdt(java.util.Date asupdt) {
    this.asupdt = asupdt;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(asid);

    dest.writeInt(asatid);

    dest.writeInt(assi);

    dest.writeString(ascont);

    dest.writeInt(asst);

    dest.writeString(ascs);

    dest.writeInt(asusid);

    dest.writeString(DefaultDateFormatter.format(ascrdt));

    dest.writeString(DefaultDateFormatter.format(asupdt));
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Sentence) ? equals((Sentence) obj, new SentenceMask().all(true)) : false;
  }

  public boolean equals(Sentence bean, SentenceMask mask) {
    if (mask == null) mask = new SentenceMask().all(true);

    if (mask.getAsid()
        && !(getAsid() == null && bean.getAsid() == null
            || getAsid() != null && bean.getAsid() != null && getAsid().equals(bean.getAsid())))
      return false;
    if (mask.getAsatid()
        && !(getAsatid() == null && bean.getAsatid() == null
            || getAsatid() != null
                && bean.getAsatid() != null
                && getAsatid().equals(bean.getAsatid()))) return false;
    if (mask.getAssi()
        && !(getAssi() == null && bean.getAssi() == null
            || getAssi() != null && bean.getAssi() != null && getAssi().equals(bean.getAssi())))
      return false;
    if (mask.getAscont()
        && !(getAscont() == null && bean.getAscont() == null
            || getAscont() != null
                && bean.getAscont() != null
                && getAscont().equals(bean.getAscont()))) return false;
    if (mask.getAsst()
        && !(getAsst() == null && bean.getAsst() == null
            || getAsst() != null && bean.getAsst() != null && getAsst().equals(bean.getAsst())))
      return false;
    if (mask.getAscs()
        && !(getAscs() == null && bean.getAscs() == null
            || getAscs() != null && bean.getAscs() != null && getAscs().equals(bean.getAscs())))
      return false;
    if (mask.getAsusid()
        && !(getAsusid() == null && bean.getAsusid() == null
            || getAsusid() != null
                && bean.getAsusid() != null
                && getAsusid().equals(bean.getAsusid()))) return false;
    if (mask.getAscrdt()
        && !(getAscrdt() == null && bean.getAscrdt() == null
            || getAscrdt() != null
                && bean.getAscrdt() != null
                && getAscrdt().equals(bean.getAscrdt()))) return false;
    if (mask.getAsupdt()
        && !(getAsupdt() == null && bean.getAsupdt() == null
            || getAsupdt() != null
                && bean.getAsupdt() != null
                && getAsupdt().equals(bean.getAsupdt()))) return false;
    return true;
  }

  public static final Sentence.Creator<Sentence> CREATOR =
      new Creator<Sentence>() {
        @Override
        public Sentence[] newArray(int size) {
          return new Sentence[size];
        }

        @Override
        public Sentence createFromParcel(Parcel in) {
          return new Sentence(in);
        }
      };
}
