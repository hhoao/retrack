package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetUser;
import com.rare_earth_track.mgb.model.RetUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetUserMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetUserExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetUserExample example);

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
    int insert(RetUser row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetUser row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetUser>
     */
    List<RetUser> selectByExample(RetUserExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetUser
     */
    RetUser selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetUser row, @Param("example") RetUserExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetUser row, @Param("example") RetUserExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetUser row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetUser row);
}