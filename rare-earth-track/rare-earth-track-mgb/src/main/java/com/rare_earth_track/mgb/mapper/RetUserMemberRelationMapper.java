package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetUserMemberRelation;
import com.rare_earth_track.mgb.model.RetUserMemberRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetUserMemberRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetUserMemberRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetUserMemberRelationExample example);

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
    int insert(RetUserMemberRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetUserMemberRelation record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetUserMemberRelation>
     */
    List<RetUserMemberRelation> selectByExample(RetUserMemberRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetUserMemberRelation
     */
    RetUserMemberRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetUserMemberRelation record, @Param("example") RetUserMemberRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetUserMemberRelation record, @Param("example") RetUserMemberRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetUserMemberRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetUserMemberRelation record);
}