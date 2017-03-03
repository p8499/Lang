package com.p8499.lang.gen.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = UserMask.Serializer.class)
public class UserMask {
  protected boolean usid = false;
  protected boolean uscell = false;
  protected boolean uspswd = false;
  protected boolean usname = false;
  protected boolean usst = false;
  protected boolean uslsid = false;
  protected boolean uslsname = false;

  public UserMask(
      boolean usid,
      boolean uscell,
      boolean uspswd,
      boolean usname,
      boolean usst,
      boolean uslsid,
      boolean uslsname) {
    this.usid = usid;
    this.uscell = uscell;
    this.uspswd = uspswd;
    this.usname = usname;
    this.usst = usst;
    this.uslsid = uslsid;
    this.uslsname = uslsname;
  }

  public UserMask() {}

  public UserMask all(boolean b) {
    this.usid = b;
    this.uscell = b;
    this.uspswd = b;
    this.usname = b;
    this.usst = b;
    this.uslsid = b;
    this.uslsname = b;
    return this;
  }

  public boolean getUsid() {
    return usid;
  }

  public UserMask setUsid(boolean usid) {
    this.usid = usid;
    return this;
  }

  public boolean getUscell() {
    return uscell;
  }

  public UserMask setUscell(boolean uscell) {
    this.uscell = uscell;
    return this;
  }

  public boolean getUspswd() {
    return uspswd;
  }

  public UserMask setUspswd(boolean uspswd) {
    this.uspswd = uspswd;
    return this;
  }

  public boolean getUsname() {
    return usname;
  }

  public UserMask setUsname(boolean usname) {
    this.usname = usname;
    return this;
  }

  public boolean getUsst() {
    return usst;
  }

  public UserMask setUsst(boolean usst) {
    this.usst = usst;
    return this;
  }

  public boolean getUslsid() {
    return uslsid;
  }

  public UserMask setUslsid(boolean uslsid) {
    this.uslsid = uslsid;
    return this;
  }

  public boolean getUslsname() {
    return uslsname;
  }

  public UserMask setUslsname(boolean uslsname) {
    this.uslsname = uslsname;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("usid")) return usid;
    else if (p.equals("uscell")) return uscell;
    else if (p.equals("uspswd")) return uspswd;
    else if (p.equals("usname")) return usname;
    else if (p.equals("usst")) return usst;
    else if (p.equals("uslsid")) return uslsid;
    else if (p.equals("uslsname")) return uslsname;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("usid")) this.usid = b;
    else if (p.equals("uscell")) this.uscell = b;
    else if (p.equals("uspswd")) this.uspswd = b;
    else if (p.equals("usname")) this.usname = b;
    else if (p.equals("usst")) this.usst = b;
    else if (p.equals("uslsid")) this.uslsid = b;
    else if (p.equals("uslsname")) this.uslsname = b;
  }

  public static class Serializer extends JsonSerializer<UserMask> {
    @Override
    public void serialize(UserMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getUsid()) {
        gen.writeFieldName("usid");
        gen.writeBoolean(value.getUsid());
      }
      if (value.getUscell()) {
        gen.writeFieldName("uscell");
        gen.writeBoolean(value.getUscell());
      }
      if (value.getUspswd()) {
        gen.writeFieldName("uspswd");
        gen.writeBoolean(value.getUspswd());
      }
      if (value.getUsname()) {
        gen.writeFieldName("usname");
        gen.writeBoolean(value.getUsname());
      }
      if (value.getUsst()) {
        gen.writeFieldName("usst");
        gen.writeBoolean(value.getUsst());
      }
      if (value.getUslsid()) {
        gen.writeFieldName("uslsid");
        gen.writeBoolean(value.getUslsid());
      }
      if (value.getUslsname()) {
        gen.writeFieldName("uslsname");
        gen.writeBoolean(value.getUslsname());
      }
      gen.writeEndObject();
    }
  }
}
