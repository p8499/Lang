package com.p8499.lang.gen.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = UserroleMask.Serializer.class)
public class UserroleMask {
  protected boolean urid = false;
  protected boolean urusid = false;
  protected boolean urrlid = false;

  public UserroleMask(boolean urid, boolean urusid, boolean urrlid) {
    this.urid = urid;
    this.urusid = urusid;
    this.urrlid = urrlid;
  }

  public UserroleMask() {}

  public UserroleMask all(boolean b) {
    this.urid = b;
    this.urusid = b;
    this.urrlid = b;
    return this;
  }

  public boolean getUrid() {
    return urid;
  }

  public UserroleMask setUrid(boolean urid) {
    this.urid = urid;
    return this;
  }

  public boolean getUrusid() {
    return urusid;
  }

  public UserroleMask setUrusid(boolean urusid) {
    this.urusid = urusid;
    return this;
  }

  public boolean getUrrlid() {
    return urrlid;
  }

  public UserroleMask setUrrlid(boolean urrlid) {
    this.urrlid = urrlid;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("urid")) return urid;
    else if (p.equals("urusid")) return urusid;
    else if (p.equals("urrlid")) return urrlid;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("urid")) this.urid = b;
    else if (p.equals("urusid")) this.urusid = b;
    else if (p.equals("urrlid")) this.urrlid = b;
  }

  public static class Serializer extends JsonSerializer<UserroleMask> {
    @Override
    public void serialize(UserroleMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getUrid()) {
        gen.writeFieldName("urid");
        gen.writeBoolean(value.getUrid());
      }
      if (value.getUrusid()) {
        gen.writeFieldName("urusid");
        gen.writeBoolean(value.getUrusid());
      }
      if (value.getUrrlid()) {
        gen.writeFieldName("urrlid");
        gen.writeBoolean(value.getUrrlid());
      }
      gen.writeEndObject();
    }
  }
}
