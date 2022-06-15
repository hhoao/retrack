package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetRoleMenuRelation;
import com.rare_earth_track.mgb.model.RetRoleMenuRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetRoleMenuRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetRoleMenuRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetRoleMenuRelationExample example);

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
    int insert(RetRoleMenuRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetRoleMenuRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetRoleMenuRelation>
     */
    List<RetRoleMenuRelation> selectByExample(RetRoleMenuRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetRoleMenuRelation
     */
    RetRoleMenuRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetRoleMenuRelation row, @Param("example") RetRoleMenuRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetRoleMenuRelation row, @Param("example") RetRoleMenuRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetRoleMenuRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetRoleMenuRelation row);
}