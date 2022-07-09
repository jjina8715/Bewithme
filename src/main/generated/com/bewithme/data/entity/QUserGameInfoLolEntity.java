package com.bewithme.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserGameInfoLolEntity is a Querydsl query type for UserGameInfoLolEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserGameInfoLolEntity extends EntityPathBase<UserGameInfoLolEntity> {

    private static final long serialVersionUID = -274020678L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserGameInfoLolEntity userGameInfoLolEntity = new QUserGameInfoLolEntity("userGameInfoLolEntity");

    public final StringPath game_type = createString("game_type");

    public final QGameCharacterEntity gameCharacter;

    public final NumberPath<Integer> level = createNumber("level", Integer.class);

    public final QMemberBasicEntity memberBasic;

    public final StringPath position = createString("position");

    public final StringPath role = createString("role");

    public final StringPath server = createString("server");

    public final StringPath summonerId = createString("summonerId");

    public QUserGameInfoLolEntity(String variable) {
        this(UserGameInfoLolEntity.class, forVariable(variable), INITS);
    }

    public QUserGameInfoLolEntity(Path<? extends UserGameInfoLolEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserGameInfoLolEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserGameInfoLolEntity(PathMetadata metadata, PathInits inits) {
        this(UserGameInfoLolEntity.class, metadata, inits);
    }

    public QUserGameInfoLolEntity(Class<? extends UserGameInfoLolEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gameCharacter = inits.isInitialized("gameCharacter") ? new QGameCharacterEntity(forProperty("gameCharacter"), inits.get("gameCharacter")) : null;
        this.memberBasic = inits.isInitialized("memberBasic") ? new QMemberBasicEntity(forProperty("memberBasic")) : null;
    }

}

