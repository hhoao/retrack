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
     * @param record record
     * @return int
     */
    int insert(RetUser record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetUser record);

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
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetUser record, @Param("example") RetUserExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetUser record, @Param("example") RetUserExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetUser record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetUser record);
}