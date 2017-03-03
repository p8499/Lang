package com.p8499.lang.server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Roleauthority {
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

  @javax.validation.constraints.Null(groups = {Insert.class})
  @javax.validation.constraints.NotNull(groups = {Update.class})
  public Integer getRaid() {
    return raid;
  }

  public Roleauthority setRaid(Integer raid) {
    this.raid = raid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 8)
  public String getRarlid() {
    return rarlid;
  }

  public Roleauthority setRarlid(String rarlid) {
    this.rarlid = rarlid;
    return this;
  }

  @javax.validation.constraints.NotNull(groups = {Insert.class, Update.class})
  @javax.validation.constraints.Size(max = 16)
  public String getRaauid() {
    return raauid;
  }

  public Roleauthority setRaauid(String raauid) {
    this.raauid = raauid;
    return this;
  }
}
