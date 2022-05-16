package com.rare_earth_track.mgb.mapper;

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
     * @param row row
     * @return int
     */
    int insert(RetMaterialCategoryDoubleCategoryDocumentRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMaterialCategoryDoubleCategoryDocumentRelation row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMaterialCategoryDoubleCategoryDocumentRelation row, @Param("example") RetMaterialCategoryDoubleCategoryDocumentRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMaterialCategoryDoubleCategoryDocumentRelation row, @Param("example") RetMaterialCategoryDoubleCategoryDocumentRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialCategoryDoubleCategoryDocumentRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMaterialCategoryDoubleCategoryDocumentRelation row);
}