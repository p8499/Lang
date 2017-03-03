package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.UserMask;
import com.p8499.lang.server.bean.User;

@Component("userMapper")
public interface UserMapper {
  @Select("SELECT COUNT(*)>0 FROM public.V0301 WHERE USID=#{usid}")
  public boolean exists(@Param("usid") Integer usid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.usid or mask.uscell or mask.uspswd or mask.usname or mask.usst or mask.uslsid or mask.uslsname'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.usid'>USID, </if>"
          + "<if test='mask.uscell'>USCELL, </if>"
          + "<if test='mask.uspswd'>USPSWD, </if>"
          + "<if test='mask.usname'>USNAME, </if>"
          + "<if test='mask.usst'>USST, </if>"
          + "<if test='mask.uslsid'>USLSID, </if>"
          + "<if test='mask.uslsname'>USLSNAME, </if>"
          + "</trim>"
          + "FROM public.V0301 WHERE USID=#{usid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT USID,USCELL,USPSWD,USNAME,USST,USLSID,USLSNAME FROM public.V0301 WHERE USID=#{usid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public User get(@Param("usid") Integer usid, @Param("mask") UserMask mask);

  @Insert(
      "INSERT INTO public.F0301 (USNAME,USST,USCELL,USPSWD,USLSID) VALUES (#{bean.usname},#{bean.usst},#{bean.uscell},#{bean.uspswd},#{bean.uslsid})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.usid")
  public void add(@Param("bean") User bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.usname or mask.usst or mask.uscell or mask.uspswd or mask.uslsid'>"
          + "UPDATE public.F0301 "
          + "<set>"
          + "<if test='mask.usname'>USNAME=#{bean.usname}, </if>"
          + "<if test='mask.usst'>USST=#{bean.usst}, </if>"
          + "<if test='mask.uscell'>USCELL=#{bean.uscell}, </if>"
          + "<if test='mask.uspswd'>USPSWD=#{bean.uspswd}, </if>"
          + "<if test='mask.uslsid'>USLSID=#{bean.uslsid}, </if>"
          + "</set>"
          + "WHERE USID=#{bean.usid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F0301 SET USNAME=#{bean.usname},USST=#{bean.usst},USCELL=#{bean.uscell},USPSWD=#{bean.uspswd},USLSID=#{bean.uslsid} WHERE USID=#{bean.usid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") User bean, @Param("mask") UserMask mask);

  @Delete("DELETE FROM public.F0301 WHERE USID=#{usid}")
  public boolean delete(@Param("usid") Integer usid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.usid'>USID, </if>"
          + "<if test='mask.uscell'>USCELL, </if>"
          + "<if test='mask.uspswd'>USPSWD, </if>"
          + "<if test='mask.usname'>USNAME, </if>"
          + "<if test='mask.usst'>USST, </if>"
          + "<if test='mask.uslsid'>USLSID, </if>"
          + "<if test='mask.uslsname'>USLSNAME, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT USID,USCELL,USPSWD,USNAME,USST,USLSID,USLSNAME "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.V0301 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<User> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") UserMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.V0301 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
