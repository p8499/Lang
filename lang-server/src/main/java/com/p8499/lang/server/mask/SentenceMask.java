package com.p8499.lang.server.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = SentenceMask.Serializer.class)
public class SentenceMask {
  protected boolean asid = false;
  protected boolean asatid = false;
  protected boolean assi = false;
  protected boolean ascont = false;
  protected boolean asst = false;
  protected boolean ascs = false;
  protected boolean asusid = false;
  protected boolean ascrdt = false;
  protected boolean asupdt = false;

  public SentenceMask(
      boolean asid,
      boolean asatid,
      boolean assi,
      boolean ascont,
      boolean asst,
      boolean ascs,
      boolean asusid,
      boolean ascrdt,
      boolean asupdt) {
    this.asid = asid;
    this.asatid = asatid;
    this.assi = assi;
    this.ascont = ascont;
    this.asst = asst;
    this.ascs = ascs;
    this.asusid = asusid;
    this.ascrdt = ascrdt;
    this.asupdt = asupdt;
  }

  public SentenceMask() {}

  public SentenceMask all(boolean b) {
    this.asid = b;
    this.asatid = b;
    this.assi = b;
    this.ascont = b;
    this.asst = b;
    this.ascs = b;
    this.asusid = b;
    this.ascrdt = b;
    this.asupdt = b;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAsid() {
    return asid;
  }

  public SentenceMask setAsid(boolean asid) {
    this.asid = asid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAsatid() {
    return asatid;
  }

  public SentenceMask setAsatid(boolean asatid) {
    this.asatid = asatid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAssi() {
    return assi;
  }

  public SentenceMask setAssi(boolean assi) {
    this.assi = assi;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAscont() {
    return ascont;
  }

  public SentenceMask setAscont(boolean ascont) {
    this.ascont = ascont;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAsst() {
    return asst;
  }

  public SentenceMask setAsst(boolean asst) {
    this.asst = asst;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAscs() {
    return ascs;
  }

  public SentenceMask setAscs(boolean ascs) {
    this.ascs = ascs;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAsusid() {
    return asusid;
  }

  public SentenceMask setAsusid(boolean asusid) {
    this.asusid = asusid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAscrdt() {
    return ascrdt;
  }

  public SentenceMask setAscrdt(boolean ascrdt) {
    this.ascrdt = ascrdt;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAsupdt() {
    return asupdt;
  }

  public SentenceMask setAsupdt(boolean asupdt) {
    this.asupdt = asupdt;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("asid")) return asid;
    else if (p.equals("asatid")) return asatid;
    else if (p.equals("assi")) return assi;
    else if (p.equals("ascont")) return ascont;
    else if (p.equals("asst")) return asst;
    else if (p.equals("ascs")) return ascs;
    else if (p.equals("asusid")) return asusid;
    else if (p.equals("ascrdt")) return ascrdt;
    else if (p.equals("asupdt")) return asupdt;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("asid")) this.asid = b;
    else if (p.equals("asatid")) this.asatid = b;
    else if (p.equals("assi")) this.assi = b;
    else if (p.equals("ascont")) this.ascont = b;
    else if (p.equals("asst")) this.asst = b;
    else if (p.equals("ascs")) this.ascs = b;
    else if (p.equals("asusid")) this.asusid = b;
    else if (p.equals("ascrdt")) this.ascrdt = b;
    else if (p.equals("asupdt")) this.asupdt = b;
  }

  public static class Serializer extends JsonSerializer<SentenceMask> {
    @Override
    public void serialize(SentenceMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getAsid()) {
        gen.writeFieldName("asid");
        gen.writeBoolean(value.getAsid());
      }
      if (value.getAsatid()) {
        gen.writeFieldName("asatid");
        gen.writeBoolean(value.getAsatid());
      }
      if (value.getAssi()) {
        gen.writeFieldName("assi");
        gen.writeBoolean(value.getAssi());
      }
      if (value.getAscont()) {
        gen.writeFieldName("ascont");
        gen.writeBoolean(value.getAscont());
      }
      if (value.getAsst()) {
        gen.writeFieldName("asst");
        gen.writeBoolean(value.getAsst());
      }
      if (value.getAscs()) {
        gen.writeFieldName("ascs");
        gen.writeBoolean(value.getAscs());
      }
      if (value.getAsusid()) {
        gen.writeFieldName("asusid");
        gen.writeBoolean(value.getAsusid());
      }
      if (value.getAscrdt()) {
        gen.writeFieldName("ascrdt");
        gen.writeBoolean(value.getAscrdt());
      }
      if (value.getAsupdt()) {
        gen.writeFieldName("asupdt");
        gen.writeBoolean(value.getAsupdt());
      }
      gen.writeEndObject();
    }
  }
}
