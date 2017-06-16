# dblk-protokit
DoubleClick ADX bidrequest and bidrespone json2proto and proto2json utils

# proto2json
Convert DoubleClick ADX json format bidrequest and bidrespone to protobuf format

- Command:
````json2proto <REQ|RES> <DOUBLECLICK_REQUEST/RESPONSE_JSON_FILE_PATH>````

- Example:
````json2proto REQ bidrequest.json````

# json2proto
Convert DoubleClick ADX protobuf format bidrequest and bidrespone to json format

- Command:
````proto2json <REQ|RES> <DOUBLECLICK_REQUEST/RESPONSE_PROTOBUF_FILE_PATH>````

- Example:
````proto2json REQ bidrequest.proto````
