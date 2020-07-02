package com.aaa.zyf.service.impl;

import com.aaa.zyf.entity.User;
import com.aaa.zyf.dao.UserDao;
import com.aaa.zyf.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zyf
 * @since 2020-06-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}
