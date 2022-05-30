package com.rare_earth_track.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.service.RetProductService;
import com.rare_earth_track.mgb.mapper.RetProductMapper;
import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.mgb.model.RetProductExample;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/5/30
 **/

@Service
@RequiredArgsConstructor
public class RetProductServiceImpl implements RetProductService {
    private final RetProductMapper productMapper;
    @Override
    public List<RetProduct> list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        RetProductExample productExample = new RetProductExample();
        return productMapper.selectByExample(productExample);
    }
}
