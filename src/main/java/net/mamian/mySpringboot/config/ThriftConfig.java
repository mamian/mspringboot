//package net.mamian.mySpringboot.config;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import javax.annotation.PostConstruct;
//import net.mamian.mySpringboot.service.thrift.DataServiceImpl;
//import net.mamian.mySpringboot.thrift.service.DataService;
//import org.apache.thrift.server.TServer;
//import org.apache.thrift.server.TThreadPoolServer;
//import org.apache.thrift.transport.TServerSocket;
//import org.apache.thrift.transport.TServerTransport;
//import org.apache.thrift.transport.TTransportException;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 暂时去除配置
// *
// * @author mamian
// * @mail mamianskyma@aliyun.com
// * @date 2017-04-15 19:51
// * @copyright ©2017 马面 All Rights Reserved
// * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
// */
//@Configuration
//public class ThriftConfig {
//
//    ExecutorService executor = Executors.newSingleThreadExecutor();
//
//    @Bean
//    public TServerTransport tServerTransport() {
//        try {
//            return new TServerSocket(7911);
//        } catch (TTransportException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Bean
//    public TServer tServer() {
//        //发布服务
//        DataService.Processor processor = new DataService.Processor(new DataServiceImpl());
//        TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(
//                tServerTransport()).processor(processor));
//        return server;
//    }
//
//    @PostConstruct
//    public void init() {
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                tServer().serve();
//            }
//        });
//    }
//
//}