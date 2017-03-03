package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.AuthorityMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Authority implements Parcelable {
  public static final String TABLE = "public.F0320";
  public static final String VIEW = "public.F0320";
  public static final String NAME = "AUTHORITY";

  public static final String FIELD_AUID = "AUID";
  public static final String FIELD_AUNAME = "AUNAME";

  protected String auid = null;

  protected String auname = null;

  public Authority(String auid, String auname) {
    if (auid != null) this.auid = auid;
    if (auname != null) this.auname = auname;
  }

  public Authority() {
    this(null, null);
  }

  public Authority clone() {
    return new Authority(auid, auname);
  }

  public Authority(Parcel in) {

    this.auid = in.readString();

    this.auname = in.readString();
  }

  public String getAuid() {
    return auid;
  }

  public Authority setAuid(String auid) {
    this.auid = auid;
    return this;
  }

  public String getAuname() {
    return auname;
  }

  public Authority setAuname(String auname) {
    this.auname = auname;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeString(auid);

    dest.writeString(auname);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Authority)
        ? equals((Authority) obj, new AuthorityMask().all(true))
        : false;
  }

  public boolean equals(Authority bean, AuthorityMask mask) {
    if (mask == null) mask = new AuthorityMask().all(true);

    if (mask.getAuid()
        && !(getAuid() == null && bean.getAuid() == null
            || getAuid() != null && bean.getAuid() != null && getAuid().equals(bean.getAuid())))
      return false;
    if (mask.getAuname()
        && !(getAuname() == null && bean.getAuname() == null
            || getAuname() != null
                && bean.getAuname() != null
                && getAuname().equals(bean.getAuname()))) return false;
    return true;
  }

  public static final Authority.Creator<Authority> CREATOR =
      new Creator<Authority>() {
        @Override
        public Authority[] newArray(int size) {
          return new Authority[size];
        }

        @Override
        public Authority createFromParcel(Parcel in) {
          return new Authority(in);
        }
      };
}
