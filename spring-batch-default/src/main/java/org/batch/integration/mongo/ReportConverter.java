package org.batch.integration.mongo;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by iurii.dziuban on 08.08.2016.
 *
 * Convertor from XML to Class
 */
public class ReportConverter implements Converter {

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Report.class);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Report report = new Report();
        report.setId(Integer.valueOf(reader.getAttribute("id")));

        reader.moveDown();
        Assert.isTrue("date".equals(reader.getNodeName()));
        Date date = null;
        try {
            date = new SimpleDateFormat("M/d/yyyy").parse(reader.getValue());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        report.setDate(date);
        reader.moveUp();

        reader.moveDown();
        Assert.isTrue("impression".equals(reader.getNodeName()));
        String impression = reader.getValue();
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        Number number = 0;
        try {
            number = format.parse(impression);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        report.setImpression(number.longValue());
        reader.moveUp();

        reader.moveDown();
        Assert.isTrue("clicks".equals(reader.getNodeName()));
        report.setClicks(Integer.valueOf(reader.getValue()));
        reader.moveUp();

        reader.moveDown();
        Assert.isTrue("earning".equals(reader.getNodeName()));
        report.setEarning(new BigDecimal(reader.getValue()));
        reader.moveUp();

        return report;
    }
}
