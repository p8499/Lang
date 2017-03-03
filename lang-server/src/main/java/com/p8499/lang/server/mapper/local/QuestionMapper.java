package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.QuestionMask;
import com.p8499.lang.server.bean.Question;

@Component("questionMapper")
public interface QuestionMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F1201 WHERE TQID=#{tqid}")
  public boolean exists(@Param("tqid") Integer tqid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.tqid or mask.tqlsid or mask.tqlv or mask.tqty or mask.tqcont or mask.tqo or mask.tqst'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.tqid'>TQID, </if>"
          + "<if test='mask.tqlsid'>TQLSID, </if>"
          + "<if test='mask.tqlv'>TQLV, </if>"
          + "<if test='mask.tqty'>TQTY, </if>"
          + "<if test='mask.tqcont'>TQCONT, </if>"
          + "<if test='mask.tqo'>TQO, </if>"
          + "<if test='mask.tqst'>TQST, </if>"
          + "</trim>"
          + "FROM public.F1201 WHERE TQID=#{tqid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT TQID,TQLSID,TQLV,TQTY,TQCONT,TQO,TQST FROM public.F1201 WHERE TQID=#{tqid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Question get(@Param("tqid") Integer tqid, @Param("mask") QuestionMask mask);

  @Insert(
      "INSERT INTO public.F1201 (TQLV,TQLSID,TQO,TQTY,TQCONT,TQST) VALUES (#{bean.tqlv},#{bean.tqlsid},#{bean.tqo},#{bean.tqty},#{bean.tqcont},#{bean.tqst})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.tqid")
  public void add(@Param("bean") Question bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.tqlv or mask.tqlsid or mask.tqo or mask.tqty or mask.tqcont or mask.tqst'>"
          + "UPDATE public.F1201 "
          + "<set>"
          + "<if test='mask.tqlv'>TQLV=#{bean.tqlv}, </if>"
          + "<if test='mask.tqlsid'>TQLSID=#{bean.tqlsid}, </if>"
          + "<if test='mask.tqo'>TQO=#{bean.tqo}, </if>"
          + "<if test='mask.tqty'>TQTY=#{bean.tqty}, </if>"
          + "<if test='mask.tqcont'>TQCONT=#{bean.tqcont}, </if>"
          + "<if test='mask.tqst'>TQST=#{bean.tqst}, </if>"
          + "</set>"
          + "WHERE TQID=#{bean.tqid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1201 SET TQLV=#{bean.tqlv},TQLSID=#{bean.tqlsid},TQO=#{bean.tqo},TQTY=#{bean.tqty},TQCONT=#{bean.tqcont},TQST=#{bean.tqst} WHERE TQID=#{bean.tqid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Question bean, @Param("mask") QuestionMask mask);

  @Delete("DELETE FROM public.F1201 WHERE TQID=#{tqid}")
  public boolean delete(@Param("tqid") Integer tqid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.tqid'>TQID, </if>"
          + "<if test='mask.tqlsid'>TQLSID, </if>"
          + "<if test='mask.tqlv'>TQLV, </if>"
          + "<if test='mask.tqty'>TQTY, </if>"
          + "<if test='mask.tqcont'>TQCONT, </if>"
          + "<if test='mask.tqo'>TQO, </if>"
          + "<if test='mask.tqst'>TQST, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT TQID,TQLSID,TQLV,TQTY,TQCONT,TQO,TQST "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F1201 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Question> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") QuestionMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F1201 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
