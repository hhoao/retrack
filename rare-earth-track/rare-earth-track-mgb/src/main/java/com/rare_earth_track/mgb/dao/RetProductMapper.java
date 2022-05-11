package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.mgb.model.RetProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetProductMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetProductExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetProductExample example);

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
    int insert(RetProduct record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetProduct record);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetProduct>
     */
    List<RetProduct> selectByExampleWithBLOBs(RetProductExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetProduct>
     */
    List<RetProduct> selectByExample(RetProductExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetProduct
     */
    RetProduct selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetProduct record, @Param("example") RetProductExample example);

    /**
     * updateByExampleWithBLOBs
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") RetProduct record, @Param("example") RetProductExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetProduct record, @Param("example") RetProductExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetProduct record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetProduct record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetProduct record);
}