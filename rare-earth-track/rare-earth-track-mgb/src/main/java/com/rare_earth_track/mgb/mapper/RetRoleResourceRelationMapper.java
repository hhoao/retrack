package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetRoleResourceRelation;
import com.rare_earth_track.mgb.model.RetRoleResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetRoleResourceRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetRoleResourceRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetRoleResourceRelationExample example);

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
    int insert(RetRoleResourceRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetRoleResourceRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetRoleResourceRelation>
     */
    List<RetRoleResourceRelation> selectByExample(RetRoleResourceRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetRoleResourceRelation
     */
    RetRoleResourceRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetRoleResourceRelation row, @Param("example") RetRoleResourceRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetRoleResourceRelation row, @Param("example") RetRoleResourceRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetRoleResourceRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetRoleResourceRelation row);
}