package com.xjw.utility;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EnumUtil {
  public static LinkedHashMap<String, String> enumToMap(Class clazz)
  throws IllegalArgumentException, IllegalAccessException
{
  LinkedHashMap result = new LinkedHashMap();
  if (clazz.isEnum())
  {
    Enum[] enums = (Enum[])(Enum[])clazz.getEnumConstants();
    LinkedHashMap map = new LinkedHashMap();
    for (Enum t : enums)
    {
      for (Field field : Reflector.getClassFields(t.getClass()))
      {
        if (field.getName().equals("code"))
        {
          Object obj = field.get(t);
          enumToMap_putMap(map, t.name(), String.valueOf(obj), 0);
        }
        else if (field.getName().equals("name"))
        {
          Object obj = field.get(t);
          enumToMap_putMap(map, t.name(), String.valueOf(obj), 1);
        }
      }
    }
    Iterator iterator=map.entrySet().iterator();
    while(iterator.hasNext()){
      Map.Entry<String, String> entity= (Entry<String, String>) iterator.next();
      result.put(entity.getKey(), entity.getValue());
     }
  }
  return result;
}

  private static void enumToMap_putMap(Map<String, String[]> map, String name, String value, int index) {
    if (map.containsKey(name)) {
      String[] v = (String[]) map.get(name);
      v[index] = value;
    } else {
      String[] v = new String[2];
      v[index] = value;
      map.put(name, v);
    }
  }
}
