package com.board.project.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSNSMember is a Querydsl query type for SNSMember
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSNSMember extends EntityPathBase<SNSMember> {

    private static final long serialVersionUID = -1598604271L;

    public static final QSNSMember sNSMember = new QSNSMember("sNSMember");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath email = createString("email");

    public final BooleanPath fromSocial = createBoolean("fromSocial");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final SetPath<SNSMemberRole, EnumPath<SNSMemberRole>> roleset = this.<SNSMemberRole, EnumPath<SNSMemberRole>>createSet("roleset", SNSMemberRole.class, EnumPath.class, PathInits.DIRECT2);

    public QSNSMember(String variable) {
        super(SNSMember.class, forVariable(variable));
    }

    public QSNSMember(Path<? extends SNSMember> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSNSMember(PathMetadata metadata) {
        super(SNSMember.class, metadata);
    }

}

