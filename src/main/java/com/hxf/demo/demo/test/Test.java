package com.hxf.demo.demo.test;

import com.hxf.demo.demo.codegen.base.BaseEntity;
import lombok.extern.slf4j.Slf4j;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

/**
 * <p>
 * Test
 * </p>
 *
 * @author hechengxi@iqingka.com
 * @date 2020年04月23日 09:57
 */
@Slf4j

public class Test {
    private static ExecutorService service;

    //从初始值0开始，做加/减处理，每次加/减1
    private static LongAdder adder = new LongAdder();

    //从初始值0开始，做累加处理
    private static LongAccumulator accumulator1 = new LongAccumulator((x, y) -> x+y, 0);

    //从初始值1开始，做累积处理
    private static LongAccumulator accumulator2 = new LongAccumulator((x, y) -> x*y, 1);
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    public static void main(String[] args) {
        /*log.info("MAXIMUM_CAPACITY={}", MAXIMUM_CAPACITY);
        log.info("tableSizeFor={}", tableSizeFor(17));
        HashMap<Object, Object> map = new HashMap<>(33);*/
        List<BaseEntity> list = new ArrayList<>();
        BaseEntity entity = new BaseEntity();
        entity.setId(1L);
        BaseEntity entity1 = new BaseEntity();
        entity1.setId(2L);
        list.add(entity);
        list.add(entity1);
        List<Long> list1 = list.stream().map(BaseEntity::getId).distinct().collect(Collectors.toList());
       /* service = Executors.newCachedThreadPool();

        for(int i=0; i<10; i++){
            service.submit(() -> {
                adder.increment(); //加1
//          adder.decrement(); //减1
                System.out.println(adder.intValue());

//                accumulator1.accumulate(2); //每次加2
//                System.out.println(accumulator1.get()); //获取当前值
//
//                accumulator2.accumulate(2); //每次 * 2
//                System.out.println(accumulator2.get()); //获取当前值

            });
        }

        service.shutdown();*/

        Test test = new Test();
        int a = test.checkReturn();
        log.error("a={}", a);
    }
    private int x = 0;
    public int checkReturn() {
        try {
            return 1;
        }catch (Exception e){

        }
        return 2;
    }

}
