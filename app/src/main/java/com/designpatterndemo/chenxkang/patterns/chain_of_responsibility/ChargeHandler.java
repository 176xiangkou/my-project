package com.designpatterndemo.chenxkang.patterns.chain_of_responsibility;

import android.util.Log;

import static com.designpatterndemo.chenxkang.patterns.chain_of_responsibility.ResponChainFragment.RESP_CHAIN_TAG;

/**
 * author: chenxkang
 * time  : 17/4/27
 * desc  : 70～80分，由主管审核
 */

public class ChargeHandler extends ChainHandler {

    @Override
    public void doHandler(double score) {
        Log.i(RESP_CHAIN_TAG, "传递到了：主管");
        if (score >= 70 && score < 80){
            Log.i(RESP_CHAIN_TAG, "审核人：主管；自评分数：" + score + "分；审核结果：通过");
        } else {
            if (null != getNextHandler()){
                Log.i(RESP_CHAIN_TAG, "不属于主管的职责，继续传递。。。");
                getNextHandler().doHandler(score);
            } else {
                Log.i(RESP_CHAIN_TAG, "主管没有处理，无下一个处理人，终止传递。。。");
            }
        }
    }
}
