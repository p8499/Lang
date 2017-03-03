package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.ExamquestionMask;
import com.p8499.lang.server.bean.Examquestion;

@Component("examquestionMapper")
public interface ExamquestionMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F1212 WHERE EQID=#{eqid}")
  public boolean exists(@Param("eqid") Integer eqid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.eqid or mask.eqexid or mask.eqsi or mask.eqtqid or mask.eqo or mask.eqts or mask.eqsc'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.eqid'>EQID, </if>"
          + "<if test='mask.eqexid'>EQEXID, </if>"
          + "<if test='mask.eqsi'>EQSI, </if>"
          + "<if test='mask.eqtqid'>EQTQID, </if>"
          + "<if test='mask.eqo'>EQO, </if>"
          + "<if test='mask.eqts'>EQTS, </if>"
          + "<if test='mask.eqsc'>EQSC, </if>"
          + "</trim>"
          + "FROM public.F1212 WHERE EQID=#{eqid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT EQID,EQEXID,EQSI,EQTQID,EQO,EQTS,EQSC FROM public.F1212 WHERE EQID=#{eqid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Examquestion get(@Param("eqid") Integer eqid, @Param("mask") ExamquestionMask mask);

  @Insert(
      "INSERT INTO public.F1212 (EQO,EQSC,EQTS,EQEXID,EQTQID,EQSI) VALUES (#{bean.eqo},#{bean.eqsc},#{bean.eqts},#{bean.eqexid},#{bean.eqtqid},#{bean.eqsi})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.eqid")
  public void add(@Param("bean") Examquestion bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.eqo or mask.eqsc or mask.eqts or mask.eqexid or mask.eqtqid or mask.eqsi'>"
          + "UPDATE public.F1212 "
          + "<set>"
          + "<if test='mask.eqo'>EQO=#{bean.eqo}, </if>"
          + "<if test='mask.eqsc'>EQSC=#{bean.eqsc}, </if>"
          + "<if test='mask.eqts'>EQTS=#{bean.eqts}, </if>"
          + "<if test='mask.eqexid'>EQEXID=#{bean.eqexid}, </if>"
          + "<if test='mask.eqtqid'>EQTQID=#{bean.eqtqid}, </if>"
          + "<if test='mask.eqsi'>EQSI=#{bean.eqsi}, </if>"
          + "</set>"
          + "WHERE EQID=#{bean.eqid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1212 SET EQO=#{bean.eqo},EQSC=#{bean.eqsc},EQTS=#{bean.eqts},EQEXID=#{bean.eqexid},EQTQID=#{bean.eqtqid},EQSI=#{bean.eqsi} WHERE EQID=#{bean.eqid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Examquestion bean, @Param("mask") ExamquestionMask mask);

  @Delete("DELETE FROM public.F1212 WHERE EQID=#{eqid}")
  public boolean delete(@Param("eqid") Integer eqid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.eqid'>EQID, </if>"
          + "<if test='mask.eqexid'>EQEXID, </if>"
          + "<if test='mask.eqsi'>EQSI, </if>"
          + "<if test='mask.eqtqid'>EQTQID, </if>"
          + "<if test='mask.eqo'>EQO, </if>"
          + "<if test='mask.eqts'>EQTS, </if>"
          + "<if test='mask.eqsc'>EQSC, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT EQID,EQEXID,EQSI,EQTQID,EQO,EQTS,EQSC "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F1212 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Examquestion> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") ExamquestionMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F1212 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
