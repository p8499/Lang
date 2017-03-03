package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.RoleauthorityMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Roleauthority implements Parcelable {
  public static final String TABLE = "public.F0321";
  public static final String VIEW = "public.F0321";
  public static final String NAME = "ROLEAUTHORITY";

  public static final String FIELD_RAID = "RAID";
  public static final String FIELD_RARLID = "RARLID";
  public static final String FIELD_RAAUID = "RAAUID";

  protected Integer raid = null;

  protected String rarlid = null;

  protected String raauid = null;

  public Roleauthority(Integer raid, String rarlid, String raauid) {
    if (raid != null) this.raid = raid;
    if (rarlid != null) this.rarlid = rarlid;
    if (raauid != null) this.raauid = raauid;
  }

  public Roleauthority() {
    this(null, null, null);
  }

  public Roleauthority clone() {
    return new Roleauthority(raid, rarlid, raauid);
  }

  public Roleauthority(Parcel in) {

    this.raid = in.readInt();

    this.rarlid = in.readString();

    this.raauid = in.readString();
  }

  public Integer getRaid() {
    return raid;
  }

  public Roleauthority setRaid(Integer raid) {
    this.raid = raid;
    return this;
  }

  public String getRarlid() {
    return rarlid;
  }

  public Roleauthority setRarlid(String rarlid) {
    this.rarlid = rarlid;
    return this;
  }

  public String getRaauid() {
    return raauid;
  }

  public Roleauthority setRaauid(String raauid) {
    this.raauid = raauid;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(raid);

    dest.writeString(rarlid);

    dest.writeString(raauid);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Roleauthority)
        ? equals((Roleauthority) obj, new RoleauthorityMask().all(true))
        : false;
  }

  public boolean equals(Roleauthority bean, RoleauthorityMask mask) {
    if (mask == null) mask = new RoleauthorityMask().all(true);

    if (mask.getRaid()
        && !(getRaid() == null && bean.getRaid() == null
            || getRaid() != null && bean.getRaid() != null && getRaid().equals(bean.getRaid())))
      return false;
    if (mask.getRarlid()
        && !(getRarlid() == null && bean.getRarlid() == null
            || getRarlid() != null
                && bean.getRarlid() != null
                && getRarlid().equals(bean.getRarlid()))) return false;
    if (mask.getRaauid()
        && !(getRaauid() == null && bean.getRaauid() == null
            || getRaauid() != null
                && bean.getRaauid() != null
                && getRaauid().equals(bean.getRaauid()))) return false;
    return true;
  }

  public static final Roleauthority.Creator<Roleauthority> CREATOR =
      new Creator<Roleauthority>() {
        @Override
        public Roleauthority[] newArray(int size) {
          return new Roleauthority[size];
        }

        @Override
        public Roleauthority createFromParcel(Parcel in) {
          return new Roleauthority(in);
        }
      };
}
