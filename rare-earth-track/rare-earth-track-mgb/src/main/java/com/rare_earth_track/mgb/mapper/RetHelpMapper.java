package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetHelp;
import com.rare_earth_track.mgb.model.RetHelpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetHelpMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetHelpExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetHelpExample example);

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
    int insert(RetHelp record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetHelp record);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetHelp>
     */
    List<RetHelp> selectByExampleWithBLOBs(RetHelpExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetHelp>
     */
    List<RetHelp> selectByExample(RetHelpExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetHelp
     */
    RetHelp selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetHelp record, @Param("example") RetHelpExample example);

    /**
     * updateByExampleWithBLOBs
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") RetHelp record, @Param("example") RetHelpExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetHelp record, @Param("example") RetHelpExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetHelp record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetHelp record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetHelp record);
}