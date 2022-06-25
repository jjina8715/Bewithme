package com.bewithme.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberBasicEntity is a Querydsl query type for MemberBasicEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberBasicEntity extends EntityPathBase<MemberBasicEntity> {

    private static final long serialVersionUID = -917895728L;

    public static final QMemberBasicEntity memberBasicEntity = new QMemberBasicEntity("memberBasicEntity");

    public final StringPath aboutMe = createString("aboutMe");

    public final StringPath accessTime = createString("accessTime");

    public final StringPath birth = createString("birth");

    public final StringPath discordUrl = createString("discordUrl");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> lastLogin = createDateTime("lastLogin", java.time.LocalDateTime.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath phoneNumber = createString("phoneNumber");

    public QMemberBasicEntity(String variable) {
        super(MemberBasicEntity.class, forVariable(variable));
    }

    public QMemberBasicEntity(Path<? extends MemberBasicEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberBasicEntity(PathMetadata metadata) {
        super(MemberBasicEntity.class, metadata);
    }

}

