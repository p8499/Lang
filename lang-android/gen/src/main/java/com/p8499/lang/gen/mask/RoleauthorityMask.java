package com.p8499.lang.gen.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = RoleauthorityMask.Serializer.class)
public class RoleauthorityMask {
  protected boolean raid = false;
  protected boolean rarlid = false;
  protected boolean raauid = false;

  public RoleauthorityMask(boolean raid, boolean rarlid, boolean raauid) {
    this.raid = raid;
    this.rarlid = rarlid;
    this.raauid = raauid;
  }

  public RoleauthorityMask() {}

  public RoleauthorityMask all(boolean b) {
    this.raid = b;
    this.rarlid = b;
    this.raauid = b;
    return this;
  }

  public boolean getRaid() {
    return raid;
  }

  public RoleauthorityMask setRaid(boolean raid) {
    this.raid = raid;
    return this;
  }

  public boolean getRarlid() {
    return rarlid;
  }

  public RoleauthorityMask setRarlid(boolean rarlid) {
    this.rarlid = rarlid;
    return this;
  }

  public boolean getRaauid() {
    return raauid;
  }

  public RoleauthorityMask setRaauid(boolean raauid) {
    this.raauid = raauid;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("raid")) return raid;
    else if (p.equals("rarlid")) return rarlid;
    else if (p.equals("raauid")) return raauid;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("raid")) this.raid = b;
    else if (p.equals("rarlid")) this.rarlid = b;
    else if (p.equals("raauid")) this.raauid = b;
  }

  public static class Serializer extends JsonSerializer<RoleauthorityMask> {
    @Override
    public void serialize(
        RoleauthorityMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getRaid()) {
        gen.writeFieldName("raid");
        gen.writeBoolean(value.getRaid());
      }
      if (value.getRarlid()) {
        gen.writeFieldName("rarlid");
        gen.writeBoolean(value.getRarlid());
      }
      if (value.getRaauid()) {
        gen.writeFieldName("raauid");
        gen.writeBoolean(value.getRaauid());
      }
      gen.writeEndObject();
    }
  }
}
