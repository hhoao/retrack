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
     * @param row row
     * @return int
     */
    int insert(RetUserMemberRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetUserMemberRelation row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetUserMemberRelation row, @Param("example") RetUserMemberRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetUserMemberRelation row, @Param("example") RetUserMemberRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetUserMemberRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetUserMemberRelation row);
}