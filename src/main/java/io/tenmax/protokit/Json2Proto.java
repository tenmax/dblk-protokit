package io.tenmax.protokit;


import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;
import org.apache.commons.io.FilenameUtils;

import java.io.*;

import static io.tenmax.protokit.BuilderUtils.getBuilder;

/**
 * Created by study on 16/06/2017.
 */
public class Json2Proto {

    public static void main(String[] args) throws Exception {
        if (args.length == 2) {
            String type = args[0];
            String jsonPath = args[1];

            Message.Builder builder = getBuilder(type);
            String basename = FilenameUtils.getBaseName(jsonPath);
            try (Reader reader = new FileReader(jsonPath);
                 OutputStream os = new FileOutputStream(basename + ".proto")) {
                JsonFormat.parser().merge(reader, builder);

                builder.build().writeTo(os);
            } catch (Exception e) {
                System.err.println("failing to convert doubleclick " + type + " to protobuf binary");
                e.printStackTrace();
            }
        } else {
            System.out.println("json2proto <REQ|RES> <DOUBLECLICK_REQUEST/RESPONSE_JSON_FILE_PATH>");
            System.out.println("ex. json2proto REQ bidrequest.json");

        }
    }
}
