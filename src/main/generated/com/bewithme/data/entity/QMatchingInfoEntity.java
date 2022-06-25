package com.bewithme.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMatchingInfoEntity is a Querydsl query type for MatchingInfoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMatchingInfoEntity extends EntityPathBase<MatchingInfoEntity> {

    private static final long serialVersionUID = 628550165L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMatchingInfoEntity matchingInfoEntity = new QMatchingInfoEntity("matchingInfoEntity");

    public final QTimeEntity _super = new QTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final QMemberBasicEntity requestee;

    public final QMemberBasicEntity requester;

    public final StringPath stat = createString("stat");

    public QMatchingInfoEntity(String variable) {
        this(MatchingInfoEntity.class, forVariable(variable), INITS);
    }

    public QMatchingInfoEntity(Path<? extends MatchingInfoEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMatchingInfoEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMatchingInfoEntity(PathMetadata metadata, PathInits inits) {
        this(MatchingInfoEntity.class, metadata, inits);
    }

    public QMatchingInfoEntity(Class<? extends MatchingInfoEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.requestee = inits.isInitialized("requestee") ? new QMemberBasicEntity(forProperty("requestee")) : null;
        this.requester = inits.isInitialized("requester") ? new QMemberBasicEntity(forProperty("requester")) : null;
    }

}

