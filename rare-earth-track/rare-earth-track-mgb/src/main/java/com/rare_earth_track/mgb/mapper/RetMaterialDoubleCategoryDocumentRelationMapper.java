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
     * @param row row
     * @return int
     */
    int insert(RetMaterialDoubleCategoryDocumentRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMaterialDoubleCategoryDocumentRelation row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMaterialDoubleCategoryDocumentRelation row, @Param("example") RetMaterialDoubleCategoryDocumentRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMaterialDoubleCategoryDocumentRelation row, @Param("example") RetMaterialDoubleCategoryDocumentRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialDoubleCategoryDocumentRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMaterialDoubleCategoryDocumentRelation row);
}