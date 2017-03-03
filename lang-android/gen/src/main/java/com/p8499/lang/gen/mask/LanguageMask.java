package com.p8499.lang.gen.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = LanguageMask.Serializer.class)
public class LanguageMask {
  protected boolean lsid = false;
  protected boolean lsname = false;
  protected boolean lsloc = false;
  protected boolean lssort = false;

  public LanguageMask(boolean lsid, boolean lsname, boolean lsloc, boolean lssort) {
    this.lsid = lsid;
    this.lsname = lsname;
    this.lsloc = lsloc;
    this.lssort = lssort;
  }

  public LanguageMask() {}

  public LanguageMask all(boolean b) {
    this.lsid = b;
    this.lsname = b;
    this.lsloc = b;
    this.lssort = b;
    return this;
  }

  public boolean getLsid() {
    return lsid;
  }

  public LanguageMask setLsid(boolean lsid) {
    this.lsid = lsid;
    return this;
  }

  public boolean getLsname() {
    return lsname;
  }

  public LanguageMask setLsname(boolean lsname) {
    this.lsname = lsname;
    return this;
  }

  public boolean getLsloc() {
    return lsloc;
  }

  public LanguageMask setLsloc(boolean lsloc) {
    this.lsloc = lsloc;
    return this;
  }

  public boolean getLssort() {
    return lssort;
  }

  public LanguageMask setLssort(boolean lssort) {
    this.lssort = lssort;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("lsid")) return lsid;
    else if (p.equals("lsname")) return lsname;
    else if (p.equals("lsloc")) return lsloc;
    else if (p.equals("lssort")) return lssort;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("lsid")) this.lsid = b;
    else if (p.equals("lsname")) this.lsname = b;
    else if (p.equals("lsloc")) this.lsloc = b;
    else if (p.equals("lssort")) this.lssort = b;
  }

  public static class Serializer extends JsonSerializer<LanguageMask> {
    @Override
    public void serialize(LanguageMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getLsid()) {
        gen.writeFieldName("lsid");
        gen.writeBoolean(value.getLsid());
      }
      if (value.getLsname()) {
        gen.writeFieldName("lsname");
        gen.writeBoolean(value.getLsname());
      }
      if (value.getLsloc()) {
        gen.writeFieldName("lsloc");
        gen.writeBoolean(value.getLsloc());
      }
      if (value.getLssort()) {
        gen.writeFieldName("lssort");
        gen.writeBoolean(value.getLssort());
      }
      gen.writeEndObject();
    }
  }
}
