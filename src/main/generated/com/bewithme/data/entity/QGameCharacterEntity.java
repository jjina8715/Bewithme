package com.bewithme.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QGameCharacterEntity is a Querydsl query type for GameCharacterEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGameCharacterEntity extends EntityPathBase<GameCharacterEntity> {

    private static final long serialVersionUID = 683315955L;

    public static final QGameCharacterEntity gameCharacterEntity = new QGameCharacterEntity("gameCharacterEntity");

    public final StringPath characterName = createString("characterName");

    public final StringPath game = createString("game");

    public final StringPath gameImagePath = createString("gameImagePath");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QGameCharacterEntity(String variable) {
        super(GameCharacterEntity.class, forVariable(variable));
    }

    public QGameCharacterEntity(Path<? extends GameCharacterEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGameCharacterEntity(PathMetadata metadata) {
        super(GameCharacterEntity.class, metadata);
    }

}

