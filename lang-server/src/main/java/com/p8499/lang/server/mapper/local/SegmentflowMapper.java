package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.SegmentflowMask;
import com.p8499.lang.server.bean.Segmentflow;

@Component("segmentflowMapper")
public interface SegmentflowMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F1131 WHERE TAID=#{taid}")
  public boolean exists(@Param("taid") Integer taid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.taid or mask.taasid or mask.tasi or mask.tapi or mask.tahz or mask.tast or mask.tausid or mask.tacrdt or mask.taupdt'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.taid'>TAID, </if>"
          + "<if test='mask.taasid'>TAASID, </if>"
          + "<if test='mask.tasi'>TASI, </if>"
          + "<if test='mask.tapi'>TAPI, </if>"
          + "<if test='mask.tahz'>TAHZ, </if>"
          + "<if test='mask.tast'>TAST, </if>"
          + "<if test='mask.tausid'>TAUSID, </if>"
          + "<if test='mask.tacrdt'>TACRDT, </if>"
          + "<if test='mask.taupdt'>TAUPDT, </if>"
          + "</trim>"
          + "FROM public.F1131 WHERE TAID=#{taid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT TAID,TAASID,TASI,TAPI,TAHZ,TAST,TAUSID,TACRDT,TAUPDT FROM public.F1131 WHERE TAID=#{taid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Segmentflow get(@Param("taid") Integer taid, @Param("mask") SegmentflowMask mask);

  @Insert(
      "INSERT INTO public.F1131 (TAPI,TASI,TAUPDT,TAST,TAHZ,TAUSID,TACRDT,TAASID) VALUES (#{bean.tapi},#{bean.tasi},#{bean.taupdt},#{bean.tast},#{bean.tahz},#{bean.tausid},#{bean.tacrdt},#{bean.taasid})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.taid")
  public void add(@Param("bean") Segmentflow bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.tapi or mask.tasi or mask.taupdt or mask.tast or mask.tahz or mask.tausid or mask.tacrdt or mask.taasid'>"
          + "UPDATE public.F1131 "
          + "<set>"
          + "<if test='mask.tapi'>TAPI=#{bean.tapi}, </if>"
          + "<if test='mask.tasi'>TASI=#{bean.tasi}, </if>"
          + "<if test='mask.taupdt'>TAUPDT=#{bean.taupdt}, </if>"
          + "<if test='mask.tast'>TAST=#{bean.tast}, </if>"
          + "<if test='mask.tahz'>TAHZ=#{bean.tahz}, </if>"
          + "<if test='mask.tausid'>TAUSID=#{bean.tausid}, </if>"
          + "<if test='mask.tacrdt'>TACRDT=#{bean.tacrdt}, </if>"
          + "<if test='mask.taasid'>TAASID=#{bean.taasid}, </if>"
          + "</set>"
          + "WHERE TAID=#{bean.taid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1131 SET TAPI=#{bean.tapi},TASI=#{bean.tasi},TAUPDT=#{bean.taupdt},TAST=#{bean.tast},TAHZ=#{bean.tahz},TAUSID=#{bean.tausid},TACRDT=#{bean.tacrdt},TAASID=#{bean.taasid} WHERE TAID=#{bean.taid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Segmentflow bean, @Param("mask") SegmentflowMask mask);

  @Delete("DELETE FROM public.F1131 WHERE TAID=#{taid}")
  public boolean delete(@Param("taid") Integer taid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.taid'>TAID, </if>"
          + "<if test='mask.taasid'>TAASID, </if>"
          + "<if test='mask.tasi'>TASI, </if>"
          + "<if test='mask.tapi'>TAPI, </if>"
          + "<if test='mask.tahz'>TAHZ, </if>"
          + "<if test='mask.tast'>TAST, </if>"
          + "<if test='mask.tausid'>TAUSID, </if>"
          + "<if test='mask.tacrdt'>TACRDT, </if>"
          + "<if test='mask.taupdt'>TAUPDT, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT TAID,TAASID,TASI,TAPI,TAHZ,TAST,TAUSID,TACRDT,TAUPDT "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F1131 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Segmentflow> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") SegmentflowMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F1131 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
