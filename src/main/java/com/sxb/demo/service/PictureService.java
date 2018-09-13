package com.sxb.demo.service;

import com.sxb.demo.entity.Picture;
import com.sxb.demo.utils.PageResult;
import com.sxb.demo.utils.PageUtil;


/**
 * @author 13
 * @date 2018-07-18
 */
public interface PictureService {

    /**
     * 查询列表数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getPicturePage(PageUtil pageUtil);

    /**
     * 根据id查询对象
     *
     * @param id
     * @return
     */
    Picture queryObject(Integer id);

    /**
     * 新增图片对象
     *
     * @param picture
     */
    int save(Picture picture);

    /**
     * 修改
     *
     * @param picture
     */
    int update(Picture picture);

    /**
     * 删除
     *
     * @param id
     */
    int delete(Integer id);

    /**
     * 批量删除
     *
     * @param ids
     */
    int deleteBatch(Integer[] ids);
}
