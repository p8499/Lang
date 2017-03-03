package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.RoleauthorityMask;
import com.p8499.lang.server.bean.Roleauthority;

@Component("roleauthorityMapper")
public interface RoleauthorityMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F0321 WHERE RAID=#{raid}")
  public boolean exists(@Param("raid") Integer raid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.raid or mask.rarlid or mask.raauid'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.raid'>RAID, </if>"
          + "<if test='mask.rarlid'>RARLID, </if>"
          + "<if test='mask.raauid'>RAAUID, </if>"
          + "</trim>"
          + "FROM public.F0321 WHERE RAID=#{raid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT RAID,RARLID,RAAUID FROM public.F0321 WHERE RAID=#{raid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Roleauthority get(@Param("raid") Integer raid, @Param("mask") RoleauthorityMask mask);

  @Insert("INSERT INTO public.F0321 (RARLID,RAAUID) VALUES (#{bean.rarlid},#{bean.raauid})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.raid")
  public void add(@Param("bean") Roleauthority bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.rarlid or mask.raauid'>"
          + "UPDATE public.F0321 "
          + "<set>"
          + "<if test='mask.rarlid'>RARLID=#{bean.rarlid}, </if>"
          + "<if test='mask.raauid'>RAAUID=#{bean.raauid}, </if>"
          + "</set>"
          + "WHERE RAID=#{bean.raid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F0321 SET RARLID=#{bean.rarlid},RAAUID=#{bean.raauid} WHERE RAID=#{bean.raid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Roleauthority bean, @Param("mask") RoleauthorityMask mask);

  @Delete("DELETE FROM public.F0321 WHERE RAID=#{raid}")
  public boolean delete(@Param("raid") Integer raid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.raid'>RAID, </if>"
          + "<if test='mask.rarlid'>RARLID, </if>"
          + "<if test='mask.raauid'>RAAUID, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT RAID,RARLID,RAAUID "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F0321 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Roleauthority> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") RoleauthorityMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F0321 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
