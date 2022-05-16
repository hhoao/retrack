package com.rare_earth_track.mgb.mapper;

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
     * @param row row
     * @return int
     */
    int insert(RetMaterialCategoryDocument row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMaterialCategoryDocument row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMaterialCategoryDocument row, @Param("example") RetMaterialCategoryDocumentExample example);

    /**
     * updateByExampleWithBLOBs
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("row") RetMaterialCategoryDocument row, @Param("example") RetMaterialCategoryDocumentExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMaterialCategoryDocument row, @Param("example") RetMaterialCategoryDocumentExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialCategoryDocument row);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param row row
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetMaterialCategoryDocument row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMaterialCategoryDocument row);
}