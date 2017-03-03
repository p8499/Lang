package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.LanguageMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Language implements Parcelable {
  public static final String TABLE = "public.F1010";
  public static final String VIEW = "public.F1010";
  public static final String NAME = "LANGUAGE";

  public static final String FIELD_LSID = "LSID";
  public static final String FIELD_LSNAME = "LSNAME";
  public static final String FIELD_LSLOC = "LSLOC";
  public static final String FIELD_LSSORT = "LSSORT";

  protected String lsid = null;

  protected String lsname = null;

  protected String lsloc = null;

  protected Integer lssort = null;

  public Language(String lsid, String lsname, String lsloc, Integer lssort) {
    if (lsid != null) this.lsid = lsid;
    if (lsname != null) this.lsname = lsname;
    if (lsloc != null) this.lsloc = lsloc;
    if (lssort != null) this.lssort = lssort;
  }

  public Language() {
    this(null, null, null, null);
  }

  public Language clone() {
    return new Language(lsid, lsname, lsloc, lssort);
  }

  public Language(Parcel in) {

    this.lsid = in.readString();

    this.lsname = in.readString();

    this.lsloc = in.readString();

    this.lssort = in.readInt();
  }

  public String getLsid() {
    return lsid;
  }

  public Language setLsid(String lsid) {
    this.lsid = lsid;
    return this;
  }

  public String getLsname() {
    return lsname;
  }

  public Language setLsname(String lsname) {
    this.lsname = lsname;
    return this;
  }

  public String getLsloc() {
    return lsloc;
  }

  public Language setLsloc(String lsloc) {
    this.lsloc = lsloc;
    return this;
  }

  public Integer getLssort() {
    return lssort;
  }

  public Language setLssort(Integer lssort) {
    this.lssort = lssort;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeString(lsid);

    dest.writeString(lsname);

    dest.writeString(lsloc);

    dest.writeInt(lssort);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Language) ? equals((Language) obj, new LanguageMask().all(true)) : false;
  }

  public boolean equals(Language bean, LanguageMask mask) {
    if (mask == null) mask = new LanguageMask().all(true);

    if (mask.getLsid()
        && !(getLsid() == null && bean.getLsid() == null
            || getLsid() != null && bean.getLsid() != null && getLsid().equals(bean.getLsid())))
      return false;
    if (mask.getLsname()
        && !(getLsname() == null && bean.getLsname() == null
            || getLsname() != null
                && bean.getLsname() != null
                && getLsname().equals(bean.getLsname()))) return false;
    if (mask.getLsloc()
        && !(getLsloc() == null && bean.getLsloc() == null
            || getLsloc() != null && bean.getLsloc() != null && getLsloc().equals(bean.getLsloc())))
      return false;
    if (mask.getLssort()
        && !(getLssort() == null && bean.getLssort() == null
            || getLssort() != null
                && bean.getLssort() != null
                && getLssort().equals(bean.getLssort()))) return false;
    return true;
  }

  public static final Language.Creator<Language> CREATOR =
      new Creator<Language>() {
        @Override
        public Language[] newArray(int size) {
          return new Language[size];
        }

        @Override
        public Language createFromParcel(Parcel in) {
          return new Language(in);
        }
      };
}
