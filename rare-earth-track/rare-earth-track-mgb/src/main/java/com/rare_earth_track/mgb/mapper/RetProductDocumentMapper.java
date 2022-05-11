package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetProductDocument;
import com.rare_earth_track.mgb.model.RetProductDocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetProductDocumentMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetProductDocumentExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetProductDocumentExample example);

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
    int insert(RetProductDocument record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetProductDocument record);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetProductDocument>
     */
    List<RetProductDocument> selectByExampleWithBLOBs(RetProductDocumentExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetProductDocument>
     */
    List<RetProductDocument> selectByExample(RetProductDocumentExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetProductDocument
     */
    RetProductDocument selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetProductDocument record, @Param("example") RetProductDocumentExample example);

    /**
     * updateByExampleWithBLOBs
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") RetProductDocument record, @Param("example") RetProductDocumentExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetProductDocument record, @Param("example") RetProductDocumentExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetProductDocument record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetProductDocument record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetProductDocument record);
}