package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.SentenceMask;
import com.p8499.lang.server.bean.Sentence;

@Component("sentenceMapper")
public interface SentenceMapper {
  @Select("SELECT COUNT(*)>0 FROM public.V1120 WHERE ASID=#{asid}")
  public boolean exists(@Param("asid") Integer asid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.asid or mask.asatid or mask.assi or mask.ascont or mask.asst or mask.ascs or mask.asusid or mask.ascrdt or mask.asupdt'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.asid'>ASID, </if>"
          + "<if test='mask.asatid'>ASATID, </if>"
          + "<if test='mask.assi'>ASSI, </if>"
          + "<if test='mask.ascont'>ASCONT, </if>"
          + "<if test='mask.asst'>ASST, </if>"
          + "<if test='mask.ascs'>ASCS, </if>"
          + "<if test='mask.asusid'>ASUSID, </if>"
          + "<if test='mask.ascrdt'>ASCRDT, </if>"
          + "<if test='mask.asupdt'>ASUPDT, </if>"
          + "</trim>"
          + "FROM public.V1120 WHERE ASID=#{asid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT ASID,ASATID,ASSI,ASCONT,ASST,ASCS,ASUSID,ASCRDT,ASUPDT FROM public.V1120 WHERE ASID=#{asid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Sentence get(@Param("asid") Integer asid, @Param("mask") SentenceMask mask);

  @Insert(
      "INSERT INTO public.F1120 (ASSI,ASATID,ASCRDT,ASUSID,ASUPDT,ASCONT,ASST) VALUES (#{bean.assi},#{bean.asatid},#{bean.ascrdt},#{bean.asusid},#{bean.asupdt},#{bean.ascont},#{bean.asst})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.asid")
  public void add(@Param("bean") Sentence bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.assi or mask.asatid or mask.ascrdt or mask.asusid or mask.asupdt or mask.ascont or mask.asst'>"
          + "UPDATE public.F1120 "
          + "<set>"
          + "<if test='mask.assi'>ASSI=#{bean.assi}, </if>"
          + "<if test='mask.asatid'>ASATID=#{bean.asatid}, </if>"
          + "<if test='mask.ascrdt'>ASCRDT=#{bean.ascrdt}, </if>"
          + "<if test='mask.asusid'>ASUSID=#{bean.asusid}, </if>"
          + "<if test='mask.asupdt'>ASUPDT=#{bean.asupdt}, </if>"
          + "<if test='mask.ascont'>ASCONT=#{bean.ascont}, </if>"
          + "<if test='mask.asst'>ASST=#{bean.asst}, </if>"
          + "</set>"
          + "WHERE ASID=#{bean.asid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1120 SET ASSI=#{bean.assi},ASATID=#{bean.asatid},ASCRDT=#{bean.ascrdt},ASUSID=#{bean.asusid},ASUPDT=#{bean.asupdt},ASCONT=#{bean.ascont},ASST=#{bean.asst} WHERE ASID=#{bean.asid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Sentence bean, @Param("mask") SentenceMask mask);

  @Delete("DELETE FROM public.F1120 WHERE ASID=#{asid}")
  public boolean delete(@Param("asid") Integer asid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.asid'>ASID, </if>"
          + "<if test='mask.asatid'>ASATID, </if>"
          + "<if test='mask.assi'>ASSI, </if>"
          + "<if test='mask.ascont'>ASCONT, </if>"
          + "<if test='mask.asst'>ASST, </if>"
          + "<if test='mask.ascs'>ASCS, </if>"
          + "<if test='mask.asusid'>ASUSID, </if>"
          + "<if test='mask.ascrdt'>ASCRDT, </if>"
          + "<if test='mask.asupdt'>ASUPDT, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT ASID,ASATID,ASSI,ASCONT,ASST,ASCS,ASUSID,ASCRDT,ASUPDT "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.V1120 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Sentence> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") SentenceMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.V1120 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
