package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.AuthorityMask;
import com.p8499.lang.server.bean.Authority;

@Component("authorityMapper")
public interface AuthorityMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F0320 WHERE AUID=#{auid}")
  public boolean exists(@Param("auid") String auid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.auid or mask.auname'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.auid'>AUID, </if>"
          + "<if test='mask.auname'>AUNAME, </if>"
          + "</trim>"
          + "FROM public.F0320 WHERE AUID=#{auid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT AUID,AUNAME FROM public.F0320 WHERE AUID=#{auid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Authority get(@Param("auid") String auid, @Param("mask") AuthorityMask mask);

  @Insert("INSERT INTO public.F0320 (AUID,AUNAME) VALUES (#{bean.auid},#{bean.auname})")
  public void add(@Param("bean") Authority bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.auname'>"
          + "UPDATE public.F0320 "
          + "<set>"
          + "<if test='mask.auname'>AUNAME=#{bean.auname}, </if>"
          + "</set>"
          + "WHERE AUID=#{bean.auid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F0320 SET AUNAME=#{bean.auname} WHERE AUID=#{bean.auid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Authority bean, @Param("mask") AuthorityMask mask);

  @Delete("DELETE FROM public.F0320 WHERE AUID=#{auid}")
  public boolean delete(@Param("auid") String auid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.auid'>AUID, </if>"
          + "<if test='mask.auname'>AUNAME, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT AUID,AUNAME "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F0320 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Authority> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") AuthorityMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F0320 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
