package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.UsercreationMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Usercreation implements Parcelable {
  public static final String TABLE = "public.F0309";
  public static final String VIEW = "public.F0309";
  public static final String NAME = "USERCREATION";

  public static final String FIELD_UCID = "UCID";
  public static final String FIELD_UCCRDT = "UCCRDT";
  public static final String FIELD_UCUPDT = "UCUPDT";
  public static final String FIELD_UCCELL = "UCCELL";
  public static final String FIELD_UCPV = "UCPV";
  public static final String FIELD_UCMV = "UCMV";
  public static final String FIELD_UCAC = "UCAC";
  public static final String FIELD_UCST = "UCST";

  public static final Integer UCAC_INITIAL = 0;

  public static final Integer UCAC_SENT = 1;

  public static final Integer UCAC_VERIFIED = 2;

  public static final Integer UCAC_FINALIZED = 3;

  public static final Integer UCST_INVALID = -1;

  public static final Integer UCST_VALID = 0;

  public static final Integer DEFAULT_UCAC = 0;

  public static final Integer DEFAULT_UCST = 0;

  protected Integer ucid = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date uccrdt = null;

  @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
  protected java.util.Date ucupdt = null;

  protected String uccell = null;

  protected String ucpv = null;

  protected String ucmv = null;

  protected Integer ucac = DEFAULT_UCAC;

  protected Integer ucst = DEFAULT_UCST;

  public Usercreation(
      Integer ucid,
      java.util.Date uccrdt,
      java.util.Date ucupdt,
      String uccell,
      String ucpv,
      String ucmv,
      Integer ucac,
      Integer ucst) {
    if (ucid != null) this.ucid = ucid;
    if (uccrdt != null) this.uccrdt = uccrdt;
    if (ucupdt != null) this.ucupdt = ucupdt;
    if (uccell != null) this.uccell = uccell;
    if (ucpv != null) this.ucpv = ucpv;
    if (ucmv != null) this.ucmv = ucmv;
    if (ucac != null) this.ucac = ucac;
    if (ucst != null) this.ucst = ucst;
  }

  public Usercreation() {
    this(null, null, null, null, null, null, null, null);
  }

  public Usercreation clone() {
    return new Usercreation(ucid, uccrdt, ucupdt, uccell, ucpv, ucmv, ucac, ucst);
  }

  public Usercreation(Parcel in) {

    this.ucid = in.readInt();

    this.uccrdt = DefaultDateFormatter.parse(in.readString());

    this.ucupdt = DefaultDateFormatter.parse(in.readString());

    this.uccell = in.readString();

    this.ucpv = in.readString();

    this.ucmv = in.readString();

    this.ucac = in.readInt();

    this.ucst = in.readInt();
  }

  public Integer getUcid() {
    return ucid;
  }

  public Usercreation setUcid(Integer ucid) {
    this.ucid = ucid;
    return this;
  }

  public java.util.Date getUccrdt() {
    return uccrdt;
  }

  public Usercreation setUccrdt(java.util.Date uccrdt) {
    this.uccrdt = uccrdt;
    return this;
  }

  public java.util.Date getUcupdt() {
    return ucupdt;
  }

  public Usercreation setUcupdt(java.util.Date ucupdt) {
    this.ucupdt = ucupdt;
    return this;
  }

  public String getUccell() {
    return uccell;
  }

  public Usercreation setUccell(String uccell) {
    this.uccell = uccell;
    return this;
  }

  public String getUcpv() {
    return ucpv;
  }

  public Usercreation setUcpv(String ucpv) {
    this.ucpv = ucpv;
    return this;
  }

  public String getUcmv() {
    return ucmv;
  }

  public Usercreation setUcmv(String ucmv) {
    this.ucmv = ucmv;
    return this;
  }

  public Integer getUcac() {
    return ucac;
  }

  public Usercreation setUcac(Integer ucac) {
    this.ucac = ucac;
    return this;
  }

  public Integer getUcst() {
    return ucst;
  }

  public Usercreation setUcst(Integer ucst) {
    this.ucst = ucst;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(ucid);

    dest.writeString(DefaultDateFormatter.format(uccrdt));

    dest.writeString(DefaultDateFormatter.format(ucupdt));

    dest.writeString(uccell);

    dest.writeString(ucpv);

    dest.writeString(ucmv);

    dest.writeInt(ucac);

    dest.writeInt(ucst);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Usercreation)
        ? equals((Usercreation) obj, new UsercreationMask().all(true))
        : false;
  }

  public boolean equals(Usercreation bean, UsercreationMask mask) {
    if (mask == null) mask = new UsercreationMask().all(true);

    if (mask.getUcid()
        && !(getUcid() == null && bean.getUcid() == null
            || getUcid() != null && bean.getUcid() != null && getUcid().equals(bean.getUcid())))
      return false;
    if (mask.getUccrdt()
        && !(getUccrdt() == null && bean.getUccrdt() == null
            || getUccrdt() != null
                && bean.getUccrdt() != null
                && getUccrdt().equals(bean.getUccrdt()))) return false;
    if (mask.getUcupdt()
        && !(getUcupdt() == null && bean.getUcupdt() == null
            || getUcupdt() != null
                && bean.getUcupdt() != null
                && getUcupdt().equals(bean.getUcupdt()))) return false;
    if (mask.getUccell()
        && !(getUccell() == null && bean.getUccell() == null
            || getUccell() != null
                && bean.getUccell() != null
                && getUccell().equals(bean.getUccell()))) return false;
    if (mask.getUcpv()
        && !(getUcpv() == null && bean.getUcpv() == null
            || getUcpv() != null && bean.getUcpv() != null && getUcpv().equals(bean.getUcpv())))
      return false;
    if (mask.getUcmv()
        && !(getUcmv() == null && bean.getUcmv() == null
            || getUcmv() != null && bean.getUcmv() != null && getUcmv().equals(bean.getUcmv())))
      return false;
    if (mask.getUcac()
        && !(getUcac() == null && bean.getUcac() == null
            || getUcac() != null && bean.getUcac() != null && getUcac().equals(bean.getUcac())))
      return false;
    if (mask.getUcst()
        && !(getUcst() == null && bean.getUcst() == null
            || getUcst() != null && bean.getUcst() != null && getUcst().equals(bean.getUcst())))
      return false;
    return true;
  }

  public static final Usercreation.Creator<Usercreation> CREATOR =
      new Creator<Usercreation>() {
        @Override
        public Usercreation[] newArray(int size) {
          return new Usercreation[size];
        }

        @Override
        public Usercreation createFromParcel(Parcel in) {
          return new Usercreation(in);
        }
      };
}
