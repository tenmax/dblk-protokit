package io.tenmax.protokit;

import com.google.protobuf.Message;
import com.google.protos.adx.NetworkBid;

/**
 * Created by study on 16/06/2017.
 */
public class BuilderUtils {
    public static Message.Builder getBuilder(String type) {
        switch (type) {
            case "REQ":
                return NetworkBid.BidRequest.newBuilder();
            case "RES":
                return NetworkBid.BidResponse.newBuilder();
            default:
                return null;
        }
    }
}
