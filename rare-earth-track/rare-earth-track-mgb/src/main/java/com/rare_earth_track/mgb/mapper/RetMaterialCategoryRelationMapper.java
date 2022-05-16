package com.rare_earth_track.mgb.mapper;

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
     * @param row row
     * @return int
     */
    int insert(RetMaterialCategoryRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMaterialCategoryRelation row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMaterialCategoryRelation row, @Param("example") RetMaterialCategoryRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMaterialCategoryRelation row, @Param("example") RetMaterialCategoryRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialCategoryRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMaterialCategoryRelation row);
}