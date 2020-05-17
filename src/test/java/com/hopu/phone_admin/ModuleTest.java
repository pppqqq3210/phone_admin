package com.hopu.phone_admin;

import com.hopu.phone_admin.dao.ModuleMapper;
import com.hopu.phone_admin.entity.ModuleTreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModuleTest {

    @Autowired
    private ModuleMapper moduleMapper;

    @Test
    public void testTreeNode(){
        List<ModuleTreeNode> nodes = moduleMapper.selectModuleTreeNodeByAccount("xiaowei");
        nodes.forEach((node)-> System.out.println(node));
    }
}
