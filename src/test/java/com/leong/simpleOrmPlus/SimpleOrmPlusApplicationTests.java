package com.leong.simpleOrmPlus;

import com.leong.simpleOrmPlus.core.TableInfo;
import com.leong.simpleOrmPlus.core.annotation.TableId;
import com.leong.simpleOrmPlus.core.utils.TableInfoCache;
import com.leong.simpleOrmPlus.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimpleOrmPlusApplicationTests {

    @Test
    void contextLoads() {
        TableInfo info = TableInfoCache.getCache(User.class);
        System.out.println(info);
    }

}
