package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetProductSubjectRelation;
import com.rare_earth_track.mgb.model.RetProductSubjectRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetProductSubjectRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetProductSubjectRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetProductSubjectRelationExample example);

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
    int insert(RetProductSubjectRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetProductSubjectRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetProductSubjectRelation>
     */
    List<RetProductSubjectRelation> selectByExample(RetProductSubjectRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetProductSubjectRelation
     */
    RetProductSubjectRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetProductSubjectRelation row, @Param("example") RetProductSubjectRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetProductSubjectRelation row, @Param("example") RetProductSubjectRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetProductSubjectRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetProductSubjectRelation row);
}