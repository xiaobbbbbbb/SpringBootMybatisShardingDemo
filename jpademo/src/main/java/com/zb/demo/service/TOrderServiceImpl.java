package com.zb.demo.service;

import com.zb.demo.entity.TOrder;
import com.zb.demo.repository.TOrderRespository;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TOrderServiceImpl {

    @Autowired
    private TOrderRespository tOrderRespository;



    //批量保存
    public List<TOrder> batchSave(List<TOrder> orderList){
        return tOrderRespository.saveAll(orderList);
    }

    //单个保存
    public TOrder save(TOrder order){
        return tOrderRespository.save(order);
    }
    //分页查询
    public Page<TOrder> page(int pageSize,int pageNo){
        Pageable pageable = PageRequest.of(pageSize,pageSize, Sort.by(Sort.Direction.DESC, "createTime"));
        return tOrderRespository.findAll(pageable);
    }
    public Optional findById(String id){
        return tOrderRespository.findById(id);
    }


    //自定义查询
    public List<TOrder> list(String id){
        tOrderRespository.findById(id);

//            Query nativeQuery = this.entityManager.createNativeQuery(sql);
//            ((SQLQuery)nativeQuery.unwrap(SQLQuery.class)).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//            nativeQuery.setFirstResult(pageable.getOffset());
//            nativeQuery.setMaxResults(pageable.getPageSize());
//            Query countNativeQuery = this.entityManager.createNativeQuery("select count(*) from (" + sql + ") a");
//            long total = Long.valueOf(String.valueOf(countNativeQuery.getSingleResult()));
//            return new PageImpl(nativeQuery.getResultList(), pageable, total);
//
//            Query nativeQuery = this.entityManager.createNativeQuery(sql);
//            ((SQLQuery)nativeQuery.unwrap(SQLQuery.class)).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//            return nativeQuery.getResultList();
//
//            Query nativeQuery = this.entityManager.createNativeQuery(sql);
//            List results = nativeQuery.getResultList();
//            if (results != null && results.size() != 0) {
//                try {
//                    if (results.size() > 1) {
//                        throw new RuntimeException("结果应当只有一个，但是发现了" + results.size() + "个。");
//                    } else {
//                        return results.get(0);
//                    }
//                } catch (NoResultException var5) {
//                    return null;
//                }
//            } else {
//                return null;
//            }

        return null;
    }

    @Autowired
    public void settOrderRespository(TOrderRespository tOrderRespository) {
        this.tOrderRespository = tOrderRespository;
    }
}
