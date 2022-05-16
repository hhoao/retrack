package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetMaterialDoubleCategory;
import com.rare_earth_track.mgb.model.RetMaterialDoubleCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMaterialDoubleCategoryMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMaterialDoubleCategoryExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMaterialDoubleCategoryExample example);

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
    int insert(RetMaterialDoubleCategory row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMaterialDoubleCategory row);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialDoubleCategory>
     */
    List<RetMaterialDoubleCategory> selectByExampleWithBLOBs(RetMaterialDoubleCategoryExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterialDoubleCategory>
     */
    List<RetMaterialDoubleCategory> selectByExample(RetMaterialDoubleCategoryExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMaterialDoubleCategory
     */
    RetMaterialDoubleCategory selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMaterialDoubleCategory row, @Param("example") RetMaterialDoubleCategoryExample example);

    /**
     * updateByExampleWithBLOBs
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("row") RetMaterialDoubleCategory row, @Param("example") RetMaterialDoubleCategoryExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMaterialDoubleCategory row, @Param("example") RetMaterialDoubleCategoryExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterialDoubleCategory row);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param row row
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetMaterialDoubleCategory row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMaterialDoubleCategory row);
}