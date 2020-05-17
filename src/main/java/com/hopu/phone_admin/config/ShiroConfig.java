package com.hopu.phone_admin.config;

import com.hopu.phone_admin.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置类
 * @Configuration 用于定义配置类，该类的各个方法返回各种对象实现系统的配置
 */
@Configuration
public class ShiroConfig {

    //返回密码匹配器
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");            //设置加密算法
        matcher.setHashIterations(2);                   //设置加密次数
        matcher.setStoredCredentialsHexEncoded(true);   //设置密文是16进制编码，false是base64编码
        return matcher;
    }

    //返回自定义Realm
    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());    //设置密码匹配器
        userRealm.setCachingEnabled(false);             //取消缓存
        return userRealm;
    }

    //返回安全管理器
    @Bean
    public SecurityManager securityManager(){
        //创建Web项目的安全管理器
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());          //设置Realm数据
        return securityManager;
    }

    //返回过滤器对象
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);    //配置安全管理器
        factoryBean.setLoginUrl("login.html");              //配置登录URL，登录失败进行自动跳转
        factoryBean.setUnauthorizedUrl("failed.html");      //配置授权失败URL
        Map<String,String> map = new LinkedHashMap<>();     //配置拦截规则，不拦截在前面，拦截在后面
        map.put("/login.html","anon");   //anon 不拦截，authc 拦截
        map.put("/register.html","anon");
        map.put("/failed.html","anon");
        map.put("/user/login","anon");
        map.put("/user/register","anon");
        map.put("/static/**","anon");
//        map.put("/**","authc");         //拦截其余的所有资源
        factoryBean.setFilterChainDefinitionMap(map);       //配置拦截规则
        return factoryBean;
    }

    //--------下面的配置用于启动@RequiresRoles 和 @RequiresPermissions 注解,基于Spring AOP扫描实现
    //配置后置处理器
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager());
        return advisor;
    }
}
