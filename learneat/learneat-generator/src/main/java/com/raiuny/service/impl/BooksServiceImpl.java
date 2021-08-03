package com.raiuny.service.impl;

import com.raiuny.pojo.Books;
import com.raiuny.mapper.BooksMapper;
import com.raiuny.service.BooksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zy
 * @since 2021-08-01
 */
@Service
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements BooksService {

}
