package com.bewithme.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserGameInfoBagEntity is a Querydsl query type for UserGameInfoBagEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserGameInfoBagEntity extends EntityPathBase<UserGameInfoBagEntity> {

    private static final long serialVersionUID = 1848562745L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserGameInfoBagEntity userGameInfoBagEntity = new QUserGameInfoBagEntity("userGameInfoBagEntity");

    public final StringPath game_type = createString("game_type");

    public final QMemberBasicEntity memberBasic;

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Integer> rp = createNumber("rp", Integer.class);

    public final StringPath server = createString("server");

    public final StringPath tier = createString("tier");

    public QUserGameInfoBagEntity(String variable) {
        this(UserGameInfoBagEntity.class, forVariable(variable), INITS);
    }

    public QUserGameInfoBagEntity(Path<? extends UserGameInfoBagEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserGameInfoBagEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserGameInfoBagEntity(PathMetadata metadata, PathInits inits) {
        this(UserGameInfoBagEntity.class, metadata, inits);
    }

    public QUserGameInfoBagEntity(Class<? extends UserGameInfoBagEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberBasic = inits.isInitialized("memberBasic") ? new QMemberBasicEntity(forProperty("memberBasic")) : null;
    }

}

