package com.jamie.friends;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class OneShareFriendsMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context) throws IOException, InterruptedException {
        String line = value.toString();

        String[] fields = line.split(":");

        String person = fields[0];
        String[] friends = fields[1].split(",");

        for (String friend : friends) {
            context.write(new Text(friend), new Text(person));
        }
    }
}
