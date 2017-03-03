package com.p8499.lang.server.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ArticleMask.Serializer.class)
public class ArticleMask {
  protected boolean atid = false;
  protected boolean atcgid = false;
  protected boolean atsi = false;
  protected boolean atname = false;
  protected boolean atusid = false;
  protected boolean atbrf = false;
  protected boolean atcsa = false;
  protected boolean atcsb = false;
  protected boolean atcsc = false;
  protected boolean atcsd = false;
  protected boolean atcse = false;
  protected boolean atcsf = false;
  protected boolean atcrdt = false;
  protected boolean atupdt = false;

  public ArticleMask(
      boolean atid,
      boolean atcgid,
      boolean atsi,
      boolean atname,
      boolean atusid,
      boolean atbrf,
      boolean atcsa,
      boolean atcsb,
      boolean atcsc,
      boolean atcsd,
      boolean atcse,
      boolean atcsf,
      boolean atcrdt,
      boolean atupdt) {
    this.atid = atid;
    this.atcgid = atcgid;
    this.atsi = atsi;
    this.atname = atname;
    this.atusid = atusid;
    this.atbrf = atbrf;
    this.atcsa = atcsa;
    this.atcsb = atcsb;
    this.atcsc = atcsc;
    this.atcsd = atcsd;
    this.atcse = atcse;
    this.atcsf = atcsf;
    this.atcrdt = atcrdt;
    this.atupdt = atupdt;
  }

  public ArticleMask() {}

  public ArticleMask all(boolean b) {
    this.atid = b;
    this.atcgid = b;
    this.atsi = b;
    this.atname = b;
    this.atusid = b;
    this.atbrf = b;
    this.atcsa = b;
    this.atcsb = b;
    this.atcsc = b;
    this.atcsd = b;
    this.atcse = b;
    this.atcsf = b;
    this.atcrdt = b;
    this.atupdt = b;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtid() {
    return atid;
  }

  public ArticleMask setAtid(boolean atid) {
    this.atid = atid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtcgid() {
    return atcgid;
  }

  public ArticleMask setAtcgid(boolean atcgid) {
    this.atcgid = atcgid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtsi() {
    return atsi;
  }

  public ArticleMask setAtsi(boolean atsi) {
    this.atsi = atsi;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtname() {
    return atname;
  }

  public ArticleMask setAtname(boolean atname) {
    this.atname = atname;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtusid() {
    return atusid;
  }

  public ArticleMask setAtusid(boolean atusid) {
    this.atusid = atusid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtbrf() {
    return atbrf;
  }

  public ArticleMask setAtbrf(boolean atbrf) {
    this.atbrf = atbrf;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtcsa() {
    return atcsa;
  }

  public ArticleMask setAtcsa(boolean atcsa) {
    this.atcsa = atcsa;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtcsb() {
    return atcsb;
  }

  public ArticleMask setAtcsb(boolean atcsb) {
    this.atcsb = atcsb;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtcsc() {
    return atcsc;
  }

  public ArticleMask setAtcsc(boolean atcsc) {
    this.atcsc = atcsc;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtcsd() {
    return atcsd;
  }

  public ArticleMask setAtcsd(boolean atcsd) {
    this.atcsd = atcsd;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtcse() {
    return atcse;
  }

  public ArticleMask setAtcse(boolean atcse) {
    this.atcse = atcse;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtcsf() {
    return atcsf;
  }

  public ArticleMask setAtcsf(boolean atcsf) {
    this.atcsf = atcsf;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtcrdt() {
    return atcrdt;
  }

  public ArticleMask setAtcrdt(boolean atcrdt) {
    this.atcrdt = atcrdt;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getAtupdt() {
    return atupdt;
  }

  public ArticleMask setAtupdt(boolean atupdt) {
    this.atupdt = atupdt;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("atid")) return atid;
    else if (p.equals("atcgid")) return atcgid;
    else if (p.equals("atsi")) return atsi;
    else if (p.equals("atname")) return atname;
    else if (p.equals("atusid")) return atusid;
    else if (p.equals("atbrf")) return atbrf;
    else if (p.equals("atcsa")) return atcsa;
    else if (p.equals("atcsb")) return atcsb;
    else if (p.equals("atcsc")) return atcsc;
    else if (p.equals("atcsd")) return atcsd;
    else if (p.equals("atcse")) return atcse;
    else if (p.equals("atcsf")) return atcsf;
    else if (p.equals("atcrdt")) return atcrdt;
    else if (p.equals("atupdt")) return atupdt;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("atid")) this.atid = b;
    else if (p.equals("atcgid")) this.atcgid = b;
    else if (p.equals("atsi")) this.atsi = b;
    else if (p.equals("atname")) this.atname = b;
    else if (p.equals("atusid")) this.atusid = b;
    else if (p.equals("atbrf")) this.atbrf = b;
    else if (p.equals("atcsa")) this.atcsa = b;
    else if (p.equals("atcsb")) this.atcsb = b;
    else if (p.equals("atcsc")) this.atcsc = b;
    else if (p.equals("atcsd")) this.atcsd = b;
    else if (p.equals("atcse")) this.atcse = b;
    else if (p.equals("atcsf")) this.atcsf = b;
    else if (p.equals("atcrdt")) this.atcrdt = b;
    else if (p.equals("atupdt")) this.atupdt = b;
  }

  public static class Serializer extends JsonSerializer<ArticleMask> {
    @Override
    public void serialize(ArticleMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getAtid()) {
        gen.writeFieldName("atid");
        gen.writeBoolean(value.getAtid());
      }
      if (value.getAtcgid()) {
        gen.writeFieldName("atcgid");
        gen.writeBoolean(value.getAtcgid());
      }
      if (value.getAtsi()) {
        gen.writeFieldName("atsi");
        gen.writeBoolean(value.getAtsi());
      }
      if (value.getAtname()) {
        gen.writeFieldName("atname");
        gen.writeBoolean(value.getAtname());
      }
      if (value.getAtusid()) {
        gen.writeFieldName("atusid");
        gen.writeBoolean(value.getAtusid());
      }
      if (value.getAtbrf()) {
        gen.writeFieldName("atbrf");
        gen.writeBoolean(value.getAtbrf());
      }
      if (value.getAtcsa()) {
        gen.writeFieldName("atcsa");
        gen.writeBoolean(value.getAtcsa());
      }
      if (value.getAtcsb()) {
        gen.writeFieldName("atcsb");
        gen.writeBoolean(value.getAtcsb());
      }
      if (value.getAtcsc()) {
        gen.writeFieldName("atcsc");
        gen.writeBoolean(value.getAtcsc());
      }
      if (value.getAtcsd()) {
        gen.writeFieldName("atcsd");
        gen.writeBoolean(value.getAtcsd());
      }
      if (value.getAtcse()) {
        gen.writeFieldName("atcse");
        gen.writeBoolean(value.getAtcse());
      }
      if (value.getAtcsf()) {
        gen.writeFieldName("atcsf");
        gen.writeBoolean(value.getAtcsf());
      }
      if (value.getAtcrdt()) {
        gen.writeFieldName("atcrdt");
        gen.writeBoolean(value.getAtcrdt());
      }
      if (value.getAtupdt()) {
        gen.writeFieldName("atupdt");
        gen.writeBoolean(value.getAtupdt());
      }
      gen.writeEndObject();
    }
  }
}
