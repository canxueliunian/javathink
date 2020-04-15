package com.canxue.day.enums;

/**
 * @Author Lishuntao
 * @Date 2019/11/18
 */

import java.util.Random;

/**
 * @author zhouzixinag
 * @version 创建时间：2018年8月12日 下午2:06:18
 * 类说明
 * 枚举类 封装了 项目经理、人力资源HR、 总经理 三种角色。
 */
public enum Handler {
    //项目经理
    ProjectManager{
        @Override
        boolean PassRequest(Request request){
            if (getSuccessor() ==null ) {
                Successor = HR; //default 默认为HR；
            }
            System.out.println("项目经理开始审批...");
            if (request.getDay()<=0.5) {
                System.out.println("项目经理审批通过");
                return true;
            }
            System.out.println("项目经理递交审批至"+Successor);
            return Successor.PassRequest(request);
        }
    },
    //HR
    HR{
        @Override
        boolean PassRequest(Request request){
            if (getSuccessor() == null) {
                Successor = Manager; //default 默认为总经理;
            }
            System.out.println("人力资源HR开始审批...");
            if (request.getDay()>0.5 && request.getDay()<=2) {
                System.out.println("人力资源HR审批通过");
                return true;
            }
            System.out.println("人力资源HR递交审批至"+Successor);
            return Successor.PassRequest(request);
        }
    },

    Manager{
        @Override
        boolean PassRequest(Request request){
            Successor = null; //default 正常情况下没有下一处理者；
            System.out.println("总经理开始审批...");
            Random rand = new Random();
            int nextInt = rand.nextInt(2);
            if (nextInt==1) {
                System.out.println("总经理审批通过");
                return true;
            }else {
                System.out.println("总经理驳回了请假请求");
                return false;
            }

        }
    };
    //下一个处理者
    public Handler Successor ;
    //获取下一个处理着
    public Handler getSuccessor() {
        return Successor;
    }
    //设置下一个处理着
    public void setSuccessor(Handler successor) {
        Successor = successor;
    }
    /*抽象方法，具体审批过程 有enum各自去实现*/
    abstract boolean PassRequest(Request request);

    public static void main(String[] args) {
        Request request = new Request(0, "病假");
        Request request2 = new Request(0.4f, "病假");//这里如果大于0.5天，会有异常，由于业务逻辑的关系，项目经理会和HR之间相互“踢皮球”。
        //Handler handler = ProjectManager;//请求从头开始，也就是项目经理开始
        Handler handler = HR;//请求也可以从中间开始 ，加入项目经理不在，直接从人力资源HR开始审核。
        handler.setSuccessor(ProjectManager);
//        System.out.println(handler.PassRequest(request));
        System.out.println(handler.PassRequest(request2));
    }
}

