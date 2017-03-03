package com.p8499.lang.server.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = CertificateMask.Serializer.class)
public class CertificateMask {
  protected boolean crid = false;
  protected boolean crusid = false;
  protected boolean crlsid = false;
  protected boolean crlsname = false;
  protected boolean crlsloc = false;
  protected boolean crlv = false;
  protected boolean crefdt = false;
  protected boolean crexdt = false;

  public CertificateMask(
      boolean crid,
      boolean crusid,
      boolean crlsid,
      boolean crlsname,
      boolean crlsloc,
      boolean crlv,
      boolean crefdt,
      boolean crexdt) {
    this.crid = crid;
    this.crusid = crusid;
    this.crlsid = crlsid;
    this.crlsname = crlsname;
    this.crlsloc = crlsloc;
    this.crlv = crlv;
    this.crefdt = crefdt;
    this.crexdt = crexdt;
  }

  public CertificateMask() {}

  public CertificateMask all(boolean b) {
    this.crid = b;
    this.crusid = b;
    this.crlsid = b;
    this.crlsname = b;
    this.crlsloc = b;
    this.crlv = b;
    this.crefdt = b;
    this.crexdt = b;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getCrid() {
    return crid;
  }

  public CertificateMask setCrid(boolean crid) {
    this.crid = crid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getCrusid() {
    return crusid;
  }

  public CertificateMask setCrusid(boolean crusid) {
    this.crusid = crusid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getCrlsid() {
    return crlsid;
  }

  public CertificateMask setCrlsid(boolean crlsid) {
    this.crlsid = crlsid;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getCrlsname() {
    return crlsname;
  }

  public CertificateMask setCrlsname(boolean crlsname) {
    this.crlsname = crlsname;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getCrlsloc() {
    return crlsloc;
  }

  public CertificateMask setCrlsloc(boolean crlsloc) {
    this.crlsloc = crlsloc;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getCrlv() {
    return crlv;
  }

  public CertificateMask setCrlv(boolean crlv) {
    this.crlv = crlv;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getCrefdt() {
    return crefdt;
  }

  public CertificateMask setCrefdt(boolean crefdt) {
    this.crefdt = crefdt;
    return this;
  }

  /** @return Before updating, it returns TRUE / FALSE set by client. */
  public boolean getCrexdt() {
    return crexdt;
  }

  public CertificateMask setCrexdt(boolean crexdt) {
    this.crexdt = crexdt;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("crid")) return crid;
    else if (p.equals("crusid")) return crusid;
    else if (p.equals("crlsid")) return crlsid;
    else if (p.equals("crlsname")) return crlsname;
    else if (p.equals("crlsloc")) return crlsloc;
    else if (p.equals("crlv")) return crlv;
    else if (p.equals("crefdt")) return crefdt;
    else if (p.equals("crexdt")) return crexdt;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("crid")) this.crid = b;
    else if (p.equals("crusid")) this.crusid = b;
    else if (p.equals("crlsid")) this.crlsid = b;
    else if (p.equals("crlsname")) this.crlsname = b;
    else if (p.equals("crlsloc")) this.crlsloc = b;
    else if (p.equals("crlv")) this.crlv = b;
    else if (p.equals("crefdt")) this.crefdt = b;
    else if (p.equals("crexdt")) this.crexdt = b;
  }

  public static class Serializer extends JsonSerializer<CertificateMask> {
    @Override
    public void serialize(CertificateMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getCrid()) {
        gen.writeFieldName("crid");
        gen.writeBoolean(value.getCrid());
      }
      if (value.getCrusid()) {
        gen.writeFieldName("crusid");
        gen.writeBoolean(value.getCrusid());
      }
      if (value.getCrlsid()) {
        gen.writeFieldName("crlsid");
        gen.writeBoolean(value.getCrlsid());
      }
      if (value.getCrlsname()) {
        gen.writeFieldName("crlsname");
        gen.writeBoolean(value.getCrlsname());
      }
      if (value.getCrlsloc()) {
        gen.writeFieldName("crlsloc");
        gen.writeBoolean(value.getCrlsloc());
      }
      if (value.getCrlv()) {
        gen.writeFieldName("crlv");
        gen.writeBoolean(value.getCrlv());
      }
      if (value.getCrefdt()) {
        gen.writeFieldName("crefdt");
        gen.writeBoolean(value.getCrefdt());
      }
      if (value.getCrexdt()) {
        gen.writeFieldName("crexdt");
        gen.writeBoolean(value.getCrexdt());
      }
      gen.writeEndObject();
    }
  }
}
