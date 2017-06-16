package io.tenmax.protokit;


import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;
import org.apache.commons.io.FilenameUtils;

import java.io.*;

import static io.tenmax.protokit.BuilderUtils.getBuilder;

/**
 * Created by study on 16/06/2017.
 */
public class Proto2Json {

    public static void main(String[] args) throws Exception {
        if (args.length == 2) {
            String type = args[0];
            String protoPath = args[1];

            Message.Builder builder = getBuilder(type);

            String basename = FilenameUtils.getBaseName(protoPath);
            try (InputStream is = new FileInputStream(protoPath);
                 Writer w = new FileWriter(basename + ".json")) {
                w.write(JsonFormat.printer().print(builder.mergeFrom(is)));
            } catch (Exception e) {
                System.err.println("failing to convert doubleclick protobuf " + type + " binary to json");
                e.printStackTrace();
            }
        } else {
            System.out.println("proto2json <REQ|RES> <DOUBLECLICK_REQUEST/RESPONSE_PROTOBUF_FILE_PATH>");
            System.out.println("ex. proto2json REQ bidrequest.proto");
        }
    }
}
