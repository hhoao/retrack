package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetFeetBack;
import com.rare_earth_track.mgb.model.RetFeetBackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetFeetBackMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetFeetBackExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetFeetBackExample example);

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
    int insert(RetFeetBack record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetFeetBack record);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetFeetBack>
     */
    List<RetFeetBack> selectByExampleWithBLOBs(RetFeetBackExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetFeetBack>
     */
    List<RetFeetBack> selectByExample(RetFeetBackExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetFeetBack
     */
    RetFeetBack selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetFeetBack record, @Param("example") RetFeetBackExample example);

    /**
     * updateByExampleWithBLOBs
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") RetFeetBack record, @Param("example") RetFeetBackExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetFeetBack record, @Param("example") RetFeetBackExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetFeetBack record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetFeetBack record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetFeetBack record);
}