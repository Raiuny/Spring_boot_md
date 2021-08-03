package com.raiuny.server.service.iml;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.raiuny.server.mapper.BooksMapper;
import com.raiuny.server.pojo.Books;
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
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements IService<Books> {

}
