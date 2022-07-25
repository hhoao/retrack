package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetFactoryApplication;
import com.rare_earth_track.mgb.model.RetFactoryApplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetFactoryApplicationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetFactoryApplicationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetFactoryApplicationExample example);

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
    int insert(RetFactoryApplication row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetFactoryApplication row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetFactoryApplication>
     */
    List<RetFactoryApplication> selectByExample(RetFactoryApplicationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetFactoryApplication
     */
    RetFactoryApplication selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetFactoryApplication row, @Param("example") RetFactoryApplicationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetFactoryApplication row, @Param("example") RetFactoryApplicationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetFactoryApplication row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetFactoryApplication row);
}