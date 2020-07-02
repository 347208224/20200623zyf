package com.aaa.zyf.service.impl;

import com.aaa.zyf.entity.UserRole;
import com.aaa.zyf.dao.UserRoleDao;
import com.aaa.zyf.service.UserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author zyf
 * @since 2020-06-23
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

}
