package com.p8499.lang.server.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = ExamquestionMask.Serializer.class)
public class ExamquestionMask {
  protected boolean eqid = false;
  protected boolean eqexid = false;
  protected boolean eqsi = false;
  protected boolean eqtqid = false;
  protected boolean eqo = false;
  protected boolean eqts = false;
  protected boolean eqsc = false;

  public ExamquestionMask(
      boolean eqid,
      boolean eqexid,
      boolean eqsi,
      boolean eqtqid,
      boolean eqo,
      boolean eqts,
      boolean eqsc) {
    this.eqid = eqid;
    this.eqexid = eqexid;
    this.eqsi = eqsi;
    this.eqtqid = eqtqid;
    this.eqo = eqo;
    this.eqts = eqts;
    this.eqsc = eqsc;
  }

  public ExamquestionMask() {}

  public ExamquestionMask all(boolean b) {
    this.eqid = b;
    this.eqexid = b;
    this.eqsi = b;
    this.eqtqid = b;
    this.eqo = b;
    this.eqts = b;
    this.eqsc = b;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getEqid() {
    return eqid;
  }

  public ExamquestionMask setEqid(boolean eqid) {
    this.eqid = eqid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getEqexid() {
    return eqexid;
  }

  public ExamquestionMask setEqexid(boolean eqexid) {
    this.eqexid = eqexid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getEqsi() {
    return eqsi;
  }

  public ExamquestionMask setEqsi(boolean eqsi) {
    this.eqsi = eqsi;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getEqtqid() {
    return eqtqid;
  }

  public ExamquestionMask setEqtqid(boolean eqtqid) {
    this.eqtqid = eqtqid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getEqo() {
    return eqo;
  }

  public ExamquestionMask setEqo(boolean eqo) {
    this.eqo = eqo;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getEqts() {
    return eqts;
  }

  public ExamquestionMask setEqts(boolean eqts) {
    this.eqts = eqts;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getEqsc() {
    return eqsc;
  }

  public ExamquestionMask setEqsc(boolean eqsc) {
    this.eqsc = eqsc;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("eqid")) return eqid;
    else if (p.equals("eqexid")) return eqexid;
    else if (p.equals("eqsi")) return eqsi;
    else if (p.equals("eqtqid")) return eqtqid;
    else if (p.equals("eqo")) return eqo;
    else if (p.equals("eqts")) return eqts;
    else if (p.equals("eqsc")) return eqsc;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("eqid")) this.eqid = b;
    else if (p.equals("eqexid")) this.eqexid = b;
    else if (p.equals("eqsi")) this.eqsi = b;
    else if (p.equals("eqtqid")) this.eqtqid = b;
    else if (p.equals("eqo")) this.eqo = b;
    else if (p.equals("eqts")) this.eqts = b;
    else if (p.equals("eqsc")) this.eqsc = b;
  }

  public static class Serializer extends JsonSerializer<ExamquestionMask> {
    @Override
    public void serialize(ExamquestionMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getEqid()) {
        gen.writeFieldName("eqid");
        gen.writeBoolean(value.getEqid());
      }
      if (value.getEqexid()) {
        gen.writeFieldName("eqexid");
        gen.writeBoolean(value.getEqexid());
      }
      if (value.getEqsi()) {
        gen.writeFieldName("eqsi");
        gen.writeBoolean(value.getEqsi());
      }
      if (value.getEqtqid()) {
        gen.writeFieldName("eqtqid");
        gen.writeBoolean(value.getEqtqid());
      }
      if (value.getEqo()) {
        gen.writeFieldName("eqo");
        gen.writeBoolean(value.getEqo());
      }
      if (value.getEqts()) {
        gen.writeFieldName("eqts");
        gen.writeBoolean(value.getEqts());
      }
      if (value.getEqsc()) {
        gen.writeFieldName("eqsc");
        gen.writeBoolean(value.getEqsc());
      }
      gen.writeEndObject();
    }
  }
}
