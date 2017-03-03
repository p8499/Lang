package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.RoleMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role implements Parcelable {
  public static final String TABLE = "public.F0310";
  public static final String VIEW = "public.F0310";
  public static final String NAME = "ROLE";

  public static final String FIELD_RLID = "RLID";
  public static final String FIELD_RLNAME = "RLNAME";

  protected String rlid = null;

  protected String rlname = null;

  public Role(String rlid, String rlname) {
    if (rlid != null) this.rlid = rlid;
    if (rlname != null) this.rlname = rlname;
  }

  public Role() {
    this(null, null);
  }

  public Role clone() {
    return new Role(rlid, rlname);
  }

  public Role(Parcel in) {

    this.rlid = in.readString();

    this.rlname = in.readString();
  }

  public String getRlid() {
    return rlid;
  }

  public Role setRlid(String rlid) {
    this.rlid = rlid;
    return this;
  }

  public String getRlname() {
    return rlname;
  }

  public Role setRlname(String rlname) {
    this.rlname = rlname;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeString(rlid);

    dest.writeString(rlname);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Role) ? equals((Role) obj, new RoleMask().all(true)) : false;
  }

  public boolean equals(Role bean, RoleMask mask) {
    if (mask == null) mask = new RoleMask().all(true);

    if (mask.getRlid()
        && !(getRlid() == null && bean.getRlid() == null
            || getRlid() != null && bean.getRlid() != null && getRlid().equals(bean.getRlid())))
      return false;
    if (mask.getRlname()
        && !(getRlname() == null && bean.getRlname() == null
            || getRlname() != null
                && bean.getRlname() != null
                && getRlname().equals(bean.getRlname()))) return false;
    return true;
  }

  public static final Role.Creator<Role> CREATOR =
      new Creator<Role>() {
        @Override
        public Role[] newArray(int size) {
          return new Role[size];
        }

        @Override
        public Role createFromParcel(Parcel in) {
          return new Role(in);
        }
      };
}
