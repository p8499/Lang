package com.p8499.lang.gen.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = QuestionoptionMask.Serializer.class)
public class QuestionoptionMask {
  protected boolean toid = false;
  protected boolean totqid = false;
  protected boolean too = false;
  protected boolean tocont = false;

  public QuestionoptionMask(boolean toid, boolean totqid, boolean too, boolean tocont) {
    this.toid = toid;
    this.totqid = totqid;
    this.too = too;
    this.tocont = tocont;
  }

  public QuestionoptionMask() {}

  public QuestionoptionMask all(boolean b) {
    this.toid = b;
    this.totqid = b;
    this.too = b;
    this.tocont = b;
    return this;
  }

  public boolean getToid() {
    return toid;
  }

  public QuestionoptionMask setToid(boolean toid) {
    this.toid = toid;
    return this;
  }

  public boolean getTotqid() {
    return totqid;
  }

  public QuestionoptionMask setTotqid(boolean totqid) {
    this.totqid = totqid;
    return this;
  }

  public boolean getToo() {
    return too;
  }

  public QuestionoptionMask setToo(boolean too) {
    this.too = too;
    return this;
  }

  public boolean getTocont() {
    return tocont;
  }

  public QuestionoptionMask setTocont(boolean tocont) {
    this.tocont = tocont;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("toid")) return toid;
    else if (p.equals("totqid")) return totqid;
    else if (p.equals("too")) return too;
    else if (p.equals("tocont")) return tocont;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("toid")) this.toid = b;
    else if (p.equals("totqid")) this.totqid = b;
    else if (p.equals("too")) this.too = b;
    else if (p.equals("tocont")) this.tocont = b;
  }

  public static class Serializer extends JsonSerializer<QuestionoptionMask> {
    @Override
    public void serialize(
        QuestionoptionMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getToid()) {
        gen.writeFieldName("toid");
        gen.writeBoolean(value.getToid());
      }
      if (value.getTotqid()) {
        gen.writeFieldName("totqid");
        gen.writeBoolean(value.getTotqid());
      }
      if (value.getToo()) {
        gen.writeFieldName("too");
        gen.writeBoolean(value.getToo());
      }
      if (value.getTocont()) {
        gen.writeFieldName("tocont");
        gen.writeBoolean(value.getTocont());
      }
      gen.writeEndObject();
    }
  }
}
