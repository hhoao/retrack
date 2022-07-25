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
     * @param row row
     * @return int
     */
    int insert(RetHelp row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetHelp row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetHelp row, @Param("example") RetHelpExample example);

    /**
     * updateByExampleWithBLOBs
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("row") RetHelp row, @Param("example") RetHelpExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetHelp row, @Param("example") RetHelpExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetHelp row);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param row row
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetHelp row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetHelp row);
}