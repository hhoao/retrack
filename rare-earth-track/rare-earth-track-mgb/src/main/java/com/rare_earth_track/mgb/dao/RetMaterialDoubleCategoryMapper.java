package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetMaterialDoubleCategory;
import com.rare_earth_track.mgb.model.RetMaterialDoubleCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMaterialDoubleCategoryMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMaterialDoubleCategoryExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMaterialDoubleCategoryExample example);

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
    int insert(RetMaterialDoubleCategory record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetMaterialDoubleCategory record);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialDoubleCategory>
     */
    List<RetMaterialDoubleCategory> selectByExampleWithBLOBs(RetMaterialDoubleCategoryExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialDoubleCategory>
     */
    List<RetMaterialDoubleCategory> selectByExample(RetMaterialDoubleCategoryExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMaterialDoubleCategory
     */
    RetMaterialDoubleCategory selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetMaterialDoubleCategory record, @Param("example") RetMaterialDoubleCategoryExample example);

    /**
     * updateByExampleWithBLOBs
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") RetMaterialDoubleCategory record, @Param("example") RetMaterialDoubleCategoryExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetMaterialDoubleCategory record, @Param("example") RetMaterialDoubleCategoryExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialDoubleCategory record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetMaterialDoubleCategory record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetMaterialDoubleCategory record);
}