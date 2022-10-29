package com.bewithme.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGameInfoEntity is a Querydsl query type for GameInfoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGameInfoEntity extends EntityPathBase<GameInfoEntity> {

    private static final long serialVersionUID = -835717302L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGameInfoEntity gameInfoEntity = new QGameInfoEntity("gameInfoEntity");

    public final StringPath comment = createString("comment");

    public final StringPath game = createString("game");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMemberBasicEntity memberBasic;

    public QGameInfoEntity(String variable) {
        this(GameInfoEntity.class, forVariable(variable), INITS);
    }

    public QGameInfoEntity(Path<? extends GameInfoEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGameInfoEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGameInfoEntity(PathMetadata metadata, PathInits inits) {
        this(GameInfoEntity.class, metadata, inits);
    }

    public QGameInfoEntity(Class<? extends GameInfoEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberBasic = inits.isInitialized("memberBasic") ? new QMemberBasicEntity(forProperty("memberBasic")) : null;
    }

}

