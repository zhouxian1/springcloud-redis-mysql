package com.zhouxian.service.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * @desc: 封装返回结果集
 * @author: zhouxian
 * @date: 2018/12/18
 */
public class ResultUtil {

    public static String result(final Integer status, final String msg, final Object data, final Integer total) {
        JSONObject jsonObject = new JSONObject() {
            {
                try {
                    put("status", status);
                    put("msg", msg);
                    put("data", data);
                    put("total", total);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        return jsonObject.toString();
    }

    public static String result(final Integer status, final String msg,  final Object data) {
        JSONObject jsonObject = new JSONObject() {
            {
                try {
                    put("status", status);
                    put("msg", msg);
                    put("data",data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        return jsonObject.toString();
    }

//    public webjars.webjars String result(final Integer status, final String msg,  User data) {
//        JSONObject jsonObject = new JSONObject() {
//            {
//                try {
//                    put("status", status);
//                    put("msg", msg);
//                    put("userId",data.getUserId());
//                    put("deptId",data.getDeptId());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        };
//        return jsonObject.toString();
//    }

    public static String result(final Integer status, final String msg) {
        JSONObject jsonObject = new JSONObject() {
            {
                try {
                    put("status", status);
                    put("msg", msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        return jsonObject.toString();
    }

}
