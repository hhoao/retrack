package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetMemberJobRelationRelation;
import com.rare_earth_track.mgb.model.RetMemberJobRelationRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
     * @param row row
     * @return int
     */
    int insert(RetMemberJobRelationRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMemberJobRelationRelation row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMemberJobRelationRelation row, @Param("example") RetMemberJobRelationRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMemberJobRelationRelation row, @Param("example") RetMemberJobRelationRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMemberJobRelationRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMemberJobRelationRelation row);
}