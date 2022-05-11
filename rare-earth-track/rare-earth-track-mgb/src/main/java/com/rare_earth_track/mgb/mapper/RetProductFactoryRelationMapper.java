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
     * @param record record
     * @return int
     */
    int insert(RetProductFactoryRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetProductFactoryRelation record);

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
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetProductFactoryRelation record, @Param("example") RetProductFactoryRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetProductFactoryRelation record, @Param("example") RetProductFactoryRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetProductFactoryRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetProductFactoryRelation record);
}