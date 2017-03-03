package com.p8499.lang.gen.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = DictionaryMask.Serializer.class)
public class DictionaryMask {
  protected boolean dcid = false;
  protected boolean dclsid = false;
  protected boolean dchz = false;
  protected boolean dcpt = false;
  protected boolean dcrm = false;

  public DictionaryMask(boolean dcid, boolean dclsid, boolean dchz, boolean dcpt, boolean dcrm) {
    this.dcid = dcid;
    this.dclsid = dclsid;
    this.dchz = dchz;
    this.dcpt = dcpt;
    this.dcrm = dcrm;
  }

  public DictionaryMask() {}

  public DictionaryMask all(boolean b) {
    this.dcid = b;
    this.dclsid = b;
    this.dchz = b;
    this.dcpt = b;
    this.dcrm = b;
    return this;
  }

  public boolean getDcid() {
    return dcid;
  }

  public DictionaryMask setDcid(boolean dcid) {
    this.dcid = dcid;
    return this;
  }

  public boolean getDclsid() {
    return dclsid;
  }

  public DictionaryMask setDclsid(boolean dclsid) {
    this.dclsid = dclsid;
    return this;
  }

  public boolean getDchz() {
    return dchz;
  }

  public DictionaryMask setDchz(boolean dchz) {
    this.dchz = dchz;
    return this;
  }

  public boolean getDcpt() {
    return dcpt;
  }

  public DictionaryMask setDcpt(boolean dcpt) {
    this.dcpt = dcpt;
    return this;
  }

  public boolean getDcrm() {
    return dcrm;
  }

  public DictionaryMask setDcrm(boolean dcrm) {
    this.dcrm = dcrm;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("dcid")) return dcid;
    else if (p.equals("dclsid")) return dclsid;
    else if (p.equals("dchz")) return dchz;
    else if (p.equals("dcpt")) return dcpt;
    else if (p.equals("dcrm")) return dcrm;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("dcid")) this.dcid = b;
    else if (p.equals("dclsid")) this.dclsid = b;
    else if (p.equals("dchz")) this.dchz = b;
    else if (p.equals("dcpt")) this.dcpt = b;
    else if (p.equals("dcrm")) this.dcrm = b;
  }

  public static class Serializer extends JsonSerializer<DictionaryMask> {
    @Override
    public void serialize(DictionaryMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getDcid()) {
        gen.writeFieldName("dcid");
        gen.writeBoolean(value.getDcid());
      }
      if (value.getDclsid()) {
        gen.writeFieldName("dclsid");
        gen.writeBoolean(value.getDclsid());
      }
      if (value.getDchz()) {
        gen.writeFieldName("dchz");
        gen.writeBoolean(value.getDchz());
      }
      if (value.getDcpt()) {
        gen.writeFieldName("dcpt");
        gen.writeBoolean(value.getDcpt());
      }
      if (value.getDcrm()) {
        gen.writeFieldName("dcrm");
        gen.writeBoolean(value.getDcrm());
      }
      gen.writeEndObject();
    }
  }
}
