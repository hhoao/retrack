package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetAdministrator;
import com.rare_earth_track.mgb.model.RetAdministratorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetAdministratorMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetAdministratorExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetAdministratorExample example);

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
    int insert(RetAdministrator row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetAdministrator row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetAdministrator>
     */
    List<RetAdministrator> selectByExample(RetAdministratorExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetAdministrator
     */
    RetAdministrator selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetAdministrator row, @Param("example") RetAdministratorExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetAdministrator row, @Param("example") RetAdministratorExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetAdministrator row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetAdministrator row);
}