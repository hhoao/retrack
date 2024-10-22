package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetFile;
import com.rare_earth_track.mgb.model.RetFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetFileMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetFileExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetFileExample example);

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
    int insert(RetFile row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetFile row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetFile>
     */
    List<RetFile> selectByExample(RetFileExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetFile
     */
    RetFile selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetFile row, @Param("example") RetFileExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetFile row, @Param("example") RetFileExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetFile row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetFile row);
}