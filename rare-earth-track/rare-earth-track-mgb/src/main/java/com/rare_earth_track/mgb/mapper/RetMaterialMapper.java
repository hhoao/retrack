package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetMaterial;
import com.rare_earth_track.mgb.model.RetMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMaterialMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMaterialExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMaterialExample example);

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
    int insert(RetMaterial row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMaterial row);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterial>
     */
    List<RetMaterial> selectByExampleWithBLOBs(RetMaterialExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMaterial>
     */
    List<RetMaterial> selectByExample(RetMaterialExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMaterial
     */
    RetMaterial selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMaterial row, @Param("example") RetMaterialExample example);

    /**
     * updateByExampleWithBLOBs
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("row") RetMaterial row, @Param("example") RetMaterialExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMaterial row, @Param("example") RetMaterialExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterial row);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param row row
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetMaterial row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMaterial row);
}