package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetUserAuth;
import com.rare_earth_track.mgb.model.RetUserAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetUserAuthMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetUserAuthExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetUserAuthExample example);

    /**
     * deleteByPrimaryKey
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert
     * @param row row
     * @return int
     */
    int insert(RetUserAuth row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetUserAuth row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetUserAuth>
     */
    List<RetUserAuth> selectByExample(RetUserAuthExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetUserAuth
     */
    RetUserAuth selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetUserAuth row, @Param("example") RetUserAuthExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetUserAuth row, @Param("example") RetUserAuthExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetUserAuth row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetUserAuth row);
}