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
     * @param row row
     * @return int
     */
    int insert(RetResourceRoleRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetResourceRoleRelation row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetResourceRoleRelation row, @Param("example") RetResourceRoleRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetResourceRoleRelation row, @Param("example") RetResourceRoleRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetResourceRoleRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetResourceRoleRelation row);
}