package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.RoleMask;
import com.p8499.lang.server.bean.Role;

@Component("roleMapper")
public interface RoleMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F0310 WHERE RLID=#{rlid}")
  public boolean exists(@Param("rlid") String rlid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.rlid or mask.rlname'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.rlid'>RLID, </if>"
          + "<if test='mask.rlname'>RLNAME, </if>"
          + "</trim>"
          + "FROM public.F0310 WHERE RLID=#{rlid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT RLID,RLNAME FROM public.F0310 WHERE RLID=#{rlid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Role get(@Param("rlid") String rlid, @Param("mask") RoleMask mask);

  @Insert("INSERT INTO public.F0310 (RLID,RLNAME) VALUES (#{bean.rlid},#{bean.rlname})")
  public void add(@Param("bean") Role bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.rlname'>"
          + "UPDATE public.F0310 "
          + "<set>"
          + "<if test='mask.rlname'>RLNAME=#{bean.rlname}, </if>"
          + "</set>"
          + "WHERE RLID=#{bean.rlid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F0310 SET RLNAME=#{bean.rlname} WHERE RLID=#{bean.rlid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Role bean, @Param("mask") RoleMask mask);

  @Delete("DELETE FROM public.F0310 WHERE RLID=#{rlid}")
  public boolean delete(@Param("rlid") String rlid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.rlid'>RLID, </if>"
          + "<if test='mask.rlname'>RLNAME, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT RLID,RLNAME "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F0310 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Role> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") RoleMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F0310 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
