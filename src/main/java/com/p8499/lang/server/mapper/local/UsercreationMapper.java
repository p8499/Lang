package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.UsercreationMask;
import com.p8499.lang.server.bean.Usercreation;

@Component("usercreationMapper")
public interface UsercreationMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F0309 WHERE UCID=#{ucid}")
  public boolean exists(@Param("ucid") Integer ucid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.ucid or mask.uccrdt or mask.ucupdt or mask.uccell or mask.ucpv or mask.ucmv or mask.ucac or mask.ucst'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.ucid'>UCID, </if>"
          + "<if test='mask.uccrdt'>UCCRDT, </if>"
          + "<if test='mask.ucupdt'>UCUPDT, </if>"
          + "<if test='mask.uccell'>UCCELL, </if>"
          + "<if test='mask.ucpv'>UCPV, </if>"
          + "<if test='mask.ucmv'>UCMV, </if>"
          + "<if test='mask.ucac'>UCAC, </if>"
          + "<if test='mask.ucst'>UCST, </if>"
          + "</trim>"
          + "FROM public.F0309 WHERE UCID=#{ucid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT UCID,UCCRDT,UCUPDT,UCCELL,UCPV,UCMV,UCAC,UCST FROM public.F0309 WHERE UCID=#{ucid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Usercreation get(@Param("ucid") Integer ucid, @Param("mask") UsercreationMask mask);

  @Insert(
      "INSERT INTO public.F0309 (UCMV,UCPV,UCCRDT,UCAC,UCCELL,UCUPDT,UCST) VALUES (#{bean.ucmv},#{bean.ucpv},#{bean.uccrdt},#{bean.ucac},#{bean.uccell},#{bean.ucupdt},#{bean.ucst})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.ucid")
  public void add(@Param("bean") Usercreation bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.ucmv or mask.ucpv or mask.uccrdt or mask.ucac or mask.uccell or mask.ucupdt or mask.ucst'>"
          + "UPDATE public.F0309 "
          + "<set>"
          + "<if test='mask.ucmv'>UCMV=#{bean.ucmv}, </if>"
          + "<if test='mask.ucpv'>UCPV=#{bean.ucpv}, </if>"
          + "<if test='mask.uccrdt'>UCCRDT=#{bean.uccrdt}, </if>"
          + "<if test='mask.ucac'>UCAC=#{bean.ucac}, </if>"
          + "<if test='mask.uccell'>UCCELL=#{bean.uccell}, </if>"
          + "<if test='mask.ucupdt'>UCUPDT=#{bean.ucupdt}, </if>"
          + "<if test='mask.ucst'>UCST=#{bean.ucst}, </if>"
          + "</set>"
          + "WHERE UCID=#{bean.ucid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F0309 SET UCMV=#{bean.ucmv},UCPV=#{bean.ucpv},UCCRDT=#{bean.uccrdt},UCAC=#{bean.ucac},UCCELL=#{bean.uccell},UCUPDT=#{bean.ucupdt},UCST=#{bean.ucst} WHERE UCID=#{bean.ucid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Usercreation bean, @Param("mask") UsercreationMask mask);

  @Delete("DELETE FROM public.F0309 WHERE UCID=#{ucid}")
  public boolean delete(@Param("ucid") Integer ucid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.ucid'>UCID, </if>"
          + "<if test='mask.uccrdt'>UCCRDT, </if>"
          + "<if test='mask.ucupdt'>UCUPDT, </if>"
          + "<if test='mask.uccell'>UCCELL, </if>"
          + "<if test='mask.ucpv'>UCPV, </if>"
          + "<if test='mask.ucmv'>UCMV, </if>"
          + "<if test='mask.ucac'>UCAC, </if>"
          + "<if test='mask.ucst'>UCST, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT UCID,UCCRDT,UCUPDT,UCCELL,UCPV,UCMV,UCAC,UCST "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F0309 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Usercreation> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") UsercreationMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F0309 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
