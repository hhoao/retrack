package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetFeetBackCategoryRelation;
import com.rare_earth_track.mgb.model.RetFeetBackCategoryRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetFeetBackCategoryRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetFeetBackCategoryRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetFeetBackCategoryRelationExample example);

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
    int insert(RetFeetBackCategoryRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetFeetBackCategoryRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetFeetBackCategoryRelation>
     */
    List<RetFeetBackCategoryRelation> selectByExample(RetFeetBackCategoryRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetFeetBackCategoryRelation
     */
    RetFeetBackCategoryRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetFeetBackCategoryRelation row, @Param("example") RetFeetBackCategoryRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetFeetBackCategoryRelation row, @Param("example") RetFeetBackCategoryRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetFeetBackCategoryRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetFeetBackCategoryRelation row);
}