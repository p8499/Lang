package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.UserMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Parcelable {
  public static final String TABLE = "public.F0301";
  public static final String VIEW = "public.V0301";
  public static final String NAME = "USER";

  public static final String FIELD_USID = "USID";
  public static final String FIELD_USCELL = "USCELL";
  public static final String FIELD_USPSWD = "USPSWD";
  public static final String FIELD_USNAME = "USNAME";
  public static final String FIELD_USST = "USST";
  public static final String FIELD_USLSID = "USLSID";
  public static final String FIELD_USLSNAME = "USLSNAME";

  public static final Integer USST_DISABLED = -1;

  public static final Integer USST_ENABLED = 0;

  public static final Integer DEFAULT_USST = 0;

  protected Integer usid = null;

  protected String uscell = null;

  protected String uspswd = null;

  protected String usname = null;

  protected Integer usst = DEFAULT_USST;

  protected String uslsid = null;

  protected String uslsname = null;

  public User(
      Integer usid,
      String uscell,
      String uspswd,
      String usname,
      Integer usst,
      String uslsid,
      String uslsname) {
    if (usid != null) this.usid = usid;
    if (uscell != null) this.uscell = uscell;
    if (uspswd != null) this.uspswd = uspswd;
    if (usname != null) this.usname = usname;
    if (usst != null) this.usst = usst;
    if (uslsid != null) this.uslsid = uslsid;
    if (uslsname != null) this.uslsname = uslsname;
  }

  public User() {
    this(null, null, null, null, null, null, null);
  }

  public User clone() {
    return new User(usid, uscell, uspswd, usname, usst, uslsid, uslsname);
  }

  public User(Parcel in) {

    this.usid = in.readInt();

    this.uscell = in.readString();

    this.uspswd = in.readString();

    this.usname = in.readString();

    this.usst = in.readInt();

    this.uslsid = in.readString();

    this.uslsname = in.readString();
  }

  public Integer getUsid() {
    return usid;
  }

  public User setUsid(Integer usid) {
    this.usid = usid;
    return this;
  }

  public String getUscell() {
    return uscell;
  }

  public User setUscell(String uscell) {
    this.uscell = uscell;
    return this;
  }

  public String getUspswd() {
    return uspswd;
  }

  public User setUspswd(String uspswd) {
    this.uspswd = uspswd;
    return this;
  }

  public String getUsname() {
    return usname;
  }

  public User setUsname(String usname) {
    this.usname = usname;
    return this;
  }

  public Integer getUsst() {
    return usst;
  }

  public User setUsst(Integer usst) {
    this.usst = usst;
    return this;
  }

  public String getUslsid() {
    return uslsid;
  }

  public User setUslsid(String uslsid) {
    this.uslsid = uslsid;
    return this;
  }

  public String getUslsname() {
    return uslsname;
  }

  public User setUslsname(String uslsname) {
    this.uslsname = uslsname;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(usid);

    dest.writeString(uscell);

    dest.writeString(uspswd);

    dest.writeString(usname);

    dest.writeInt(usst);

    dest.writeString(uslsid);

    dest.writeString(uslsname);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof User) ? equals((User) obj, new UserMask().all(true)) : false;
  }

  public boolean equals(User bean, UserMask mask) {
    if (mask == null) mask = new UserMask().all(true);

    if (mask.getUsid()
        && !(getUsid() == null && bean.getUsid() == null
            || getUsid() != null && bean.getUsid() != null && getUsid().equals(bean.getUsid())))
      return false;
    if (mask.getUscell()
        && !(getUscell() == null && bean.getUscell() == null
            || getUscell() != null
                && bean.getUscell() != null
                && getUscell().equals(bean.getUscell()))) return false;
    if (mask.getUspswd()
        && !(getUspswd() == null && bean.getUspswd() == null
            || getUspswd() != null
                && bean.getUspswd() != null
                && getUspswd().equals(bean.getUspswd()))) return false;
    if (mask.getUsname()
        && !(getUsname() == null && bean.getUsname() == null
            || getUsname() != null
                && bean.getUsname() != null
                && getUsname().equals(bean.getUsname()))) return false;
    if (mask.getUsst()
        && !(getUsst() == null && bean.getUsst() == null
            || getUsst() != null && bean.getUsst() != null && getUsst().equals(bean.getUsst())))
      return false;
    if (mask.getUslsid()
        && !(getUslsid() == null && bean.getUslsid() == null
            || getUslsid() != null
                && bean.getUslsid() != null
                && getUslsid().equals(bean.getUslsid()))) return false;
    if (mask.getUslsname()
        && !(getUslsname() == null && bean.getUslsname() == null
            || getUslsname() != null
                && bean.getUslsname() != null
                && getUslsname().equals(bean.getUslsname()))) return false;
    return true;
  }

  public static final User.Creator<User> CREATOR =
      new Creator<User>() {
        @Override
        public User[] newArray(int size) {
          return new User[size];
        }

        @Override
        public User createFromParcel(Parcel in) {
          return new User(in);
        }
      };
}
