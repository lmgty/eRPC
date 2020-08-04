package com.yufa.xz.client.remoteservice;

import com.yufa.xz.client.rpc.RemoteClass;

/**
 * @author admin
 * @data 2020/7/30
 */
@RemoteClass("com.yufa.xz.server.service.UserService")
public interface UserService {
    /**
     * 返回全部user列表
     *
     * @return 全部
     */
    public String listAll();

    /**
     * 返回id对应user
     * @param id userId
     * @return user
     */
    public String listById(Integer id);

    /**
     * 添加user
     * @param name name
     * @param age age
     * @param sex sex
     * @return 0 or X
     */
    public Integer create(String name, Integer age, Integer sex);

}
