package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.ArticleMask;
import com.p8499.lang.server.bean.Article;

@Component("articleMapper")
public interface ArticleMapper {
  @Select("SELECT COUNT(*)>0 FROM public.V1110 WHERE ATID=#{atid}")
  public boolean exists(@Param("atid") Integer atid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.atid or mask.atcgid or mask.atsi or mask.atname or mask.atusid or mask.atbrf or mask.atcsa or mask.atcsb or mask.atcsc or mask.atcsd or mask.atcse or mask.atcsf or mask.atcrdt or mask.atupdt'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.atid'>ATID, </if>"
          + "<if test='mask.atcgid'>ATCGID, </if>"
          + "<if test='mask.atsi'>ATSI, </if>"
          + "<if test='mask.atname'>ATNAME, </if>"
          + "<if test='mask.atusid'>ATUSID, </if>"
          + "<if test='mask.atbrf'>ATBRF, </if>"
          + "<if test='mask.atcsa'>ATCSA, </if>"
          + "<if test='mask.atcsb'>ATCSB, </if>"
          + "<if test='mask.atcsc'>ATCSC, </if>"
          + "<if test='mask.atcsd'>ATCSD, </if>"
          + "<if test='mask.atcse'>ATCSE, </if>"
          + "<if test='mask.atcsf'>ATCSF, </if>"
          + "<if test='mask.atcrdt'>ATCRDT, </if>"
          + "<if test='mask.atupdt'>ATUPDT, </if>"
          + "</trim>"
          + "FROM public.V1110 WHERE ATID=#{atid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT ATID,ATCGID,ATSI,ATNAME,ATUSID,ATBRF,ATCSA,ATCSB,ATCSC,ATCSD,ATCSE,ATCSF,ATCRDT,ATUPDT FROM public.V1110 WHERE ATID=#{atid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Article get(@Param("atid") Integer atid, @Param("mask") ArticleMask mask);

  @Insert(
      "INSERT INTO public.F1110 (ATUPDT,ATNAME,ATSI,ATCGID,ATCRDT,ATUSID) VALUES (#{bean.atupdt},#{bean.atname},#{bean.atsi},#{bean.atcgid},#{bean.atcrdt},#{bean.atusid})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.atid")
  public void add(@Param("bean") Article bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.atupdt or mask.atname or mask.atsi or mask.atcgid or mask.atcrdt or mask.atusid'>"
          + "UPDATE public.F1110 "
          + "<set>"
          + "<if test='mask.atupdt'>ATUPDT=#{bean.atupdt}, </if>"
          + "<if test='mask.atname'>ATNAME=#{bean.atname}, </if>"
          + "<if test='mask.atsi'>ATSI=#{bean.atsi}, </if>"
          + "<if test='mask.atcgid'>ATCGID=#{bean.atcgid}, </if>"
          + "<if test='mask.atcrdt'>ATCRDT=#{bean.atcrdt}, </if>"
          + "<if test='mask.atusid'>ATUSID=#{bean.atusid}, </if>"
          + "</set>"
          + "WHERE ATID=#{bean.atid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1110 SET ATUPDT=#{bean.atupdt},ATNAME=#{bean.atname},ATSI=#{bean.atsi},ATCGID=#{bean.atcgid},ATCRDT=#{bean.atcrdt},ATUSID=#{bean.atusid} WHERE ATID=#{bean.atid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Article bean, @Param("mask") ArticleMask mask);

  @Delete("DELETE FROM public.F1110 WHERE ATID=#{atid}")
  public boolean delete(@Param("atid") Integer atid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.atid'>ATID, </if>"
          + "<if test='mask.atcgid'>ATCGID, </if>"
          + "<if test='mask.atsi'>ATSI, </if>"
          + "<if test='mask.atname'>ATNAME, </if>"
          + "<if test='mask.atusid'>ATUSID, </if>"
          + "<if test='mask.atbrf'>ATBRF, </if>"
          + "<if test='mask.atcsa'>ATCSA, </if>"
          + "<if test='mask.atcsb'>ATCSB, </if>"
          + "<if test='mask.atcsc'>ATCSC, </if>"
          + "<if test='mask.atcsd'>ATCSD, </if>"
          + "<if test='mask.atcse'>ATCSE, </if>"
          + "<if test='mask.atcsf'>ATCSF, </if>"
          + "<if test='mask.atcrdt'>ATCRDT, </if>"
          + "<if test='mask.atupdt'>ATUPDT, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT ATID,ATCGID,ATSI,ATNAME,ATUSID,ATBRF,ATCSA,ATCSB,ATCSC,ATCSD,ATCSE,ATCSF,ATCRDT,ATUPDT "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.V1110 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Article> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") ArticleMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.V1110 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
