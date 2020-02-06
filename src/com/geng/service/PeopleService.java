package com.geng.service;

import com.geng.pojo.People;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public interface PeopleService {
    /**
     * 查询全部
     *
     * @return List
     */
    List<People> showAll() throws IOException;
}
