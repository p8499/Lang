package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.UserroleMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Userrole implements Parcelable {
  public static final String TABLE = "public.F0311";
  public static final String VIEW = "public.F0311";
  public static final String NAME = "USERROLE";

  public static final String FIELD_URID = "URID";
  public static final String FIELD_URUSID = "URUSID";
  public static final String FIELD_URRLID = "URRLID";

  protected Integer urid = null;

  protected Integer urusid = null;

  protected String urrlid = null;

  public Userrole(Integer urid, Integer urusid, String urrlid) {
    if (urid != null) this.urid = urid;
    if (urusid != null) this.urusid = urusid;
    if (urrlid != null) this.urrlid = urrlid;
  }

  public Userrole() {
    this(null, null, null);
  }

  public Userrole clone() {
    return new Userrole(urid, urusid, urrlid);
  }

  public Userrole(Parcel in) {

    this.urid = in.readInt();

    this.urusid = in.readInt();

    this.urrlid = in.readString();
  }

  public Integer getUrid() {
    return urid;
  }

  public Userrole setUrid(Integer urid) {
    this.urid = urid;
    return this;
  }

  public Integer getUrusid() {
    return urusid;
  }

  public Userrole setUrusid(Integer urusid) {
    this.urusid = urusid;
    return this;
  }

  public String getUrrlid() {
    return urrlid;
  }

  public Userrole setUrrlid(String urrlid) {
    this.urrlid = urrlid;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(urid);

    dest.writeInt(urusid);

    dest.writeString(urrlid);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Userrole) ? equals((Userrole) obj, new UserroleMask().all(true)) : false;
  }

  public boolean equals(Userrole bean, UserroleMask mask) {
    if (mask == null) mask = new UserroleMask().all(true);

    if (mask.getUrid()
        && !(getUrid() == null && bean.getUrid() == null
            || getUrid() != null && bean.getUrid() != null && getUrid().equals(bean.getUrid())))
      return false;
    if (mask.getUrusid()
        && !(getUrusid() == null && bean.getUrusid() == null
            || getUrusid() != null
                && bean.getUrusid() != null
                && getUrusid().equals(bean.getUrusid()))) return false;
    if (mask.getUrrlid()
        && !(getUrrlid() == null && bean.getUrrlid() == null
            || getUrrlid() != null
                && bean.getUrrlid() != null
                && getUrrlid().equals(bean.getUrrlid()))) return false;
    return true;
  }

  public static final Userrole.Creator<Userrole> CREATOR =
      new Creator<Userrole>() {
        @Override
        public Userrole[] newArray(int size) {
          return new Userrole[size];
        }

        @Override
        public Userrole createFromParcel(Parcel in) {
          return new Userrole(in);
        }
      };
}
