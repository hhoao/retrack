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
     * @param record record
     * @return int
     */
    int insert(RetProductDocumentRelation record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetProductDocumentRelation record);

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
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetProductDocumentRelation record, @Param("example") RetProductDocumentRelationExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetProductDocumentRelation record, @Param("example") RetProductDocumentRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetProductDocumentRelation record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetProductDocumentRelation record);
}