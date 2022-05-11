package com.rare_earth_track.mgb.dao;

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
     * @param record record
     * @return int
     */
    int insert(RetMaterial record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetMaterial record);

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
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetMaterial record, @Param("example") RetMaterialExample example);

    /**
     * updateByExampleWithBLOBs
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") RetMaterial record, @Param("example") RetMaterialExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetMaterial record, @Param("example") RetMaterialExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetMaterial record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetMaterial record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetMaterial record);
}