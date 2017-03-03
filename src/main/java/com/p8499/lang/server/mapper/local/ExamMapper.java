package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.ExamMask;
import com.p8499.lang.server.bean.Exam;

@Component("examMapper")
public interface ExamMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F1211 WHERE EXID=#{exid}")
  public boolean exists(@Param("exid") Integer exid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.exid or mask.exusid or mask.exsi or mask.exlsid or mask.exlv or mask.excrdt or mask.exupdt or mask.exts or mask.exsc'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.exid'>EXID, </if>"
          + "<if test='mask.exusid'>EXUSID, </if>"
          + "<if test='mask.exsi'>EXSI, </if>"
          + "<if test='mask.exlsid'>EXLSID, </if>"
          + "<if test='mask.exlv'>EXLV, </if>"
          + "<if test='mask.excrdt'>EXCRDT, </if>"
          + "<if test='mask.exupdt'>EXUPDT, </if>"
          + "<if test='mask.exts'>EXTS, </if>"
          + "<if test='mask.exsc'>EXSC, </if>"
          + "</trim>"
          + "FROM public.F1211 WHERE EXID=#{exid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT EXID,EXUSID,EXSI,EXLSID,EXLV,EXCRDT,EXUPDT,EXTS,EXSC FROM public.F1211 WHERE EXID=#{exid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Exam get(@Param("exid") Integer exid, @Param("mask") ExamMask mask);

  @Insert(
      "INSERT INTO public.F1211 (EXCRDT,EXLSID,EXLV,EXUPDT,EXSI,EXUSID,EXSC,EXTS) VALUES (#{bean.excrdt},#{bean.exlsid},#{bean.exlv},#{bean.exupdt},#{bean.exsi},#{bean.exusid},#{bean.exsc},#{bean.exts})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.exid")
  public void add(@Param("bean") Exam bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.excrdt or mask.exlsid or mask.exlv or mask.exupdt or mask.exsi or mask.exusid or mask.exsc or mask.exts'>"
          + "UPDATE public.F1211 "
          + "<set>"
          + "<if test='mask.excrdt'>EXCRDT=#{bean.excrdt}, </if>"
          + "<if test='mask.exlsid'>EXLSID=#{bean.exlsid}, </if>"
          + "<if test='mask.exlv'>EXLV=#{bean.exlv}, </if>"
          + "<if test='mask.exupdt'>EXUPDT=#{bean.exupdt}, </if>"
          + "<if test='mask.exsi'>EXSI=#{bean.exsi}, </if>"
          + "<if test='mask.exusid'>EXUSID=#{bean.exusid}, </if>"
          + "<if test='mask.exsc'>EXSC=#{bean.exsc}, </if>"
          + "<if test='mask.exts'>EXTS=#{bean.exts}, </if>"
          + "</set>"
          + "WHERE EXID=#{bean.exid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1211 SET EXCRDT=#{bean.excrdt},EXLSID=#{bean.exlsid},EXLV=#{bean.exlv},EXUPDT=#{bean.exupdt},EXSI=#{bean.exsi},EXUSID=#{bean.exusid},EXSC=#{bean.exsc},EXTS=#{bean.exts} WHERE EXID=#{bean.exid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Exam bean, @Param("mask") ExamMask mask);

  @Delete("DELETE FROM public.F1211 WHERE EXID=#{exid}")
  public boolean delete(@Param("exid") Integer exid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.exid'>EXID, </if>"
          + "<if test='mask.exusid'>EXUSID, </if>"
          + "<if test='mask.exsi'>EXSI, </if>"
          + "<if test='mask.exlsid'>EXLSID, </if>"
          + "<if test='mask.exlv'>EXLV, </if>"
          + "<if test='mask.excrdt'>EXCRDT, </if>"
          + "<if test='mask.exupdt'>EXUPDT, </if>"
          + "<if test='mask.exts'>EXTS, </if>"
          + "<if test='mask.exsc'>EXSC, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT EXID,EXUSID,EXSI,EXLSID,EXLV,EXCRDT,EXUPDT,EXTS,EXSC "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F1211 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Exam> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") ExamMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F1211 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
