package com.raiuny.service.impl;

import com.raiuny.pojo.Users;
import com.raiuny.mapper.UsersMapper;
import com.raiuny.service.UsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
