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
     * @param row row
     * @return int
     */
    int insert(RetFactoryUserRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetFactoryUserRelation row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetFactoryUserRelation row, @Param("example") RetFactoryUserRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetFactoryUserRelation row, @Param("example") RetFactoryUserRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetFactoryUserRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetFactoryUserRelation row);
}