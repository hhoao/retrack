package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetMaterialProductRelation;
import com.rare_earth_track.mgb.model.RetMaterialProductRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMaterialProductRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMaterialProductRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMaterialProductRelationExample example);

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
    int insert(RetMaterialProductRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMaterialProductRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialProductRelation>
     */
    List<RetMaterialProductRelation> selectByExample(RetMaterialProductRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMaterialProductRelation
     */
    RetMaterialProductRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMaterialProductRelation row, @Param("example") RetMaterialProductRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMaterialProductRelation row, @Param("example") RetMaterialProductRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialProductRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMaterialProductRelation row);
}