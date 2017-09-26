package com.scott.dev.common.xstream;

import java.util.Date;

import com.scott.dev.common.utils.DateUtils;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * XStream 日期转换类
 * 
 * @author WangZhen
 */
public class DateTimeConverter implements Converter {

    @Override
    @SuppressWarnings("rawtypes")
    public boolean canConvert(Class type) {
        return type.equals(Date.class);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer,
            MarshallingContext context) {
        Date date = (Date) source;
        if (date != null) {
            writer.setValue(DateUtils.formatDateTime(date));
        } else {
            writer.setValue("");
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        try {
            Date date = DateUtils.parseDate(reader.getValue());
            return date;
        } catch (Exception e) {
            return null;
        }
    }

}
