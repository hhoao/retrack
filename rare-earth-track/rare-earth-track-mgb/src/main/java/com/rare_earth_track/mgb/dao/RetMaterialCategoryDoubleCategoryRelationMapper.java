package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetMaterialCategoryDoubleCategoryRelation;
import com.rare_earth_track.mgb.model.RetMaterialCategoryDoubleCategoryRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMaterialCategoryDoubleCategoryRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMaterialCategoryDoubleCategoryRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMaterialCategoryDoubleCategoryRelationExample example);

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
    int insert(RetMaterialCategoryDoubleCategoryRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetMaterialCategoryDoubleCategoryRelation record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialCategoryDoubleCategoryRelation>
     */
    List<RetMaterialCategoryDoubleCategoryRelation> selectByExample(RetMaterialCategoryDoubleCategoryRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMaterialCategoryDoubleCategoryRelation
     */
    RetMaterialCategoryDoubleCategoryRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetMaterialCategoryDoubleCategoryRelation record, @Param("example") RetMaterialCategoryDoubleCategoryRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetMaterialCategoryDoubleCategoryRelation record, @Param("example") RetMaterialCategoryDoubleCategoryRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialCategoryDoubleCategoryRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetMaterialCategoryDoubleCategoryRelation record);
}