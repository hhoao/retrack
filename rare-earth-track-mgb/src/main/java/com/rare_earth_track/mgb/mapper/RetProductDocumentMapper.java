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
     * @param row row
     * @return int
     */
    int insert(RetProductDocument row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetProductDocument row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetProductDocument row, @Param("example") RetProductDocumentExample example);

    /**
     * updateByExampleWithBLOBs
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("row") RetProductDocument row, @Param("example") RetProductDocumentExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetProductDocument row, @Param("example") RetProductDocumentExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetProductDocument row);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param row row
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetProductDocument row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetProductDocument row);
}