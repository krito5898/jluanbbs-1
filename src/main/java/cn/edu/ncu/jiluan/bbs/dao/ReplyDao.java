package cn.edu.ncu.jiluan.bbs.dao;

import cn.edu.ncu.jiluan.bbs.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by krito on 2018/12/20
 */
public interface ReplyDao extends JpaRepository<ReplyEntity, Integer> {
    List<ReplyEntity> findReplyEntitiesByPostId(Integer postId);

    @Modifying
    @Transactional
    void deleteReplyEntitiesByPostId(Integer postId);

    void countReplyEntityByPostId(Integer postId);


    @Query(value="SELECT count(reply_id) FROM reply,post WHERE reply.post_id = post.post_id AND post.plate_id = ?1", nativeQuery = true)
    Integer countReplyEntityByPlateId(int plateId);


}
