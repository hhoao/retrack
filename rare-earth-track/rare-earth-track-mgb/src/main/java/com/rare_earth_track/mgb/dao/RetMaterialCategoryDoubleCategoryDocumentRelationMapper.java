package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetMaterialCategoryDoubleCategoryDocumentRelation;
import com.rare_earth_track.mgb.model.RetMaterialCategoryDoubleCategoryDocumentRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMaterialCategoryDoubleCategoryDocumentRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMaterialCategoryDoubleCategoryDocumentRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMaterialCategoryDoubleCategoryDocumentRelationExample example);

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
    int insert(RetMaterialCategoryDoubleCategoryDocumentRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetMaterialCategoryDoubleCategoryDocumentRelation record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialCategoryDoubleCategoryDocumentRelation>
     */
    List<RetMaterialCategoryDoubleCategoryDocumentRelation> selectByExample(RetMaterialCategoryDoubleCategoryDocumentRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMaterialCategoryDoubleCategoryDocumentRelation
     */
    RetMaterialCategoryDoubleCategoryDocumentRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetMaterialCategoryDoubleCategoryDocumentRelation record, @Param("example") RetMaterialCategoryDoubleCategoryDocumentRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetMaterialCategoryDoubleCategoryDocumentRelation record, @Param("example") RetMaterialCategoryDoubleCategoryDocumentRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialCategoryDoubleCategoryDocumentRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetMaterialCategoryDoubleCategoryDocumentRelation record);
}