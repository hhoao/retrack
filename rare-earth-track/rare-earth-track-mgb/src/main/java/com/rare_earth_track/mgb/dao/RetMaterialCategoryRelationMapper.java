package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetMaterialCategoryRelation;
import com.rare_earth_track.mgb.model.RetMaterialCategoryRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMaterialCategoryRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMaterialCategoryRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMaterialCategoryRelationExample example);

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
    int insert(RetMaterialCategoryRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetMaterialCategoryRelation record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialCategoryRelation>
     */
    List<RetMaterialCategoryRelation> selectByExample(RetMaterialCategoryRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMaterialCategoryRelation
     */
    RetMaterialCategoryRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetMaterialCategoryRelation record, @Param("example") RetMaterialCategoryRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetMaterialCategoryRelation record, @Param("example") RetMaterialCategoryRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialCategoryRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetMaterialCategoryRelation record);
}