package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetMaterialDocumentRelation;
import com.rare_earth_track.mgb.model.RetMaterialDocumentRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMaterialDocumentRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMaterialDocumentRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMaterialDocumentRelationExample example);

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
    int insert(RetMaterialDocumentRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMaterialDocumentRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialDocumentRelation>
     */
    List<RetMaterialDocumentRelation> selectByExample(RetMaterialDocumentRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMaterialDocumentRelation
     */
    RetMaterialDocumentRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMaterialDocumentRelation row, @Param("example") RetMaterialDocumentRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMaterialDocumentRelation row, @Param("example") RetMaterialDocumentRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialDocumentRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMaterialDocumentRelation row);
}