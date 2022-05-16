package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetFactoryMemberRelation;
import com.rare_earth_track.mgb.model.RetFactoryMemberRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetFactoryMemberRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetFactoryMemberRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetFactoryMemberRelationExample example);

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
    int insert(RetFactoryMemberRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetFactoryMemberRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetFactoryMemberRelation>
     */
    List<RetFactoryMemberRelation> selectByExample(RetFactoryMemberRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetFactoryMemberRelation
     */
    RetFactoryMemberRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetFactoryMemberRelation row, @Param("example") RetFactoryMemberRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetFactoryMemberRelation row, @Param("example") RetFactoryMemberRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetFactoryMemberRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetFactoryMemberRelation row);
}