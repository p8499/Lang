package com.p8499.lang.server.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = RoleMask.Serializer.class)
public class RoleMask {
  protected boolean rlid = false;
  protected boolean rlname = false;

  public RoleMask(boolean rlid, boolean rlname) {
    this.rlid = rlid;
    this.rlname = rlname;
  }

  public RoleMask() {}

  public RoleMask all(boolean b) {
    this.rlid = b;
    this.rlname = b;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getRlid() {
    return rlid;
  }

  public RoleMask setRlid(boolean rlid) {
    this.rlid = rlid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getRlname() {
    return rlname;
  }

  public RoleMask setRlname(boolean rlname) {
    this.rlname = rlname;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("rlid")) return rlid;
    else if (p.equals("rlname")) return rlname;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("rlid")) this.rlid = b;
    else if (p.equals("rlname")) this.rlname = b;
  }

  public static class Serializer extends JsonSerializer<RoleMask> {
    @Override
    public void serialize(RoleMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getRlid()) {
        gen.writeFieldName("rlid");
        gen.writeBoolean(value.getRlid());
      }
      if (value.getRlname()) {
        gen.writeFieldName("rlname");
        gen.writeBoolean(value.getRlname());
      }
      gen.writeEndObject();
    }
  }
}
