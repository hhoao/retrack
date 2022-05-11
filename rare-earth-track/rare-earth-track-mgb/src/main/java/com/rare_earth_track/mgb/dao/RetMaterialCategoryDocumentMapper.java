package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetMaterialCategoryDocument;
import com.rare_earth_track.mgb.model.RetMaterialCategoryDocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMaterialCategoryDocumentMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMaterialCategoryDocumentExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMaterialCategoryDocumentExample example);

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
    int insert(RetMaterialCategoryDocument record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetMaterialCategoryDocument record);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialCategoryDocument>
     */
    List<RetMaterialCategoryDocument> selectByExampleWithBLOBs(RetMaterialCategoryDocumentExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialCategoryDocument>
     */
    List<RetMaterialCategoryDocument> selectByExample(RetMaterialCategoryDocumentExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMaterialCategoryDocument
     */
    RetMaterialCategoryDocument selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetMaterialCategoryDocument record, @Param("example") RetMaterialCategoryDocumentExample example);

    /**
     * updateByExampleWithBLOBs
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") RetMaterialCategoryDocument record, @Param("example") RetMaterialCategoryDocumentExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetMaterialCategoryDocument record, @Param("example") RetMaterialCategoryDocumentExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialCategoryDocument record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetMaterialCategoryDocument record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetMaterialCategoryDocument record);
}