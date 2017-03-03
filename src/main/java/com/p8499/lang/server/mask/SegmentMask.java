package com.p8499.lang.server.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = SegmentMask.Serializer.class)
public class SegmentMask {
  protected boolean trasid = false;
  protected boolean trpi = false;
  protected boolean trhz = false;
  protected boolean trst = false;
  protected boolean trusid = false;
  protected boolean trcrdt = false;
  protected boolean trupdt = false;

  public SegmentMask(
      boolean trasid,
      boolean trpi,
      boolean trhz,
      boolean trst,
      boolean trusid,
      boolean trcrdt,
      boolean trupdt) {
    this.trasid = trasid;
    this.trpi = trpi;
    this.trhz = trhz;
    this.trst = trst;
    this.trusid = trusid;
    this.trcrdt = trcrdt;
    this.trupdt = trupdt;
  }

  public SegmentMask() {}

  public SegmentMask all(boolean b) {
    this.trasid = b;
    this.trpi = b;
    this.trhz = b;
    this.trst = b;
    this.trusid = b;
    this.trcrdt = b;
    this.trupdt = b;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getTrasid() {
    return trasid;
  }

  public SegmentMask setTrasid(boolean trasid) {
    this.trasid = trasid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getTrpi() {
    return trpi;
  }

  public SegmentMask setTrpi(boolean trpi) {
    this.trpi = trpi;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getTrhz() {
    return trhz;
  }

  public SegmentMask setTrhz(boolean trhz) {
    this.trhz = trhz;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getTrst() {
    return trst;
  }

  public SegmentMask setTrst(boolean trst) {
    this.trst = trst;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getTrusid() {
    return trusid;
  }

  public SegmentMask setTrusid(boolean trusid) {
    this.trusid = trusid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getTrcrdt() {
    return trcrdt;
  }

  public SegmentMask setTrcrdt(boolean trcrdt) {
    this.trcrdt = trcrdt;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getTrupdt() {
    return trupdt;
  }

  public SegmentMask setTrupdt(boolean trupdt) {
    this.trupdt = trupdt;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("trasid")) return trasid;
    else if (p.equals("trpi")) return trpi;
    else if (p.equals("trhz")) return trhz;
    else if (p.equals("trst")) return trst;
    else if (p.equals("trusid")) return trusid;
    else if (p.equals("trcrdt")) return trcrdt;
    else if (p.equals("trupdt")) return trupdt;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("trasid")) this.trasid = b;
    else if (p.equals("trpi")) this.trpi = b;
    else if (p.equals("trhz")) this.trhz = b;
    else if (p.equals("trst")) this.trst = b;
    else if (p.equals("trusid")) this.trusid = b;
    else if (p.equals("trcrdt")) this.trcrdt = b;
    else if (p.equals("trupdt")) this.trupdt = b;
  }

  public static class Serializer extends JsonSerializer<SegmentMask> {
    @Override
    public void serialize(SegmentMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getTrasid()) {
        gen.writeFieldName("trasid");
        gen.writeBoolean(value.getTrasid());
      }
      if (value.getTrpi()) {
        gen.writeFieldName("trpi");
        gen.writeBoolean(value.getTrpi());
      }
      if (value.getTrhz()) {
        gen.writeFieldName("trhz");
        gen.writeBoolean(value.getTrhz());
      }
      if (value.getTrst()) {
        gen.writeFieldName("trst");
        gen.writeBoolean(value.getTrst());
      }
      if (value.getTrusid()) {
        gen.writeFieldName("trusid");
        gen.writeBoolean(value.getTrusid());
      }
      if (value.getTrcrdt()) {
        gen.writeFieldName("trcrdt");
        gen.writeBoolean(value.getTrcrdt());
      }
      if (value.getTrupdt()) {
        gen.writeFieldName("trupdt");
        gen.writeBoolean(value.getTrupdt());
      }
      gen.writeEndObject();
    }
  }
}
