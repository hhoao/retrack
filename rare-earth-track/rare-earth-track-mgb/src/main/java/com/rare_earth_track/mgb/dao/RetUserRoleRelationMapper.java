package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetUserRoleRelation;
import com.rare_earth_track.mgb.model.RetUserRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetUserRoleRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetUserRoleRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetUserRoleRelationExample example);

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
    int insert(RetUserRoleRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetUserRoleRelation record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetUserRoleRelation>
     */
    List<RetUserRoleRelation> selectByExample(RetUserRoleRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetUserRoleRelation
     */
    RetUserRoleRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetUserRoleRelation record, @Param("example") RetUserRoleRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetUserRoleRelation record, @Param("example") RetUserRoleRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetUserRoleRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetUserRoleRelation record);
}