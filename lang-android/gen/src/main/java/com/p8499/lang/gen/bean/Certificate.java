package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.CertificateMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Certificate implements Parcelable {
  public static final String TABLE = "public.F0331";
  public static final String VIEW = "public.V0331";
  public static final String NAME = "CERTIFICATE";

  public static final String FIELD_CRID = "CRID";
  public static final String FIELD_CRUSID = "CRUSID";
  public static final String FIELD_CRLSID = "CRLSID";
  public static final String FIELD_CRLSNAME = "CRLSNAME";
  public static final String FIELD_CRLSLOC = "CRLSLOC";
  public static final String FIELD_CRLV = "CRLV";
  public static final String FIELD_CREFDT = "CREFDT";
  public static final String FIELD_CREXDT = "CREXDT";

  public static final Integer CRLV_B = 10;

  public static final Integer CRLV_A = 20;

  protected Integer crid = null;

  protected Integer crusid = null;

  protected String crlsid = null;

  protected String crlsname = null;

  protected String crlsloc = null;

  protected Integer crlv = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date crefdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date crexdt = null;

  public Certificate(
      Integer crid,
      Integer crusid,
      String crlsid,
      String crlsname,
      String crlsloc,
      Integer crlv,
      java.util.Date crefdt,
      java.util.Date crexdt) {
    if (crid != null) this.crid = crid;
    if (crusid != null) this.crusid = crusid;
    if (crlsid != null) this.crlsid = crlsid;
    if (crlsname != null) this.crlsname = crlsname;
    if (crlsloc != null) this.crlsloc = crlsloc;
    if (crlv != null) this.crlv = crlv;
    if (crefdt != null) this.crefdt = crefdt;
    if (crexdt != null) this.crexdt = crexdt;
  }

  public Certificate() {
    this(null, null, null, null, null, null, null, null);
  }

  public Certificate clone() {
    return new Certificate(crid, crusid, crlsid, crlsname, crlsloc, crlv, crefdt, crexdt);
  }

  public Certificate(Parcel in) {

    this.crid = in.readInt();

    this.crusid = in.readInt();

    this.crlsid = in.readString();

    this.crlsname = in.readString();

    this.crlsloc = in.readString();

    this.crlv = in.readInt();

    this.crefdt = DefaultDateFormatter.parse(in.readString());

    this.crexdt = DefaultDateFormatter.parse(in.readString());
  }

  public Integer getCrid() {
    return crid;
  }

  public Certificate setCrid(Integer crid) {
    this.crid = crid;
    return this;
  }

  public Integer getCrusid() {
    return crusid;
  }

  public Certificate setCrusid(Integer crusid) {
    this.crusid = crusid;
    return this;
  }

  public String getCrlsid() {
    return crlsid;
  }

  public Certificate setCrlsid(String crlsid) {
    this.crlsid = crlsid;
    return this;
  }

  public String getCrlsname() {
    return crlsname;
  }

  public Certificate setCrlsname(String crlsname) {
    this.crlsname = crlsname;
    return this;
  }

  public String getCrlsloc() {
    return crlsloc;
  }

  public Certificate setCrlsloc(String crlsloc) {
    this.crlsloc = crlsloc;
    return this;
  }

  public Integer getCrlv() {
    return crlv;
  }

  public Certificate setCrlv(Integer crlv) {
    this.crlv = crlv;
    return this;
  }

  public java.util.Date getCrefdt() {
    return crefdt;
  }

  public Certificate setCrefdt(java.util.Date crefdt) {
    this.crefdt = crefdt;
    return this;
  }

  public java.util.Date getCrexdt() {
    return crexdt;
  }

  public Certificate setCrexdt(java.util.Date crexdt) {
    this.crexdt = crexdt;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(crid);

    dest.writeInt(crusid);

    dest.writeString(crlsid);

    dest.writeString(crlsname);

    dest.writeString(crlsloc);

    dest.writeInt(crlv);

    dest.writeString(DefaultDateFormatter.format(crefdt));

    dest.writeString(DefaultDateFormatter.format(crexdt));
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Certificate)
        ? equals((Certificate) obj, new CertificateMask().all(true))
        : false;
  }

  public boolean equals(Certificate bean, CertificateMask mask) {
    if (mask == null) mask = new CertificateMask().all(true);

    if (mask.getCrid()
        && !(getCrid() == null && bean.getCrid() == null
            || getCrid() != null && bean.getCrid() != null && getCrid().equals(bean.getCrid())))
      return false;
    if (mask.getCrusid()
        && !(getCrusid() == null && bean.getCrusid() == null
            || getCrusid() != null
                && bean.getCrusid() != null
                && getCrusid().equals(bean.getCrusid()))) return false;
    if (mask.getCrlsid()
        && !(getCrlsid() == null && bean.getCrlsid() == null
            || getCrlsid() != null
                && bean.getCrlsid() != null
                && getCrlsid().equals(bean.getCrlsid()))) return false;
    if (mask.getCrlsname()
        && !(getCrlsname() == null && bean.getCrlsname() == null
            || getCrlsname() != null
                && bean.getCrlsname() != null
                && getCrlsname().equals(bean.getCrlsname()))) return false;
    if (mask.getCrlsloc()
        && !(getCrlsloc() == null && bean.getCrlsloc() == null
            || getCrlsloc() != null
                && bean.getCrlsloc() != null
                && getCrlsloc().equals(bean.getCrlsloc()))) return false;
    if (mask.getCrlv()
        && !(getCrlv() == null && bean.getCrlv() == null
            || getCrlv() != null && bean.getCrlv() != null && getCrlv().equals(bean.getCrlv())))
      return false;
    if (mask.getCrefdt()
        && !(getCrefdt() == null && bean.getCrefdt() == null
            || getCrefdt() != null
                && bean.getCrefdt() != null
                && getCrefdt().equals(bean.getCrefdt()))) return false;
    if (mask.getCrexdt()
        && !(getCrexdt() == null && bean.getCrexdt() == null
            || getCrexdt() != null
                && bean.getCrexdt() != null
                && getCrexdt().equals(bean.getCrexdt()))) return false;
    return true;
  }

  public static final Certificate.Creator<Certificate> CREATOR =
      new Creator<Certificate>() {
        @Override
        public Certificate[] newArray(int size) {
          return new Certificate[size];
        }

        @Override
        public Certificate createFromParcel(Parcel in) {
          return new Certificate(in);
        }
      };
}
