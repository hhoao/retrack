package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetMenu;
import com.rare_earth_track.mgb.model.RetMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMenuMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMenuExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMenuExample example);

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
    int insert(RetMenu row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMenu row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMenu>
     */
    List<RetMenu> selectByExample(RetMenuExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMenu
     */
    RetMenu selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMenu row, @Param("example") RetMenuExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMenu row, @Param("example") RetMenuExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMenu row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMenu row);
}