package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetMemberJobResourceRelation;
import com.rare_earth_track.mgb.model.RetMemberJobResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMemberJobResourceRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMemberJobResourceRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMemberJobResourceRelationExample example);

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
    int insert(RetMemberJobResourceRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMemberJobResourceRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMemberJobResourceRelation>
     */
    List<RetMemberJobResourceRelation> selectByExample(RetMemberJobResourceRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMemberJobResourceRelation
     */
    RetMemberJobResourceRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMemberJobResourceRelation row, @Param("example") RetMemberJobResourceRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMemberJobResourceRelation row, @Param("example") RetMemberJobResourceRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMemberJobResourceRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMemberJobResourceRelation row);
}