package com.p8499.lang.server.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = UsercreationMask.Serializer.class)
public class UsercreationMask {
  protected boolean ucid = false;
  protected boolean uccrdt = false;
  protected boolean ucupdt = false;
  protected boolean uccell = false;
  protected boolean ucpv = false;
  protected boolean ucmv = false;
  protected boolean ucac = false;
  protected boolean ucst = false;

  public UsercreationMask(
      boolean ucid,
      boolean uccrdt,
      boolean ucupdt,
      boolean uccell,
      boolean ucpv,
      boolean ucmv,
      boolean ucac,
      boolean ucst) {
    this.ucid = ucid;
    this.uccrdt = uccrdt;
    this.ucupdt = ucupdt;
    this.uccell = uccell;
    this.ucpv = ucpv;
    this.ucmv = ucmv;
    this.ucac = ucac;
    this.ucst = ucst;
  }

  public UsercreationMask() {}

  public UsercreationMask all(boolean b) {
    this.ucid = b;
    this.uccrdt = b;
    this.ucupdt = b;
    this.uccell = b;
    this.ucpv = b;
    this.ucmv = b;
    this.ucac = b;
    this.ucst = b;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getUcid() {
    return ucid;
  }

  public UsercreationMask setUcid(boolean ucid) {
    this.ucid = ucid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getUccrdt() {
    return uccrdt;
  }

  public UsercreationMask setUccrdt(boolean uccrdt) {
    this.uccrdt = uccrdt;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getUcupdt() {
    return ucupdt;
  }

  public UsercreationMask setUcupdt(boolean ucupdt) {
    this.ucupdt = ucupdt;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getUccell() {
    return uccell;
  }

  public UsercreationMask setUccell(boolean uccell) {
    this.uccell = uccell;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getUcpv() {
    return ucpv;
  }

  public UsercreationMask setUcpv(boolean ucpv) {
    this.ucpv = ucpv;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getUcmv() {
    return ucmv;
  }

  public UsercreationMask setUcmv(boolean ucmv) {
    this.ucmv = ucmv;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getUcac() {
    return ucac;
  }

  public UsercreationMask setUcac(boolean ucac) {
    this.ucac = ucac;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getUcst() {
    return ucst;
  }

  public UsercreationMask setUcst(boolean ucst) {
    this.ucst = ucst;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("ucid")) return ucid;
    else if (p.equals("uccrdt")) return uccrdt;
    else if (p.equals("ucupdt")) return ucupdt;
    else if (p.equals("uccell")) return uccell;
    else if (p.equals("ucpv")) return ucpv;
    else if (p.equals("ucmv")) return ucmv;
    else if (p.equals("ucac")) return ucac;
    else if (p.equals("ucst")) return ucst;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("ucid")) this.ucid = b;
    else if (p.equals("uccrdt")) this.uccrdt = b;
    else if (p.equals("ucupdt")) this.ucupdt = b;
    else if (p.equals("uccell")) this.uccell = b;
    else if (p.equals("ucpv")) this.ucpv = b;
    else if (p.equals("ucmv")) this.ucmv = b;
    else if (p.equals("ucac")) this.ucac = b;
    else if (p.equals("ucst")) this.ucst = b;
  }

  public static class Serializer extends JsonSerializer<UsercreationMask> {
    @Override
    public void serialize(UsercreationMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getUcid()) {
        gen.writeFieldName("ucid");
        gen.writeBoolean(value.getUcid());
      }
      if (value.getUccrdt()) {
        gen.writeFieldName("uccrdt");
        gen.writeBoolean(value.getUccrdt());
      }
      if (value.getUcupdt()) {
        gen.writeFieldName("ucupdt");
        gen.writeBoolean(value.getUcupdt());
      }
      if (value.getUccell()) {
        gen.writeFieldName("uccell");
        gen.writeBoolean(value.getUccell());
      }
      if (value.getUcpv()) {
        gen.writeFieldName("ucpv");
        gen.writeBoolean(value.getUcpv());
      }
      if (value.getUcmv()) {
        gen.writeFieldName("ucmv");
        gen.writeBoolean(value.getUcmv());
      }
      if (value.getUcac()) {
        gen.writeFieldName("ucac");
        gen.writeBoolean(value.getUcac());
      }
      if (value.getUcst()) {
        gen.writeFieldName("ucst");
        gen.writeBoolean(value.getUcst());
      }
      gen.writeEndObject();
    }
  }
}
