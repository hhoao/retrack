package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetProductDocumentRelation;
import com.rare_earth_track.mgb.model.RetProductDocumentRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetProductDocumentRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetProductDocumentRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetProductDocumentRelationExample example);

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
    int insert(RetProductDocumentRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetProductDocumentRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetProductDocumentRelation>
     */
    List<RetProductDocumentRelation> selectByExample(RetProductDocumentRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetProductDocumentRelation
     */
    RetProductDocumentRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetProductDocumentRelation row, @Param("example") RetProductDocumentRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetProductDocumentRelation row, @Param("example") RetProductDocumentRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetProductDocumentRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetProductDocumentRelation row);
}