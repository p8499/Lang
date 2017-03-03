package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.SegmentvoteMask;
import com.p8499.lang.server.bean.Segmentvote;

@Component("segmentvoteMapper")
public interface SegmentvoteMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F1132 WHERE TVID=#{tvid}")
  public boolean exists(@Param("tvid") Integer tvid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.tvid or mask.tvtaid or mask.tvsi or mask.tvusid or mask.tvpo or mask.tvcrdt or mask.tvupdt'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.tvid'>TVID, </if>"
          + "<if test='mask.tvtaid'>TVTAID, </if>"
          + "<if test='mask.tvsi'>TVSI, </if>"
          + "<if test='mask.tvusid'>TVUSID, </if>"
          + "<if test='mask.tvpo'>TVPO, </if>"
          + "<if test='mask.tvcrdt'>TVCRDT, </if>"
          + "<if test='mask.tvupdt'>TVUPDT, </if>"
          + "</trim>"
          + "FROM public.F1132 WHERE TVID=#{tvid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT TVID,TVTAID,TVSI,TVUSID,TVPO,TVCRDT,TVUPDT FROM public.F1132 WHERE TVID=#{tvid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Segmentvote get(@Param("tvid") Integer tvid, @Param("mask") SegmentvoteMask mask);

  @Insert(
      "INSERT INTO public.F1132 (TVPO,TVUPDT,TVUSID,TVTAID,TVSI,TVCRDT) VALUES (#{bean.tvpo},#{bean.tvupdt},#{bean.tvusid},#{bean.tvtaid},#{bean.tvsi},#{bean.tvcrdt})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.tvid")
  public void add(@Param("bean") Segmentvote bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.tvpo or mask.tvupdt or mask.tvusid or mask.tvtaid or mask.tvsi or mask.tvcrdt'>"
          + "UPDATE public.F1132 "
          + "<set>"
          + "<if test='mask.tvpo'>TVPO=#{bean.tvpo}, </if>"
          + "<if test='mask.tvupdt'>TVUPDT=#{bean.tvupdt}, </if>"
          + "<if test='mask.tvusid'>TVUSID=#{bean.tvusid}, </if>"
          + "<if test='mask.tvtaid'>TVTAID=#{bean.tvtaid}, </if>"
          + "<if test='mask.tvsi'>TVSI=#{bean.tvsi}, </if>"
          + "<if test='mask.tvcrdt'>TVCRDT=#{bean.tvcrdt}, </if>"
          + "</set>"
          + "WHERE TVID=#{bean.tvid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1132 SET TVPO=#{bean.tvpo},TVUPDT=#{bean.tvupdt},TVUSID=#{bean.tvusid},TVTAID=#{bean.tvtaid},TVSI=#{bean.tvsi},TVCRDT=#{bean.tvcrdt} WHERE TVID=#{bean.tvid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Segmentvote bean, @Param("mask") SegmentvoteMask mask);

  @Delete("DELETE FROM public.F1132 WHERE TVID=#{tvid}")
  public boolean delete(@Param("tvid") Integer tvid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.tvid'>TVID, </if>"
          + "<if test='mask.tvtaid'>TVTAID, </if>"
          + "<if test='mask.tvsi'>TVSI, </if>"
          + "<if test='mask.tvusid'>TVUSID, </if>"
          + "<if test='mask.tvpo'>TVPO, </if>"
          + "<if test='mask.tvcrdt'>TVCRDT, </if>"
          + "<if test='mask.tvupdt'>TVUPDT, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT TVID,TVTAID,TVSI,TVUSID,TVPO,TVCRDT,TVUPDT "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F1132 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Segmentvote> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") SegmentvoteMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F1132 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
