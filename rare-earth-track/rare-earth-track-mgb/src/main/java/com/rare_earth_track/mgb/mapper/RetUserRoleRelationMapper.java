package com.rare_earth_track.mgb.mapper;

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
     * @param row row
     * @return int
     */
    int insert(RetUserRoleRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetUserRoleRelation row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetUserRoleRelation row, @Param("example") RetUserRoleRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetUserRoleRelation row, @Param("example") RetUserRoleRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetUserRoleRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetUserRoleRelation row);
}