package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.CertificateMask;
import com.p8499.lang.server.bean.Certificate;

@Component("certificateMapper")
public interface CertificateMapper {
  @Select("SELECT COUNT(*)>0 FROM public.V0331 WHERE CRID=#{crid}")
  public boolean exists(@Param("crid") Integer crid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.crid or mask.crusid or mask.crlsid or mask.crlsname or mask.crlsloc or mask.crlv or mask.crefdt or mask.crexdt'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.crid'>CRID, </if>"
          + "<if test='mask.crusid'>CRUSID, </if>"
          + "<if test='mask.crlsid'>CRLSID, </if>"
          + "<if test='mask.crlsname'>CRLSNAME, </if>"
          + "<if test='mask.crlsloc'>CRLSLOC, </if>"
          + "<if test='mask.crlv'>CRLV, </if>"
          + "<if test='mask.crefdt'>CREFDT, </if>"
          + "<if test='mask.crexdt'>CREXDT, </if>"
          + "</trim>"
          + "FROM public.V0331 WHERE CRID=#{crid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT CRID,CRUSID,CRLSID,CRLSNAME,CRLSLOC,CRLV,CREFDT,CREXDT FROM public.V0331 WHERE CRID=#{crid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Certificate get(@Param("crid") Integer crid, @Param("mask") CertificateMask mask);

  @Insert(
      "INSERT INTO public.F0331 (CRUSID,CREFDT,CRLV,CREXDT,CRLSID) VALUES (#{bean.crusid},#{bean.crefdt},#{bean.crlv},#{bean.crexdt},#{bean.crlsid})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.crid")
  public void add(@Param("bean") Certificate bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.crusid or mask.crefdt or mask.crlv or mask.crexdt or mask.crlsid'>"
          + "UPDATE public.F0331 "
          + "<set>"
          + "<if test='mask.crusid'>CRUSID=#{bean.crusid}, </if>"
          + "<if test='mask.crefdt'>CREFDT=#{bean.crefdt}, </if>"
          + "<if test='mask.crlv'>CRLV=#{bean.crlv}, </if>"
          + "<if test='mask.crexdt'>CREXDT=#{bean.crexdt}, </if>"
          + "<if test='mask.crlsid'>CRLSID=#{bean.crlsid}, </if>"
          + "</set>"
          + "WHERE CRID=#{bean.crid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F0331 SET CRUSID=#{bean.crusid},CREFDT=#{bean.crefdt},CRLV=#{bean.crlv},CREXDT=#{bean.crexdt},CRLSID=#{bean.crlsid} WHERE CRID=#{bean.crid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Certificate bean, @Param("mask") CertificateMask mask);

  @Delete("DELETE FROM public.F0331 WHERE CRID=#{crid}")
  public boolean delete(@Param("crid") Integer crid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.crid'>CRID, </if>"
          + "<if test='mask.crusid'>CRUSID, </if>"
          + "<if test='mask.crlsid'>CRLSID, </if>"
          + "<if test='mask.crlsname'>CRLSNAME, </if>"
          + "<if test='mask.crlsloc'>CRLSLOC, </if>"
          + "<if test='mask.crlv'>CRLV, </if>"
          + "<if test='mask.crefdt'>CREFDT, </if>"
          + "<if test='mask.crexdt'>CREXDT, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT CRID,CRUSID,CRLSID,CRLSNAME,CRLSLOC,CRLV,CREFDT,CREXDT "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.V0331 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Certificate> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") CertificateMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.V0331 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
