package com.p8499.lang.gen.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = SegmentvoteMask.Serializer.class)
public class SegmentvoteMask {
  protected boolean tvid = false;
  protected boolean tvtaid = false;
  protected boolean tvsi = false;
  protected boolean tvusid = false;
  protected boolean tvpo = false;
  protected boolean tvcrdt = false;
  protected boolean tvupdt = false;

  public SegmentvoteMask(
      boolean tvid,
      boolean tvtaid,
      boolean tvsi,
      boolean tvusid,
      boolean tvpo,
      boolean tvcrdt,
      boolean tvupdt) {
    this.tvid = tvid;
    this.tvtaid = tvtaid;
    this.tvsi = tvsi;
    this.tvusid = tvusid;
    this.tvpo = tvpo;
    this.tvcrdt = tvcrdt;
    this.tvupdt = tvupdt;
  }

  public SegmentvoteMask() {}

  public SegmentvoteMask all(boolean b) {
    this.tvid = b;
    this.tvtaid = b;
    this.tvsi = b;
    this.tvusid = b;
    this.tvpo = b;
    this.tvcrdt = b;
    this.tvupdt = b;
    return this;
  }

  public boolean getTvid() {
    return tvid;
  }

  public SegmentvoteMask setTvid(boolean tvid) {
    this.tvid = tvid;
    return this;
  }

  public boolean getTvtaid() {
    return tvtaid;
  }

  public SegmentvoteMask setTvtaid(boolean tvtaid) {
    this.tvtaid = tvtaid;
    return this;
  }

  public boolean getTvsi() {
    return tvsi;
  }

  public SegmentvoteMask setTvsi(boolean tvsi) {
    this.tvsi = tvsi;
    return this;
  }

  public boolean getTvusid() {
    return tvusid;
  }

  public SegmentvoteMask setTvusid(boolean tvusid) {
    this.tvusid = tvusid;
    return this;
  }

  public boolean getTvpo() {
    return tvpo;
  }

  public SegmentvoteMask setTvpo(boolean tvpo) {
    this.tvpo = tvpo;
    return this;
  }

  public boolean getTvcrdt() {
    return tvcrdt;
  }

  public SegmentvoteMask setTvcrdt(boolean tvcrdt) {
    this.tvcrdt = tvcrdt;
    return this;
  }

  public boolean getTvupdt() {
    return tvupdt;
  }

  public SegmentvoteMask setTvupdt(boolean tvupdt) {
    this.tvupdt = tvupdt;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("tvid")) return tvid;
    else if (p.equals("tvtaid")) return tvtaid;
    else if (p.equals("tvsi")) return tvsi;
    else if (p.equals("tvusid")) return tvusid;
    else if (p.equals("tvpo")) return tvpo;
    else if (p.equals("tvcrdt")) return tvcrdt;
    else if (p.equals("tvupdt")) return tvupdt;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("tvid")) this.tvid = b;
    else if (p.equals("tvtaid")) this.tvtaid = b;
    else if (p.equals("tvsi")) this.tvsi = b;
    else if (p.equals("tvusid")) this.tvusid = b;
    else if (p.equals("tvpo")) this.tvpo = b;
    else if (p.equals("tvcrdt")) this.tvcrdt = b;
    else if (p.equals("tvupdt")) this.tvupdt = b;
  }

  public static class Serializer extends JsonSerializer<SegmentvoteMask> {
    @Override
    public void serialize(SegmentvoteMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getTvid()) {
        gen.writeFieldName("tvid");
        gen.writeBoolean(value.getTvid());
      }
      if (value.getTvtaid()) {
        gen.writeFieldName("tvtaid");
        gen.writeBoolean(value.getTvtaid());
      }
      if (value.getTvsi()) {
        gen.writeFieldName("tvsi");
        gen.writeBoolean(value.getTvsi());
      }
      if (value.getTvusid()) {
        gen.writeFieldName("tvusid");
        gen.writeBoolean(value.getTvusid());
      }
      if (value.getTvpo()) {
        gen.writeFieldName("tvpo");
        gen.writeBoolean(value.getTvpo());
      }
      if (value.getTvcrdt()) {
        gen.writeFieldName("tvcrdt");
        gen.writeBoolean(value.getTvcrdt());
      }
      if (value.getTvupdt()) {
        gen.writeFieldName("tvupdt");
        gen.writeBoolean(value.getTvupdt());
      }
      gen.writeEndObject();
    }
  }
}
