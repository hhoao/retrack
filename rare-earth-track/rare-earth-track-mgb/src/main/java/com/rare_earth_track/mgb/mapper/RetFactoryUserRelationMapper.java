package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetFactoryUserRelation;
import com.rare_earth_track.mgb.model.RetFactoryUserRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetFactoryUserRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetFactoryUserRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetFactoryUserRelationExample example);

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
    int insert(RetFactoryUserRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetFactoryUserRelation record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetFactoryUserRelation>
     */
    List<RetFactoryUserRelation> selectByExample(RetFactoryUserRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetFactoryUserRelation
     */
    RetFactoryUserRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetFactoryUserRelation record, @Param("example") RetFactoryUserRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetFactoryUserRelation record, @Param("example") RetFactoryUserRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetFactoryUserRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetFactoryUserRelation record);
}