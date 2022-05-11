package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetSubjectCategorySubjectRelation;
import com.rare_earth_track.mgb.model.RetSubjectCategorySubjectRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetSubjectCategorySubjectRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetSubjectCategorySubjectRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetSubjectCategorySubjectRelationExample example);

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
    int insert(RetSubjectCategorySubjectRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetSubjectCategorySubjectRelation record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetSubjectCategorySubjectRelation>
     */
    List<RetSubjectCategorySubjectRelation> selectByExample(RetSubjectCategorySubjectRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetSubjectCategorySubjectRelation
     */
    RetSubjectCategorySubjectRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetSubjectCategorySubjectRelation record, @Param("example") RetSubjectCategorySubjectRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetSubjectCategorySubjectRelation record, @Param("example") RetSubjectCategorySubjectRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetSubjectCategorySubjectRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetSubjectCategorySubjectRelation record);
}