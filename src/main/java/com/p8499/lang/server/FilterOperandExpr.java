package com.p8499.lang.server;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FilterOperandExpr implements FilterExpr {
  public static final String OP_STRING = "string";
  public static final String OP_NUMBER = "number";
  public static final String OP_DATE = "date";

  public String op = null;
  public String data = null;
  public Boolean isCol = null;

  public FilterOperandExpr() {}

  public FilterOperandExpr(String data, String op, Boolean isCol) {
    this.op = op;
    this.data = data;
    this.isCol = isCol;
  }

  public String toString() {
    if (!isCol && OP_STRING.equals(op)) return String.format("'%s'", parseEscapedString(data));
    else if (!isCol && OP_DATE.equals(op)) {
      return String.format("to_date('%s','yyyymmddhh24miss')", data);
    } else return data;
  }

  public static String parseEscapedString(
      String
          raw) { //String escaped=raw.replaceAll("\0","\\0").replaceAll("\n","\\n").replaceAll("\t","\\t").replaceAll("\r","\\r").replaceAll("\b","\\b").replaceAll("'","\\'").replaceAll("\\","\\\\");
    String escaped = raw.replace("'", "\\\\'").replaceAll("\\\\", "\\\\\\\\");
    return escaped;
  }

  public static String parseWildEscapedString(
      String
          raw) { //String escaped=raw.replaceAll("\0","\\0").replaceAll("\n","\\n").replaceAll("\t","\\t").replaceAll("\r","\\r").replaceAll("\b","\\b").replaceAll("'","\\'").replaceAll("\\","\\\\").replaceAll("%","\\%").replaceAll("_","\\_");
    String escaped =
        raw.replace("'", "\\\\'")
            .replaceAll("\\\\", "\\\\\\\\")
            .replaceAll("%", "\\\\%")
            .replaceAll("_", "\\\\_");
    return escaped;
  }

  public String toEscapedStartWithSql() {
    StringBuffer sb = new StringBuffer();
    if (!isCol && OP_STRING.equals(op)) {
      sb.append("'");
      sb.append(parseWildEscapedString(data));
      sb.append("%'");
    }
    return sb.toString();
  }

  public String toEscapedEndWithSql() {
    StringBuffer sb = new StringBuffer();
    if (!isCol && OP_STRING.equals(op)) {
      sb.append("'%");
      sb.append(parseWildEscapedString(data));
      sb.append("'");
    }
    return sb.toString();
  }

  public String toEscapedContainSql() {
    StringBuffer sb = new StringBuffer();
    if (!isCol && OP_STRING.equals(op)) {
      sb.append("'%");
      sb.append(parseWildEscapedString(data));
      sb.append("%'");
    }
    return sb.toString();
  }
}
