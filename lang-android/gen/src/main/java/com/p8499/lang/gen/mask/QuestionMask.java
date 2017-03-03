package com.p8499.lang.gen.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = QuestionMask.Serializer.class)
public class QuestionMask {
  protected boolean tqid = false;
  protected boolean tqlsid = false;
  protected boolean tqlv = false;
  protected boolean tqty = false;
  protected boolean tqcont = false;
  protected boolean tqo = false;
  protected boolean tqst = false;

  public QuestionMask(
      boolean tqid,
      boolean tqlsid,
      boolean tqlv,
      boolean tqty,
      boolean tqcont,
      boolean tqo,
      boolean tqst) {
    this.tqid = tqid;
    this.tqlsid = tqlsid;
    this.tqlv = tqlv;
    this.tqty = tqty;
    this.tqcont = tqcont;
    this.tqo = tqo;
    this.tqst = tqst;
  }

  public QuestionMask() {}

  public QuestionMask all(boolean b) {
    this.tqid = b;
    this.tqlsid = b;
    this.tqlv = b;
    this.tqty = b;
    this.tqcont = b;
    this.tqo = b;
    this.tqst = b;
    return this;
  }

  public boolean getTqid() {
    return tqid;
  }

  public QuestionMask setTqid(boolean tqid) {
    this.tqid = tqid;
    return this;
  }

  public boolean getTqlsid() {
    return tqlsid;
  }

  public QuestionMask setTqlsid(boolean tqlsid) {
    this.tqlsid = tqlsid;
    return this;
  }

  public boolean getTqlv() {
    return tqlv;
  }

  public QuestionMask setTqlv(boolean tqlv) {
    this.tqlv = tqlv;
    return this;
  }

  public boolean getTqty() {
    return tqty;
  }

  public QuestionMask setTqty(boolean tqty) {
    this.tqty = tqty;
    return this;
  }

  public boolean getTqcont() {
    return tqcont;
  }

  public QuestionMask setTqcont(boolean tqcont) {
    this.tqcont = tqcont;
    return this;
  }

  public boolean getTqo() {
    return tqo;
  }

  public QuestionMask setTqo(boolean tqo) {
    this.tqo = tqo;
    return this;
  }

  public boolean getTqst() {
    return tqst;
  }

  public QuestionMask setTqst(boolean tqst) {
    this.tqst = tqst;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("tqid")) return tqid;
    else if (p.equals("tqlsid")) return tqlsid;
    else if (p.equals("tqlv")) return tqlv;
    else if (p.equals("tqty")) return tqty;
    else if (p.equals("tqcont")) return tqcont;
    else if (p.equals("tqo")) return tqo;
    else if (p.equals("tqst")) return tqst;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("tqid")) this.tqid = b;
    else if (p.equals("tqlsid")) this.tqlsid = b;
    else if (p.equals("tqlv")) this.tqlv = b;
    else if (p.equals("tqty")) this.tqty = b;
    else if (p.equals("tqcont")) this.tqcont = b;
    else if (p.equals("tqo")) this.tqo = b;
    else if (p.equals("tqst")) this.tqst = b;
  }

  public static class Serializer extends JsonSerializer<QuestionMask> {
    @Override
    public void serialize(QuestionMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getTqid()) {
        gen.writeFieldName("tqid");
        gen.writeBoolean(value.getTqid());
      }
      if (value.getTqlsid()) {
        gen.writeFieldName("tqlsid");
        gen.writeBoolean(value.getTqlsid());
      }
      if (value.getTqlv()) {
        gen.writeFieldName("tqlv");
        gen.writeBoolean(value.getTqlv());
      }
      if (value.getTqty()) {
        gen.writeFieldName("tqty");
        gen.writeBoolean(value.getTqty());
      }
      if (value.getTqcont()) {
        gen.writeFieldName("tqcont");
        gen.writeBoolean(value.getTqcont());
      }
      if (value.getTqo()) {
        gen.writeFieldName("tqo");
        gen.writeBoolean(value.getTqo());
      }
      if (value.getTqst()) {
        gen.writeFieldName("tqst");
        gen.writeBoolean(value.getTqst());
      }
      gen.writeEndObject();
    }
  }
}
