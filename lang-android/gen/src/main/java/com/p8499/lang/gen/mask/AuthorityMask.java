package com.p8499.lang.gen.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = AuthorityMask.Serializer.class)
public class AuthorityMask {
  protected boolean auid = false;
  protected boolean auname = false;

  public AuthorityMask(boolean auid, boolean auname) {
    this.auid = auid;
    this.auname = auname;
  }

  public AuthorityMask() {}

  public AuthorityMask all(boolean b) {
    this.auid = b;
    this.auname = b;
    return this;
  }

  public boolean getAuid() {
    return auid;
  }

  public AuthorityMask setAuid(boolean auid) {
    this.auid = auid;
    return this;
  }

  public boolean getAuname() {
    return auname;
  }

  public AuthorityMask setAuname(boolean auname) {
    this.auname = auname;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("auid")) return auid;
    else if (p.equals("auname")) return auname;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("auid")) this.auid = b;
    else if (p.equals("auname")) this.auname = b;
  }

  public static class Serializer extends JsonSerializer<AuthorityMask> {
    @Override
    public void serialize(AuthorityMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getAuid()) {
        gen.writeFieldName("auid");
        gen.writeBoolean(value.getAuid());
      }
      if (value.getAuname()) {
        gen.writeFieldName("auname");
        gen.writeBoolean(value.getAuname());
      }
      gen.writeEndObject();
    }
  }
}
