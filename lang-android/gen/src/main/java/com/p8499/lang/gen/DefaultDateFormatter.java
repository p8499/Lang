package com.p8499.lang.gen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DefaultDateFormatter {
  private static SimpleDateFormat formatter;

  public static SimpleDateFormat getFormatter() {
    if (formatter == null) formatter = new SimpleDateFormat("yyyyMMddHHmmss");
    return formatter;
  }

  public static String format(Date date) {
    return getFormatter().format(date);
  }

  public static Date parse(String str) {
    Date date = null;
    try {
      date = getFormatter().parse(str);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }
}
