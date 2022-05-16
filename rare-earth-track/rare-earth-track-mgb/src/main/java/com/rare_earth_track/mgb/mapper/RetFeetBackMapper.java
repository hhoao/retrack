package com.rare_earth_track.mgb.mapper;

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
     * @param row row
     * @return int
     */
    int insert(RetFeetBack row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetFeetBack row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetFeetBack row, @Param("example") RetFeetBackExample example);

    /**
     * updateByExampleWithBLOBs
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("row") RetFeetBack row, @Param("example") RetFeetBackExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetFeetBack row, @Param("example") RetFeetBackExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetFeetBack row);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param row row
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetFeetBack row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetFeetBack row);
}