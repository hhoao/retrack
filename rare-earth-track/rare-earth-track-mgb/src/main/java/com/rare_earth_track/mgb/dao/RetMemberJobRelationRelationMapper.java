package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetMemberJobRelationRelation;
import com.rare_earth_track.mgb.model.RetMemberJobRelationRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RetMemberJobRelationRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMemberJobRelationRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMemberJobRelationRelationExample example);

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
    int insert(RetMemberJobRelationRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetMemberJobRelationRelation record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMemberJobRelationRelation>
     */
    List<RetMemberJobRelationRelation> selectByExample(RetMemberJobRelationRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMemberJobRelationRelation
     */
    RetMemberJobRelationRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetMemberJobRelationRelation record, @Param("example") RetMemberJobRelationRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetMemberJobRelationRelation record, @Param("example") RetMemberJobRelationRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetMemberJobRelationRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetMemberJobRelationRelation record);
}