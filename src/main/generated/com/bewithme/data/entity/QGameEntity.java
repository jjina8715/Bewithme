package com.bewithme.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGameEntity is a Querydsl query type for GameEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGameEntity extends EntityPathBase<GameEntity> {

    private static final long serialVersionUID = -198388356L;

    public static final QGameEntity gameEntity = new QGameEntity("gameEntity");

    public final StringPath gameImagePath = createString("gameImagePath");

    public final StringPath gameName = createString("gameName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QGameEntity(String variable) {
        super(GameEntity.class, forVariable(variable));
    }

    public QGameEntity(Path<? extends GameEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGameEntity(PathMetadata metadata) {
        super(GameEntity.class, metadata);
    }

}

