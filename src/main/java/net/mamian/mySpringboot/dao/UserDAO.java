package net.mamian.mySpringboot.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import net.mamian.mySpringboot.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户表访问层
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-07-21 11:41
 * @copyright ©2016 马面 All Rights Reserved
 */
@Slf4j
@Repository
@Transactional
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 创建用户
     * 
     * @param user
     */
    public void create(User user) {
        entityManager.persist(user);
    }

    /**
     * 删除用户
     * 
     * @param user
     */
    public void delete(User user) {
        if (entityManager.contains(user)) {
            entityManager.remove(user);
        } else {
            entityManager.remove(entityManager.merge(user));
        }
    }

    /**
     * 查找所有用户
     * 
     * @return 
     */
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    /**
     * 查找用户
     *
     * @param mobile
     * @return
     */
    public User findByMobile(String mobile) {
        log.debug("\n mamian mamianmamianmamianmamianmamianmamianmamian \n");
        return entityManager.createQuery("from User where mobile = :mobile", User.class)
                .setParameter("mobile", mobile)
                .getSingleResult();
    }

    /**
     * 查找用户
     * 
     * @param id
     * @return 
     */
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    /**
     * 修改用户
     * 
     * @param user
     */
    public void update(User user) {
        entityManager.merge(user);
    }

}
