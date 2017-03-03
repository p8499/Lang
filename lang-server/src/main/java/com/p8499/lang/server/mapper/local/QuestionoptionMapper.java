package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.QuestionoptionMask;
import com.p8499.lang.server.bean.Questionoption;

@Component("questionoptionMapper")
public interface QuestionoptionMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F1202 WHERE TOID=#{toid}")
  public boolean exists(@Param("toid") Integer toid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.toid or mask.totqid or mask.too or mask.tocont'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.toid'>TOID, </if>"
          + "<if test='mask.totqid'>TOTQID, </if>"
          + "<if test='mask.too'>TOO, </if>"
          + "<if test='mask.tocont'>TOCONT, </if>"
          + "</trim>"
          + "FROM public.F1202 WHERE TOID=#{toid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT TOID,TOTQID,TOO,TOCONT FROM public.F1202 WHERE TOID=#{toid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Questionoption get(@Param("toid") Integer toid, @Param("mask") QuestionoptionMask mask);

  @Insert(
      "INSERT INTO public.F1202 (TOCONT,TOO,TOTQID) VALUES (#{bean.tocont},#{bean.too},#{bean.totqid})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.toid")
  public void add(@Param("bean") Questionoption bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.tocont or mask.too or mask.totqid'>"
          + "UPDATE public.F1202 "
          + "<set>"
          + "<if test='mask.tocont'>TOCONT=#{bean.tocont}, </if>"
          + "<if test='mask.too'>TOO=#{bean.too}, </if>"
          + "<if test='mask.totqid'>TOTQID=#{bean.totqid}, </if>"
          + "</set>"
          + "WHERE TOID=#{bean.toid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1202 SET TOCONT=#{bean.tocont},TOO=#{bean.too},TOTQID=#{bean.totqid} WHERE TOID=#{bean.toid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Questionoption bean, @Param("mask") QuestionoptionMask mask);

  @Delete("DELETE FROM public.F1202 WHERE TOID=#{toid}")
  public boolean delete(@Param("toid") Integer toid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.toid'>TOID, </if>"
          + "<if test='mask.totqid'>TOTQID, </if>"
          + "<if test='mask.too'>TOO, </if>"
          + "<if test='mask.tocont'>TOCONT, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT TOID,TOTQID,TOO,TOCONT "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F1202 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Questionoption> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") QuestionoptionMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F1202 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
