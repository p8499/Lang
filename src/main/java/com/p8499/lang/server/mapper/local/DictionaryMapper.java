package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.DictionaryMask;
import com.p8499.lang.server.bean.Dictionary;

@Component("dictionaryMapper")
public interface DictionaryMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F1011 WHERE DCID=#{dcid}")
  public boolean exists(@Param("dcid") Integer dcid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.dcid or mask.dclsid or mask.dchz or mask.dcpt or mask.dcrm'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.dcid'>DCID, </if>"
          + "<if test='mask.dclsid'>DCLSID, </if>"
          + "<if test='mask.dchz'>DCHZ, </if>"
          + "<if test='mask.dcpt'>DCPT, </if>"
          + "<if test='mask.dcrm'>DCRM, </if>"
          + "</trim>"
          + "FROM public.F1011 WHERE DCID=#{dcid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT DCID,DCLSID,DCHZ,DCPT,DCRM FROM public.F1011 WHERE DCID=#{dcid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Dictionary get(@Param("dcid") Integer dcid, @Param("mask") DictionaryMask mask);

  @Insert(
      "INSERT INTO public.F1011 (DCRM,DCLSID,DCPT,DCHZ) VALUES (#{bean.dcrm},#{bean.dclsid},#{bean.dcpt},#{bean.dchz})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.dcid")
  public void add(@Param("bean") Dictionary bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.dcrm or mask.dclsid or mask.dcpt or mask.dchz'>"
          + "UPDATE public.F1011 "
          + "<set>"
          + "<if test='mask.dcrm'>DCRM=#{bean.dcrm}, </if>"
          + "<if test='mask.dclsid'>DCLSID=#{bean.dclsid}, </if>"
          + "<if test='mask.dcpt'>DCPT=#{bean.dcpt}, </if>"
          + "<if test='mask.dchz'>DCHZ=#{bean.dchz}, </if>"
          + "</set>"
          + "WHERE DCID=#{bean.dcid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1011 SET DCRM=#{bean.dcrm},DCLSID=#{bean.dclsid},DCPT=#{bean.dcpt},DCHZ=#{bean.dchz} WHERE DCID=#{bean.dcid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Dictionary bean, @Param("mask") DictionaryMask mask);

  @Delete("DELETE FROM public.F1011 WHERE DCID=#{dcid}")
  public boolean delete(@Param("dcid") Integer dcid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.dcid'>DCID, </if>"
          + "<if test='mask.dclsid'>DCLSID, </if>"
          + "<if test='mask.dchz'>DCHZ, </if>"
          + "<if test='mask.dcpt'>DCPT, </if>"
          + "<if test='mask.dcrm'>DCRM, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT DCID,DCLSID,DCHZ,DCPT,DCRM "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F1011 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Dictionary> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") DictionaryMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F1011 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
