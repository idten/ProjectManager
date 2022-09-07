package com.ibk.epmo.account;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogEsRepository extends ElasticsearchRepository<Blog, String> {
    Blog findById(Integer id);
}

