package com.bewithme.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMateWishEntity is a Querydsl query type for MateWishEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMateWishEntity extends EntityPathBase<MateWishEntity> {

    private static final long serialVersionUID = -1710234666L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMateWishEntity mateWishEntity = new QMateWishEntity("mateWishEntity");

    public final StringPath acessTime = createString("acessTime");

    public final StringPath ageGroup = createString("ageGroup");

    public final StringPath gameType = createString("gameType");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMemberBasicEntity memberBasic;

    public QMateWishEntity(String variable) {
        this(MateWishEntity.class, forVariable(variable), INITS);
    }

    public QMateWishEntity(Path<? extends MateWishEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMateWishEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMateWishEntity(PathMetadata metadata, PathInits inits) {
        this(MateWishEntity.class, metadata, inits);
    }

    public QMateWishEntity(Class<? extends MateWishEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberBasic = inits.isInitialized("memberBasic") ? new QMemberBasicEntity(forProperty("memberBasic")) : null;
    }

}

