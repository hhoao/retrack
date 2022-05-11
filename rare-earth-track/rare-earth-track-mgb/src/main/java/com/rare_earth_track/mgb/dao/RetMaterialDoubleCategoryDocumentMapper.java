package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetMaterialDoubleCategoryDocument;
import com.rare_earth_track.mgb.model.RetMaterialDoubleCategoryDocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMaterialDoubleCategoryDocumentMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMaterialDoubleCategoryDocumentExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMaterialDoubleCategoryDocumentExample example);

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
    int insert(RetMaterialDoubleCategoryDocument record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetMaterialDoubleCategoryDocument record);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialDoubleCategoryDocument>
     */
    List<RetMaterialDoubleCategoryDocument> selectByExampleWithBLOBs(RetMaterialDoubleCategoryDocumentExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialDoubleCategoryDocument>
     */
    List<RetMaterialDoubleCategoryDocument> selectByExample(RetMaterialDoubleCategoryDocumentExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMaterialDoubleCategoryDocument
     */
    RetMaterialDoubleCategoryDocument selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetMaterialDoubleCategoryDocument record, @Param("example") RetMaterialDoubleCategoryDocumentExample example);

    /**
     * updateByExampleWithBLOBs
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") RetMaterialDoubleCategoryDocument record, @Param("example") RetMaterialDoubleCategoryDocumentExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetMaterialDoubleCategoryDocument record, @Param("example") RetMaterialDoubleCategoryDocumentExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialDoubleCategoryDocument record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetMaterialDoubleCategoryDocument record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetMaterialDoubleCategoryDocument record);
}