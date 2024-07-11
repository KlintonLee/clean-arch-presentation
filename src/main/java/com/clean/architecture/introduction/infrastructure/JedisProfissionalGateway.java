package com.clean.architecture.introduction.infrastructure;

import com.clean.architecture.introduction.entity.Profissional;
import com.clean.architecture.introduction.infrastructure.config.ObjectMapperConfig;
import com.clean.architecture.introduction.infrastructure.gateway.ProfissionalGateway;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class JedisProfissionalGateway implements ProfissionalGateway {

    private final ObjectMapperConfig<Profissional> objectMapperConfig;

    public JedisProfissionalGateway(ObjectMapperConfig<Profissional> objectMapperConfig) {
        this.objectMapperConfig = objectMapperConfig;
    }

    public Jedis getConnection() {
        return new JedisPool("localhost", 7000).getResource();
    }

    @Override
    public Profissional create(Profissional profissional) {
        getConnection()
                .set(profissional.getId(), objectMapperConfig.objToString(profissional));
        return profissional;
    }

    @Override
    public Optional<Profissional> findById(String id) {
        return getConnection().get(id) != null ?
                Optional.of(objectMapperConfig.stringToObj(getConnection().get(id), Profissional.class)) :
                Optional.empty();
    }

    @Override
    public Profissional update(Profissional profissional) {
        getConnection()
                .set(profissional.getId(), objectMapperConfig.objToString(profissional));
        return profissional;
    }

    @Override
    public boolean existsById(String id) {
        return getConnection().get(id) != null;
    }
}
