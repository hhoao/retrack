package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetProductFactoryRelation;
import com.rare_earth_track.mgb.model.RetProductFactoryRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetProductFactoryRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetProductFactoryRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetProductFactoryRelationExample example);

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
    int insert(RetProductFactoryRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetProductFactoryRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetProductFactoryRelation>
     */
    List<RetProductFactoryRelation> selectByExample(RetProductFactoryRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetProductFactoryRelation
     */
    RetProductFactoryRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetProductFactoryRelation row, @Param("example") RetProductFactoryRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetProductFactoryRelation row, @Param("example") RetProductFactoryRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetProductFactoryRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetProductFactoryRelation row);
}