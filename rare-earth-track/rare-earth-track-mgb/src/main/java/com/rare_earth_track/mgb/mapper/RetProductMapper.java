package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.mgb.model.RetProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RetProductMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetProductExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetProductExample example);

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
    int insertByBatchId(RetProduct row);

    /**
     * insert
     * @param row row
     * @return int
     */
    int insert(RetProduct row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetProduct row);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetProduct>
     */
    List<RetProduct> selectByExampleWithBLOBs(RetProductExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetProduct>
     */
    List<RetProduct> selectByExample(RetProductExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetProduct
     */
    RetProduct selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetProduct row, @Param("example") RetProductExample example);

    /**
     * updateByExampleWithBLOBs
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("row") RetProduct row, @Param("example") RetProductExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetProduct row, @Param("example") RetProductExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetProduct row);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param row row
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetProduct row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetProduct row);
}