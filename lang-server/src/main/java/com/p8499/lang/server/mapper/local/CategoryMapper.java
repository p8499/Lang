package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.CategoryMask;
import com.p8499.lang.server.bean.Category;

@Component("categoryMapper")
public interface CategoryMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F1030 WHERE CGID=#{cgid}")
  public boolean exists(@Param("cgid") Integer cgid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.cgid or mask.cglsid or mask.cgsi or mask.cgpsi or mask.cgusid or mask.cgname'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.cgid'>CGID, </if>"
          + "<if test='mask.cglsid'>CGLSID, </if>"
          + "<if test='mask.cgsi'>CGSI, </if>"
          + "<if test='mask.cgpsi'>CGPSI, </if>"
          + "<if test='mask.cgusid'>CGUSID, </if>"
          + "<if test='mask.cgname'>CGNAME, </if>"
          + "</trim>"
          + "FROM public.F1030 WHERE CGID=#{cgid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT CGID,CGLSID,CGSI,CGPSI,CGUSID,CGNAME FROM public.F1030 WHERE CGID=#{cgid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Category get(@Param("cgid") Integer cgid, @Param("mask") CategoryMask mask);

  @Insert(
      "INSERT INTO public.F1030 (CGPSI,CGNAME,CGSI,CGLSID,CGUSID) VALUES (#{bean.cgpsi},#{bean.cgname},#{bean.cgsi},#{bean.cglsid},#{bean.cgusid})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.cgid")
  public void add(@Param("bean") Category bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.cgpsi or mask.cgname or mask.cgsi or mask.cglsid or mask.cgusid'>"
          + "UPDATE public.F1030 "
          + "<set>"
          + "<if test='mask.cgpsi'>CGPSI=#{bean.cgpsi}, </if>"
          + "<if test='mask.cgname'>CGNAME=#{bean.cgname}, </if>"
          + "<if test='mask.cgsi'>CGSI=#{bean.cgsi}, </if>"
          + "<if test='mask.cglsid'>CGLSID=#{bean.cglsid}, </if>"
          + "<if test='mask.cgusid'>CGUSID=#{bean.cgusid}, </if>"
          + "</set>"
          + "WHERE CGID=#{bean.cgid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1030 SET CGPSI=#{bean.cgpsi},CGNAME=#{bean.cgname},CGSI=#{bean.cgsi},CGLSID=#{bean.cglsid},CGUSID=#{bean.cgusid} WHERE CGID=#{bean.cgid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Category bean, @Param("mask") CategoryMask mask);

  @Delete("DELETE FROM public.F1030 WHERE CGID=#{cgid}")
  public boolean delete(@Param("cgid") Integer cgid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.cgid'>CGID, </if>"
          + "<if test='mask.cglsid'>CGLSID, </if>"
          + "<if test='mask.cgsi'>CGSI, </if>"
          + "<if test='mask.cgpsi'>CGPSI, </if>"
          + "<if test='mask.cgusid'>CGUSID, </if>"
          + "<if test='mask.cgname'>CGNAME, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT CGID,CGLSID,CGSI,CGPSI,CGUSID,CGNAME "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F1030 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Category> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") CategoryMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F1030 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
