package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.QuestionoptionMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Questionoption implements Parcelable {
  public static final String TABLE = "public.F1202";
  public static final String VIEW = "public.F1202";
  public static final String NAME = "QUESTIONOPTION";

  public static final String FIELD_TOID = "TOID";
  public static final String FIELD_TOTQID = "TOTQID";
  public static final String FIELD_TOO = "TOO";
  public static final String FIELD_TOCONT = "TOCONT";

  protected Integer toid = null;

  protected Integer totqid = null;

  protected String too = null;

  protected String tocont = null;

  public Questionoption(Integer toid, Integer totqid, String too, String tocont) {
    if (toid != null) this.toid = toid;
    if (totqid != null) this.totqid = totqid;
    if (too != null) this.too = too;
    if (tocont != null) this.tocont = tocont;
  }

  public Questionoption() {
    this(null, null, null, null);
  }

  public Questionoption clone() {
    return new Questionoption(toid, totqid, too, tocont);
  }

  public Questionoption(Parcel in) {

    this.toid = in.readInt();

    this.totqid = in.readInt();

    this.too = in.readString();

    this.tocont = in.readString();
  }

  public Integer getToid() {
    return toid;
  }

  public Questionoption setToid(Integer toid) {
    this.toid = toid;
    return this;
  }

  public Integer getTotqid() {
    return totqid;
  }

  public Questionoption setTotqid(Integer totqid) {
    this.totqid = totqid;
    return this;
  }

  public String getToo() {
    return too;
  }

  public Questionoption setToo(String too) {
    this.too = too;
    return this;
  }

  public String getTocont() {
    return tocont;
  }

  public Questionoption setTocont(String tocont) {
    this.tocont = tocont;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(toid);

    dest.writeInt(totqid);

    dest.writeString(too);

    dest.writeString(tocont);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Questionoption)
        ? equals((Questionoption) obj, new QuestionoptionMask().all(true))
        : false;
  }

  public boolean equals(Questionoption bean, QuestionoptionMask mask) {
    if (mask == null) mask = new QuestionoptionMask().all(true);

    if (mask.getToid()
        && !(getToid() == null && bean.getToid() == null
            || getToid() != null && bean.getToid() != null && getToid().equals(bean.getToid())))
      return false;
    if (mask.getTotqid()
        && !(getTotqid() == null && bean.getTotqid() == null
            || getTotqid() != null
                && bean.getTotqid() != null
                && getTotqid().equals(bean.getTotqid()))) return false;
    if (mask.getToo()
        && !(getToo() == null && bean.getToo() == null
            || getToo() != null && bean.getToo() != null && getToo().equals(bean.getToo())))
      return false;
    if (mask.getTocont()
        && !(getTocont() == null && bean.getTocont() == null
            || getTocont() != null
                && bean.getTocont() != null
                && getTocont().equals(bean.getTocont()))) return false;
    return true;
  }

  public static final Questionoption.Creator<Questionoption> CREATOR =
      new Creator<Questionoption>() {
        @Override
        public Questionoption[] newArray(int size) {
          return new Questionoption[size];
        }

        @Override
        public Questionoption createFromParcel(Parcel in) {
          return new Questionoption(in);
        }
      };
}
