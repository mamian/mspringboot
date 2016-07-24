package net.mamian.mySpringboot.dao;

import javax.transaction.Transactional;
import net.mamian.mySpringboot.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户表访问层
 * 
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-07-05 11:41
 * @copyright ©2016 马面 All Rights Reserved
 */
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * 获取用户
     * 
     * @param email
     * @return 
     */
    public User findByEmail(String email);

}
