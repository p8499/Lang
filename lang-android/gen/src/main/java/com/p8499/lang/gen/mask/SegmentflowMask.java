package com.p8499.lang.gen.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = SegmentflowMask.Serializer.class)
public class SegmentflowMask {
  protected boolean taid = false;
  protected boolean taasid = false;
  protected boolean tasi = false;
  protected boolean tapi = false;
  protected boolean tahz = false;
  protected boolean tast = false;
  protected boolean tausid = false;
  protected boolean tacrdt = false;
  protected boolean taupdt = false;

  public SegmentflowMask(
      boolean taid,
      boolean taasid,
      boolean tasi,
      boolean tapi,
      boolean tahz,
      boolean tast,
      boolean tausid,
      boolean tacrdt,
      boolean taupdt) {
    this.taid = taid;
    this.taasid = taasid;
    this.tasi = tasi;
    this.tapi = tapi;
    this.tahz = tahz;
    this.tast = tast;
    this.tausid = tausid;
    this.tacrdt = tacrdt;
    this.taupdt = taupdt;
  }

  public SegmentflowMask() {}

  public SegmentflowMask all(boolean b) {
    this.taid = b;
    this.taasid = b;
    this.tasi = b;
    this.tapi = b;
    this.tahz = b;
    this.tast = b;
    this.tausid = b;
    this.tacrdt = b;
    this.taupdt = b;
    return this;
  }

  public boolean getTaid() {
    return taid;
  }

  public SegmentflowMask setTaid(boolean taid) {
    this.taid = taid;
    return this;
  }

  public boolean getTaasid() {
    return taasid;
  }

  public SegmentflowMask setTaasid(boolean taasid) {
    this.taasid = taasid;
    return this;
  }

  public boolean getTasi() {
    return tasi;
  }

  public SegmentflowMask setTasi(boolean tasi) {
    this.tasi = tasi;
    return this;
  }

  public boolean getTapi() {
    return tapi;
  }

  public SegmentflowMask setTapi(boolean tapi) {
    this.tapi = tapi;
    return this;
  }

  public boolean getTahz() {
    return tahz;
  }

  public SegmentflowMask setTahz(boolean tahz) {
    this.tahz = tahz;
    return this;
  }

  public boolean getTast() {
    return tast;
  }

  public SegmentflowMask setTast(boolean tast) {
    this.tast = tast;
    return this;
  }

  public boolean getTausid() {
    return tausid;
  }

  public SegmentflowMask setTausid(boolean tausid) {
    this.tausid = tausid;
    return this;
  }

  public boolean getTacrdt() {
    return tacrdt;
  }

  public SegmentflowMask setTacrdt(boolean tacrdt) {
    this.tacrdt = tacrdt;
    return this;
  }

  public boolean getTaupdt() {
    return taupdt;
  }

  public SegmentflowMask setTaupdt(boolean taupdt) {
    this.taupdt = taupdt;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("taid")) return taid;
    else if (p.equals("taasid")) return taasid;
    else if (p.equals("tasi")) return tasi;
    else if (p.equals("tapi")) return tapi;
    else if (p.equals("tahz")) return tahz;
    else if (p.equals("tast")) return tast;
    else if (p.equals("tausid")) return tausid;
    else if (p.equals("tacrdt")) return tacrdt;
    else if (p.equals("taupdt")) return taupdt;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("taid")) this.taid = b;
    else if (p.equals("taasid")) this.taasid = b;
    else if (p.equals("tasi")) this.tasi = b;
    else if (p.equals("tapi")) this.tapi = b;
    else if (p.equals("tahz")) this.tahz = b;
    else if (p.equals("tast")) this.tast = b;
    else if (p.equals("tausid")) this.tausid = b;
    else if (p.equals("tacrdt")) this.tacrdt = b;
    else if (p.equals("taupdt")) this.taupdt = b;
  }

  public static class Serializer extends JsonSerializer<SegmentflowMask> {
    @Override
    public void serialize(SegmentflowMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getTaid()) {
        gen.writeFieldName("taid");
        gen.writeBoolean(value.getTaid());
      }
      if (value.getTaasid()) {
        gen.writeFieldName("taasid");
        gen.writeBoolean(value.getTaasid());
      }
      if (value.getTasi()) {
        gen.writeFieldName("tasi");
        gen.writeBoolean(value.getTasi());
      }
      if (value.getTapi()) {
        gen.writeFieldName("tapi");
        gen.writeBoolean(value.getTapi());
      }
      if (value.getTahz()) {
        gen.writeFieldName("tahz");
        gen.writeBoolean(value.getTahz());
      }
      if (value.getTast()) {
        gen.writeFieldName("tast");
        gen.writeBoolean(value.getTast());
      }
      if (value.getTausid()) {
        gen.writeFieldName("tausid");
        gen.writeBoolean(value.getTausid());
      }
      if (value.getTacrdt()) {
        gen.writeFieldName("tacrdt");
        gen.writeBoolean(value.getTacrdt());
      }
      if (value.getTaupdt()) {
        gen.writeFieldName("taupdt");
        gen.writeBoolean(value.getTaupdt());
      }
      gen.writeEndObject();
    }
  }
}
