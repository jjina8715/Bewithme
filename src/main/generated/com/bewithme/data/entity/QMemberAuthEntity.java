package com.bewithme.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberAuthEntity is a Querydsl query type for MemberAuthEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberAuthEntity extends EntityPathBase<MemberAuthEntity> {

    private static final long serialVersionUID = -1033792596L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberAuthEntity memberAuthEntity = new QMemberAuthEntity("memberAuthEntity");

    public final QTimeEntity _super = new QTimeEntity(this);

    public final StringPath authId = createString("authId");

    public final StringPath authRole = createString("authRole");

    public final StringPath authValue = createString("authValue");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMemberBasicEntity memberBasic;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public QMemberAuthEntity(String variable) {
        this(MemberAuthEntity.class, forVariable(variable), INITS);
    }

    public QMemberAuthEntity(Path<? extends MemberAuthEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberAuthEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberAuthEntity(PathMetadata metadata, PathInits inits) {
        this(MemberAuthEntity.class, metadata, inits);
    }

    public QMemberAuthEntity(Class<? extends MemberAuthEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberBasic = inits.isInitialized("memberBasic") ? new QMemberBasicEntity(forProperty("memberBasic")) : null;
    }

}

