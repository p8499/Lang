package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.UserroleMask;
import com.p8499.lang.server.bean.Userrole;

@Component("userroleMapper")
public interface UserroleMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F0311 WHERE URID=#{urid}")
  public boolean exists(@Param("urid") Integer urid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.urid or mask.urusid or mask.urrlid'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.urid'>URID, </if>"
          + "<if test='mask.urusid'>URUSID, </if>"
          + "<if test='mask.urrlid'>URRLID, </if>"
          + "</trim>"
          + "FROM public.F0311 WHERE URID=#{urid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT URID,URUSID,URRLID FROM public.F0311 WHERE URID=#{urid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Userrole get(@Param("urid") Integer urid, @Param("mask") UserroleMask mask);

  @Insert("INSERT INTO public.F0311 (URRLID,URUSID) VALUES (#{bean.urrlid},#{bean.urusid})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.urid")
  public void add(@Param("bean") Userrole bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.urrlid or mask.urusid'>"
          + "UPDATE public.F0311 "
          + "<set>"
          + "<if test='mask.urrlid'>URRLID=#{bean.urrlid}, </if>"
          + "<if test='mask.urusid'>URUSID=#{bean.urusid}, </if>"
          + "</set>"
          + "WHERE URID=#{bean.urid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F0311 SET URRLID=#{bean.urrlid},URUSID=#{bean.urusid} WHERE URID=#{bean.urid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Userrole bean, @Param("mask") UserroleMask mask);

  @Delete("DELETE FROM public.F0311 WHERE URID=#{urid}")
  public boolean delete(@Param("urid") Integer urid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.urid'>URID, </if>"
          + "<if test='mask.urusid'>URUSID, </if>"
          + "<if test='mask.urrlid'>URRLID, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT URID,URUSID,URRLID "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F0311 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Userrole> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") UserroleMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F0311 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
