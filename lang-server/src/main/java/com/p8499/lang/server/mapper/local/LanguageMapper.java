package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.LanguageMask;
import com.p8499.lang.server.bean.Language;

@Component("languageMapper")
public interface LanguageMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F1010 WHERE LSID=#{lsid}")
  public boolean exists(@Param("lsid") String lsid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.lsid or mask.lsname or mask.lsloc or mask.lssort'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.lsid'>LSID, </if>"
          + "<if test='mask.lsname'>LSNAME, </if>"
          + "<if test='mask.lsloc'>LSLOC, </if>"
          + "<if test='mask.lssort'>LSSORT, </if>"
          + "</trim>"
          + "FROM public.F1010 WHERE LSID=#{lsid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT LSID,LSNAME,LSLOC,LSSORT FROM public.F1010 WHERE LSID=#{lsid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Language get(@Param("lsid") String lsid, @Param("mask") LanguageMask mask);

  @Insert(
      "INSERT INTO public.F1010 (LSID,LSNAME,LSLOC,LSSORT) VALUES (#{bean.lsid},#{bean.lsname},#{bean.lsloc},#{bean.lssort})")
  public void add(@Param("bean") Language bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.lssort or mask.lsname or mask.lsloc'>"
          + "UPDATE public.F1010 "
          + "<set>"
          + "<if test='mask.lssort'>LSSORT=#{bean.lssort}, </if>"
          + "<if test='mask.lsname'>LSNAME=#{bean.lsname}, </if>"
          + "<if test='mask.lsloc'>LSLOC=#{bean.lsloc}, </if>"
          + "</set>"
          + "WHERE LSID=#{bean.lsid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1010 SET LSSORT=#{bean.lssort},LSNAME=#{bean.lsname},LSLOC=#{bean.lsloc} WHERE LSID=#{bean.lsid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Language bean, @Param("mask") LanguageMask mask);

  @Delete("DELETE FROM public.F1010 WHERE LSID=#{lsid}")
  public boolean delete(@Param("lsid") String lsid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.lsid'>LSID, </if>"
          + "<if test='mask.lsname'>LSNAME, </if>"
          + "<if test='mask.lsloc'>LSLOC, </if>"
          + "<if test='mask.lssort'>LSSORT, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT LSID,LSNAME,LSLOC,LSSORT "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F1010 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Language> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") LanguageMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F1010 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
