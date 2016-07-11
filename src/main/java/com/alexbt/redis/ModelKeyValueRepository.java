package com.alexbt.redis;

import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface ModelKeyValueRepository extends KeyValueRepository<Model, String> {
}     