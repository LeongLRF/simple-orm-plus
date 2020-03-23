package com.leong.simpleOrmPlus.entity;

import com.leong.simpleOrmPlus.core.annotation.Column;
import com.leong.simpleOrmPlus.core.annotation.TableId;
import com.leong.simpleOrmPlus.core.annotation.TableName;
import com.leong.simpleOrmPlus.core.support.IdType;

@TableName("user")
public class User {

    @TableId(idType = IdType.AUTO)
    long id;

    @Column("userName")
    String userName;

}
