package com.bewithme.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameCharacterEntity is a Querydsl query type for GameCharacterEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGameCharacterEntity extends EntityPathBase<GameCharacterEntity> {

    private static final long serialVersionUID = 683315955L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameCharacterEntity gameCharacterEntity = new QGameCharacterEntity("gameCharacterEntity");

    public final StringPath characterName = createString("characterName");

    public final QGameEntity game;

    public final StringPath gameImagePath = createString("gameImagePath");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QGameCharacterEntity(String variable) {
        this(GameCharacterEntity.class, forVariable(variable), INITS);
    }

    public QGameCharacterEntity(Path<? extends GameCharacterEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGameCharacterEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGameCharacterEntity(PathMetadata metadata, PathInits inits) {
        this(GameCharacterEntity.class, metadata, inits);
    }

    public QGameCharacterEntity(Class<? extends GameCharacterEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.game = inits.isInitialized("game") ? new QGameEntity(forProperty("game")) : null;
    }

}

