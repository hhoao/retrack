package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetMemberJobPermissionRelation;
import com.rare_earth_track.mgb.model.RetMemberJobPermissionRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMemberJobPermissionRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMemberJobPermissionRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMemberJobPermissionRelationExample example);

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
    int insert(RetMemberJobPermissionRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMemberJobPermissionRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMemberJobPermissionRelation>
     */
    List<RetMemberJobPermissionRelation> selectByExample(RetMemberJobPermissionRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMemberJobPermissionRelation
     */
    RetMemberJobPermissionRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMemberJobPermissionRelation row, @Param("example") RetMemberJobPermissionRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMemberJobPermissionRelation row, @Param("example") RetMemberJobPermissionRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMemberJobPermissionRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMemberJobPermissionRelation row);
}