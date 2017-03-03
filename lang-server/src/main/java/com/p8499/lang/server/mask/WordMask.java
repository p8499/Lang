package com.p8499.lang.server.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = WordMask.Serializer.class)
public class WordMask {
  protected boolean woid = false;
  protected boolean wolsid = false;
  protected boolean wopt = false;
  protected boolean wohz = false;
  protected boolean wocl = false;
  protected boolean wost = false;
  protected boolean wosr = false;
  protected boolean wosort = false;
  protected boolean wocrdt = false;
  protected boolean woupdt = false;

  public WordMask(
      boolean woid,
      boolean wolsid,
      boolean wopt,
      boolean wohz,
      boolean wocl,
      boolean wost,
      boolean wosr,
      boolean wosort,
      boolean wocrdt,
      boolean woupdt) {
    this.woid = woid;
    this.wolsid = wolsid;
    this.wopt = wopt;
    this.wohz = wohz;
    this.wocl = wocl;
    this.wost = wost;
    this.wosr = wosr;
    this.wosort = wosort;
    this.wocrdt = wocrdt;
    this.woupdt = woupdt;
  }

  public WordMask() {}

  public WordMask all(boolean b) {
    this.woid = b;
    this.wolsid = b;
    this.wopt = b;
    this.wohz = b;
    this.wocl = b;
    this.wost = b;
    this.wosr = b;
    this.wosort = b;
    this.wocrdt = b;
    this.woupdt = b;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getWoid() {
    return woid;
  }

  public WordMask setWoid(boolean woid) {
    this.woid = woid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getWolsid() {
    return wolsid;
  }

  public WordMask setWolsid(boolean wolsid) {
    this.wolsid = wolsid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getWopt() {
    return wopt;
  }

  public WordMask setWopt(boolean wopt) {
    this.wopt = wopt;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getWohz() {
    return wohz;
  }

  public WordMask setWohz(boolean wohz) {
    this.wohz = wohz;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getWocl() {
    return wocl;
  }

  public WordMask setWocl(boolean wocl) {
    this.wocl = wocl;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getWost() {
    return wost;
  }

  public WordMask setWost(boolean wost) {
    this.wost = wost;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getWosr() {
    return wosr;
  }

  public WordMask setWosr(boolean wosr) {
    this.wosr = wosr;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getWosort() {
    return wosort;
  }

  public WordMask setWosort(boolean wosort) {
    this.wosort = wosort;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getWocrdt() {
    return wocrdt;
  }

  public WordMask setWocrdt(boolean wocrdt) {
    this.wocrdt = wocrdt;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getWoupdt() {
    return woupdt;
  }

  public WordMask setWoupdt(boolean woupdt) {
    this.woupdt = woupdt;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("woid")) return woid;
    else if (p.equals("wolsid")) return wolsid;
    else if (p.equals("wopt")) return wopt;
    else if (p.equals("wohz")) return wohz;
    else if (p.equals("wocl")) return wocl;
    else if (p.equals("wost")) return wost;
    else if (p.equals("wosr")) return wosr;
    else if (p.equals("wosort")) return wosort;
    else if (p.equals("wocrdt")) return wocrdt;
    else if (p.equals("woupdt")) return woupdt;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("woid")) this.woid = b;
    else if (p.equals("wolsid")) this.wolsid = b;
    else if (p.equals("wopt")) this.wopt = b;
    else if (p.equals("wohz")) this.wohz = b;
    else if (p.equals("wocl")) this.wocl = b;
    else if (p.equals("wost")) this.wost = b;
    else if (p.equals("wosr")) this.wosr = b;
    else if (p.equals("wosort")) this.wosort = b;
    else if (p.equals("wocrdt")) this.wocrdt = b;
    else if (p.equals("woupdt")) this.woupdt = b;
  }

  public static class Serializer extends JsonSerializer<WordMask> {
    @Override
    public void serialize(WordMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getWoid()) {
        gen.writeFieldName("woid");
        gen.writeBoolean(value.getWoid());
      }
      if (value.getWolsid()) {
        gen.writeFieldName("wolsid");
        gen.writeBoolean(value.getWolsid());
      }
      if (value.getWopt()) {
        gen.writeFieldName("wopt");
        gen.writeBoolean(value.getWopt());
      }
      if (value.getWohz()) {
        gen.writeFieldName("wohz");
        gen.writeBoolean(value.getWohz());
      }
      if (value.getWocl()) {
        gen.writeFieldName("wocl");
        gen.writeBoolean(value.getWocl());
      }
      if (value.getWost()) {
        gen.writeFieldName("wost");
        gen.writeBoolean(value.getWost());
      }
      if (value.getWosr()) {
        gen.writeFieldName("wosr");
        gen.writeBoolean(value.getWosr());
      }
      if (value.getWosort()) {
        gen.writeFieldName("wosort");
        gen.writeBoolean(value.getWosort());
      }
      if (value.getWocrdt()) {
        gen.writeFieldName("wocrdt");
        gen.writeBoolean(value.getWocrdt());
      }
      if (value.getWoupdt()) {
        gen.writeFieldName("woupdt");
        gen.writeBoolean(value.getWoupdt());
      }
      gen.writeEndObject();
    }
  }
}
