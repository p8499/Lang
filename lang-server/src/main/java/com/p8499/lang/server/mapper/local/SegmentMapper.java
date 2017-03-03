package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.SegmentMask;
import com.p8499.lang.server.bean.Segment;

@Component("segmentMapper")
public interface SegmentMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F1130 WHERE TRASID=#{trasid}")
  public boolean exists(@Param("trasid") Integer trasid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.trasid or mask.trpi or mask.trhz or mask.trst or mask.trusid or mask.trcrdt or mask.trupdt'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.trasid'>TRASID, </if>"
          + "<if test='mask.trpi'>TRPI, </if>"
          + "<if test='mask.trhz'>TRHZ, </if>"
          + "<if test='mask.trst'>TRST, </if>"
          + "<if test='mask.trusid'>TRUSID, </if>"
          + "<if test='mask.trcrdt'>TRCRDT, </if>"
          + "<if test='mask.trupdt'>TRUPDT, </if>"
          + "</trim>"
          + "FROM public.F1130 WHERE TRASID=#{trasid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT TRASID,TRPI,TRHZ,TRST,TRUSID,TRCRDT,TRUPDT FROM public.F1130 WHERE TRASID=#{trasid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Segment get(@Param("trasid") Integer trasid, @Param("mask") SegmentMask mask);

  @Insert(
      "INSERT INTO public.F1130 (TRASID,TRPI,TRHZ,TRST,TRUSID,TRCRDT,TRUPDT) VALUES (#{bean.trasid},#{bean.trpi},#{bean.trhz},#{bean.trst},#{bean.trusid},#{bean.trcrdt},#{bean.trupdt})")
  public void add(@Param("bean") Segment bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.trpi or mask.trhz or mask.trupdt or mask.trusid or mask.trst or mask.trcrdt'>"
          + "UPDATE public.F1130 "
          + "<set>"
          + "<if test='mask.trpi'>TRPI=#{bean.trpi}, </if>"
          + "<if test='mask.trhz'>TRHZ=#{bean.trhz}, </if>"
          + "<if test='mask.trupdt'>TRUPDT=#{bean.trupdt}, </if>"
          + "<if test='mask.trusid'>TRUSID=#{bean.trusid}, </if>"
          + "<if test='mask.trst'>TRST=#{bean.trst}, </if>"
          + "<if test='mask.trcrdt'>TRCRDT=#{bean.trcrdt}, </if>"
          + "</set>"
          + "WHERE TRASID=#{bean.trasid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1130 SET TRPI=#{bean.trpi},TRHZ=#{bean.trhz},TRUPDT=#{bean.trupdt},TRUSID=#{bean.trusid},TRST=#{bean.trst},TRCRDT=#{bean.trcrdt} WHERE TRASID=#{bean.trasid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Segment bean, @Param("mask") SegmentMask mask);

  @Delete("DELETE FROM public.F1130 WHERE TRASID=#{trasid}")
  public boolean delete(@Param("trasid") Integer trasid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.trasid'>TRASID, </if>"
          + "<if test='mask.trpi'>TRPI, </if>"
          + "<if test='mask.trhz'>TRHZ, </if>"
          + "<if test='mask.trst'>TRST, </if>"
          + "<if test='mask.trusid'>TRUSID, </if>"
          + "<if test='mask.trcrdt'>TRCRDT, </if>"
          + "<if test='mask.trupdt'>TRUPDT, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT TRASID,TRPI,TRHZ,TRST,TRUSID,TRCRDT,TRUPDT "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F1130 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Segment> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") SegmentMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F1130 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
