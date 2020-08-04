# [eRPC](https://github.com/lmgty/eRPC)

![language](https://img.shields.io/badge/language-java-green.svg)
---
## 简介
本工程实现了一个简单的RPC模型，基于springboot 单点直连。
旨在理解RPC概念并练习动态代理。

## 客户端
客户端controller接收外部请求，通过 动态代理，序列化，网络传输，传递给服务端。
拿到服务端返回结果后进行反序列化。

## 服务端
服务端controller根据接收到的客户端请求，进行反序列化，调用服务，返回序列化结果。

