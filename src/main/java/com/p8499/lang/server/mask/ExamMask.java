package com.p8499.lang.server.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ExamMask.Serializer.class)
public class ExamMask {
  protected boolean exid = false;
  protected boolean exusid = false;
  protected boolean exsi = false;
  protected boolean exlsid = false;
  protected boolean exlv = false;
  protected boolean excrdt = false;
  protected boolean exupdt = false;
  protected boolean exts = false;
  protected boolean exsc = false;

  public ExamMask(
      boolean exid,
      boolean exusid,
      boolean exsi,
      boolean exlsid,
      boolean exlv,
      boolean excrdt,
      boolean exupdt,
      boolean exts,
      boolean exsc) {
    this.exid = exid;
    this.exusid = exusid;
    this.exsi = exsi;
    this.exlsid = exlsid;
    this.exlv = exlv;
    this.excrdt = excrdt;
    this.exupdt = exupdt;
    this.exts = exts;
    this.exsc = exsc;
  }

  public ExamMask() {}

  public ExamMask all(boolean b) {
    this.exid = b;
    this.exusid = b;
    this.exsi = b;
    this.exlsid = b;
    this.exlv = b;
    this.excrdt = b;
    this.exupdt = b;
    this.exts = b;
    this.exsc = b;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getExid() {
    return exid;
  }

  public ExamMask setExid(boolean exid) {
    this.exid = exid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getExusid() {
    return exusid;
  }

  public ExamMask setExusid(boolean exusid) {
    this.exusid = exusid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getExsi() {
    return exsi;
  }

  public ExamMask setExsi(boolean exsi) {
    this.exsi = exsi;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getExlsid() {
    return exlsid;
  }

  public ExamMask setExlsid(boolean exlsid) {
    this.exlsid = exlsid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getExlv() {
    return exlv;
  }

  public ExamMask setExlv(boolean exlv) {
    this.exlv = exlv;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getExcrdt() {
    return excrdt;
  }

  public ExamMask setExcrdt(boolean excrdt) {
    this.excrdt = excrdt;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getExupdt() {
    return exupdt;
  }

  public ExamMask setExupdt(boolean exupdt) {
    this.exupdt = exupdt;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getExts() {
    return exts;
  }

  public ExamMask setExts(boolean exts) {
    this.exts = exts;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getExsc() {
    return exsc;
  }

  public ExamMask setExsc(boolean exsc) {
    this.exsc = exsc;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("exid")) return exid;
    else if (p.equals("exusid")) return exusid;
    else if (p.equals("exsi")) return exsi;
    else if (p.equals("exlsid")) return exlsid;
    else if (p.equals("exlv")) return exlv;
    else if (p.equals("excrdt")) return excrdt;
    else if (p.equals("exupdt")) return exupdt;
    else if (p.equals("exts")) return exts;
    else if (p.equals("exsc")) return exsc;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("exid")) this.exid = b;
    else if (p.equals("exusid")) this.exusid = b;
    else if (p.equals("exsi")) this.exsi = b;
    else if (p.equals("exlsid")) this.exlsid = b;
    else if (p.equals("exlv")) this.exlv = b;
    else if (p.equals("excrdt")) this.excrdt = b;
    else if (p.equals("exupdt")) this.exupdt = b;
    else if (p.equals("exts")) this.exts = b;
    else if (p.equals("exsc")) this.exsc = b;
  }

  public static class Serializer extends JsonSerializer<ExamMask> {
    @Override
    public void serialize(ExamMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getExid()) {
        gen.writeFieldName("exid");
        gen.writeBoolean(value.getExid());
      }
      if (value.getExusid()) {
        gen.writeFieldName("exusid");
        gen.writeBoolean(value.getExusid());
      }
      if (value.getExsi()) {
        gen.writeFieldName("exsi");
        gen.writeBoolean(value.getExsi());
      }
      if (value.getExlsid()) {
        gen.writeFieldName("exlsid");
        gen.writeBoolean(value.getExlsid());
      }
      if (value.getExlv()) {
        gen.writeFieldName("exlv");
        gen.writeBoolean(value.getExlv());
      }
      if (value.getExcrdt()) {
        gen.writeFieldName("excrdt");
        gen.writeBoolean(value.getExcrdt());
      }
      if (value.getExupdt()) {
        gen.writeFieldName("exupdt");
        gen.writeBoolean(value.getExupdt());
      }
      if (value.getExts()) {
        gen.writeFieldName("exts");
        gen.writeBoolean(value.getExts());
      }
      if (value.getExsc()) {
        gen.writeFieldName("exsc");
        gen.writeBoolean(value.getExsc());
      }
      gen.writeEndObject();
    }
  }
}
