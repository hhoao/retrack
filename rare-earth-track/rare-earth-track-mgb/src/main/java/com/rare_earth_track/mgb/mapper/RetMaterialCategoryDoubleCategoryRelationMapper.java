package com.rare_earth_track.mgb.mapper;

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
     * @param row row
     * @return int
     */
    int insert(RetMaterialCategoryDoubleCategoryRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMaterialCategoryDoubleCategoryRelation row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMaterialCategoryDoubleCategoryRelation row, @Param("example") RetMaterialCategoryDoubleCategoryRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMaterialCategoryDoubleCategoryRelation row, @Param("example") RetMaterialCategoryDoubleCategoryRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialCategoryDoubleCategoryRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMaterialCategoryDoubleCategoryRelation row);
}