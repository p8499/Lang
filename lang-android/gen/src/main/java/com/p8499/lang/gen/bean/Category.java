package com.p8499.lang.gen.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.p8499.lang.gen.DefaultDateFormatter;
import com.p8499.lang.gen.mask.CategoryMask;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category implements Parcelable {
  public static final String TABLE = "public.F1030";
  public static final String VIEW = "public.F1030";
  public static final String NAME = "CATEGORY";

  public static final String FIELD_CGID = "CGID";
  public static final String FIELD_CGLSID = "CGLSID";
  public static final String FIELD_CGSI = "CGSI";
  public static final String FIELD_CGPSI = "CGPSI";
  public static final String FIELD_CGUSID = "CGUSID";
  public static final String FIELD_CGNAME = "CGNAME";

  protected Integer cgid = null;

  protected String cglsid = null;

  protected Integer cgsi = null;

  protected Integer cgpsi = null;

  protected Integer cgusid = null;

  protected String cgname = null;

  public Category(
      Integer cgid, String cglsid, Integer cgsi, Integer cgpsi, Integer cgusid, String cgname) {
    if (cgid != null) this.cgid = cgid;
    if (cglsid != null) this.cglsid = cglsid;
    if (cgsi != null) this.cgsi = cgsi;
    if (cgpsi != null) this.cgpsi = cgpsi;
    if (cgusid != null) this.cgusid = cgusid;
    if (cgname != null) this.cgname = cgname;
  }

  public Category() {
    this(null, null, null, null, null, null);
  }

  public Category clone() {
    return new Category(cgid, cglsid, cgsi, cgpsi, cgusid, cgname);
  }

  public Category(Parcel in) {

    this.cgid = in.readInt();

    this.cglsid = in.readString();

    this.cgsi = in.readInt();

    this.cgpsi = in.readInt();

    this.cgusid = in.readInt();

    this.cgname = in.readString();
  }

  public Integer getCgid() {
    return cgid;
  }

  public Category setCgid(Integer cgid) {
    this.cgid = cgid;
    return this;
  }

  public String getCglsid() {
    return cglsid;
  }

  public Category setCglsid(String cglsid) {
    this.cglsid = cglsid;
    return this;
  }

  public Integer getCgsi() {
    return cgsi;
  }

  public Category setCgsi(Integer cgsi) {
    this.cgsi = cgsi;
    return this;
  }

  public Integer getCgpsi() {
    return cgpsi;
  }

  public Category setCgpsi(Integer cgpsi) {
    this.cgpsi = cgpsi;
    return this;
  }

  public Integer getCgusid() {
    return cgusid;
  }

  public Category setCgusid(Integer cgusid) {
    this.cgusid = cgusid;
    return this;
  }

  public String getCgname() {
    return cgname;
  }

  public Category setCgname(String cgname) {
    this.cgname = cgname;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

    dest.writeInt(cgid);

    dest.writeString(cglsid);

    dest.writeInt(cgsi);

    dest.writeInt(cgpsi);

    dest.writeInt(cgusid);

    dest.writeString(cgname);
  }

  @Override
  public boolean equals(Object obj) {
    return (obj instanceof Category) ? equals((Category) obj, new CategoryMask().all(true)) : false;
  }

  public boolean equals(Category bean, CategoryMask mask) {
    if (mask == null) mask = new CategoryMask().all(true);

    if (mask.getCgid()
        && !(getCgid() == null && bean.getCgid() == null
            || getCgid() != null && bean.getCgid() != null && getCgid().equals(bean.getCgid())))
      return false;
    if (mask.getCglsid()
        && !(getCglsid() == null && bean.getCglsid() == null
            || getCglsid() != null
                && bean.getCglsid() != null
                && getCglsid().equals(bean.getCglsid()))) return false;
    if (mask.getCgsi()
        && !(getCgsi() == null && bean.getCgsi() == null
            || getCgsi() != null && bean.getCgsi() != null && getCgsi().equals(bean.getCgsi())))
      return false;
    if (mask.getCgpsi()
        && !(getCgpsi() == null && bean.getCgpsi() == null
            || getCgpsi() != null && bean.getCgpsi() != null && getCgpsi().equals(bean.getCgpsi())))
      return false;
    if (mask.getCgusid()
        && !(getCgusid() == null && bean.getCgusid() == null
            || getCgusid() != null
                && bean.getCgusid() != null
                && getCgusid().equals(bean.getCgusid()))) return false;
    if (mask.getCgname()
        && !(getCgname() == null && bean.getCgname() == null
            || getCgname() != null
                && bean.getCgname() != null
                && getCgname().equals(bean.getCgname()))) return false;
    return true;
  }

  public static final Category.Creator<Category> CREATOR =
      new Creator<Category>() {
        @Override
        public Category[] newArray(int size) {
          return new Category[size];
        }

        @Override
        public Category createFromParcel(Parcel in) {
          return new Category(in);
        }
      };
}
