package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetResourceRoleRelation;
import com.rare_earth_track.mgb.model.RetResourceRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetResourceRoleRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetResourceRoleRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetResourceRoleRelationExample example);

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
    int insert(RetResourceRoleRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetResourceRoleRelation record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetResourceRoleRelation>
     */
    List<RetResourceRoleRelation> selectByExample(RetResourceRoleRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetResourceRoleRelation
     */
    RetResourceRoleRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetResourceRoleRelation record, @Param("example") RetResourceRoleRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetResourceRoleRelation record, @Param("example") RetResourceRoleRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetResourceRoleRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetResourceRoleRelation record);
}