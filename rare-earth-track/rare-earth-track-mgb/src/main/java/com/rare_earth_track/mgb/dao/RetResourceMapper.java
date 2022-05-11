package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetResource;
import com.rare_earth_track.mgb.model.RetResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetResourceMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetResourceExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetResourceExample example);

    /**
     * deleteByPrimaryKey
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert
     * @param record record
     * @return int
     */
    int insert(RetResource record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetResource record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetResource>
     */
    List<RetResource> selectByExample(RetResourceExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetResource
     */
    RetResource selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetResource record, @Param("example") RetResourceExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetResource record, @Param("example") RetResourceExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetResource record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetResource record);
}