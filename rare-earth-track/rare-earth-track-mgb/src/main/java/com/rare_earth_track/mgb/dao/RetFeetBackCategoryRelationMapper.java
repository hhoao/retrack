package com.rare_earth_track.mgb.dao;

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
     * @param record record
     * @return int
     */
    int insert(RetFeetBackCategoryRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetFeetBackCategoryRelation record);

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
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetFeetBackCategoryRelation record, @Param("example") RetFeetBackCategoryRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetFeetBackCategoryRelation record, @Param("example") RetFeetBackCategoryRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetFeetBackCategoryRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetFeetBackCategoryRelation record);
}