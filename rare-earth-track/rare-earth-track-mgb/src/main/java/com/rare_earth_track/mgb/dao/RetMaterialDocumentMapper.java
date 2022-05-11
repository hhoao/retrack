package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetMaterialDocument;
import com.rare_earth_track.mgb.model.RetMaterialDocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMaterialDocumentMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMaterialDocumentExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMaterialDocumentExample example);

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
    int insert(RetMaterialDocument record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetMaterialDocument record);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialDocument>
     */
    List<RetMaterialDocument> selectByExampleWithBLOBs(RetMaterialDocumentExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialDocument>
     */
    List<RetMaterialDocument> selectByExample(RetMaterialDocumentExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMaterialDocument
     */
    RetMaterialDocument selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetMaterialDocument record, @Param("example") RetMaterialDocumentExample example);

    /**
     * updateByExampleWithBLOBs
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") RetMaterialDocument record, @Param("example") RetMaterialDocumentExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetMaterialDocument record, @Param("example") RetMaterialDocumentExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialDocument record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetMaterialDocument record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetMaterialDocument record);
}