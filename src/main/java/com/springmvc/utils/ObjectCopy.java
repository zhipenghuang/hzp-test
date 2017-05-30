package com.springmvc.utils;

import lombok.extern.slf4j.Slf4j;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import com.springmvc.annotation.FieldMapped;

@Slf4j
public class ObjectCopy {

    public ObjectCopy() {
    }

    private static Field getField(Class sourCls, Field toField) {
        HashSet toNames = new HashSet();
        toNames.add(toField.getName());
        FieldMapped fMapped = (FieldMapped)toField.getAnnotation(FieldMapped.class);
        int var5;
        int var6;
        if(fMapped != null) {
            String[] var4 = fMapped.names();
            var5 = var4.length;

            for(var6 = 0; var6 < var5; ++var6) {
                String from = var4[var6];
                if(!toNames.contains(from)) {
                    toNames.add(from);
                }
            }
        }

        do {
            Field[] var12 = sourCls.getDeclaredFields();
            var5 = var12.length;

            for(var6 = 0; var6 < var5; ++var6) {
                Field var13 = var12[var6];
                if(toNames.contains(var13.getName())) {
                    return var13;
                }

                fMapped = (FieldMapped)var13.getAnnotation(FieldMapped.class);
                if(fMapped != null) {
                    String[] var8 = fMapped.names();
                    int var9 = var8.length;

                    for(int var10 = 0; var10 < var9; ++var10) {
                        String cur_name = var8[var10];
                        if(toNames.contains(cur_name)) {
                            return var13;
                        }
                    }
                }
            }

            sourCls = sourCls.getSuperclass();
        } while(sourCls != Object.class);

        return null;
    }

    public static <T> T copyTo(Object obj, Class<T> toObj) throws Exception {
        Object toObjIns = toObj.newInstance();
        Class toCls = toObj;
        Field fromField = null;

        do {
            Field[] toFlds = toCls.getDeclaredFields();
            Field[] var8 = toFlds;
            int var9 = toFlds.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                Field cur = var8[var10];
                cur.setAccessible(true);
                String name = cur.getName();
                String type = cur.getType().getTypeName();
                Class sourCls = obj.getClass();
                fromField = getField(sourCls, cur);
                if(fromField != null) {
                    fromField.setAccessible(true);
                    String fromType = fromField.getType().getTypeName();
                    if(type.equals(fromType)) {
                        cur.set(toObjIns, fromField.get(obj));
                    } else {
                        try {
                            if(type.endsWith("String")) {
                                cur.set(toObjIns, String.valueOf(fromField.get(obj)));
                            } else if(!type.endsWith("int") && !type.endsWith("Integer")) {
                                if(type.endsWith("Date")) {
                                    if(fromType.endsWith("Date")) {
                                        cur.set(toObjIns, (Date)fromField.get(obj));
                                    } else {
                                        long e = 0L;
                                        if(!fromType.endsWith("int") && !fromType.endsWith("Integer") && !type.endsWith("long") && !type.endsWith("Long")) {
                                            e = Long.valueOf(String.valueOf(fromField.get(obj))).longValue();
                                        } else {
                                            e = ((Long)fromField.get(obj)).longValue();
                                        }

                                        if(e == 0L) {
                                            throw new Exception();
                                        }

                                        cur.set(toObjIns, new Date(e));
                                    }
                                } else if(!type.endsWith("long") && !type.endsWith("Long")) {
                                    if(!type.endsWith("short") && !type.endsWith("Short")) {
                                        throw new Exception("类型转换失败！");
                                    }

                                    if(!fromType.endsWith("short") && !fromType.endsWith("Short")) {
                                        cur.set(toObjIns, Short.valueOf(String.valueOf(fromField.get(obj))));
                                    } else {
                                        cur.set(toObjIns, (Short)fromField.get(obj));
                                    }
                                } else if(!fromType.endsWith("long") && !fromType.endsWith("Long")) {
                                    cur.set(toObjIns, Long.valueOf(String.valueOf(fromField.get(obj))));
                                } else {
                                    cur.set(toObjIns, (Long)fromField.get(obj));
                                }
                            } else if(!fromType.endsWith("int") && !fromType.endsWith("Integer")) {
                                cur.set(toObjIns, Integer.valueOf(String.valueOf(fromField.get(obj))));
                            } else {
                                cur.set(toObjIns, (Integer)fromField.get(obj));
                            }
                        } catch (Exception var16) {
                            log.error("类型转换失败:{}.{}[{}] convert to {}.{}[{}]", new Object[]{obj.getClass().getName(), name, fromType, toObj.getName(), name, type});
                            throw new IllegalArgumentException("类型转换失败:" + obj.getClass().getName() + "." + name + "[" + fromType + "] convert to " + toObj.getName() + "." + name + "[" + type + "]");
                        }
                    }
                }
            }

            toCls = toCls.getSuperclass();
        } while(toCls != Object.class);

        return (T) toObjIns;
    }

    public static <T> List<T> copyTo(List from, Class<T> to) {
        ArrayList toList = new ArrayList();
        Iterator var3 = from.iterator();

        while(var3.hasNext()) {
            Object cur = var3.next();

            try {
                toList.add(copyTo(cur, to));
            } catch (Exception var6) {
                throw new IllegalArgumentException(var6);
            }
        }

        return toList;
    }
}
