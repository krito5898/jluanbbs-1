package cn.edu.ncu.jiluan.bbs.dao;

import cn.edu.ncu.jiluan.bbs.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by krito on 2018/12/20
 */
public interface PostDao extends JpaRepository<PostEntity, Integer> {
}
