package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.DictionaryMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dictionary implements Parcelable {
  public static final String TABLE = "public.F1011";
  public static final String VIEW = "public.F1011";
  public static final String NAME = "DICTIONARY";

  public static final String FIELD_DCID = "DCID";
  public static final String FIELD_DCLSID = "DCLSID";
  public static final String FIELD_DCHZ = "DCHZ";
  public static final String FIELD_DCPT = "DCPT";
  public static final String FIELD_DCRM = "DCRM";

  protected Integer dcid = null;

  protected String dclsid = null;

  protected String dchz = null;

  protected String dcpt = null;

  protected String dcrm = null;

  public Dictionary(Integer dcid, String dclsid, String dchz, String dcpt, String dcrm) {
    if (dcid != null) this.dcid = dcid;
    if (dclsid != null) this.dclsid = dclsid;
    if (dchz != null) this.dchz = dchz;
    if (dcpt != null) this.dcpt = dcpt;
    if (dcrm != null) this.dcrm = dcrm;
  }

  public Dictionary() {
    this(null, null, null, null, null);
  }

  public Dictionary clone() {
    return new Dictionary(dcid, dclsid, dchz, dcpt, dcrm);
  }

  public Dictionary(Parcel in) {

    this.dcid = in.readInt();

    this.dclsid = in.readString();

    this.dchz = in.readString();

    this.dcpt = in.readString();

    this.dcrm = in.readString();
  }

  public Integer getDcid() {
    return dcid;
  }

  public Dictionary setDcid(Integer dcid) {
    this.dcid = dcid;
    return this;
  }

  public String getDclsid() {
    return dclsid;
  }

  public Dictionary setDclsid(String dclsid) {
    this.dclsid = dclsid;
    return this;
  }

  public String getDchz() {
    return dchz;
  }

  public Dictionary setDchz(String dchz) {
    this.dchz = dchz;
    return this;
  }

  public String getDcpt() {
    return dcpt;
  }

  public Dictionary setDcpt(String dcpt) {
    this.dcpt = dcpt;
    return this;
  }

  public String getDcrm() {
    return dcrm;
  }

  public Dictionary setDcrm(String dcrm) {
    this.dcrm = dcrm;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(dcid);

    dest.writeString(dclsid);

    dest.writeString(dchz);

    dest.writeString(dcpt);

    dest.writeString(dcrm);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Dictionary)
        ? equals((Dictionary) obj, new DictionaryMask().all(true))
        : false;
  }

  public boolean equals(Dictionary bean, DictionaryMask mask) {
    if (mask == null) mask = new DictionaryMask().all(true);

    if (mask.getDcid()
        && !(getDcid() == null && bean.getDcid() == null
            || getDcid() != null && bean.getDcid() != null && getDcid().equals(bean.getDcid())))
      return false;
    if (mask.getDclsid()
        && !(getDclsid() == null && bean.getDclsid() == null
            || getDclsid() != null
                && bean.getDclsid() != null
                && getDclsid().equals(bean.getDclsid()))) return false;
    if (mask.getDchz()
        && !(getDchz() == null && bean.getDchz() == null
            || getDchz() != null && bean.getDchz() != null && getDchz().equals(bean.getDchz())))
      return false;
    if (mask.getDcpt()
        && !(getDcpt() == null && bean.getDcpt() == null
            || getDcpt() != null && bean.getDcpt() != null && getDcpt().equals(bean.getDcpt())))
      return false;
    if (mask.getDcrm()
        && !(getDcrm() == null && bean.getDcrm() == null
            || getDcrm() != null && bean.getDcrm() != null && getDcrm().equals(bean.getDcrm())))
      return false;
    return true;
  }

  public static final Dictionary.Creator<Dictionary> CREATOR =
      new Creator<Dictionary>() {
        @Override
        public Dictionary[] newArray(int size) {
          return new Dictionary[size];
        }

        @Override
        public Dictionary createFromParcel(Parcel in) {
          return new Dictionary(in);
        }
      };
}
