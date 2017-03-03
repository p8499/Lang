package com.p8499.lang.gen.mask;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = CategoryMask.Serializer.class)
public class CategoryMask {
  protected boolean cgid = false;
  protected boolean cglsid = false;
  protected boolean cgsi = false;
  protected boolean cgpsi = false;
  protected boolean cgusid = false;
  protected boolean cgname = false;

  public CategoryMask(
      boolean cgid, boolean cglsid, boolean cgsi, boolean cgpsi, boolean cgusid, boolean cgname) {
    this.cgid = cgid;
    this.cglsid = cglsid;
    this.cgsi = cgsi;
    this.cgpsi = cgpsi;
    this.cgusid = cgusid;
    this.cgname = cgname;
  }

  public CategoryMask() {}

  public CategoryMask all(boolean b) {
    this.cgid = b;
    this.cglsid = b;
    this.cgsi = b;
    this.cgpsi = b;
    this.cgusid = b;
    this.cgname = b;
    return this;
  }

  public boolean getCgid() {
    return cgid;
  }

  public CategoryMask setCgid(boolean cgid) {
    this.cgid = cgid;
    return this;
  }

  public boolean getCglsid() {
    return cglsid;
  }

  public CategoryMask setCglsid(boolean cglsid) {
    this.cglsid = cglsid;
    return this;
  }

  public boolean getCgsi() {
    return cgsi;
  }

  public CategoryMask setCgsi(boolean cgsi) {
    this.cgsi = cgsi;
    return this;
  }

  public boolean getCgpsi() {
    return cgpsi;
  }

  public CategoryMask setCgpsi(boolean cgpsi) {
    this.cgpsi = cgpsi;
    return this;
  }

  public boolean getCgusid() {
    return cgusid;
  }

  public CategoryMask setCgusid(boolean cgusid) {
    this.cgusid = cgusid;
    return this;
  }

  public boolean getCgname() {
    return cgname;
  }

  public CategoryMask setCgname(boolean cgname) {
    this.cgname = cgname;
    return this;
  }

  public boolean get(String p) {
    if (p.equals("cgid")) return cgid;
    else if (p.equals("cglsid")) return cglsid;
    else if (p.equals("cgsi")) return cgsi;
    else if (p.equals("cgpsi")) return cgpsi;
    else if (p.equals("cgusid")) return cgusid;
    else if (p.equals("cgname")) return cgname;
    return false;
  }

  public void set(String p, boolean b) {
    if (p.equals("cgid")) this.cgid = b;
    else if (p.equals("cglsid")) this.cglsid = b;
    else if (p.equals("cgsi")) this.cgsi = b;
    else if (p.equals("cgpsi")) this.cgpsi = b;
    else if (p.equals("cgusid")) this.cgusid = b;
    else if (p.equals("cgname")) this.cgname = b;
  }

  public static class Serializer extends JsonSerializer<CategoryMask> {
    @Override
    public void serialize(CategoryMask value, JsonGenerator gen, SerializerProvider serializers)
        throws IOException, JsonProcessingException {
      gen.writeStartObject();

      if (value.getCgid()) {
        gen.writeFieldName("cgid");
        gen.writeBoolean(value.getCgid());
      }
      if (value.getCglsid()) {
        gen.writeFieldName("cglsid");
        gen.writeBoolean(value.getCglsid());
      }
      if (value.getCgsi()) {
        gen.writeFieldName("cgsi");
        gen.writeBoolean(value.getCgsi());
      }
      if (value.getCgpsi()) {
        gen.writeFieldName("cgpsi");
        gen.writeBoolean(value.getCgpsi());
      }
      if (value.getCgusid()) {
        gen.writeFieldName("cgusid");
        gen.writeBoolean(value.getCgusid());
      }
      if (value.getCgname()) {
        gen.writeFieldName("cgname");
        gen.writeBoolean(value.getCgname());
      }
      gen.writeEndObject();
    }
  }
}
