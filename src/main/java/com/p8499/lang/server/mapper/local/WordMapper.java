package com.p8499.lang.server.mapper.local;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.p8499.lang.server.mask.WordMask;
import com.p8499.lang.server.bean.Word;

@Component("wordMapper")
public interface WordMapper {
  @Select("SELECT COUNT(*)>0 FROM public.F1040 WHERE WOID=#{woid}")
  public boolean exists(@Param("woid") Integer woid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.woid or mask.wolsid or mask.wopt or mask.wohz or mask.wocl or mask.wost or mask.wosr or mask.wosort or mask.wocrdt or mask.woupdt'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.woid'>WOID, </if>"
          + "<if test='mask.wolsid'>WOLSID, </if>"
          + "<if test='mask.wopt'>WOPT, </if>"
          + "<if test='mask.wohz'>WOHZ, </if>"
          + "<if test='mask.wocl'>WOCL, </if>"
          + "<if test='mask.wost'>WOST, </if>"
          + "<if test='mask.wosr'>WOSR, </if>"
          + "<if test='mask.wosort'>WOSORT, </if>"
          + "<if test='mask.wocrdt'>WOCRDT, </if>"
          + "<if test='mask.woupdt'>WOUPDT, </if>"
          + "</trim>"
          + "FROM public.F1040 WHERE WOID=#{woid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "SELECT WOID,WOLSID,WOPT,WOHZ,WOCL,WOST,WOSR,WOSORT,WOCRDT,WOUPDT FROM public.F1040 WHERE WOID=#{woid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public Word get(@Param("woid") Integer woid, @Param("mask") WordMask mask);

  @Insert(
      "INSERT INTO public.F1040 (WOSR,WOUPDT,WOSORT,WOLSID,WOCL,WOPT,WOCRDT,WOHZ,WOST) VALUES (#{bean.wosr},#{bean.woupdt},#{bean.wosort},#{bean.wolsid},#{bean.wocl},#{bean.wopt},#{bean.wocrdt},#{bean.wohz},#{bean.wost})")
  @org.apache.ibatis.annotations.Options(useGeneratedKeys = true, keyProperty = "bean.woid")
  public void add(@Param("bean") Word bean);

  @Update(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<if test='mask.wosr or mask.woupdt or mask.wosort or mask.wolsid or mask.wocl or mask.wopt or mask.wocrdt or mask.wohz or mask.wost'>"
          + "UPDATE public.F1040 "
          + "<set>"
          + "<if test='mask.wosr'>WOSR=#{bean.wosr}, </if>"
          + "<if test='mask.woupdt'>WOUPDT=#{bean.woupdt}, </if>"
          + "<if test='mask.wosort'>WOSORT=#{bean.wosort}, </if>"
          + "<if test='mask.wolsid'>WOLSID=#{bean.wolsid}, </if>"
          + "<if test='mask.wocl'>WOCL=#{bean.wocl}, </if>"
          + "<if test='mask.wopt'>WOPT=#{bean.wopt}, </if>"
          + "<if test='mask.wocrdt'>WOCRDT=#{bean.wocrdt}, </if>"
          + "<if test='mask.wohz'>WOHZ=#{bean.wohz}, </if>"
          + "<if test='mask.wost'>WOST=#{bean.wost}, </if>"
          + "</set>"
          + "WHERE WOID=#{bean.woid}"
          + "</if>"
          + "</when>"
          + "<otherwise>"
          + "UPDATE public.F1040 SET WOSR=#{bean.wosr},WOUPDT=#{bean.woupdt},WOSORT=#{bean.wosort},WOLSID=#{bean.wolsid},WOCL=#{bean.wocl},WOPT=#{bean.wopt},WOCRDT=#{bean.wocrdt},WOHZ=#{bean.wohz},WOST=#{bean.wost} WHERE WOID=#{bean.woid}"
          + "</otherwise>"
          + "</choose>"
          + "</script>")
  public void update(@Param("bean") Word bean, @Param("mask") WordMask mask);

  @Delete("DELETE FROM public.F1040 WHERE WOID=#{woid}")
  public boolean delete(@Param("woid") Integer woid);

  @Select(
      "<script>"
          + "<choose>"
          + "<when test='mask!=null'>"
          + "<trim prefix='SELECT' suffixOverrides=','>"
          + "<if test='mask.woid'>WOID, </if>"
          + "<if test='mask.wolsid'>WOLSID, </if>"
          + "<if test='mask.wopt'>WOPT, </if>"
          + "<if test='mask.wohz'>WOHZ, </if>"
          + "<if test='mask.wocl'>WOCL, </if>"
          + "<if test='mask.wost'>WOST, </if>"
          + "<if test='mask.wosr'>WOSR, </if>"
          + "<if test='mask.wosort'>WOSORT, </if>"
          + "<if test='mask.wocrdt'>WOCRDT, </if>"
          + "<if test='mask.woupdt'>WOUPDT, </if>"
          + "</trim>"
          + "</when>"
          + "<otherwise>"
          + "SELECT WOID,WOLSID,WOPT,WOHZ,WOCL,WOST,WOSR,WOSORT,WOCRDT,WOUPDT "
          + "</otherwise>"
          + "</choose>"
          + "FROM public.F1040 "
          + "<if test='filter!=null'>WHERE ${filter} </if>"
          + "<if test='order!=null'>ORDER BY ${order} </if>"
          + "LIMIT #{count} OFFSET #{start}"
          + "</script>")
  public List<Word> query(
      @Param("filter") String filter,
      @Param("order") String order,
      @Param("start") long start,
      @Param("count") long count,
      @Param("mask") WordMask mask);

  @Select(
      "<script>"
          + "SELECT COUNT(*) FROM public.F1040 "
          + "<if test='filter!=null'>WHERE ${filter}</if> "
          + "</script>")
  public long count(@Param("filter") String filter);
}
