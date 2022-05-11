package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetMaterialDoubleCategoryDocumentRelation;
import com.rare_earth_track.mgb.model.RetMaterialDoubleCategoryDocumentRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMaterialDoubleCategoryDocumentRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMaterialDoubleCategoryDocumentRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMaterialDoubleCategoryDocumentRelationExample example);

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
    int insert(RetMaterialDoubleCategoryDocumentRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetMaterialDoubleCategoryDocumentRelation record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialDoubleCategoryDocumentRelation>
     */
    List<RetMaterialDoubleCategoryDocumentRelation> selectByExample(RetMaterialDoubleCategoryDocumentRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMaterialDoubleCategoryDocumentRelation
     */
    RetMaterialDoubleCategoryDocumentRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetMaterialDoubleCategoryDocumentRelation record, @Param("example") RetMaterialDoubleCategoryDocumentRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetMaterialDoubleCategoryDocumentRelation record, @Param("example") RetMaterialDoubleCategoryDocumentRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialDoubleCategoryDocumentRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetMaterialDoubleCategoryDocumentRelation record);
}