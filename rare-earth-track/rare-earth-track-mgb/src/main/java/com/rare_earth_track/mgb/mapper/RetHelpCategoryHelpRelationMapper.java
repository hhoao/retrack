package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetHelpCategoryHelpRelation;
import com.rare_earth_track.mgb.model.RetHelpCategoryHelpRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetHelpCategoryHelpRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetHelpCategoryHelpRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetHelpCategoryHelpRelationExample example);

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
    int insert(RetHelpCategoryHelpRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetHelpCategoryHelpRelation record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetHelpCategoryHelpRelation>
     */
    List<RetHelpCategoryHelpRelation> selectByExample(RetHelpCategoryHelpRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetHelpCategoryHelpRelation
     */
    RetHelpCategoryHelpRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetHelpCategoryHelpRelation record, @Param("example") RetHelpCategoryHelpRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetHelpCategoryHelpRelation record, @Param("example") RetHelpCategoryHelpRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetHelpCategoryHelpRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetHelpCategoryHelpRelation record);
}