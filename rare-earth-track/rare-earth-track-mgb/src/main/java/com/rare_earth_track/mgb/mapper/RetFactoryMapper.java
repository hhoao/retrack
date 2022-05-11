package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetFactory;
import com.rare_earth_track.mgb.model.RetFactoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetFactoryMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetFactoryExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetFactoryExample example);

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
    int insert(RetFactory record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetFactory record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetFactory>
     */
    List<RetFactory> selectByExample(RetFactoryExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetFactory
     */
    RetFactory selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetFactory record, @Param("example") RetFactoryExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetFactory record, @Param("example") RetFactoryExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetFactory record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetFactory record);
}